package com.it.sys.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.sys.entity.Role;
import com.it.sys.entity.UserRole;

import java.util.List;

/**
 * <p>
 * role 角色表 服务类
 * </p>
 */
public interface IRoleService extends IService<Role> {

    /**
     * 删除角色表并且删除角色权限表关联数据
     *
     * @param id
     * @return
     */
    boolean deleteRoleByIdAndPermission(String id);

    /**
     * 分配用户角色
     *
     * @param userRoles
     * @return
     */
    boolean modifyUserRole(List<UserRole> userRoles);
}