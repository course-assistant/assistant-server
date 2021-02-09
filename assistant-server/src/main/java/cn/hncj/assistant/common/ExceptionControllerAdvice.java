package cn.hncj.assistant.common;

import cn.hncj.assistant.exception.ServerException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@RestControllerAdvice
public class ExceptionControllerAdvice {


    // 传递的参数类型与API上的不一致
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public Object methodArgumentTypeMismatchException() {
        return ServerResponse.createError("参数转换异常，请按照API的数据类型");
    }


    // 没有传入必要参数
    @ExceptionHandler(MissingServletRequestParameterException.class)
    public Object missingServletRequestParameterException() {
        return ServerResponse.createError("请传入所有必要参数");
    }


    // 自定义信息的异常
    @ExceptionHandler(ServerException.class)
    public Object handleMyException(ServerException e) {
        return ServerResponse.createError(e.getMessage());
    }

    // 空指针异常
    @ExceptionHandler(NullPointerException.class)
    public Object nullPointer() {
        return ServerResponse.createError("服务器内部异常");
    }


    @ExceptionHandler(Exception.class)
    public Object exceptionHandler() {
        return ServerResponse.createError("服务器异常");
    }

}
