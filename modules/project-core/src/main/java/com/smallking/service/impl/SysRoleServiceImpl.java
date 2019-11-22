package com.smallking.service.impl;

import com.smallking.model.SysRole;
import com.smallking.repository.SysRoleRepository;
import com.smallking.service.ISysRoleService;
import com.smallking.dao.SysRoleDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smallking.dto.SysRoleDTO;
import org.apache.commons.beanutils.BeanUtils;
import com.smallking.enums.StatusEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.listener.DeleteListenable;

/**
* 描述：角色表 服务实现层
* @author WangShaoXiong
* @date 2019/11/21
*/
@Service
public class SysRoleServiceImpl implements ISysRoleService {

    @Autowired
    private SysRoleDAO sysRoleDAO;

    @Autowired
    private SysRoleRepository sysRoleRepository;

    @Override
    public SysRoleDTO findDTOById(String id) throws Exception {
        SysRoleDTO sysRoleDTO = sysRoleDAO.findDTOById(id);
        return sysRoleDTO;
    }

    @Override
    public SysRoleDTO createSysRole(SysRoleDTO sysRoleDTO) throws Exception {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRole,sysRoleDTO);
        sysRole.setStatus(StatusEnum.ENABLE.toString());
        sysRole = sysRoleRepository.saveAndFlush(sysRole);
        return this.findDTOById(sysRole.getId());
    }

    @Override
    public SysRoleDTO updateSysRole(SysRoleDTO sysRoleDTO)throws Exception {
        SysRole sysRole = new SysRole();
        BeanUtils.copyProperties(sysRole,sysRoleDTO);
        sysRole = sysRoleRepository.saveAndFlush(sysRole);
        return this.findDTOById(sysRole.getId());
    }

    /**
    * 描述：查询列表(分页)
    * @param pageable  分页参数
    * @param sysRoleDTO 实体DTO
    */
    @Override
    public IPage findSysRolePage(Page pageable, SysRoleDTO sysRoleDTO) throws Exception{
        return sysRoleDAO.findSysRolePage(pageable, sysRoleDTO);
    }

    @Override
    public void deleteById(String id) throws Exception {
        SysRole sysRole = sysRoleDAO.selectById(id);
        if (sysRole instanceof DeleteListenable) {
            sysRole.setStatus(StatusEnum.DELETED.toString());
            sysRoleRepository.save(sysRole);
        } else {
            sysRoleRepository.deleteById(id);
        }
    }

}



