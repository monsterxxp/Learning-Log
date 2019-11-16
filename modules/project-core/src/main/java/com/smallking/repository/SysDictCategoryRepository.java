package com.smallking.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.smallking.model.SysDictCategory;

/**
* 描述：字典类别 Repository接口
* @author WangShaoXiong
* @date 2019/11/14
*/
@Repository
public interface SysDictCategoryRepository extends JpaRepository<SysDictCategory, String> {



}
