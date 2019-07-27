package com.smallking.learn.service.impl.mysqlrepository;

import com.smallking.learn.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 系统用户Repository
 * @Author: smallking
 * @Date: 2019-07-27
 */
@Repository
public interface SysUserRepositoryMysql extends JpaRepository<SysUser, String> {
}
