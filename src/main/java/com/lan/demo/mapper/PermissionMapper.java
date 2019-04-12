package com.lan.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lan.demo.dto.PermissionDto;
import com.lan.demo.entity.Permission;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 权限表 Mapper 接口
 * </p>
 *
 * @author Lan
 * @since 2019-04-04
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 返回所有角色资源
     *
     * @return
     */
    List<PermissionDto> findAll();
}
