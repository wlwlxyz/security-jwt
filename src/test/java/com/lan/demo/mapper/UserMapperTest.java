package com.lan.demo.mapper;

import com.alibaba.fastjson.JSON;
import com.lan.demo.dto.UserDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author: Lan
 * @date: 2019/4/8 09:58
 * @description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;


    @Test
    public void login() {
        UserDTO userDTO = userMapper.getUserDTO("15295939085");
        System.out.println(JSON.toJSONString(userDTO));
    }

}