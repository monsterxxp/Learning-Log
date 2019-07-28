package com.smallking.service.impl;

import com.smallking.dao.SysUserDao;
import com.smallking.model.SysUser;
import com.smallking.service.ISysUserService;
import com.smallking.service.impl.mysqlrepository.SysUserRepositoryMysql;
import com.smallking.service.impl.postgresqlrepository.SysUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @program: learn
 * @description: 系统用户接口实现类
 * @author: smallking
 * @data: 2019-07-27 01:47
 **/
@Service
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    private SysUserDao sysUserDao;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private SysUserRepository sysUserRepository;

    @Autowired
    private SysUserRepositoryMysql sysUserRepositoryMysql;

    @Override
    public List<SysUser> findAll() {
        return sysUserDao.findAll();
    }

    @Override
    public List<Map<String, Object>> findAllByJdbcTemplate() {
        String sql = "select * from sys_user";
        return jdbcTemplate.queryForList(sql);
    }

    @Override
    public List<SysUser> findAllByJpa() {
        return sysUserRepository.findAll();
    }

    @Override
    public SysUser create() {
        SysUser user = new SysUser();
        user.setId("3");
        user.setName("123456");
        user.setAccount("saf");
        user.setPassword("sfadf");
        SysUser sysUser = sysUserRepository.saveAndFlush(user);

        return sysUserDao.findById(sysUser.getId());
    }

    @Override
    public List<SysUser> findAllByMysql() {
        return sysUserRepositoryMysql.findAll();
    }

    @Override
    public SysUser findById(String id) {
        return sysUserDao.findById(id);
    }
}
