package com.forgeeks.SpringDZ5.utils;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectApp {

//    @Pointcut("within(com.forgeeks.SpringDZ5.service.*)")
//    public void serviceClassMethods(){};

    @Around("within(com.forgeeks.SpringDZ5.service.*)")
//    @Around("serviceClassMethods()")
    public Object countServicesWorktime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        System.out.println("start counting worktime of method: " + (MethodSignature) proceedingJoinPoint.getSignature());
        long begin = System.currentTimeMillis();
        Object out = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();
        long worktime = end - begin;
        System.out.println((MethodSignature) proceedingJoinPoint.getSignature() + " worktime " + worktime);
        System.out.println("end counting worktime of method: " + (MethodSignature) proceedingJoinPoint.getSignature());
        return out;
    }
}
