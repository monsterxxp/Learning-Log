package com.smallking.service;
import com.smallking.model.dto.SysDictCategoryDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
* 描述：会议室预订 服务实现层接口
* @author WangShaoXiong
* @date 2019/11/10
*/
public interface ISysDictCategoryService {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    SysDictCategoryDTO findDTOById(String id)throws Exception;

    SysDictCategoryDTO createSysDictCategory(SysDictCategoryDTO sysDictCategoryDTO) throws Exception;

    SysDictCategoryDTO updateSysDictCategory(SysDictCategoryDTO sysDictCategoryDTO) throws Exception;

    Page<SysDictCategoryDTO> findSysDictCategoryPage(SysDictCategoryDTO sysDictCategoryDTO, Pageable page) throws Exception;

}
