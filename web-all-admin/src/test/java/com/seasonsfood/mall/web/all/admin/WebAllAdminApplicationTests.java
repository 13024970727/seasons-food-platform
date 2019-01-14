package com.seasonsfood.mall.web.all.admin;

import com.alibaba.dubbo.config.annotation.Reference;
import com.seasonsfood.mall.admin.api.domain.SysUser;
import com.seasonsfood.mall.admin.api.service.SysUserService;
import com.seasonsfood.mall.util.util.RedisUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes= WebAllAdminApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebAllAdminApplicationTests {

    @Resource
    RedisUtils<String> redisUtils;

    @Reference(check = false)
    SysUserService sysUserService;

    @Test
    public void redisTest(){

        redisUtils.cacheSet("rontest22","111");

    }

    @Test
    public void mysqlTest(){

        SysUser sysUser = new SysUser();
        sysUser.setUsername("admin");
        sysUser = sysUserService.selectOne(sysUser);
        System.out.println(sysUser.getUsername());

    }

}
