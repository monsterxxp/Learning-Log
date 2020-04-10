package com.smallking.dao;

import com.smallking.dto.SysParameterDTO;
import com.smallking.model.SysParameter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;
/**
 * 描述：参数配置DAO 层
 * @author WangShaoXiong
 * @date 2020/04/08
 */
@Mapper
@Component
public interface SysParameterDAO extends BaseMapper<SysParameter> {

    SysParameterDTO findDTOById(@Param("id") String id);


    /**
    * 描述：查询参数配置列表以及高级搜索(分页)
    * @param pageable  分页参数
    * @param sysParameterDTO  参数配置DTO
    */
    IPage<SysParameterDTO> findSysParameterPage(Page pageable, SysParameterDTO sysParameterDTO);

}
