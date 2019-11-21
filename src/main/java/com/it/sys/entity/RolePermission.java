package com.it.sys.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;


/**
 * <p>
 * role_permission 角色权限表
 * </p>
 */
@Data
@TableName("role_permission")
public class RolePermission {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 角色ID
     */
    private Long rid;
    /**
     * 权限ID
     */
    private Long pid;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

}
