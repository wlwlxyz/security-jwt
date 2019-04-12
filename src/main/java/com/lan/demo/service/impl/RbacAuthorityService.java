package com.lan.demo.service.impl;

import com.lan.demo.dto.PermissionDto;
import com.lan.demo.dto.PermissionMap;
import com.lan.demo.mapper.PermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: Lan
 * @date: 2019/4/9 14:56
 * @description:判断是否具有权限访问当前资源
 */
@Component("rbacauthorityservice")
public class RbacAuthorityService {

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 判断是否有权限
     *
     * @param request
     * @param authentication
     * @return
     */
    public boolean hasPermission(HttpServletRequest request, Authentication authentication) {
        Collection<ConfigAttribute> collection = getAttributes(request);
        if (authentication.getPrincipal().equals("anonymousUser")) {
            return false;
        }

        if (null == collection || collection.size() <= 0) {
            return true;
        }

        ConfigAttribute configAttribute;
        String needRole;
        for (Iterator<ConfigAttribute> iterator = collection.iterator(); iterator.hasNext(); ) {
            configAttribute = iterator.next();
            needRole = configAttribute.getAttribute();
            for (GrantedAuthority grantedAuthority : authentication.getAuthorities()) {
                if (needRole.trim().equals(grantedAuthority.getAuthority())) {
                    return true;
                }
            }
        }
        throw new AccessDeniedException("权限不足");
    }

    /**
     * 判定用户请求的url是否在权限表中，如果在权限表中，则返回decide方法，
     * 用来判定用户是否有权限，如果不在权限表中则放行
     *
     * @param request
     * @return
     * @throws IllegalArgumentException
     */
    public Collection<ConfigAttribute> getAttributes(HttpServletRequest request) throws IllegalArgumentException {
        HashMap<String, Collection<ConfigAttribute>> map = PermissionMap.map;
        if (map == null) {
            map = loadResourceDefine(map);
        }
        for (Map.Entry<String, Collection<ConfigAttribute>> entry : map.entrySet()) {
            String url = entry.getKey();
            if (new AntPathRequestMatcher(url).matches(request)) {
                return map.get(url);
            }
        }
        return null;
    }

    /**
     * 加载权限表中所有权限
     */
    private HashMap<String, Collection<ConfigAttribute>> loadResourceDefine(HashMap<String, Collection<ConfigAttribute>> map) {
        map = new HashMap<>();
        List<PermissionDto> all = permissionMapper.findAll();
        for (PermissionDto permissionDto : all) {
            List<ConfigAttribute> configAttributeList = permissionDto.getRoleNames().stream().map(roleName -> {
                ConfigAttribute configAttribute = new SecurityConfig("ROLE_" + roleName.toUpperCase());
                return configAttribute;
            }).collect(Collectors.toList());
            map.put(permissionDto.getPermissionUrl(), configAttributeList);
        }
        PermissionMap.map = map;
        return map;
    }
}
