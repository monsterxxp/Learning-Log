package com.smallking.dao;

import com.smallking.dto.SysMenuDTO;
import com.smallking.model.SysMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
/**
 * 描述：菜单表DAO 层
 * @author WangShaoXiong
 * @date 2019/11/21
 */
@Mapper
@Component
public interface SysMenuDAO extends BaseMapper<SysMenu> {

    SysMenuDTO findDTOById(@Param("id") String id);


    /**
    * 描述：查询菜单表列表以及高级搜索(分页)
    * @param pageable  分页参数
    * @param sysMenuDTO  菜单表DTO
    */
    IPage<SysMenuDTO> findSysMenuPage(Page pageable, SysMenuDTO sysMenuDTO);

}
