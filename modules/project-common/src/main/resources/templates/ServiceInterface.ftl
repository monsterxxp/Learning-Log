package ${package_name}.service;

import ${package_name}.dto.${table_name}DTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* 描述：${table_annotation} 服务实现层接口
* @author ${author}
* @date ${date}
*/
public interface I${table_name}Service {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    ${table_name}DTO findDTOById(String id)throws Exception;

    ${table_name}DTO create${table_name}(${table_name}DTO ${table_name?uncap_first}DTO) throws Exception;

    ${table_name}DTO update${table_name}(${table_name}DTO ${table_name?uncap_first}DTO) throws Exception;

    IPage find${table_name}Page(Page pageable, ${table_name}DTO ${table_name?uncap_first}DTO) throws Exception;

    void deleteById(String id) throws Exception;

}
