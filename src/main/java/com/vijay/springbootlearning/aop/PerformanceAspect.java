package com.vijay.springbootlearning.aop;

import com.vijay.springbootlearning.logger.LogContext;
import com.vijay.springbootlearning.logger.PerformanceLog;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.StopWatch;

import java.lang.reflect.Method;

@Configuration
@Aspect
@Slf4j
public class PerformanceAspect {

    @Around(value = "@annotation(com.vijay.springbootlearning.aop.PerformanceTracker)")
    public Object calculateTime(ProceedingJoinPoint joinPoint) throws Throwable {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        log.info("method: {}", method.toString());
        PerformanceTracker performanceTracker = method.getAnnotation(PerformanceTracker.class);
        final StopWatch stopWatch = new StopWatch();
        //Measure method execution time
        stopWatch.start();
        Object result = joinPoint.proceed();
        stopWatch.stop();

        //Log method execution time
        LogContext logContext = PerformanceLog.getPerformanceLogContext();
        if (logContext.exists(performanceTracker.timerKey())) {
            logContext.put(performanceTracker.timerKey(), Long.parseLong(logContext.get(performanceTracker.timerKey()).toString()) + stopWatch.getTotalTimeMillis());
        } else {
            logContext.put(performanceTracker.timerKey(), stopWatch.getLastTaskTimeMillis());
        }
        log.info("{}: {} ms", performanceTracker.timerKey(),  logContext.get(performanceTracker.timerKey()));
        return result;
    }
}
