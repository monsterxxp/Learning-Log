package com.smallking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smallking.model.SysRoleRelation;

import java.util.List;

/**
* 描述：角色关联表 Repository接口
* @author WangShaoXiong
* @date 2019/11/24
*/
@Repository
public interface SysRoleRelationRepository extends JpaRepository<SysRoleRelation, String> {

    List<SysRoleRelation> findSysRoleRelationByUserId(String userId);

    void deleteSysRoleRelationByUserId(String userId);
}
