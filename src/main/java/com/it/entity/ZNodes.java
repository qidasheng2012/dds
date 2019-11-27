package com.it.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * zTree 树实体
 */
@Data
public class ZNodes implements Serializable {

    private Long id;

    private Long pid;

    private String name;

    private boolean open;

    private boolean checked;

    private boolean isParent;

}
