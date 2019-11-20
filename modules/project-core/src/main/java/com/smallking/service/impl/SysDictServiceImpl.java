package com.smallking.service.impl;

import com.smallking.common.BizException;
import com.smallking.model.SysDict;
import com.smallking.repository.SysDictRepository;
import com.smallking.service.ISysDictService;
import com.smallking.dao.SysDictDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smallking.dto.SysDictDTO;
import org.apache.commons.beanutils.BeanUtils;
import com.smallking.enums.StatusEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.listener.DeleteListenable;

import java.util.List;

/**
* 描述：数据字典表 服务实现层
* @author WangShaoXiong
* @date 2019/11/16
*/
@Service
public class SysDictServiceImpl implements ISysDictService {

    @Autowired
    private SysDictDAO sysDictDAO;

    @Autowired
    private SysDictRepository sysDictRepository;

    @Override
    public SysDictDTO findDTOById(String id) throws Exception {
        SysDictDTO sysDictDTO = sysDictDAO.findDTOById(id);
        return sysDictDTO;
    }

    @Override
    public SysDictDTO createSysDict(SysDictDTO sysDictDTO) throws Exception {
        if (sysDictRepository.findByCategoryCodeAndCode(sysDictDTO.getCategoryCode(), sysDictDTO.getCode()) != null) {
            throw new BizException("字典参数代码已存在，请重新输入");
        }
        SysDict sysDict = new SysDict();
        BeanUtils.copyProperties(sysDict,sysDictDTO);
        sysDict.setStatus(StatusEnum.ENABLE.toString());
        sysDict.setIsUpdate("1");
        sysDict = sysDictRepository.saveAndFlush(sysDict);
        return this.findDTOById(sysDict.getId());
    }

    @Override
    public SysDictDTO updateSysDict(SysDictDTO sysDictDTO)throws Exception {
        SysDict temp = sysDictRepository.findByCategoryCodeAndCode(sysDictDTO.getCategoryCode(), sysDictDTO.getCode());
        if (temp != null && !temp.getId().equals(sysDictDTO.getId())) {
            throw new BizException("字典参数代码已存在，请重新输入");
        }
        SysDict sysDict = new SysDict();
        BeanUtils.copyProperties(sysDict,sysDictDTO);
        sysDict = sysDictRepository.saveAndFlush(sysDict);
        return this.findDTOById(sysDict.getId());
    }

    /**
    * 描述：查询列表(分页)
    * @param pageable  分页参数
    * @param sysDictDTO 实体DTO
    */
    @Override
    public IPage findSysDictPage(Page pageable, SysDictDTO sysDictDTO) throws Exception{
        return sysDictDAO.findSysDictPage(pageable, sysDictDTO);
    }

    @Override
    public void deleteById(String id) throws Exception {
        SysDict sysDict = sysDictDAO.selectById(id);
        if (sysDict instanceof DeleteListenable) {
            sysDict.setStatus(StatusEnum.DELETED.toString());
            sysDictRepository.save(sysDict);
        } else {
            sysDictRepository.deleteById(id);
        }
    }

    @Override
    public List<SysDictDTO> findByCategoryCode(String categoryCode) throws Exception {
        return sysDictDAO.findByCategoryCode(categoryCode);
    }

}



