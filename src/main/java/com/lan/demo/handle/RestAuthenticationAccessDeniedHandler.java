package com.lan.demo.handle;

import com.lan.demo.enums.ResultEnum;
import com.lan.demo.utils.ResponseUtil;
import com.lan.demo.utils.ResultUtil;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: Lan
 * @date: 2019/4/8 18:25
 * @description:权限不足
 */
public class RestAuthenticationAccessDeniedHandler implements AccessDeniedHandler {
    @Override
    public void handle(HttpServletRequest httpServletRequest, HttpServletResponse response, AccessDeniedException e) throws IOException, ServletException {
        ResponseUtil.write(response, ResultUtil.error(ResultEnum.ACCESS_NOT));
    }
}
