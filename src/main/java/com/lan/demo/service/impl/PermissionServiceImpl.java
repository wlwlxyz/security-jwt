package com.lan.demo.service.impl;

import com.lan.demo.entity.Permission;
import com.lan.demo.mapper.PermissionMapper;
import com.lan.demo.service.IPermissionService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 权限表 服务实现类
 * </p>
 *
 * @author Lan
 * @since 2019-04-04
 */
@Service
public class PermissionServiceImpl extends ServiceImpl<PermissionMapper, Permission> implements IPermissionService {

}
