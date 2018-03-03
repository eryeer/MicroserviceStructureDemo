package com.wxbc.operlog;

import com.wxbc.operlog.bean.OperLogInfo;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by fengxinhe on 2017/8/21.
 */
@Target({ ElementType.PARAMETER, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)

public @interface OperLogAnnotation {
    String description() default "";
    String logLevel() default OperLogInfo.LOG_TYPE_INFO;

}

