package com.lan.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lan.demo.entity.Role;
import com.lan.demo.mapper.RoleMapper;
import com.lan.demo.service.IRoleService;
import com.lan.demo.utils.ResultUtil;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 角色表 服务实现类
 * </p>
 *
 * @author Lan
 * @since 2019-04-04
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Override
    public ResultUtil list() {
        List<Role> list = list(new QueryWrapper<Role>().lambda()
                .eq(Role::getRoleStatus, '0'));
        return ResultUtil.success(list);
    }
}
