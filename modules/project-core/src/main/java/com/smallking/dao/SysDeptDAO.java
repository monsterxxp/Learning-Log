package com.smallking.dao;

import com.smallking.dto.SysDeptDTO;
import com.smallking.model.SysDept;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 描述：组织结构表DAO 层
 * @author WangShaoXiong
 * @date 2019/11/16
 */
@Mapper
@Component
public interface SysDeptDAO extends BaseMapper<SysDept> {

    SysDeptDTO findDTOById(@Param("id") String id);


    /**
    * 描述：查询组织结构表列表以及高级搜索(分页)
    * @param pageable  分页参数
    * @param sysDeptDTO  组织结构表DTO
    */
    IPage<SysDeptDTO> findSysDeptPage(Page pageable, @Param("val") SysDeptDTO sysDeptDTO);

    List<SysDeptDTO> findSysDeptList(SysDeptDTO sysDeptDTO);
}
