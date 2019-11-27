package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.entity.Menu;
import com.it.entity.Permission;
import com.it.entity.RolePermission;
import com.it.entity.ZNodes;

import java.util.List;

public interface IPermissionService extends IService<Permission> {

    /**
     * 创建登陆用户菜单
     *
     * @param uid
     * @return
     */
    List<Menu> createMenu(Long uid);

    /**
     * 查询所有权限树形展示 并且选中角色拥有的树节点
     *
     * @param roleId 角色ID
     * @return
     */
    List<ZNodes> findPermissionZTreeNodes(Long roleId);

    /**
     * 修改角色权限
     *
     * @param rolePermissions
     * @return
     */
    boolean modifyRolePermission(List<RolePermission> rolePermissions);

    /**
     * 删除权限 和 权限角色表数据
     *
     * @param id
     * @return
     */
    boolean deletePermissionRole(String id);
}
