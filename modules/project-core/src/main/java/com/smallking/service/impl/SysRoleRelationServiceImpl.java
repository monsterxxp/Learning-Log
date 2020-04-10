package com.smallking.service.impl;

import com.smallking.model.SysRoleRelation;
import com.smallking.repository.SysRoleRelationRepository;
import com.smallking.service.ISysRoleRelationService;
import com.smallking.dao.SysRoleRelationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smallking.dto.SysRoleRelationDTO;
import org.apache.commons.beanutils.BeanUtils;
import com.smallking.enums.StatusEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.listener.DeleteListenable;

import java.util.List;

/**
* 描述：角色关联表 服务实现层
* @author WangShaoXiong
* @date 2019/11/24
*/
@Service
public class SysRoleRelationServiceImpl implements ISysRoleRelationService {

    @Autowired
    private SysRoleRelationDAO sysRoleRelationDAO;

    @Autowired
    private SysRoleRelationRepository sysRoleRelationRepository;

    @Override
    public SysRoleRelationDTO findDTOById(String id) throws Exception {
        SysRoleRelationDTO sysRoleRelationDTO = sysRoleRelationDAO.findDTOById(id);
        return sysRoleRelationDTO;
    }

    @Override
    public SysRoleRelationDTO createSysRoleRelation(SysRoleRelationDTO sysRoleRelationDTO) throws Exception {
        SysRoleRelation sysRoleRelation = new SysRoleRelation();
        BeanUtils.copyProperties(sysRoleRelation,sysRoleRelationDTO);
        sysRoleRelation = sysRoleRelationRepository.saveAndFlush(sysRoleRelation);
        return this.findDTOById(sysRoleRelation.getId());
    }

    @Override
    public SysRoleRelationDTO updateSysRoleRelation(SysRoleRelationDTO sysRoleRelationDTO)throws Exception {
        SysRoleRelation sysRoleRelation = new SysRoleRelation();
        BeanUtils.copyProperties(sysRoleRelation,sysRoleRelationDTO);
        sysRoleRelation = sysRoleRelationRepository.saveAndFlush(sysRoleRelation);
        return this.findDTOById(sysRoleRelation.getId());
    }

    /**
    * 描述：查询列表(分页)
    * @param pageable  分页参数
    * @param sysRoleRelationDTO 实体DTO
    */
    @Override
    public IPage findSysRoleRelationPage(Page pageable, SysRoleRelationDTO sysRoleRelationDTO) throws Exception{
        return sysRoleRelationDAO.findSysRoleRelationPage(pageable, sysRoleRelationDTO);
    }

    @Override
    public void deleteById(String id) throws Exception {
        sysRoleRelationRepository.deleteById(id);
    }

    @Override
    public List<SysRoleRelationDTO> findRoleRelation(SysRoleRelationDTO sysRoleRelationDTO) {
        return sysRoleRelationDAO.findRoleRelationList(sysRoleRelationDTO);
    }

    @Override
    public List<SysRoleRelation> batchSysRoleRelation(List<SysRoleRelation> sysRoleRelations) {
        return sysRoleRelationRepository.saveAll(sysRoleRelations);
    }

    @Override
    public List<SysRoleRelation> findByUserId(String userId) {
        return sysRoleRelationRepository.findSysRoleRelationByUserId(userId);
    }

    @Override
    public void deleteByUserId(String userId) {
        sysRoleRelationRepository.deleteSysRoleRelationByUserId(userId);
    }

}



