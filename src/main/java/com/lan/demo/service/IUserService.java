package com.lan.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lan.demo.entity.User;
import com.lan.demo.utils.ResultUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * 用户表 服务类
 * </p>
 *
 * @author Lan
 * @since 2019-04-04
 */
public interface IUserService extends IService<User> {

    /**
     * 用户列表
     *
     * @return
     */
    ResultUtil list();

    /**
     * 注销
     *
     * @param request
     * @param response
     * @return
     */
    ResultUtil logout(HttpServletRequest request, HttpServletResponse response);
}
