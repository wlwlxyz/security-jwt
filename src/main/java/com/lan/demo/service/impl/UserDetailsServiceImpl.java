package com.lan.demo.service.impl;

import com.alibaba.fastjson.JSON;
import com.lan.demo.dto.UserDTO;
import com.lan.demo.form.LoginUser;
import com.lan.demo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author: Lan
 * @date: 2019/4/8 15:24
 * @description:
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String json) throws UsernameNotFoundException {
        LoginUser loginUser = JSON.parseObject(json, LoginUser.class);
        UserDTO userDTO = userMapper.getUserDTO(loginUser.getUserPhone());
        if (userDTO == null) {
            return null;
        }
        userDTO.setRemember(loginUser.getRemember());
        userDTO.setName(userDTO.getUsername());
        userDTO.setUserName(json);
        return userDTO;
    }
}
