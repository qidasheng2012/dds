package com.it.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.util.Date;


/**
 * <p>
 * permission 权限表
 * </p>
 */
@Data
@TableName("t_permission")
public class Permission {

    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    private Long id;
    /**
     * 上级ID
     */
    private Long pid;
    /**
     * 权限名
     */
    private String name;
    /**
     * 类型 0、目录 1、菜单 2、按钮
     */
    private Integer type;
    /**
     * 排序
     */
    private Integer sort;
    /**
     * 地址
     */
    private String url;
    /**
     * 权限编码
     */
    private String permCode;
    /**
     * 图标
     */
    private String icon;
    /**
     * 描述
     */
    private String description;
    /**
     * 状态 0、禁用 1、正常
     */
    private Integer status;
    /**
     * 创建时间
     */
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;

}
