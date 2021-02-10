package cn.hncj.assistant.pointcut;

import cn.hncj.assistant.annotation.Authentication;
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
public class CheckAuthorizationPointcut {

    final static Logger logger = LoggerFactory.getLogger(CheckAuthorizationPointcut.class);

    /**
     * 切点
     * 验证带有 @Authentication 注解的controller方法
     */
    @Pointcut(value = "@annotation(cn.hncj.assistant.annotation.Authentication)")
    private void permissionCheckCut() {
    }

    @Around("permissionCheckCut()")
    public Object around(ProceedingJoinPoint pjp) throws Throwable {
        logger.info("进行token验证");

        // 获取request，获取header
        RequestAttributes requestAttributes = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes) requestAttributes;
        if (servletRequestAttributes == null) {
            throw new ServerException("服务器内部异常");
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
        Authentication authentication = targetMethod.getAnnotation(Authentication.class);
        String permission = authentication.permission();

        // 获取token中的permission，如果出现异常则为JWT校验失败
        try {
            DecodedJWT decodedJWT = JWTUtil.verifyToken(token);
            String id = decodedJWT.getClaim("id").asString();
            String type = decodedJWT.getClaim("type").asString();
            logger.info("请求id：[{}]", id);
            logger.info("角色：[{}]", type);
        } catch (Exception e) {
            e.printStackTrace();
            throw new ServerException("权限验证失败，token为无效");
        }
        System.out.println("当前接口请求的permission :{" + permission + "}");
//        throw new ServerException("没有权限");
        // 放行
        return pjp.proceed();
    }
}
