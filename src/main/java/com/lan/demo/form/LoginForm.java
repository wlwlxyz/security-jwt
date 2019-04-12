package com.lan.demo.form;

import lombok.Data;

/**
 * @author: Lan
 * @date: 2019/4/8 15:41
 * @description:登录请求参数
 */
@Data
public class LoginForm extends LoginUser {

    /**
     * 用户密码
     */
    private String userPassword;

}
