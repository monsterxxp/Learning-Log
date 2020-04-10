package com.smallking.dto;

import com.smallking.model.SysDict;

/**
* 描述：数据字典表DTO
* @author WangShaoXiong
* @date 2019/11/16
*/
public class SysDictDTO extends SysDict{

    private String categoryId;

    private String categoryName;

    private String parentName;

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
