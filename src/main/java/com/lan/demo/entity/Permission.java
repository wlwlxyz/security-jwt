package com.lan.demo.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 权限表
 * </p>
 *
 * @author Lan
 * @since 2019-04-04
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class Permission implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 权限编号
     */
    @TableId
    private String permissionId;

    /**
     * 授权url
     */
    private String permissionUrl;

    /**
     * 描述
     */
    private String permissionComment;

    /**
     * 权限状态,0正常，-1删除
     */
    private String permissionStatus;


}
