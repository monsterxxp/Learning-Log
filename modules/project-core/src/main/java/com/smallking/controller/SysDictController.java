package com.smallking.controller;

import com.smallking.service.ISysDictService;
import com.smallking.model.SysDict;
import com.smallking.dto.SysDictDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smallking.common.Query;
import com.smallking.common.Return;

import java.util.List;

/**
* 描述：数据字典表控制层
* @author WangShaoXiong
* @date 2019/11/16
*/
@RestController
@RequestMapping("/sysDict")
public class SysDictController {

    @Autowired
    private ISysDictService sysDictService;

    /**
    * 描述：根据Id 查询
    * @param id  数据字典表id
    */
    @GetMapping(value = "/{id}")
    public Return<SysDictDTO> findById(@PathVariable("id") String id) throws Exception {
        return Return.ok(sysDictService.findDTOById(id));
    }

    /**
    * 描述:创建数据字典表
    * @param sysDictDTO  数据字典表DTO
    */
    @PostMapping(value = "")
    public Return<SysDictDTO> create(@RequestBody SysDictDTO sysDictDTO) throws Exception {
        return Return.ok(sysDictService.createSysDict(sysDictDTO));
    }

    /**
    * 描述：删除数据字典表
    * @param id 数据字典表id
    */
    @DeleteMapping(value = "/{id}/bulk")
    public void deleteById(@PathVariable("id") String id) throws Exception {
        sysDictService.deleteById(id);
    }

    /**
    * 描述：更新数据字典表
    * @param id 数据字典表id
    */
    @PutMapping(value = "/{id}")
    public Return<SysDictDTO> updateSysDict(@PathVariable("id") String id,@RequestBody SysDictDTO sysDictDTO) throws Exception {
        sysDictDTO.setId(id);
        return Return.ok(sysDictService.updateSysDict(sysDictDTO));
    }

    /**
    * 分页查询
    * @param query
    * @return
    * @throws Exception
    */
    @GetMapping(value = "")
    public Return<IPage> search(Query<SysDictDTO> query) throws Exception{
        SysDictDTO sysDictDTO = (SysDictDTO) query.getBean(SysDictDTO.class);
        Page pageable = query.getPageable();
        IPage page = sysDictService.findSysDictPage(pageable, sysDictDTO);
        return Return.ok(page);
    }

    /**
     * 描述：根据CategoryCode 查询
     * @param categoryCode  数据字典所属分类categoryCode
     */
    @GetMapping(value = "/{categoryCode}/findByCategoryCode")
    public Return<List<SysDictDTO>> findByCategoryCode(@PathVariable("categoryCode") String categoryCode) throws Exception {
        return Return.ok(sysDictService.findByCategoryCode(categoryCode));
    }
}