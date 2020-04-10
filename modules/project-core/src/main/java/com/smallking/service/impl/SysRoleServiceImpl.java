package com.smallking.service.impl;

import com.google.common.collect.Maps;
import com.smallking.common.TreeModel;
import com.smallking.dto.SysMenuDTO;
import com.smallking.model.SysMenu;
import com.smallking.model.SysMenuRelation;
import com.smallking.model.SysRole;
import com.smallking.repository.SysRoleRepository;
import com.smallking.service.ISysMenuRelationService;
import com.smallking.service.ISysMenuService;
import com.smallking.service.ISysRoleService;
import com.smallking.dao.SysRoleDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smallking.dto.SysRoleDTO;
import org.apache.commons.beanutils.BeanUtils;
import com.smallking.enums.StatusEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.listener.DeleteListenable;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private ISysMenuService sysMenuService;

    @Autowired
    private ISysMenuRelationService sysMenuRelationService;

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

    @Override
    public IPage findRoleByUserId(Page pageable, SysRoleDTO sysRoleDTO) throws Exception {
        return sysRoleDAO.findRoleByUserId(pageable, sysRoleDTO);
    }

    @Override
    public List<TreeModel<SysMenu>> findAuthByRoleId(String id) {
        List<SysMenu> menus = sysMenuService.findAll();
        List<TreeModel<SysMenu>> list = new ArrayList<>();
        List<SysMenu> rootNodes = menus.stream().filter(dept -> "0".equals(dept.getParentId())).collect(Collectors.toList());
        List<String> menuIds = sysMenuRelationService.findByRoleId(id).stream().map(item -> item.getMenuId()).collect(Collectors.toList());

        rootNodes.forEach(rootNode -> {
            TreeModel<SysMenu> tree = new TreeModel<>();
            tree.setKey(rootNode.getId());
            tree.setValue(rootNode.getId());
            tree.setTitle(rootNode.getName());
            tree.setParentId(rootNode.getParentId());
            tree.setSort(rootNode.getSort());
            tree.setData(rootNode);
            tree.setCheck(false);
            if (menuIds.contains(rootNode.getId())) {
                tree.setCheck(true);
            } else {
                tree.setCheck(false);
            }
            Map<String, Object> slots = Maps.newHashMap();
            slots.put("title", "title");
            tree.setScopedSlots(slots);
            initTree(tree, menus, menuIds);
            list.add(tree);
        });

        return list;
    }

    @Override
    public List<TreeModel<SysMenu>> updateAuth(String id, List<String> menuIds) throws Exception {
        List<SysMenuRelation> sysMenuRelations = new ArrayList<>();
        menuIds.forEach(menuId -> {
            SysMenuRelation sysMenuRelation = new SysMenuRelation();
            sysMenuRelation.setRoleId(id);
            sysMenuRelation.setMenuId(menuId);
            sysMenuRelations.add(sysMenuRelation);
        });
        sysMenuRelationService.batchCreateSysMenuRelation(id, sysMenuRelations);
        return this.findAuthByRoleId(id);
    }

    @Override
    public List<SysRole> findAll() {
        return sysRoleRepository.findAll();
    }

    @Override
    public void batchBulk(List<String> ids) throws Exception {
        List<SysRole> userList = sysRoleDAO.selectBatchIds(ids);
        if (new SysRole() instanceof DeleteListenable) {
            userList.forEach(user -> {
                user.setStatus(StatusEnum.DELETED.toString());
            });
            sysRoleRepository.saveAll(userList);
        } else {
            sysRoleRepository.deleteInBatch(userList);
        }
    }

    private void initTree(TreeModel<SysMenu> tree, List<SysMenu> menus, List<String> menuIds) {
        List<SysMenu> subNode = menus.stream().filter(menu -> tree.getKey().equals(menu.getParentId())).collect(Collectors.toList());
        if (subNode.size() > 0) {
            List<TreeModel<SysMenu>> subList = new ArrayList<>();
            subNode.forEach(menu -> {
                TreeModel<SysMenu> subTree = new TreeModel<>();
                subTree.setKey(menu.getId());
                subTree.setTitle(menu.getName());
                subTree.setValue(menu.getId());
                subTree.setParentId(menu.getParentId());
                subTree.setSort(menu.getSort());
                subTree.setData(menu);
                subTree.setCheck(false);
                if (menuIds.contains(menu.getId())) {
                    subTree.setCheck(true);
                } else {
                    subTree.setCheck(false);
                }
                Map<String, Object> slots = Maps.newHashMap();
                slots.put("title", "title");
                subTree.setScopedSlots(slots);
                subList.add(subTree);
                initTree(subTree, menus, menuIds);
            });
            tree.setChildren(subList);
        } else {
            return;
        }
    }

}



