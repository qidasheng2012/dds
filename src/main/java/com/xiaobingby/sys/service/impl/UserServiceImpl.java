package com.xiaobingby.sys.service.impl;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xiaobingby.common.result.JsonResult;
import com.xiaobingby.sys.entity.User;
import com.xiaobingby.sys.entity.UserRole;
import com.xiaobingby.sys.mapper.UserMapper;
import com.xiaobingby.sys.mapper.UserRoleMapper;
import com.xiaobingby.sys.service.IUserService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * user 用户表 服务实现类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2017-09-23
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public boolean addUser(User user) {
        String salt = String.valueOf(System.currentTimeMillis());
        SimpleHash password = new SimpleHash("MD5", user.getUsername(), salt);
        user.setSalt(salt);
        user.setPassword(password.toString());
        Integer result = userMapper.insert(user);
        if (result >= 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        Integer result = userMapper.updateById(user);
        if (result >= 1) {
            return true;
        }
        return false;
    }

    @Transactional
    @Override
    public boolean deleteUserByIdAndRole(String id) {
        // 拼接用户表删除list
        String[] split = id.split(",");
        List<String> userId = new ArrayList<>();
        for (String item:split) {
            userId.add(item);
        }
        // 删除用户表数据
        Integer integer = userMapper.deleteBatchIds(userId);

        // 删除用户角色关联表数据
        EntityWrapper<UserRole> userRoleEntityWrapper = new EntityWrapper<>();
        userRoleEntityWrapper.in("uid", id);
        userRoleMapper.delete(userRoleEntityWrapper);

        return true;
    }

}
