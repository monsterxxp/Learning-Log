package com.smallking.common;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: 统一返回
 * @author: smallking
 * @date: 2019-07-31
 **/
public class Return<T> implements Serializable {

    private static final long serialVersionUID = 5203201995827748690L;

    private T result;
    private boolean success;
    private int code;
    private String message;

    private Return() {}

    private Return(boolean success, int code, String message) {
        this.success = success;
        this.code = code;
        this.message = message;
    }

    private Return(T result, boolean success, int code, String message) {
        this.result = result;
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
    public static <T> Return<T> ok(T result){
        return new Return<T>(result, true, 200, "返回成功");
    }

    /**
     * 分页返回
     */
    public static Return<Map<String, Object>> page(IPage page){
        Map<String, Object> pageMap = new HashMap<>();
        pageMap.put("data", page.getRecords());
        pageMap.put("pageSize", page.getSize());
        pageMap.put("pageNo", page.getCurrent());
        pageMap.put("totalPage", page.getPages());
        pageMap.put("totalCount", page.getTotal());
        return new Return(pageMap, true, 200, "返回成功");
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
    public static <T> Return<T> error(T result, int code, String message){
        return new Return<T>(result, false, code, message);
    }

    /**
     * 自定义失败二
     */
    public static <T> Return<T> error(int code, String message){
        return new Return<T>(false, code, message);
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
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
