package com.smallking.learninglog.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @program: learn
 * @description: 系统用户类
 * @author: smallking
 * @data: 2019-07-27 01:41
 **/
@Entity
@Table(name = "sys_user")
public class SysUser implements Serializable{

    private static final long serialVersionUID = -4806761471282761282L;

    @Id
    private String id;

    @Column(name = "name", columnDefinition = "VARCHAR")
    private String name;

    @Column(name = "account", columnDefinition = "VARCHAR")
    private String account;

    @Column(name = "password", columnDefinition = "VARCHAR")
    private String password;

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

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
