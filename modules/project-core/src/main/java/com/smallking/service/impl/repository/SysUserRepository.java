package com.smallking.service.impl.repository;

import com.smallking.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * 系统用户Repository
 * @Author: smallking
 * @Date: 2019-07-27
 */
@Repository
public interface SysUserRepository extends JpaRepository<SysUser, String> {
}
