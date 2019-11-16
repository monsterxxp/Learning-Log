package ${package_name}.controller;

import ${package_name}.service.I${table_name}Service;
import ${package_name}.model.${table_name};
import ${package_name}.dto.${table_name}DTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.smallking.common.Query;
import com.smallking.common.Return;

/**
* 描述：${table_annotation}控制层
* @author ${author}
* @date ${date}
*/
@Rest(${table_name}
@RestController
@RequestMapping("/${table_name?uncap_first}")
public class ${table_name}Controller {

    @Autowired
    private I${table_name}Service ${table_name?uncap_first}Service;

    /**
    * 描述：根据Id 查询
    * @param id  ${table_annotation}id
    */
    @GetMapping(value = "/{id}")
    public Return<${table_name}DTO> findById(@PathVariable("id") String id)  {
        return Return.ok(${table_name?uncap_first}Service.findDTOById(id));
    }

    /**
    * 描述:创建${table_annotation}
    * @param ${table_name?uncap_first}DTO  ${table_annotation}DTO
    */
    @PostMapping(value = "")
    public Return<${table_name}DTO> create(@RequestBody ${table_name}DTO ${table_name?uncap_first}DTO) throws Exception {
        return Return.ok(${table_name?uncap_first}Service.create${table_name}(${table_name?uncap_first}DTO));
    }

    /**
    * 描述：删除${table_annotation}
    * @param id ${table_annotation}id
    */
    @DeleteMapping(value = "/{id}/bulk")
    public void deleteById(@PathVariable("id") String id) throws Exception {
        ${table_name?uncap_first}Service.deleteById(id);
    }

    /**
    * 描述：更新${table_annotation}
    * @param id ${table_annotation}id
    */
    @PutMapping(value = "/{id}")
    public Return<${table_name}DTO> update${table_name}(@PathVariable("id") String id,@RequestBody ${table_name}DTO ${table_name?uncap_first}DTO) throws Exception {
        ${table_name?uncap_first}DTO.setId(id);
        return Return.ok(${table_name?uncap_first}Service.update${table_name}(${table_name?uncap_first}DTO));
    }

    /**
    * 分页查询
    * @param query
    * @return
    * @throws Exception
    */
    @GetMapping(value = "")
    public Return<IPage> search(Query<${table_name}DTO> query) throws Exception{
        ${table_name}DTO ${table_name?uncap_first}DTO = (${table_name}DTO) query.getBean(${table_name}DTO.class);
        Page pageable = query.getPageable();
        IPage page = ${table_name?uncap_first}Service.findSysDictCategoryPage(pageable, ${table_name?uncap_first}DTO);
        return Return.ok(page);
    }
}