package com.smallking.dao;

import com.smallking.model.SysPermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: 权限DAO
 * @author: smallking
 * @date: 2019-08-01
 **/
@Mapper
@Component
public interface SysPermissionDao {

    List<SysPermission> findByAccount(@Param("account") String account);
}
