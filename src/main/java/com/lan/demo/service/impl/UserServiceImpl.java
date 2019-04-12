package com.lan.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lan.demo.dto.PermissionMap;
import com.lan.demo.entity.User;
import com.lan.demo.mapper.UserMapper;
import com.lan.demo.service.IUserService;
import com.lan.demo.utils.ResultUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author Lan
 * @since 2019-04-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public ResultUtil list() {
        List<User> list = list(new QueryWrapper<User>().lambda()
                .eq(User::getUserStatus, "0"));
        return ResultUtil.success(list);
    }

    @Override
    public ResultUtil logout(HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null) {
            new SecurityContextLogoutHandler().logout(request, response, auth);
            PermissionMap.map = null;
            PermissionMap.list = null;
        }
        return ResultUtil.success();
    }
}
