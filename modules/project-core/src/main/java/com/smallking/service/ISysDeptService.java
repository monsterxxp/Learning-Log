package com.smallking.service;

import com.smallking.common.TreeModel;
import com.smallking.dto.SysDeptDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.util.List;

/**
* 描述：组织结构表 服务实现层接口
* @author WangShaoXiong
* @date 2019/11/16
*/
public interface ISysDeptService {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    SysDeptDTO findDTOById(String id)throws Exception;

    SysDeptDTO createSysDept(SysDeptDTO sysDeptDTO) throws Exception;

    SysDeptDTO updateSysDept(SysDeptDTO sysDeptDTO) throws Exception;

    IPage findSysDeptPage(Page pageable, SysDeptDTO sysDeptDTO) throws Exception;

    void deleteById(String id) throws Exception;

    void deleteByIds(List<String> ids) throws Exception;

    /**
     * 获取组织树
     * @param sysDeptDTO
     * @return
     */
    List<TreeModel<SysDeptDTO>> findSysDeptTree(SysDeptDTO sysDeptDTO);

    void batchDelete(List<String> ids) throws Exception;
}
