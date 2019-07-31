package com.smallking.common;

public class BizException extends RuntimeException{

    private String msg;

    public BizException(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
