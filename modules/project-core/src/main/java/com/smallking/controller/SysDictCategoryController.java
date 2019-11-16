package com.smallking.controller;

import com.smallking.service.ISysDictCategoryService;
import com.smallking.model.SysDictCategory;
import com.smallking.dto.SysDictCategoryDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smallking.common.Query;
import com.smallking.common.Return;

/**
* 描述：字典类别控制层
* @author WangShaoXiong
* @date 2019/11/14
*/

@RestController
@RequestMapping("/sysDictCategory")
public class SysDictCategoryController {

    @Autowired
    private ISysDictCategoryService sysDictCategoryService;

    /**
    * 描述：根据Id 查询
    * @param id  字典类别id
    */
    @GetMapping(value = "/{id}")
    public Return<SysDictCategoryDTO> findById(@PathVariable("id") String id) throws Exception{
        return Return.ok(sysDictCategoryService.findDTOById(id));
    }

    /**
    * 描述:创建字典类别
    * @param sysDictCategoryDTO  字典类别DTO
    */
    @PostMapping(value = "")
    public Return<SysDictCategoryDTO> create(@RequestBody SysDictCategoryDTO sysDictCategoryDTO) throws Exception {
        return Return.ok(sysDictCategoryService.createSysDictCategory(sysDictCategoryDTO));
    }

    /**
    * 描述：删除字典类别
    * @param id 字典类别id
    */
    @DeleteMapping(value = "/{id}/bulk")
    public void deleteById(@PathVariable("id") String id) throws Exception {
        sysDictCategoryService.deleteById(id);
    }

    /**
    * 描述：更新字典类别
    * @param id 字典类别id
    */
    @PutMapping(value = "/{id}")
    public Return<SysDictCategoryDTO> updateSysDictCategory(@PathVariable("id") String id,@RequestBody SysDictCategoryDTO sysDictCategoryDTO) throws Exception {
        sysDictCategoryDTO.setId(id);
        return Return.ok(sysDictCategoryService.updateSysDictCategory(sysDictCategoryDTO));
    }

    /**
     * 分页查询
     * @param query
     * @return
     * @throws Exception
     */
    @GetMapping(value = "")
    public Return<IPage> search(Query<SysDictCategoryDTO> query) throws Exception{
        SysDictCategoryDTO sysUserDTO = (SysDictCategoryDTO) query.getBean(SysDictCategoryDTO.class);
        Page pageable = query.getPageable();
        IPage page = sysDictCategoryService.findSysDictCategoryPage(pageable, sysUserDTO);
        return Return.ok(page);
    }

}