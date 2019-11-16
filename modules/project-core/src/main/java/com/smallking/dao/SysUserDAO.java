package com.smallking.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
import com.smallking.model.SysUser;
import com.smallking.dto.SysUserDTO;

/**
 * 系统用户DAO
 * @Author: smallking
 * @Date: 2019-07-27
 */
@Mapper
@Component
public interface SysUserDAO extends BaseMapper<SysUser> {

    SysUserDTO findByAccount(@Param("account") String account);

    IPage findPage(Page pageable, @Param("val") SysUserDTO sysUserDTO);

    SysUserDTO findDTOById(@Param("id") String id);
}
