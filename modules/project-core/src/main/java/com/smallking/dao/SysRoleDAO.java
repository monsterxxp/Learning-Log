package com.smallking.dao;

import com.smallking.model.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @description: 角色DAO
 * @author: smallking
 * @date: 2019-08-01
 **/
@Mapper
@Component
public interface SysRoleDAO {
    List<SysRole> findByAccount(@Param("account") String account);
}
