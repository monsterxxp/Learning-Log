package com.smallking.service;

import com.smallking.model.SysUser;

import java.util.List;
import java.util.Map;

/**
 * 系统用户接口
 * @Author: smallking
 * @Date: 2019-07-27
 */
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
     * jdbctemplate查询所有系统用户
     * @param
     * @return: {@link {@link List< Map< String, Object>>}}
     * @throws
     * @Author: smallking
     * @Date: 2019-07-27
     */
    List<Map<String, Object>> findAllByJdbcTemplate();

    /**
     * Jpa查询所有系统用户
     * @param
     * @return: {@link {@link List< Map< String, Object>>}}
     * @throws
     * @Author: smallking
     * @Date: 2019-07-27
     */
    List<SysUser> findAllByJpa();

    /**
     * 新建用户
     * @param
     * @return: {@link {@link SysUser}}
     * @throws
     * @Author: smallking
     * @Date: 2019-07-27
     */
    SysUser create();

    /**
     * mysql数据源查询系统用户
     * @param
     * @return: {@link {@link List< SysUser>}}
     * @throws
     * @Author: smallking
     * @Date: 2019-07-27
     */
    List<SysUser> findAllByMysql();

    /**
     * mysql数据源查询系统用户
     * @param[id]
     * @return: {@link {@link List< SysUser>}}
     * @throws
     * @Author: smallking
     * @Date: 2019-07-27
     */
    SysUser findById(String id);
}
