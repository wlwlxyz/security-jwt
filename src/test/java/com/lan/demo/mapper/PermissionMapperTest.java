package com.lan.demo.mapper;

import com.lan.demo.entity.Permission;
import com.lan.demo.entity.RolePermission;
import com.lan.demo.utils.UUIDUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Lan
 * @date: 2019/4/9 11:19
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class PermissionMapperTest {

    @Autowired
    private PermissionMapper permissionMapper;

    @Autowired
    private RolePermissionMapper rolePermissionMapper;

    @Test
    public void insert() {
        Permission permission = new Permission();
        permission.setPermissionId(UUIDUtil.createId());
        permission.setPermissionComment("获取所有角色");
        permission.setPermissionUrl("/role/list");

        RolePermission rolePermission = new RolePermission();
        rolePermission.setPermissionId(permission.getPermissionId());
        rolePermission.setRolePermissionId(UUIDUtil.createId());
        rolePermission.setRoleId("3ac96c378b2b4df1a9d96dda9ef5f7f1");

        int insert = permissionMapper.insert(permission);
        int insert1 = rolePermissionMapper.insert(rolePermission);
        Assert.assertEquals(true, insert > 0 && insert1 > 0);
    }
}