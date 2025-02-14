package com.es.cloud.generate.common.service.impl;

import com.es.cloud.generate.common.UnitServiceName;
import com.es.cloud.generate.common.service.BaseUnitService;
import org.springframework.core.annotation.AnnotationUtils;

import static com.es.cloud.generate.common.SpringContext.applicationContext;

//基础业务服务
public abstract class BaseCenterServiceImpl {

    public Object getService() {
        String serviceName = AnnotationUtils.findAnnotation(this.getClass(), UnitServiceName.class).value();
        BaseUnitService service = (BaseUnitService) applicationContext.getBean(serviceName);
        return service;
    }


}
