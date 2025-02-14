package com.es.cloud.generate.common;

import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import static com.es.cloud.generate.common.SpringContext.applicationContext;

/**
 * @Author: zry
 */
@Component
public class AutowiredCustomPostProcessor implements InstantiationAwareBeanPostProcessor, PriorityOrdered {

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        doWithAllAutowiringFields(bean.getClass(), f -> {
            Class<?> targetClazz = f.getType();
            RemoteServiceAutowired autowired = AnnotationUtils.findAnnotation(f, RemoteServiceAutowired.class);
            RemoteService remoteService = AnnotationUtils.getAnnotation(f.getType(), RemoteService.class);
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(f.getType());
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
                    String methodName = method.getName();
                    String appName = remoteService.appName();
                    String serviceName = remoteService.serviceName();
                    if (StringUtils.isBlank(serviceName)) {
                        String interfaceName = targetClazz.getSimpleName();
                        if (interfaceName.startsWith("I")) {
                            interfaceName = interfaceName.substring(1);
                        }
                        serviceName = interfaceName.substring(0, 1).toLowerCase() + interfaceName.substring(1) + "Impl";
                    }
                    RestTemplate rest = applicationContext.getBean(RestTemplate.class);
                    String url = "http://" + appName + "/_common/binary/" + serviceName + "/" + methodName;
                    byte[] requestData = SerializationUtils.serialize(args);
                    HttpHeaders headers = new HttpHeaders();
                    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
                    HttpEntity<byte[]> requestEntity = new HttpEntity<>(requestData, headers);
                    ResponseEntity<byte[]> response = rest.exchange(url, HttpMethod.POST, requestEntity, byte[].class);

                    if (response.getStatusCode().is2xxSuccessful()) {
                        return SerializationUtils.deserialize(response.getBody());
                    } else {
                        throw new RuntimeException("请求失败，状态码: " + response.getStatusCode());
                    }
                }
            });
            setField(bean, f, enhancer.create());
        });
        return pvs;
    }

    private void setField(Object bean, Field field, Object value) {
        ReflectionUtils.makeAccessible(field);
        ReflectionUtils.setField(field, bean, value);
    }

    private void doWithAllAutowiringFields(Class<?> clazz, FieldCallback fieldCallback) {
        ReflectionUtils.doWithFields(clazz, fieldCallback, f -> AnnotationUtils.findAnnotation(f, RemoteServiceAutowired.class) != null && AnnotationUtils.findAnnotation(f.getType(), RemoteService.class) != null);
    }

    public <T> Class<T> getEntityClass(Type superclass) {
        if (superclass instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) superclass;
            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
            if (actualTypeArguments.length > 0) {
                return (Class<T>) actualTypeArguments[0];
            }
        }
        return null;
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE - 1;
    }
}
