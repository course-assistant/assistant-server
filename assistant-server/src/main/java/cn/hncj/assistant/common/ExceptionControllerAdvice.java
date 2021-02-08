package cn.hncj.assistant.common;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {


    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(){
        return ServerResponse.createError("服务器异常");
    }

}
