package com.htzhu.annotation;

import com.google.inject.BindingAnnotation;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Logged
 *
 * @author zhuhaitao
 * @date 2018/6/4 14:58
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@BindingAnnotation
public @interface Logged {

}
