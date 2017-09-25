package com.xiaobingby.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xiaobingby.sys.entity.Role;
import com.xiaobingby.sys.entity.RolePermission;
import com.xiaobingby.sys.entity.UserRole;
import com.xiaobingby.sys.mapper.RoleMapper;
import com.xiaobingby.sys.mapper.RolePermissionMapper;
import com.xiaobingby.sys.mapper.UserRoleMapper;
import com.xiaobingby.sys.service.IRoleService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.xiaobingby.sys.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * role 角色表 服务实现类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2017-09-23
 */
@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

    @Autowired
    private RoleMapper roleMapper;
    @Autowired
    private RolePermissionMapper rolePermissionMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;
    @Autowired
    private IUserRoleService iUserRoleService;

    @Transactional
    @Override
    public boolean deleteRoleByIdAndPermission(String id) {
        // 拼接角色表删除list
        String[] split = id.split(",");
        List<String> userId = new ArrayList<>();
        for (String item:split) {
            userId.add(item);
        }
        // 删除角色表
        Integer integer = roleMapper.deleteBatchIds(userId);

        // 删除角权限关联表数据
        EntityWrapper<RolePermission> permissionEntityWrapper = new EntityWrapper<>();
        permissionEntityWrapper.in("rid", id);
        rolePermissionMapper.delete(permissionEntityWrapper);

        return true;
    }

    @Transactional
    @Override
    public boolean modifyUserRole(List<UserRole> userRoles) {
        // 删除用户角色原表数据
        EntityWrapper<UserRole> userRoleEntityWrapper = new EntityWrapper<>();
        userRoleEntityWrapper.eq("uid", userRoles.get(0).getUid());
        userRoleMapper.delete(userRoleEntityWrapper);

        // 新增用户角色数据 并 返回
        return iUserRoleService.insertBatch(userRoles);
    }
}
