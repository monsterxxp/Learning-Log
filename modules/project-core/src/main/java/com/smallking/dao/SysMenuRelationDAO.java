package com.smallking.dao;

import com.smallking.dto.SysMenuRelationDTO;
import com.smallking.model.SysMenuRelation;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
/**
 * 描述：权限关联表DAO 层
 * @author WangShaoXiong
 * @date 2019/11/26
 */
@Mapper
@Component
public interface SysMenuRelationDAO extends BaseMapper<SysMenuRelation> {

    SysMenuRelationDTO findDTOById(@Param("id") String id);


    /**
    * 描述：查询权限关联表列表以及高级搜索(分页)
    * @param pageable  分页参数
    * @param sysMenuRelationDTO  权限关联表DTO
    */
    IPage<SysMenuRelationDTO> findSysMenuRelationPage(Page pageable, SysMenuRelationDTO sysMenuRelationDTO);

}
