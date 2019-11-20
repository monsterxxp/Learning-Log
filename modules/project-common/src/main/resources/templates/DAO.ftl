package ${package_name}.dao;

import ${package_name}.dto.${table_name}DTO;
import com.smallking.model.${table_name};
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
/**
 * 描述：${table_annotation}DAO 层
 * @author ${author}
 * @date ${date}
 */
@Mapper
@Component
public interface ${table_name}DAO extends BaseMapper<${table_name}> {

    ${table_name}DTO findDTOById(@Param("id")String id);


    /**
    * 描述：查询${table_annotation}列表以及高级搜索(分页)
    * @param pageable  分页参数
    * @param ${table_name?uncap_first}DTO  ${table_annotation}DTO
    */
    IPage<${table_name}DTO> find${table_name}Page(Page pageable, @Param("val") ${table_name}DTO ${table_name?uncap_first}DTO);

}
