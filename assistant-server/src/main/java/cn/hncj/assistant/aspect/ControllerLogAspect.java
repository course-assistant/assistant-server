package cn.hncj.assistant.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 统一输出controller方法的日志
 */
@Aspect
@Slf4j
@Component
public class ControllerLogAspect {


    @Before("execution(* cn.hncj.assistant.controller.*.*(..))")
    public void before(JoinPoint joinPoint) {

        Signature signature = joinPoint.getSignature();
        Object target = joinPoint.getTarget();
        Object[] args = joinPoint.getArgs();

        log.info("执行方法: {}.{}", target.getClass().getSimpleName(), signature.getName());
        log.info("传递参数: {}", Arrays.toString(args));
    }


    @AfterReturning("execution(* cn.hncj.assistant.controller.*.*(..))")
    public void afterReturning(JoinPoint joinPoint) {
        Signature signature = joinPoint.getSignature();
        Object target = joinPoint.getTarget();
        log.info("执行完成: {}.{}", target.getClass().getSimpleName(), signature.getName());
    }

}
