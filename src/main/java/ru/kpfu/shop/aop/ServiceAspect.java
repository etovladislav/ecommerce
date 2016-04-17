package ru.kpfu.shop.aop;


import org.aspectj.lang.ProceedingJoinPoint;

import java.util.Arrays;

public class ServiceAspect {


    /**
     * Замер времени работы метода и просмотр параметров с которыми он был вызван
     * @param joinPoint
     * @return
     * @throws Throwable
     */
    public Object timeLog(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        System.out.println("Start invoking "
                + joinPoint.getTarget().getClass().getSimpleName()
                + "."
                + joinPoint.getSignature().getName()
                + " with params "
                + Arrays.toString(joinPoint.getArgs()));
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();
        System.out.println("End invoking method: " + (end - start) + "ms");
        return result;
    }
}
