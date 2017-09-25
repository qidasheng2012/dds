package com.xiaobingby.sys.service;

import com.xiaobingby.sys.entity.Role;
import com.baomidou.mybatisplus.service.IService;
import com.xiaobingby.sys.entity.UserRole;

import java.util.List;

/**
 * <p>
 * role 角色表 服务类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2017-09-23
 */
public interface IRoleService extends IService<Role> {

    /**
     * 删除角色表并且删除角色权限表关联数据
     * @param id
     * @return
     */
    boolean deleteRoleByIdAndPermission(String id);

    /**
     * 分配用户角色
     * @param userRoles
     * @return
     */
    boolean modifyUserRole(List<UserRole> userRoles);
}
