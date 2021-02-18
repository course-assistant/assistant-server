package cn.hncj.assistant.constance;

/**
 * 响应的返回码
 */
public enum ResponseCode {

    /* 请求成功 */
    OK(200),

    /* 查询结果为空 */
    EMPTY_QUERY(300),

    /* 客户端错误 */
    ERROR(400),

    /* 服务器内部错误 */
    INTERNAL_ERROR(500);


    private int code;

    public int getCode() {
        return code;
    }

    ResponseCode(int code) {
        this.code = code;
    }
}
