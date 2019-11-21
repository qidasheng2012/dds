package com.it.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.sys.entity.RolePermission;
import com.it.sys.mapper.RolePermissionMapper;
import com.it.sys.service.IRolePermissionService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * role_permission 角色权限表 服务实现类
 * </p>
 */
@Service
public class RolePermissionServiceImpl extends ServiceImpl<RolePermissionMapper, RolePermission> implements IRolePermissionService {

}
