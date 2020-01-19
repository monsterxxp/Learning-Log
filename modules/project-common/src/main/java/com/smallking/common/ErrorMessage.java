package com.smallking.common;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class ErrorMessage extends LinkedHashMap<String, Object> implements Serializable {
    private static final long serialVersionUID = 811899486654614381L;
    private int code;
    private String message;
    private String moreInfo;
    private Object result;

    private void setErrorMap() {
        HashMap messageMap = new HashMap();
        messageMap.put("code", this.code);
        messageMap.put("message", this.message);
        messageMap.put("moreInfo", this.moreInfo);
        messageMap.put("result", this.result);
        this.put("error", messageMap);
    }

    public ErrorMessage(int code, String message, String moreInfo) {
        this.setCode(code);
        this.setMessage(message);
        this.setMoreInfo(moreInfo);
        this.setErrorMap();
    }

    public ErrorMessage(int code, String message) {
        this.setCode(code);
        this.setMessage(message);
        this.setErrorMap();
    }

    public ErrorMessage(int code, String message, Object result) {
        this.setCode(code);
        this.setMessage(message);
        this.setResult(result);
        this.setErrorMap();
    }

    public ErrorMessage(String message) {
        this.setMessage(message);
        this.setErrorMap();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMoreInfo() {
        return this.moreInfo;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    @Override
    public String toString() {
        return "error{ code='" + this.code + '\'' + ", message='" + this.message + '\'' + ", moreInfo='" + this.moreInfo + '\'' + '}';
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }
}