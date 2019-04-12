package com.lan.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lan.demo.entity.UserRole;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * 用户角色表 Mapper 接口
 * </p>
 *
 * @author Lan
 * @since 2019-04-04
 */
@Repository
public interface UserRoleMapper extends BaseMapper<UserRole> {

    /**
     * 获取用户角色
     *
     * @param userId
     * @return
     */
    List<String> roles(String userId);
}
