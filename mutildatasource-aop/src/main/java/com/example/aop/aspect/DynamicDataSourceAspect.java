package com.example.aop.aspect;

import com.example.aop.annotation.DataSourceSign;
import com.example.aop.common.ContextConst;
import com.example.aop.config.DataSourceContextHolder;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * description:
 *
 * @author xiaoming.li04@hand-china.com
 * @datatime 2020/11/22 16:11
 */
@Component
@Order(-1)// 保证该AOP在@Transactional之前执行
@Aspect
@Slf4j
@SuppressWarnings("all")
public class DynamicDataSourceAspect {

/*    @Before("execution(* com.example.aop.service..*.*(..))")
    public void before(JoinPoint point){
        try {
            DataSourceSign annotationOfClass =
                    point.getTarget().getClass().getAnnotation(DataSourceSign.class);
            String methodName = point.getSignature().getName();
            Class[] parameterTypes =
                    ((MethodSignature) point.getSignature()).getParameterTypes();
            Method method =
                    point.getTarget().getClass().getMethod(methodName, parameterTypes);
            DataSourceSign methodAnnotation =
                    method.getAnnotation(DataSourceSign.class);
            methodAnnotation = methodAnnotation ==
                    null ? annotationOfClass:methodAnnotation;
            String dataSourceType =
                    methodAnnotation != null &&  methodAnnotation.value() !=null ?
                            methodAnnotation.value() :ContextConst.PRIMARY ;
            DataSourceContextHolder.setDataSource(dataSourceType);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    @After("execution(* com.example.aop.service..*.*(..))")
    public void after(JoinPoint point){
        DataSourceContextHolder.clearDataSource();
    }*/

    @Pointcut("execution(* com.example.aop.service.UserServiceImpl.save*(..))")
    public void dataSourcePointCut() {
    }

    @Around("dataSourcePointCut()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        MethodSignature signature = (MethodSignature) point.getSignature();
        Method method = signature.getMethod();
        DataSourceSign ds = method.getAnnotation(DataSourceSign.class);
        if (ds == null) {
            DataSourceContextHolder.setDataSource(ContextConst.PRIMARY);
            log.debug("set datasource is {}" , ContextConst.PRIMARY);
        } else {
            DataSourceContextHolder.setDataSource(ds.value());
            log.debug("set datasource is {} " , ds.value());
        }
        try {
            //执行目标方法
            return point.proceed();
        } finally {
            DataSourceContextHolder.clearDataSource();
            log.debug("clean datasource");
        }
    }

    @Pointcut("execution(* com.example.aop.service.UserServiceImpl.test(..))")
    public void test() {
    }

    @Before("test()")
    public void before(){
        System.out.println("前置通知....");
    }
    @AfterReturning("test()")
    public void afterReturning(){
        System.out.println("后置通知......");
    }
    @AfterThrowing("test()")
    public void afterThrowing(){
        System.out.println("异常通知.......");
    }
    @After("test()")
    public void after(){
        System.out.println("最终通知........");
    }


}
