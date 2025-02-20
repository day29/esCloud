package com.es.cloud.generate.common;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RemoteService {

    String appName() default "";

    String serviceName() default "";

    String path() default "";
}
