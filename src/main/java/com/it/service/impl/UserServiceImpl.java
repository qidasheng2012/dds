package com.it.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.it.entity.User;
import com.it.entity.UserRole;
import com.it.mapper.UserMapper;
import com.it.mapper.UserRoleMapper;
import com.it.service.IUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public boolean addUser(User user) {
        String salt = String.valueOf(System.currentTimeMillis());
        SimpleHash password = new SimpleHash("MD5", user.getUsername(), salt);
        user.setSalt(salt);
        user.setPassword(password.toString());
        Integer result = baseMapper.insert(user);
        if (result >= 1) {
            return true;
        }
        return false;
    }

    @Override
    public boolean updateUser(User user) {
        Integer result = baseMapper.updateById(user);
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
        for (String item : split) {
            userId.add(item);
        }
        // 删除用户表数据
        Integer integer = baseMapper.deleteBatchIds(userId);

        // 删除用户角色关联表数据
        QueryWrapper<UserRole> userRoleEntityWrapper = new QueryWrapper<>();
        userRoleEntityWrapper.in("uid", id);
        userRoleMapper.delete(userRoleEntityWrapper);

        return true;
    }

}
