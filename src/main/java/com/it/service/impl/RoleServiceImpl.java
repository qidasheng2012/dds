package com.it.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.entity.Role;
import com.it.entity.RolePermission;
import com.it.entity.UserRole;
import com.it.mapper.RoleMapper;
import com.it.mapper.RolePermissionMapper;
import com.it.mapper.UserRoleMapper;
import com.it.service.IRoleService;
import com.it.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleServiceImpl extends ServiceImpl<RoleMapper, Role> implements IRoleService {

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
        for (String item : split) {
            userId.add(item);
        }
        // 删除角色表
        Integer integer = baseMapper.deleteBatchIds(userId);

        // 删除角权限关联表数据
        QueryWrapper<RolePermission> permissionEntityWrapper = new QueryWrapper<>();
        permissionEntityWrapper.in("rid", id);
        rolePermissionMapper.delete(permissionEntityWrapper);

        return true;
    }

    @Transactional
    @Override
    public boolean modifyUserRole(List<UserRole> userRoles) {
        // 删除用户角色原表数据
        QueryWrapper<UserRole> userRoleEntityWrapper = new QueryWrapper<>();
        userRoleEntityWrapper.eq("uid", userRoles.get(0).getUid());
        userRoleMapper.delete(userRoleEntityWrapper);

        // 新增用户角色数据 并 返回
        return iUserRoleService.saveBatch(userRoles);
    }
}
