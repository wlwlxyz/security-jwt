package com.lan.demo.dto;

import lombok.Data;

import java.util.List;

/**
 * @author: LanLi
 * @date: 2019/4/3 10:42
 * @description:角色资源
 */
@Data
public class PermissionDto {

    /**
     * url
     */
    private String permissionUrl;

    /**
     * 角色名称
     */
    private List<String> roleNames;
}
