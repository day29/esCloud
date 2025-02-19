package com.es.cloud.generate.common.service.impl;

import com.es.cloud.generate.common.RemoteService;
import com.es.cloud.generate.common.UnitService;
import com.es.cloud.generate.common.service.BaseUnitService;
import org.springframework.core.annotation.AnnotationUtils;

import static com.es.cloud.generate.common.AutowiredCustomPostProcessor.getBean;

//基础业务服务
public abstract class BaseCenterServiceImpl {

    public Object getService() {
        Class clazz = AnnotationUtils.findAnnotation(getClass(), UnitService.class).value();
        RemoteService remoteService = AnnotationUtils.getAnnotation(clazz, RemoteService.class);
        return getBean(remoteService, clazz);
    }

    public BaseUnitService getUnitService() {
        return (BaseUnitService) getService();
    }
}
