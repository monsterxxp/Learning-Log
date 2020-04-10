package com.smallking.service;

import com.smallking.dto.SysRoleRelationDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.model.SysRoleRelation;

import java.util.List;

/**
* 描述：角色关联表 服务实现层接口
* @author WangShaoXiong
* @date 2019/11/24
*/
public interface ISysRoleRelationService {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    SysRoleRelationDTO findDTOById(String id)throws Exception;

    SysRoleRelationDTO createSysRoleRelation(SysRoleRelationDTO sysRoleRelationDTO) throws Exception;

    SysRoleRelationDTO updateSysRoleRelation(SysRoleRelationDTO sysRoleRelationDTO) throws Exception;

    IPage findSysRoleRelationPage(Page pageable, SysRoleRelationDTO sysRoleRelationDTO) throws Exception;

    void deleteById(String id) throws Exception;

    List<SysRoleRelationDTO> findRoleRelation(SysRoleRelationDTO sysRoleRelationDTO);

    List<SysRoleRelation> batchSysRoleRelation(List<SysRoleRelation> sysRoleRelations);

    List<SysRoleRelation> findByUserId(String userId);

    void deleteByUserId(String userId);
}
