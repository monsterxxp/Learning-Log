package com.smallking.controller;

import com.smallking.service.ISysParameterService;
import com.smallking.model.SysParameter;
import com.smallking.dto.SysParameterDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smallking.common.Query;
import com.smallking.common.Return;

import java.util.List;

/**
* 描述：参数配置控制层
* @author WangShaoXiong
* @date 2020/04/08
*/
@RestController
@RequestMapping("/sysParameter")
public class SysParameterController {

    @Autowired
    private ISysParameterService sysParameterService;

    /**
    * 描述：根据Id 查询
    * @param id  参数配置id
    */
    @GetMapping(value = "/{id}")
    public Return<SysParameterDTO> findById(@PathVariable("id") String id) throws Exception {
        return Return.ok(sysParameterService.findDTOById(id));
    }

    /**
    * 描述:创建参数配置
    * @param sysParameterDTO  参数配置DTO
    */
    @PostMapping(value = "")
    public Return<SysParameterDTO> create(@RequestBody SysParameterDTO sysParameterDTO) throws Exception {
        return Return.ok(sysParameterService.createSysParameter(sysParameterDTO));
    }

    /**
    * 描述：删除参数配置
    * @param id 参数配置id
    */
    @DeleteMapping(value = "/{id}/bulk")
    public void deleteById(@PathVariable("id") String id) throws Exception {
        sysParameterService.deleteById(id);
    }

    /**
     * 描述：批量刪除参数配置
     * @param ids ids
     */
    @DeleteMapping(value = "/batchBulk")
    public void batchBulk(@RequestBody List<String> ids) throws Exception {
        sysParameterService.batchBulk(ids);
    }

    /**
    * 描述：更新参数配置
    * @param id 参数配置id
    */
    @PutMapping(value = "/{id}")
    public Return<SysParameterDTO> updateSysParameter(@PathVariable("id") String id,@RequestBody SysParameterDTO sysParameterDTO) throws Exception {
        sysParameterDTO.setId(id);
        return Return.ok(sysParameterService.updateSysParameter(sysParameterDTO));
    }

    /**
    * 分页查询
    * @param query
    * @return
    * @throws Exception
    */
    @GetMapping(value = "")
    public Return search(Query<SysParameterDTO> query) throws Exception{
        SysParameterDTO sysParameterDTO = (SysParameterDTO) query.getBean(SysParameterDTO.class);
        Page pageable = query.getPageable();
        IPage page = sysParameterService.findSysParameterPage(pageable, sysParameterDTO);
        return Return.page(page);
    }
}