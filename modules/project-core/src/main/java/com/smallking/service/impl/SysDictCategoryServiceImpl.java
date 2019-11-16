package com.smallking.service.impl;

import com.smallking.listener.DeleteListenable;
import com.smallking.model.SysDictCategory;
import com.smallking.repository.SysDictCategoryRepository;
import com.smallking.service.ISysDictCategoryService;
import com.smallking.dao.SysDictCategoryDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smallking.dto.SysDictCategoryDTO;
import org.apache.commons.beanutils.BeanUtils;
import com.smallking.enums.StatusEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* 描述：字典类别 服务实现层
* @author WangShaoXiong
* @date 2019/11/14
*/
@Service
public class SysDictCategoryServiceImpl implements ISysDictCategoryService {

    @Autowired
    private SysDictCategoryDAO sysDictCategoryDAO;

    @Autowired
    private SysDictCategoryRepository sysDictCategoryRepository;

    @Override
    public SysDictCategoryDTO findDTOById(String id) throws Exception {
        SysDictCategoryDTO sysDictCategoryDTO = sysDictCategoryDAO.findDTOById(id);
        return sysDictCategoryDTO;
    }

    @Override
    public SysDictCategoryDTO createSysDictCategory(SysDictCategoryDTO sysDictCategoryDTO) throws Exception {
        SysDictCategory sysDictCategory = new SysDictCategory();
        BeanUtils.copyProperties(sysDictCategory,sysDictCategoryDTO);
        sysDictCategory.setStatus(StatusEnum.ENABLE.toString());
        sysDictCategory = sysDictCategoryRepository.saveAndFlush(sysDictCategory);
        return this.findDTOById(sysDictCategory.getId());
    }

    @Override
    public SysDictCategoryDTO updateSysDictCategory(SysDictCategoryDTO sysDictCategoryDTO)throws Exception {
        SysDictCategory sysDictCategory = new SysDictCategory();
        BeanUtils.copyProperties(sysDictCategory,sysDictCategoryDTO);
        sysDictCategory = sysDictCategoryRepository.saveAndFlush(sysDictCategory);
        return this.findDTOById(sysDictCategory.getId());
    }

    /**
    * 描述：查询列表(分页)
    * @param pageable  分页参数
    * @param sysDictCategoryDTO 实体DTO
    */
    @Override
    public IPage findSysDictCategoryPage(Page pageable, SysDictCategoryDTO sysDictCategoryDTO) throws Exception{
        return sysDictCategoryDAO.findSysDictCategoryPage(pageable, sysDictCategoryDTO);
    }

    @Override
    public void deleteById(String id) {
        SysDictCategory sysDictCategory = sysDictCategoryDAO.selectById(id);
        if (sysDictCategory instanceof DeleteListenable) {
            sysDictCategory.setStatus(StatusEnum.DELETED.toString());
            sysDictCategoryRepository.save(sysDictCategory);
        } else {
            sysDictCategoryRepository.deleteById(id);
        }
    }

}



