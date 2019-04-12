package com.lan.demo.service.impl;

import com.lan.demo.entity.UserRole;
import com.lan.demo.mapper.UserRoleMapper;
import com.lan.demo.service.IUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户角色表 服务实现类
 * </p>
 *
 * @author Lan
 * @since 2019-04-04
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
