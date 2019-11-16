package com.smallking.dao;

import com.smallking.dto.SysDictCategoryDTO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.model.SysDictCategory;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
/**
 * 描述：字典类别DAO 层
 * @author WangShaoXiong
 * @date 2019/11/14
 */
@Mapper
@Component
public interface SysDictCategoryDAO extends BaseMapper<SysDictCategory> {

    SysDictCategoryDTO findDTOById(@Param("id") String id);


    /**
    * 描述：查询字典类别列表以及高级搜索(分页)
    * @param pageable  分页参数
    * @param sysDictCategoryDTO  会议室预订DTO
    */
    Page<SysDictCategoryDTO> findSysDictCategoryPage(Page pageable, @Param("val") SysDictCategoryDTO sysDictCategoryDTO);

}
