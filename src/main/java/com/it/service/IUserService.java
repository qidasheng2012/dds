package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.entity.User;

/**
 * <p>
 * user 用户表 服务类
 * </p>
 */
public interface IUserService extends IService<User> {

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 删除用户表并且删除用户角色关联表数据
     *
     * @param id
     * @return
     */
    public boolean deleteUserByIdAndRole(String id);

}
