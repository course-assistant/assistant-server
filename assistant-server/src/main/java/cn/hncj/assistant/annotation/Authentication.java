package cn.hncj.assistant.annotation;


import java.lang.annotation.*;

/**
 * 权限认证
 */

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Authentication {

    String ADMIN = "1";

    String permission() default "";
}
