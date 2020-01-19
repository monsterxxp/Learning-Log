package com.smallking.dao;

import com.smallking.dto.SysRoleRelationDTO;
import com.smallking.model.SysRoleRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 描述：角色关联表DAO 层
 * @author WangShaoXiong
 * @date 2019/11/24
 */
@Mapper
@Component
public interface SysRoleRelationDAO extends BaseMapper<SysRoleRelation> {

    SysRoleRelationDTO findDTOById(@Param("id") String id);


    /**
    * 描述：查询角色关联表列表以及高级搜索(分页)
    * @param pageable  分页参数
    * @param sysRoleRelationDTO  角色关联表DTO
    */
    IPage<SysRoleRelationDTO> findSysRoleRelationPage(Page pageable, SysRoleRelationDTO sysRoleRelationDTO);

    List<SysRoleRelationDTO> findRoleRelationList(SysRoleRelationDTO sysRoleRelationDTO);
}
