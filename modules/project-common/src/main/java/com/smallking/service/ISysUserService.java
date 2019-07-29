package com.smallking.service;

import com.smallking.model.SysUser;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

import java.util.List;
import java.util.Map;

/**
 * 系统用户接口
 * @Author: smallking
 * @Date: 2019-07-27
 */
@CacheConfig(cacheNames = "student")
public interface ISysUserService {

    /**
     * 查询所有系统用户
     * @param
     * @return: {@link {@link List< SysUser>}}
     * @throws
     * @Author: smallking
     * @Date: 2019-07-27
     */
    List<SysUser> findAll();

    /**
     * mysql数据源查询系统用户
     * @param
     * @return: {@link {@link List< SysUser>}}
     * @throws
     * @Author: smallking
     * @Date: 2019-07-27
     */
    List<SysUser> findAllByJPA();

    /**
     * 新增用户
     * @param
     * @return: {@link {@link SysUser}}
     * @throws
     * @Author: smallking
     * @Date: 2019-07-27
     */
    SysUser create();
    /**
     * 修改用户
     * @param
     * @return: {@link {@link SysUser}}
     * @throws
     * @Author: smallking
     * @Date: 2019-07-27
     */

    @CachePut(key = "#p0.id")
    SysUser update(SysUser sysUser);

    @Cacheable(key = "#p0")
    SysUser findById(String id);

    @CacheEvict(key = "#p0", allEntries = true)
    void delete(String id);
}
