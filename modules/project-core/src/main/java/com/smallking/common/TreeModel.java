package com.smallking.common;

import java.util.List;

public class TreeModel<T> {

    private String id;
    private String name;
    private List<TreeModel<T>> children;
//    private boolean hasChildren;
    private T data;
    private String parentId;
    private Integer sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
}
