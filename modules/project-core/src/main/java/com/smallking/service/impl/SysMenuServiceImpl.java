package com.smallking.service.impl;

import com.smallking.common.TreeModel;
import com.smallking.model.SysMenu;
import com.smallking.model.SysUser;
import com.smallking.repository.SysMenuRepository;
import com.smallking.service.ISysMenuService;
import com.smallking.dao.SysMenuDAO;
import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smallking.dto.SysMenuDTO;
import org.apache.commons.beanutils.BeanUtils;
import com.smallking.enums.StatusEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.listener.DeleteListenable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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

    @Override
    public List<TreeModel<SysMenuDTO>> findTree(SysMenuDTO sysMenuDTO) {
        List<SysMenuDTO> menus = sysMenuDAO.findSysMenuList(sysMenuDTO);
        List<TreeModel<SysMenuDTO>> list = new ArrayList<>();
        List<SysMenuDTO> rootNodes = new ArrayList<>();
        if (StringUtils.isNotEmpty(sysMenuDTO.getName())) {
            rootNodes = menus;
        } else {
            // 获取主节点
            rootNodes =  menus.stream().filter(dept -> "0".equals(dept.getParentId())).collect(Collectors.toList());
        }

        rootNodes.forEach(rootNode -> {
            TreeModel<SysMenuDTO> tree = new TreeModel<>();
            tree.setKey(rootNode.getId());
            tree.setTitle(rootNode.getName());
            tree.setParentId(rootNode.getParentId());
            tree.setSort(rootNode.getSort());
            tree.setData(rootNode);
            // 组装树
            if (StringUtils.isEmpty(sysMenuDTO.getName())) {
                initTree(tree, menus);
            }
            list.add(tree);
        });

        return list;
    }

    @Override
    public List<SysMenuDTO> findMenuByUserId(String userId) {
        return sysMenuDAO.findMenuByUserId(userId);
    }

    @Override
    public List<SysMenu> findAll() {
        return sysMenuRepository.findAll();
    }

    private void initTree(TreeModel<SysMenuDTO> tree, List<SysMenuDTO> menus) {
        List<SysMenuDTO> subNode = menus.stream().filter(menu -> tree.getKey().equals(menu.getParentId())).collect(Collectors.toList());
        if (subNode.size() > 0) {
            List<TreeModel<SysMenuDTO>> subList = new ArrayList<>();
            subNode.forEach(menu -> {
                TreeModel<SysMenuDTO> subTree = new TreeModel<>();
                subTree.setKey(menu.getId());
                subTree.setTitle(menu.getName());
                subTree.setParentId(menu.getParentId());
                subTree.setSort(menu.getSort());
                subTree.setData(menu);
                subList.add(subTree);
                initTree(subTree, menus);
            });
            tree.setChildren(subList);
        } else {
            return;
        }
    }
}



