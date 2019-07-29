package com.smallking;

import com.smallking.model.SysUser;
import com.smallking.service.ISysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @program: learning-log
 * @description: 单元测试
 * @author: smallking
 * @create: 2019-07-30 01:03
 **/

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = LearningLogApplication.class)
public class ApplicationTest {

    @Autowired
    private ISysUserService sysUserService;

    @Test
    public void test() throws Exception {
        SysUser sysUser = this.sysUserService.findById("402861816c3db94d016c3e26c29f0000");
        System.out.println("ID" + sysUser.getId() + "姓名为：" + sysUser.getName());

        sysUser.setName("smallking");
        this.sysUserService.update(sysUser);

        SysUser sysUser2 = this.sysUserService.findById("402861816c3db94d016c3e26c29f0000");
        System.out.println("ID" + sysUser2.getId() + "姓名为：" + sysUser2.getName());
    }
}
