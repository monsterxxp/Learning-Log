package com.smallking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smallking.model.SysRole;

/**
* 描述：角色表 Repository接口
* @author WangShaoXiong
* @date 2019/11/21
*/
@Repository
public interface SysRoleRepository extends JpaRepository<SysRole, String> {



}
