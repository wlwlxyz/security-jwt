package com.lan.demo.service;

import com.lan.demo.entity.User;
import com.lan.demo.utils.TimeUtil;
import com.lan.demo.utils.UUIDUtil;
import com.lan.demo.utils.UserUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: Lan
 * @date: 2019/4/8 11:14
 * @description:
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class IUserServiceTest {

    @Autowired
    private IUserService userService;

    @Test
    public void insert() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setUserId(UUIDUtil.createId());
            user.setUserCreateTime(TimeUtil.nowTimeStamp());
            user.setUserName(UserUtil.createName());
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            user.setUserPassword(bCryptPasswordEncoder.encode("123456"));
            user.setUserPhone(UserUtil.createTel());
            users.add(user);
        }
        boolean saveBatch = userService.saveBatch(users);
        Assert.assertEquals(true, saveBatch);
    }
}