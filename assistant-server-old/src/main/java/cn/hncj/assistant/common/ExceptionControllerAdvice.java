package cn.hncj.assistant.common;

import cn.hncj.assistant.exception.ServerException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;


/**
 * 进行统一异常处理的类
 */
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
    public Object nullPointer(NullPointerException e) {
        e.printStackTrace();
        return ServerResponse.createInternalError("服务器内部异常");
    }

    // 数据库连接异常
//    @ExceptionHandler(Communication)
//    public Object connectException() {
//        return ServerResponse.createError("数据库连接超时");
//    }

    // 其他异常
    @ExceptionHandler(Exception.class)
    public Object exceptionHandler(Exception e) {
        e.printStackTrace();
        return ServerResponse.createInternalError("服务器异常");
    }


    /* 数据库相关异常 */
    // 重复插入
    @ExceptionHandler(DuplicateKeyException.class)
    public Object DuplicateKeyException(){
        return ServerResponse.createInternalError("数据库试图插入重复的值");
    }

}
