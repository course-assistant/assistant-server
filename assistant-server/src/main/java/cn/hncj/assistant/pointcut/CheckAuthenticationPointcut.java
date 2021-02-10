package cn.hncj.assistant.pointcut;

import cn.hncj.assistant.annotation.RoleCheck;
import cn.hncj.assistant.exception.ServerException;
import cn.hncj.assistant.util.JWTUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.Method;


/**
 * 检查授权切入点
 */
@Aspect
@Component
public class CheckAuthenticationPointcut {

    final static Logger logger = LoggerFactory.getLogger(CheckAuthenticationPointcut.class);

    /**
     * 切点
     * 验证带有 @Authentication 注解的controller方法
     */
    @Pointcut(value = "@annotation(cn.hncj.assistant.annotation.RoleCheck)")
    private void checkAuthentication() {
    }

    @Around("checkAuthentication()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("进行token验证");

        // 获取request，获取header
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        if (servletRequestAttributes == null) {
            throw new ServerException("服务器异常：requests接收失败");
        }
        HttpServletRequest request = servletRequestAttributes.getRequest();
        String token = request.getHeader("token");
        logger.info("待验证的token:{}", token);
        if (token == null) {
            throw new ServerException("权限验证失败，token为null");
        }

        // 获取方法上 @Authentication注解 的参数
        Signature signature = pjp.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method targetMethod = methodSignature.getMethod();
        cn.hncj.assistant.annotation.RoleCheck annotation = targetMethod.getAnnotation(RoleCheck.class);
        String requiredRole = annotation.role();
        String providedId;
        String providedRole;

        // 这里捕获一下异常，统统抛出 token无效
        // 获取token中的permission，如果出现异常则为JWT校验失败
        try {
            DecodedJWT decodedJWT = JWTUtil.verifyToken(token);
            providedId = decodedJWT.getClaim("id").asString();
            providedRole = decodedJWT.getClaim("role").asString();
            // JWT里没有包含id和role信息
            if (providedId == null || providedRole == null) {
                throw new ServerException("权限验证失败，token无效 id或role为空");
            }
            logger.info("请求id：[{}]", providedId);
            logger.info("providedRole：[{}]", providedRole);
            logger.info("requiredRole：[{}]", requiredRole);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException("权限验证失败，token无效");
        }

        /*
         * requiredRole：要求的role
         * providedRole：传入的role
         * 验证权限，验证规则：
         * 如果 providedRole 为 admin 直接判定有权限
         * 如果 providedRole 为 teacher或student，那么只能 requiredRole和providedRole 完全匹配才有权限
         */
        if (RoleCheck.ADMIN.equals(providedRole) || requiredRole.equals(providedRole)) {
            logger.info("验证通过");
            return pjp.proceed();
        }
        throw new ServerException("权限不匹配");

    }
}
