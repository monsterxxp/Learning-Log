package com.smallking.service;

import com.smallking.dto.SysDictDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
* 描述：数据字典表 服务实现层接口
* @author WangShaoXiong
* @date 2019/11/16
*/
public interface ISysDictService {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    SysDictDTO findDTOById(String id)throws Exception;

    SysDictDTO createSysDict(SysDictDTO sysDictDTO) throws Exception;

    SysDictDTO updateSysDict(SysDictDTO sysDictDTO) throws Exception;

    IPage findSysDictPage(Page pageable, SysDictDTO sysDictDTO) throws Exception;

    void deleteById(String id) throws Exception;

    List<SysDictDTO> findByCategoryCode(String categoryCode) throws Exception;

}
