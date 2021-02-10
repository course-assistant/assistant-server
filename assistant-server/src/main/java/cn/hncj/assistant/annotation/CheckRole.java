package cn.hncj.assistant.annotation;


import java.lang.annotation.*;

/**
 * 权限认证
 */

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckRole {

    String ADMIN = "administrator";
    String TEACHER = "teacher";
    String STUDENT = "student";

    String role() default "";
}
