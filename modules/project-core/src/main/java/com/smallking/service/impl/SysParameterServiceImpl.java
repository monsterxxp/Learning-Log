package com.smallking.service.impl;

import com.smallking.model.SysParameter;
import com.smallking.repository.SysParameterRepository;
import com.smallking.service.ISysParameterService;
import com.smallking.dao.SysParameterDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.smallking.dto.SysParameterDTO;
import org.apache.commons.beanutils.BeanUtils;
import com.smallking.enums.StatusEnum;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.smallking.listener.DeleteListenable;

/**
* 描述：参数配置 服务实现层
* @author WangShaoXiong
* @date 2020/04/08
*/
@Service
public class SysParameterServiceImpl implements ISysParameterService {

    @Autowired
    private SysParameterDAO sysParameterDAO;

    @Autowired
    private SysParameterRepository sysParameterRepository;

    @Override
    public SysParameterDTO findDTOById(String id) throws Exception {
        SysParameterDTO sysParameterDTO = sysParameterDAO.findDTOById(id);
        return sysParameterDTO;
    }

    @Override
    public SysParameterDTO createSysParameter(SysParameterDTO sysParameterDTO) throws Exception {
        SysParameter sysParameter = new SysParameter();
        BeanUtils.copyProperties(sysParameter,sysParameterDTO);
        sysParameter = sysParameterRepository.saveAndFlush(sysParameter);
        return this.findDTOById(sysParameter.getId());
    }

    @Override
    public SysParameterDTO updateSysParameter(SysParameterDTO sysParameterDTO)throws Exception {
        SysParameter sysParameter = new SysParameter();
        BeanUtils.copyProperties(sysParameter,sysParameterDTO);
        sysParameter = sysParameterRepository.saveAndFlush(sysParameter);
        return this.findDTOById(sysParameter.getId());
    }

    /**
    * 描述：查询列表(分页)
    * @param pageable  分页参数
    * @param sysParameterDTO 实体DTO
    */
    @Override
    public IPage findSysParameterPage(Page pageable, SysParameterDTO sysParameterDTO) throws Exception{
        return sysParameterDAO.findSysParameterPage(pageable, sysParameterDTO);
    }

    @Override
    public void deleteById(String id) throws Exception {
        sysParameterRepository.deleteById(id);
    }

}



