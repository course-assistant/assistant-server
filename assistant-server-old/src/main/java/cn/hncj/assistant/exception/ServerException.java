package cn.hncj.assistant.exception;


/**
 * 自定义异常
 */
public class ServerException extends RuntimeException {
    public ServerException(String msg) {
        super(msg);
    }
}
