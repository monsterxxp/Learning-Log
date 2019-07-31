package com.smallking.dao;

import com.smallking.model.SysUser;
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

    SysUser findByAccount(@Param("account") String account);
}
