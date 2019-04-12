package com.lan.demo.controller;


import com.lan.demo.service.IUserService;
import com.lan.demo.utils.ResultUtil;
import com.sun.org.apache.regexp.internal.REUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author Lan
 * @since 2019-04-04
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    @GetMapping("/list")
    public ResultUtil list() {
        return userService.list();
    }

    @GetMapping("/hello")
    public ResultUtil hello() {
        return ResultUtil.success("不需要权限也可以访问我啊！");
    }

    @GetMapping("/logout")
    public ResultUtil logout(HttpServletRequest request, HttpServletResponse response) {
        return userService.logout(request, response);
    }
}

