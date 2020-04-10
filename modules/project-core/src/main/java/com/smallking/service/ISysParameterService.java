package com.smallking.service;

import com.smallking.dto.SysParameterDTO;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
* 描述：参数配置 服务实现层接口
* @author WangShaoXiong
* @date 2020/04/08
*/
public interface ISysParameterService {

    /**
    * 描述：根据Id获取DTO
    * @param id
    */
    SysParameterDTO findDTOById(String id)throws Exception;

    SysParameterDTO createSysParameter(SysParameterDTO sysParameterDTO) throws Exception;

    SysParameterDTO updateSysParameter(SysParameterDTO sysParameterDTO) throws Exception;

    IPage findSysParameterPage(Page pageable, SysParameterDTO sysParameterDTO) throws Exception;

    void deleteById(String id) throws Exception;

}
