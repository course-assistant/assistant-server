package cn.hncj.assistant.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * 给controller方法增加延时
 */
@SuppressWarnings({"unused"})
@Aspect
@Slf4j
@Component
public class ControllerDelayAspect {

    @Before("execution(* cn.hncj.assistant.controller.*.*(..))")
    public void before(JoinPoint joinPoint) throws Exception {
//        Thread.sleep(1500);
    }

}
