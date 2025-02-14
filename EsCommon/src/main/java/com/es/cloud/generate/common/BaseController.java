package com.es.cloud.generate.common;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONArray;
import com.es.cloud.generate.common.service.impl.BaseUnitServiceImpl;
import org.apache.commons.lang.SerializationUtils;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.stream.IntStream;

import static com.es.cloud.generate.common.SpringContext.applicationContext;

@RestController
@RequestMapping("/_common")
@ConditionalOnProperty(prefix = "es.cloud.common.controller", name = "enable", havingValue = "true", matchIfMissing = true)
public class BaseController {

    @ResponseBody
    @RequestMapping("/{serviceId}/{method}")
    public String rutor(@PathVariable("serviceId") String serviceId, @PathVariable("method") String method, @RequestBody String body) {
        Assert.notNull(serviceId, "PathVariable serviceId 不能为空");
        Object serviceObj = applicationContext.getBean(serviceId);
        Class serviceClass = serviceObj.getClass();
        if (BaseUnitServiceImpl.class.isAssignableFrom(serviceClass)) {
            serviceClass = BaseUnitServiceImpl.class;
        }
        JSONArray param = JSON.parseArray(body);
        Method[] methods = ReflectionUtils.getUniqueDeclaredMethods(serviceClass, m -> m.getName().equals(method) && m.getParameterCount() == param.size());
        Assert.notEmpty(methods, "未找到方法");
        Method m = methods[0];
        Type[] genericParameterTypes = m.getGenericParameterTypes();
        Object[] args = IntStream.range(0, param.size()).mapToObj(i -> {
            Type genericType = genericParameterTypes[i];
            if (genericType instanceof ParameterizedType && ((ParameterizedType) genericType).getRawType() == List.class) {
                ParameterizedType parameterizedType = (ParameterizedType) genericType;
                Type actualTypeArgument = parameterizedType.getActualTypeArguments()[0];
                return param.getJSONArray(i).toJavaList((Class<?>) actualTypeArgument);
            } else {
                return param.getObject(i, (Class<?>) genericType);
            }
        }).toArray();
        Object ret = ReflectionUtils.invokeMethod(m, serviceObj, args);
        return JSON.toJSONString(ret);
    }

    @PostMapping(value = "/binary/{serviceId}/{method}", consumes = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<byte[]> rutorBinary(@PathVariable("serviceId") String serviceId, @PathVariable("method") String method, @RequestBody byte[] requestData) throws IOException {
        var xx = SerializationUtils.deserialize(requestData);
        if (!xx.getClass().isArray()) {
            throw new IllegalArgumentException("参数必须是数组");
        }
        Object[] arr = (Object[]) xx;
        Assert.notNull(serviceId, "PathVariable serviceId 不能为空");
        Class<?>[] css = new Class[arr.length];
        IntStream.range(0, arr.length).forEach(i -> css[i] = arr[i].getClass());
        Object serviceObj = applicationContext.getBean(serviceId);
        Class serviceClass = serviceObj.getClass();
        var mm = ReflectionUtils.findMethod(serviceClass, method, css);
        Method[] methods = ReflectionUtils.getUniqueDeclaredMethods(serviceClass, m -> m.getName().equals(method)
                && m.getParameterCount() == arr.length && isSameType(m.getParameterTypes(), css));
        Assert.notEmpty(methods, "未找到方法");
        Method m = methods[0];
        Object ret = ReflectionUtils.invokeMethod(m, serviceObj, arr);
        byte[] responseData = SerializationUtils.serialize((Serializable) ret);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        return new ResponseEntity<>(responseData, headers, HttpStatus.OK);
    }

    private boolean isSameType(Class<?>[] parameterTypes, Class<?>[] css) {
        return IntStream.range(0, parameterTypes.length).noneMatch(i -> parameterTypes[i] != css[i] && !parameterTypes[i].isAssignableFrom(css[i]));
    }


    public static void main(String[] args) {
        Class serviceClass = BaseUnitServiceImpl.class;
        Method[] methods = ReflectionUtils.getUniqueDeclaredMethods(serviceClass, m -> m.getName().equals("doSearch") && m.getParameterCount() == 3);
        System.out.println(methods[0].getGenericParameterTypes()[0].getClass().getName());
    }

}
