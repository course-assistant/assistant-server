package cn.hncj.assistant.aspect;

import cn.hncj.assistant.annotation.Comment;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Date;

/**
 * 统一输出controller方法的日志
 */
@Aspect
@Slf4j
@Component
public class ControllerLogAspect {
    // 环绕通知，暂时不记录返回值
    @Around("execution(* cn.hncj.assistant.controller.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        Object target = pjp.getTarget();
        Signature signature = pjp.getSignature();
        Object[] args = pjp.getArgs();

        // 执行前
        Comment comment = ((MethodSignature) pjp.getSignature()).getMethod().getAnnotation(Comment.class);
        String methodComment = "";
        if (comment != null) {
            methodComment = comment.value();
        }
        log.info("执行方法: [{}] {}.{}", methodComment, target.getClass().getSimpleName(), signature.getName());
        log.info("传递参数: {}", Arrays.toString(args));

        // 开始执行
        long time = new Date().getTime();
        Object proceed = pjp.proceed();
        time = new Date().getTime() - time;

        // 执行后
        log.info("执行完成: [{}] {}.{}", methodComment, target.getClass().getSimpleName(), signature.getName());
        log.info("耗时: {}ms\n", time);

        return proceed;
    }

}
