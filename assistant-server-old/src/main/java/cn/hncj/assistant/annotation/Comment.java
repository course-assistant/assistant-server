package cn.hncj.assistant.annotation;

import java.lang.annotation.*;

/**
 * 方法上面的批注，用于日志打印
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Comment {
    String value() default "";
}
