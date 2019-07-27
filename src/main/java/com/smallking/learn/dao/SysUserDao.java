package com.smallking.learn.dao;

import com.smallking.learn.model.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 系统用户DAO
 * @Author: smallking
 * @Date: 2019-07-27
 */
@Mapper
@Component
public interface SysUserDao {

    /**
     * 查询所有系统用户
     * @param
     * @return: {@link {@link List< SysUser>}}
     * @throws
     * @Author: smallking
     * @Date: 2019-07-27
     */
    @Select("SELECT * FROM sys_user")
    List<SysUser> findAll();

    @Select("SELECT * FROM sys_user WHERE id=#{id}")
    SysUser findById(@Param("id") String id);
}
