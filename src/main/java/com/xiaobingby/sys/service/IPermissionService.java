package com.xiaobingby.sys.service;

import com.xiaobingby.sys.entity.Menu;
import com.xiaobingby.sys.entity.Permission;
import com.baomidou.mybatisplus.service.IService;
import com.xiaobingby.sys.entity.RolePermission;
import com.xiaobingby.sys.entity.ZNodes;

import java.util.List;

/**
 * <p>
 * permission 权限表 服务类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2017-09-23
 */
public interface IPermissionService extends IService<Permission> {

    /**
     * 创建登陆用户菜单
     * @param uid
     * @return
     */
    List<Menu> createMenu(Long uid);

    /**
     * 查询所有权限树形展示 并且选中角色拥有的树节点
     * @param roleId 角色ID
     * @return
     */
    List<ZNodes> findPermissionZTreeNodes(Long roleId);

    /**
     * 修改角色权限
     * @param rolePermissions
     * @return
     */
    boolean modifyRolePermission(List<RolePermission> rolePermissions);

    /**
     * 删除权限 和 权限角色表数据
     * @param id
     * @return
     */
    boolean deletePermissionRole(String id);
}
