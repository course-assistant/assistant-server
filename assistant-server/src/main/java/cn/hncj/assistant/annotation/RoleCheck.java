package cn.hncj.assistant.annotation;


import java.lang.annotation.*;

/**
 * 角色验证
 */

@Target({ElementType.METHOD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RoleCheck {

    String ADMIN = "administrator";
    String TEACHER = "teacher";
    String STUDENT = "student";
    String USER = "user";

    String value() default "";
}
