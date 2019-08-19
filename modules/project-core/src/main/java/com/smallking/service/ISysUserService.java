package com.smallking.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.model.SysUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

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
    SysUser findByAccount(String account);

    IPage findPage(Page pageable, SysUser sysUser);
}
