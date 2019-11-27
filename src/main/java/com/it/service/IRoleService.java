package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.entity.Role;
import com.it.entity.UserRole;

import java.util.List;

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
