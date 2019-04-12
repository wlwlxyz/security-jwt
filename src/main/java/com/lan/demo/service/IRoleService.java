package com.lan.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.lan.demo.entity.Role;
import com.lan.demo.utils.ResultUtil;

/**
 * <p>
 * 角色表 服务类
 * </p>
 *
 * @author Lan
 * @since 2019-04-04
 */
public interface IRoleService extends IService<Role> {

    /**
     * 角色列表
     *
     * @return
     */
    ResultUtil list();
}
