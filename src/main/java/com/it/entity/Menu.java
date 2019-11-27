package com.it.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Menu implements Serializable {

    private Long id;

    private Long pid;

    private String name;

    private String url;

    private String icon;

    private List<Menu> children;

}
