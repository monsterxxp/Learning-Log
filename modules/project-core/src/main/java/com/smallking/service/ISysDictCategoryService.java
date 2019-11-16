package com.smallking.service;

import com.smallking.dto.SysDictCategoryDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* 描述：字典类别 服务实现层接口
* @author WangShaoXiong
* @date 2019/11/14
*/
public interface ISysDictCategoryService {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    SysDictCategoryDTO findDTOById(String id)throws Exception;

    SysDictCategoryDTO createSysDictCategory(SysDictCategoryDTO sysDictCategoryDTO) throws Exception;

    SysDictCategoryDTO updateSysDictCategory(SysDictCategoryDTO sysDictCategoryDTO) throws Exception;

    IPage findSysDictCategoryPage(Page pageable, SysDictCategoryDTO sysDictCategoryDTO) throws Exception;

    void deleteById(String id);
}
