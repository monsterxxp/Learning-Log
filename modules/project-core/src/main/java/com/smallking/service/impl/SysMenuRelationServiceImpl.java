package com.smallking.service.impl;

import com.smallking.model.SysMenuRelation;
import com.smallking.repository.SysMenuRelationRepository;
import com.smallking.service.ISysMenuRelationService;
import com.smallking.dao.SysMenuRelationDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smallking.dto.SysMenuRelationDTO;
import org.apache.commons.beanutils.BeanUtils;
import com.smallking.enums.StatusEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.listener.DeleteListenable;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 描述：权限关联表 服务实现层
* @author WangShaoXiong
* @date 2019/11/26
*/
@Service
public class SysMenuRelationServiceImpl implements ISysMenuRelationService {

    @Autowired
    private SysMenuRelationDAO sysMenuRelationDAO;

    @Autowired
    private SysMenuRelationRepository sysMenuRelationRepository;

    @Override
    public SysMenuRelationDTO findDTOById(String id) throws Exception {
        SysMenuRelationDTO sysMenuRelationDTO = sysMenuRelationDAO.findDTOById(id);
        return sysMenuRelationDTO;
    }

    @Override
    public SysMenuRelationDTO createSysMenuRelation(SysMenuRelationDTO sysMenuRelationDTO) throws Exception {
        SysMenuRelation sysMenuRelation = new SysMenuRelation();
        BeanUtils.copyProperties(sysMenuRelation,sysMenuRelationDTO);
        sysMenuRelation = sysMenuRelationRepository.saveAndFlush(sysMenuRelation);
        return this.findDTOById(sysMenuRelation.getId());
    }

    @Override
    public SysMenuRelationDTO updateSysMenuRelation(SysMenuRelationDTO sysMenuRelationDTO)throws Exception {
        SysMenuRelation sysMenuRelation = new SysMenuRelation();
        BeanUtils.copyProperties(sysMenuRelation,sysMenuRelationDTO);
        sysMenuRelation = sysMenuRelationRepository.saveAndFlush(sysMenuRelation);
        return this.findDTOById(sysMenuRelation.getId());
    }

    /**
    * 描述：查询列表(分页)
    * @param pageable  分页参数
    * @param sysMenuRelationDTO 实体DTO
    */
    @Override
    public IPage findSysMenuRelationPage(Page pageable, SysMenuRelationDTO sysMenuRelationDTO) throws Exception{
        return sysMenuRelationDAO.findSysMenuRelationPage(pageable, sysMenuRelationDTO);
    }

    @Override
    public void deleteById(String id) throws Exception {
        sysMenuRelationRepository.deleteById(id);
    }

    @Override
    public List<SysMenuRelation> findByRoleId(String id) {
        return sysMenuRelationRepository.findByRoleId(id);
    }

    @Override
    @Transactional
    public List<SysMenuRelation> batchCreateSysMenuRelation(String roleId, List<SysMenuRelation> sysMenuRelations) {
        // 删除原有权限关联，重新进行关联
        sysMenuRelationRepository.deleteSysMenuRelationByRoleId(roleId);
        //关联权限
        return sysMenuRelationRepository.saveAll(sysMenuRelations);
    }

    @Override
    public void deleteByRoleId(String roleId) {
        sysMenuRelationRepository.deleteSysMenuRelationByRoleId(roleId);
    }

}



