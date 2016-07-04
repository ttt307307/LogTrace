package com.logtrace.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by tandewei on 2016/6/30.
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.CONSTRUCTOR,ElementType.METHOD})
public @interface LogTrace {
    public int level() default 2;  //TRACE = 1 DEBUG = 2 INFO = 3 WARN = 4 ERROR = 5 FATAL = 6
}
