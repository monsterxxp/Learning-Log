package com.smallking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smallking.model.SysMenu;

/**
* 描述：菜单表 Repository接口
* @author WangShaoXiong
* @date 2019/11/21
*/
@Repository
public interface SysMenuRepository extends JpaRepository<SysMenu, String> {



}
