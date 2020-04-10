package com.smallking.service;

import com.smallking.dto.SysMenuRelationDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.model.SysMenuRelation;

import java.util.List;

/**
* 描述：权限关联表 服务实现层接口
* @author WangShaoXiong
* @date 2019/11/26
*/
public interface ISysMenuRelationService {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    SysMenuRelationDTO findDTOById(String id)throws Exception;

    SysMenuRelationDTO createSysMenuRelation(SysMenuRelationDTO sysMenuRelationDTO) throws Exception;

    SysMenuRelationDTO updateSysMenuRelation(SysMenuRelationDTO sysMenuRelationDTO) throws Exception;

    IPage findSysMenuRelationPage(Page pageable, SysMenuRelationDTO sysMenuRelationDTO) throws Exception;

    void deleteById(String id) throws Exception;

    List<SysMenuRelation> findByRoleId(String id);

    List<SysMenuRelation> batchCreateSysMenuRelation(String roleId, List<SysMenuRelation> sysMenuRelations);

    void deleteByRoleId(String roleId);
}
