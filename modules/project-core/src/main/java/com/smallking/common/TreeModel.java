package com.smallking.common;

import java.util.List;

public class TreeModel<T> {

    private String key;
    private String title;
    private String value;
    private List<TreeModel<T>> children;
    private boolean check;
//    private boolean hasChildren;
    private T data;
    private String parentId;
    private Integer sort;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<TreeModel<T>> getChildren() {
        return children;
    }

    public void setChildren(List<TreeModel<T>> children) {
        this.children = children;
    }

//    public boolean isHasChildren() {
//        return hasChildren;
//    }
//
//    public void setHasChildren(boolean hasChildren) {
//        this.hasChildren = hasChildren;
//    }


    public boolean isCheck() {
        return check;
    }

    public void setCheck(boolean check) {
        this.check = check;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
