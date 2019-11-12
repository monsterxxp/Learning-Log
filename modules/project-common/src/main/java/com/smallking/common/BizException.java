package com.smallking.common;

public class BizException extends RuntimeException{

    private String message;

    public BizException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
