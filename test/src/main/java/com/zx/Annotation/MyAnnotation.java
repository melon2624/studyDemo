package com.zx.Annotation;

import java.lang.annotation.*;

/**
 * @author zhangxin
 * @date 2022/5/7 9:59
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyAnnotation {


    String value() default "";

}
