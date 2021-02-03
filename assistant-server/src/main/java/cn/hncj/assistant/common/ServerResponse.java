package cn.hncj.assistant.common;


import com.fasterxml.jackson.annotation.JsonInclude;

import java.io.Serializable;

enum ResponseCode {
    SUCCESS(200),
    ERROR(401);

    private int code;

    public int getCode() {
        return code;
    }

    ResponseCode(int code) {
        this.code = code;
    }
}

/**
 * 封装返回结果
 */
@SuppressWarnings("unused")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ServerResponse<T> implements Serializable {
    private Integer code;
    private String msg;
    private T data = null;

    ServerResponse() {
    }

    /**
     * 创建一个只有消息的成功的response
     *
     * @param msg  消息
     * @param data 数据
     * @return ServerResponse
     */
    public static <T> ServerResponse<T> createSuccess(String msg, T data) {
        ServerResponse<T> successResponse = new ServerResponse<>();
        successResponse.setCode(ResponseCode.SUCCESS.getCode());
        successResponse.setMsg(msg);
        successResponse.setData(data);
        return successResponse;
    }

    /**
     * 创建一个只有消息的成功的response
     *
     * @param msg 消息
     * @return ServerResponse
     */
    public static <T> ServerResponse<T> createSuccess(String msg) {
        ServerResponse<T> successResponse = new ServerResponse<>();
        successResponse.setCode(ResponseCode.SUCCESS.getCode());
        successResponse.setMsg(msg);
        successResponse.setData(null);
        return successResponse;
    }

    /**
     * 创建一个失败的response
     *
     * @param errorMsg 失败消息
     * @return ServerResponse
     */
    public static <T> ServerResponse<T> createError(String errorMsg) {
        ServerResponse<T> errorResponse = new ServerResponse<>();
        errorResponse.setCode(ResponseCode.ERROR.getCode());
        errorResponse.setMsg(errorMsg);
        errorResponse.setData(null);
        return errorResponse;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
