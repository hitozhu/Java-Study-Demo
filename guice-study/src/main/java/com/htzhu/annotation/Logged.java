package com.htzhu.annotation;

import com.google.inject.BindingAnnotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Logged
 *
 * @author zhuhaitao
 * @date 2018/6/4 14:58
 **/
@Retention(RetentionPolicy.RUNTIME)
@BindingAnnotation
public @interface Logged {

}
