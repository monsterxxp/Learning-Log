package com.smallking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smallking.model.SysMenuRelation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
* 描述：权限关联表 Repository接口
* @author WangShaoXiong
* @date 2019/11/26
*/
@Repository
public interface SysMenuRelationRepository extends JpaRepository<SysMenuRelation, String> {

    List<SysMenuRelation> findByRoleId(String roleId);

    @Transactional
    void deleteByRoleId(String roleId);

}
