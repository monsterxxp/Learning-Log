package com.smallking.service.impl;

import com.smallking.model.SysMenu;
import com.smallking.repository.SysMenuRepository;
import com.smallking.service.ISysMenuService;
import com.smallking.dao.SysMenuDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smallking.dto.SysMenuDTO;
import org.apache.commons.beanutils.BeanUtils;
import com.smallking.enums.StatusEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.listener.DeleteListenable;

/**
* 描述：菜单表 服务实现层
* @author WangShaoXiong
* @date 2019/11/21
*/
@Service
public class SysMenuServiceImpl implements ISysMenuService {

    @Autowired
    private SysMenuDAO sysMenuDAO;

    @Autowired
    private SysMenuRepository sysMenuRepository;

    @Override
    public SysMenuDTO findDTOById(String id) throws Exception {
        SysMenuDTO sysMenuDTO = sysMenuDAO.findDTOById(id);
        return sysMenuDTO;
    }

    @Override
    public SysMenuDTO createSysMenu(SysMenuDTO sysMenuDTO) throws Exception {
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenu,sysMenuDTO);
        sysMenu.setStatus(StatusEnum.ENABLE.toString());
        sysMenu = sysMenuRepository.saveAndFlush(sysMenu);
        return this.findDTOById(sysMenu.getId());
    }

    @Override
    public SysMenuDTO updateSysMenu(SysMenuDTO sysMenuDTO)throws Exception {
        SysMenu sysMenu = new SysMenu();
        BeanUtils.copyProperties(sysMenu,sysMenuDTO);
        sysMenu = sysMenuRepository.saveAndFlush(sysMenu);
        return this.findDTOById(sysMenu.getId());
    }

    /**
    * 描述：查询列表(分页)
    * @param pageable  分页参数
    * @param sysMenuDTO 实体DTO
    */
    @Override
    public IPage findSysMenuPage(Page pageable, SysMenuDTO sysMenuDTO) throws Exception{
        return sysMenuDAO.findSysMenuPage(pageable, sysMenuDTO);
    }

    @Override
    public void deleteById(String id) throws Exception {
        SysMenu sysMenu = sysMenuDAO.selectById(id);
        if (sysMenu instanceof DeleteListenable) {
            sysMenu.setStatus(StatusEnum.DELETED.toString());
            sysMenuRepository.save(sysMenu);
        } else {
            sysMenuRepository.deleteById(id);
        }
    }

}



