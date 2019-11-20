package com.smallking.dao;

import com.smallking.dto.SysDictDTO;
import com.smallking.model.SysDict;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 描述：数据字典表DAO 层
 * @author WangShaoXiong
 * @date 2019/11/16
 */
@Mapper
@Component
public interface SysDictDAO extends BaseMapper<SysDict> {

    SysDictDTO findDTOById(@Param("id") String id);


    /**
    * 描述：查询数据字典表列表以及高级搜索(分页)
    * @param pageable  分页参数
    * @param sysDictDTO  数据字典表DTO
    */
    Page<SysDictDTO> findSysDictPage(Page pageable, @Param("val") SysDictDTO sysDictDTO);

    List<SysDictDTO> findByCategoryCode(@Param("categoryCode") String categoryCode);

}
