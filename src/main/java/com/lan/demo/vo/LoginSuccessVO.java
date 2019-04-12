package com.lan.demo.vo;

import lombok.Data;

import java.util.List;

/**
 * @author: Lan
 * @date: 2019/4/9 11:28
 * @description:登录成功返回
 */
@Data
public class LoginSuccessVO {

    /**
     * 用户编号
     */
    private String userId;

    /**
     * 用户手机号码
     */
    private String userPhone;

    /**
     * 角色信息
     */
    private List<String> roles;

    /**
     * 用户名
     */
    private String name;
}
