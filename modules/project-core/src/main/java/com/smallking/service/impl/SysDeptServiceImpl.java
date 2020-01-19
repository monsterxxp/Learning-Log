package com.smallking.service.impl;

import com.smallking.common.TreeModel;
import com.smallking.model.SysDept;
import com.smallking.repository.SysDeptRepository;
import com.smallking.service.ISysDeptService;
import com.smallking.dao.SysDeptDAO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smallking.dto.SysDeptDTO;
import org.apache.commons.beanutils.BeanUtils;
import com.smallking.enums.StatusEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.listener.DeleteListenable;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
* 描述：组织结构表 服务实现层
* @author WangShaoXiong
* @date 2019/11/16
*/
@Service
public class SysDeptServiceImpl implements ISysDeptService {

    @Autowired
    private SysDeptDAO sysDeptDAO;

    @Autowired
    private SysDeptRepository sysDeptRepository;

    @Override
    public SysDeptDTO findDTOById(String id) throws Exception {
        SysDeptDTO sysDeptDTO = sysDeptDAO.findDTOById(id);
        return sysDeptDTO;
    }

    @Override
    public SysDeptDTO createSysDept(SysDeptDTO sysDeptDTO) throws Exception {
        SysDept sysDept = new SysDept();
        BeanUtils.copyProperties(sysDept,sysDeptDTO);
        sysDept.setStatus(StatusEnum.ENABLE.toString());
        sysDept = sysDeptRepository.saveAndFlush(sysDept);
        return this.findDTOById(sysDept.getId());
    }

    @Override
    public SysDeptDTO updateSysDept(SysDeptDTO sysDeptDTO)throws Exception {
        SysDept sysDept = new SysDept();
        BeanUtils.copyProperties(sysDept,sysDeptDTO);
        sysDept = sysDeptRepository.saveAndFlush(sysDept);
        return this.findDTOById(sysDept.getId());
    }

    /**
    * 描述：查询列表(分页)
    * @param pageable  分页参数
    * @param sysDeptDTO 实体DTO
    */
    @Override
    public IPage findSysDeptPage(Page pageable, SysDeptDTO sysDeptDTO) throws Exception{
        return sysDeptDAO.findSysDeptPage(pageable, sysDeptDTO);
    }

    @Override
    public void deleteById(String id) throws Exception {
        SysDept sysDept = sysDeptDAO.selectById(id);
        if (sysDept instanceof DeleteListenable) {
            sysDept.setStatus(StatusEnum.DELETED.toString());
            sysDeptRepository.save(sysDept);
        } else {
            sysDeptRepository.deleteById(id);
        }
    }

    @Override
    public List<TreeModel<SysDeptDTO>> findSysDeptTree(SysDeptDTO sysDeptDTO) {
        List<SysDeptDTO> depts = sysDeptDAO.findSysDeptList(sysDeptDTO);
        List<TreeModel<SysDeptDTO>> list = new ArrayList<>();
        List<SysDeptDTO> rootNodes = new ArrayList<>();
        if (StringUtils.isNotEmpty(sysDeptDTO.getName())) {
            rootNodes = depts;
        } else {
            // 获取主节点
            rootNodes =  depts.stream().filter(dept -> "0".equals(dept.getParentId())).collect(Collectors.toList());
        }

        rootNodes.forEach(rootNode -> {
            TreeModel<SysDeptDTO> tree = new TreeModel<>();
            tree.setKey(rootNode.getId());
            tree.setValue(rootNode.getId());
            tree.setTitle(rootNode.getName());
            tree.setParentId(rootNode.getParentId());
            tree.setSort(rootNode.getSort());
            tree.setData(rootNode);
            // 组装树
            if (StringUtils.isEmpty(sysDeptDTO.getName())) {
                initTree(tree, depts);
            }
            list.add(tree);
        });

        return list;
    }

    private void initTree(TreeModel<SysDeptDTO> tree, List<SysDeptDTO> depts) {
        List<SysDeptDTO> subNode = depts.stream().filter(dept -> tree.getKey().equals(dept.getParentId())).collect(Collectors.toList());
        if (subNode.size() > 0) {
            List<TreeModel<SysDeptDTO>> subList = new ArrayList<>();
            subNode.forEach(dept -> {
                TreeModel<SysDeptDTO> subTree = new TreeModel<>();
                subTree.setKey(dept.getId());
                subTree.setValue(dept.getId());
                subTree.setTitle(dept.getName());
                subTree.setParentId(dept.getParentId());
                subTree.setSort(dept.getSort());
                subTree.setData(dept);
                subList.add(subTree);
                initTree(subTree, depts);
            });
            tree.setChildren(subList);
        } else {
            return;
        }

    }

}



