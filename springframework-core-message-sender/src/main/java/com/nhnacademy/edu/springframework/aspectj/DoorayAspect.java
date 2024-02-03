package com.nhnacademy.edu.springframework.aspectj;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.util.StopWatch;


@Aspect
public class DoorayAspect {


    @Pointcut("execution(* com.nhnacademy.edu.springframework.*.sendMessage(..)) " +
            "&& @annotation(com.nhnacademy.edu.springframework.TimeLogging))")
    public void logmethodsInPackage() {
    }

    @Around("logmethodsInPackage()")
    public Object logMethodExecution(ProceedingJoinPoint joinPoint) throws Throwable {


        String methodName = joinPoint.getSignature().getName();


        StopWatch stopWatch = new StopWatch();
        stopWatch.start();


        Object result = joinPoint.proceed();
        stopWatch.stop();
        System.out.println(stopWatch.prettyPrint());

        return result;
    }


}
