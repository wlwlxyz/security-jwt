package com.lan.demo.form;

import lombok.Data;

/**
 * @author: Lan
 * @date: 2019/4/8 16:03
 * @description:
 */
@Data
public class LoginUser {

    /**
     * 用户手机号码
     */
    private String userPhone;

    /**
     * 是否记住密码
     */
    private Boolean remember;

}
