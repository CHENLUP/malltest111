package com.blya.malltest.comm.api;

public enum ResultCode implements IErrorCode{

    SUCCESS(100001, "操作成功"),
    FAILED(100002, "操作失败"),
    VALIDATE_FAILED(100003, "参数检验失败"),
    UNAUTHORIZED(100004, "暂未登录或token已经过期"),
    FORBIDDEN(100005, "没有相关权限");

    private long code;
    private String message;

    ResultCode(long code, String message) {
        this.code = code;
        this.message = message;
    }

    @Override
    public long getCode() {
        return code;
    }
    @Override
    public String getMessage() {
        return message;
    }
}
