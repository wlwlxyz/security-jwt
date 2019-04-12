package com.lan.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lan.demo.dto.UserDTO;
import com.lan.demo.entity.User;
import org.springframework.stereotype.Repository;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author Lan
 * @since 2019-04-04
 */
@Repository
public interface UserMapper extends BaseMapper<User> {

    /**
     * 登录校验
     *
     * @param phone
     * @return
     */
    UserDTO getUserDTO(String phone);
}
