package com.smallking.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
public interface SysUserDao extends BaseMapper<SysUser> {

    SysUser findByAccount(@Param("account") String account);

    IPage findPage(Page pageable, @Param("val") SysUser sysUser);
}
