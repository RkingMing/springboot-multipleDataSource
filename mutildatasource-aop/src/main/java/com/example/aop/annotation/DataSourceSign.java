package com.example.aop.annotation;

import com.example.aop.common.ContextConst;

import java.lang.annotation.*;

/**
 * description:
 *
 * @author xiaoming.li04@hand-china.com
 * @datatime 2020/11/22 16:10
 */
@Target({ElementType.TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface DataSourceSign {
    String value() default ContextConst.PRIMARY;
}
