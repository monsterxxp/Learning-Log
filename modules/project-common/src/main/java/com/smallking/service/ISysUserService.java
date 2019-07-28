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
    SysUser update(String id);
}
