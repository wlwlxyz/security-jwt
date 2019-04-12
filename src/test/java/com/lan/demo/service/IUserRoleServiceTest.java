package com.lan.demo.service;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.lan.demo.entity.Role;
import com.lan.demo.entity.User;
import com.lan.demo.entity.UserRole;
import com.lan.demo.utils.JwtTokenUtil;
import com.lan.demo.utils.UUIDUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Lan
 * @date: 2019/4/8 11:26
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IUserRoleServiceTest {

    @Autowired
    private IUserRoleService userRoleService;

    @Autowired
    private IRoleService roleService;

    @Autowired
    private IUserService userService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Test
    public void insert() {
        List<Role> roleList = roleService.list(new QueryWrapper<Role>());
        List<User> userList = userService.list(new QueryWrapper<User>());
        List<UserRole> userRoles = new ArrayList<>();
        for (int i = 0; i < userList.size(); i++) {
            UserRole userRole = new UserRole();
            userRole.setUserRoleId(UUIDUtil.createId());
            userRole.setUserId(userList.get(i).getUserId());
            if (i % 2 == 0) {
                userRole.setRoleId(roleList.get(0).getRoleId());
            } else {
                userRole.setRoleId(roleList.get(1).getRoleId());
            }
            userRoles.add(userRole);
        }
        boolean saveBatch = userRoleService.saveBatch(userRoles);
        Assert.assertEquals(true, saveBatch);
    }

}