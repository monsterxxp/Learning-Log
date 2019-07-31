package com.smallking.common;

import java.io.Serializable;

/**
 * @description: 统一返回
 * @author: smallking
 * @date: 2019-07-31
 **/
public class Return<T> implements Serializable {

    private static final long serialVersionUID = 5203201995827748690L;

    private T data;
    private boolean success;
    private int code;
    private String message;

    private Return() {}

    private Return(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    private Return(T data, boolean success, int code, String message) {
        this.data = data;
        this.success = success;
        this.code = code;
        this.message = message;
    }

    /**
     * 调用默认成功
     */
    public static <T> Return<T> ok(){
        return new Return<T>(true, 200, "返回成功");
    }

    /**
     * 调用默认成功
     */
    public static <T> Return<T> ok(T data){
        return new Return<T>(data, true, 200, "返回成功");
    }

    /**
     * 返回默认失败
     */
    public static <T> Return<T> error(){
        return new Return<T>(false, 500, "系统内部错误");
    }

    /**
     * 自定义失败一
     */
    public static <T> Return<T> error(T data, int code, String message){
        return new Return<T>(data, false, code, message);
    }

    /**
     * 自定义失败二
     */
    public static <T> Return<T> error(int code, String message){
        return new Return<T>(false, code, message);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
