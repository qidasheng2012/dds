package com.it.sys.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.sys.entity.UserRole;
import com.it.sys.mapper.UserRoleMapper;
import com.it.sys.service.IUserRoleService;
import org.springframework.stereotype.Service;

/**
 * <p>
 * user_role 用户角色关联表 服务实现类
 * </p>
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole> implements IUserRoleService {

}
