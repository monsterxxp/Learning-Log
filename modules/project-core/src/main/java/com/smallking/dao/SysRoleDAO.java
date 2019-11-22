package com.smallking.dao;

import com.smallking.dto.SysRoleDTO;
import com.smallking.model.SysRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 描述：角色表DAO 层
 * @author WangShaoXiong
 * @date 2019/11/21
 */
@Mapper
@Component
public interface SysRoleDAO extends BaseMapper<SysRole> {

    SysRoleDTO findDTOById(@Param("id") String id);


    /**
    * 描述：查询角色表列表以及高级搜索(分页)
    * @param pageable  分页参数
    * @param sysRoleDTO  角色表DTO
    */
    IPage<SysRoleDTO> findSysRolePage(Page pageable, @Param("val") SysRoleDTO sysRoleDTO);

    List<SysRoleDTO> findByAccount(@Param("account") String account);
}
