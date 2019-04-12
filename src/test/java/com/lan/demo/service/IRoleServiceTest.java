package com.lan.demo.service;

import com.lan.demo.entity.Role;
import com.lan.demo.utils.UUIDUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author: Lan
 * @date: 2019/4/8 11:15
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IRoleServiceTest {

    @Autowired
    private IRoleService roleService;

    @Test
    public void insert() {
        String[] roles = {"ADMIN", "REPORTADMIN"};
        List<Role> roleList = Arrays.asList(roles).stream().map(roleName -> {
            Role role = new Role();
            role.setRoleId(UUIDUtil.createId());
            role.setRoleName(roleName);
            return role;
        }).collect(Collectors.toList());
        boolean saveBatch = roleService.saveBatch(roleList);
        Assert.assertEquals(true, saveBatch);
    }
}