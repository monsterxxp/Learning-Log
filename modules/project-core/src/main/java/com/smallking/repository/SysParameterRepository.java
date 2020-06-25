package com.smallking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smallking.model.SysParameter;

/**
* 描述：参数配置 Repository接口
* @author WangShaoXiong
* @date 2020/04/08
*/
@Repository
public interface SysParameterRepository extends JpaRepository<SysParameter, String> {

    SysParameter findByConfigKey(String configKey);

}
