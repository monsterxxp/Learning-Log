package com.smallking.controller;

import com.smallking.common.TreeModel;
import com.smallking.service.ISysDeptService;
import com.smallking.model.SysDept;
import com.smallking.dto.SysDeptDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smallking.common.Query;
import com.smallking.common.Return;

import java.util.List;

/**
* 描述：组织结构表控制层
* @author WangShaoXiong
* @date 2019/11/16
*/
@RestController
@RequestMapping("/sysDept")
public class SysDeptController {

    @Autowired
    private ISysDeptService sysDeptService;

    /**
    * 描述：根据Id 查询
    * @param id  组织结构表id
    */
    @GetMapping(value = "/{id}")
    public Return<SysDeptDTO> findById(@PathVariable("id") String id)  throws Exception{
        return Return.ok(sysDeptService.findDTOById(id));
    }

    /**
    * 描述:创建组织结构表
    * @param sysDeptDTO  组织结构表DTO
    */
    @PostMapping(value = "")
    public Return<SysDeptDTO> create(@RequestBody SysDeptDTO sysDeptDTO) throws Exception {
        return Return.ok(sysDeptService.createSysDept(sysDeptDTO));
    }

    /**
    * 描述：删除组织结构表
    * @param id 组织结构表id
    */
    @DeleteMapping(value = "/{id}/bulk")
    public void deleteById(@PathVariable("id") String id) throws Exception {
        sysDeptService.deleteById(id);
    }

    /**
    * 描述：更新组织结构表
    * @param id 组织结构表id
    */
    @PutMapping(value = "/{id}")
    public Return<SysDeptDTO> updateSysDept(@PathVariable("id") String id,@RequestBody SysDeptDTO sysDeptDTO) throws Exception {
        sysDeptDTO.setId(id);
        return Return.ok(sysDeptService.updateSysDept(sysDeptDTO));
    }

    /**
    * 分页查询
    * @param query
    * @return
    * @throws Exception
    */
    @GetMapping(value = "")
    public Return<IPage> search(Query<SysDeptDTO> query) throws Exception{
        SysDeptDTO sysDeptDTO = (SysDeptDTO) query.getBean(SysDeptDTO.class);
        Page pageable = query.getPageable();
        IPage page = sysDeptService.findSysDeptPage(pageable, sysDeptDTO);
        return Return.ok(page);
    }

    /**
     * 分页查询
     * @param query
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/tree")
    public Return<List<TreeModel<SysDeptDTO>>> tree(Query<SysDeptDTO> query) throws Exception{
        SysDeptDTO sysDeptDTO = (SysDeptDTO) query.getBean(SysDeptDTO.class);
        List<TreeModel<SysDeptDTO>>  tree = sysDeptService.findSysDeptTree(sysDeptDTO);
        return Return.ok(tree);
    }
}