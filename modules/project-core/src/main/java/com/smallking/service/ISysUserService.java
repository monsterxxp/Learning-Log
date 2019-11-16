package com.smallking.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.dto.SysUserDTO;

import java.util.List;

/**
 * 系统用户接口
 * @Author: smallking
 * @Date: 2019-07-27
 */
public interface ISysUserService {
   /**
    * 根据用户名查询系统用户
    *
    * @param  account
    * @return  sysUser
    * @date  2019-07-31
    */
    SysUserDTO findByAccount(String account);

    IPage findPage(Page pageable, SysUserDTO sysUserDTO);

    SysUserDTO create(SysUserDTO sysUserDTO) throws Exception;

    SysUserDTO findDTOById(String id);

    SysUserDTO update(SysUserDTO sysUserDTO) throws Exception;

    void deleteById(String id) throws Exception;

    SysUserDTO resetPwd(SysUserDTO sysUserDTO) throws Exception;

    void batchBulk(List<String> ids) throws Exception;
}
