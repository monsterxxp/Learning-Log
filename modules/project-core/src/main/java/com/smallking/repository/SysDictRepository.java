package com.smallking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smallking.model.SysDict;

/**
* 描述：数据字典表 Repository接口
* @author WangShaoXiong
* @date 2019/11/16
*/
@Repository
public interface SysDictRepository extends JpaRepository<SysDict, String> {

    SysDict findByCategoryCodeAndCode(String categoryCode, String code);

}
