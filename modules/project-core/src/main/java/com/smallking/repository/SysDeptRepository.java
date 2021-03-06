package com.smallking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smallking.model.SysDept;

import java.util.List;

/**
* 描述：组织结构表 Repository接口
* @author WangShaoXiong
* @date 2019/11/16
*/
@Repository
public interface SysDeptRepository extends JpaRepository<SysDept, String> {

    // 根据parentIds获取部门列表
    List<SysDept> findByParentIdIn(List<String> parentIds);
}
