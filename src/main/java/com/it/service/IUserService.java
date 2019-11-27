package com.it.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.it.entity.User;

public interface IUserService extends IService<User> {

    /**
     * 删除用户表并且删除用户角色关联表数据
     *
     * @param id
     * @return
     */
    boolean deleteUserByIdAndRole(String id);

}
