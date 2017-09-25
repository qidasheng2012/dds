package com.xiaobingby.sys.service;

import com.xiaobingby.common.result.JsonResult;
import com.xiaobingby.sys.entity.User;
import com.baomidou.mybatisplus.service.IService;

/**
 * <p>
 * user 用户表 服务类
 * </p>
 *
 * @author XiaoBingBy
 * @since 2017-09-23
 */
public interface IUserService extends IService<User> {

    /**
     * 添加用户
     * @param user
     * @return
     */
    boolean addUser(User user);

    /**
     * 修改用户
     * @param user
     * @return
     */
    boolean updateUser(User user);

    /**
     * 删除用户表并且删除用户角色关联表数据
     * @param id
     * @return
     */
    public boolean deleteUserByIdAndRole(String id);

}
