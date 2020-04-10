package com.smallking.model;

import com.smallking.common.BaseModel;
import com.smallking.listener.CreateListenable;
import com.smallking.listener.DeleteListenable;
import com.smallking.listener.UpdateListenable;
import org.hibernate.annotations.Where;
import javax.persistence.*;
import java.util.Date;

/**
* 描述：参数配置模型
* @author WangShaoXiong
* @date 2020/04/08
*/
@Entity
@Table(name="sys_parameter")
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class SysParameter extends BaseModel {

    /**
    *
    */
    @Column(name = "key",columnDefinition = "VARCHAR")
    private String key;


    /**
    *
    */
    @Column(name = "name",columnDefinition = "VARCHAR")
    private String name;


    /**
    *
    */
    @Column(name = "value",columnDefinition = "VARCHAR")
    private String value;


    /**
    *
    */
    @Column(name = "display_type",columnDefinition = "VARCHAR")
    private String displayType;


    /**
    *
    */

    @Column(name = "sort",columnDefinition = "INT")
    private Integer sort;

    /**
    *
    */
    @Column(name = "remark",columnDefinition = "VARCHAR")
    private String remark;

    public String getKey() {
        return this.key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return this.value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDisplayType() {
        return this.displayType;
    }

    public void setDisplayType(String displayType) {
        this.displayType = displayType;
    }

    public Integer getSort() {
    return this.sort;
    }

    public void setSort(Integer sort) {
    this.sort = sort;
    }

    public String getRemark() {
        return this.remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

}
