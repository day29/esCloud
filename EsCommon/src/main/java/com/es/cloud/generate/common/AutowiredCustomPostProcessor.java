package com.es.cloud.generate.common;

import com.es.cloud.generate.common.service.impl.BaseUnitServiceImpl;
import org.apache.commons.lang.SerializationUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.PropertyValues;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.InstantiationAwareBeanPostProcessor;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import org.springframework.core.Ordered;
import org.springframework.core.PriorityOrdered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import org.springframework.util.ReflectionUtils.FieldCallback;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static com.es.cloud.generate.common.SpringContext.applicationContext;

/**
 * @Author: zry
 */
@Component
public class AutowiredCustomPostProcessor implements InstantiationAwareBeanPostProcessor, BeanFactoryPostProcessor, PriorityOrdered {

    @Override
    public PropertyValues postProcessProperties(PropertyValues pvs, Object bean, String beanName) throws BeansException {
        doWithAllAutowiringFields(bean.getClass(), f -> {
            System.out.println(bean.getClass());
            Class<?> targetClazz = f.getType();
            RemoteService remoteService = AnnotationUtils.getAnnotation(f.getType(), RemoteService.class);
            Object obj = getBean(remoteService, targetClazz);
            setField(bean, f, obj);
        });
        return pvs;
    }

    private static Map<Class<?>, Object> beanMap = new ConcurrentHashMap<>();

    public static Object getBean(RemoteService remoteService, Class<?> targetClazz) {
        var arr = applicationContext.getBeanNamesForType(targetClazz);
        if (arr.length > 0) {
            return applicationContext.getBean(arr[0], targetClazz);
        }
        if (beanMap.containsKey(targetClazz)) {
            return beanMap.get(targetClazz);
        }
        synchronized (beanMap) {
            if (beanMap.containsKey(targetClazz)) {
                return beanMap.get(targetClazz);
            }
            return beanMap.computeIfAbsent(targetClazz, k -> createBean(remoteService, targetClazz));
        }
    }

    private static Object createBean(RemoteService remoteService, Class<?> targetClazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(targetClazz);
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
        return enhancer.create();
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

    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        var beanDefinitionNames = beanFactory.getBeanDefinitionNames();
        for (String beanName : beanDefinitionNames) {
            if (beanName.endsWith("Service") && beanName != null) {
                var bean = beanFactory.getBeanDefinition(beanName);
                if (bean == null || bean.isAbstract() || bean.getBeanClassName() == null) continue;
                try {
                    var clazz = Class.forName(bean.getBeanClassName());
                    if (BaseUnitServiceImpl.class.isAssignableFrom(clazz)) {
                        Type genericInterface = clazz.getGenericSuperclass();
                        if (genericInterface instanceof ParameterizedType parameterizedType) {
                            Type rawType = parameterizedType.getRawType();
                            Type[] actualTypeArguments = parameterizedType.getActualTypeArguments();
                            if (actualTypeArguments != null && actualTypeArguments.length == 2 && actualTypeArguments[1] instanceof Class<?> typeClass) {
                                String alise = typeClass.getSimpleName().toLowerCase();
                                RemoteService rs = AnnotationUtils.findAnnotation(clazz, RemoteService.class);
                                String[] alises = new String[]{alise, clazz.getSimpleName(), clazz.getSimpleName().toLowerCase(), alise.toLowerCase(), rs.serviceName(), rs.serviceName().toLowerCase()};
                                for (int i = 0; i < alises.length; i++) {
                                    if (!alises[i].equals(beanName) && !beanFactory.containsBean(alises[i])) {
                                        beanFactory.registerAlias(beanName, alises[i]);
                                    }
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

}
