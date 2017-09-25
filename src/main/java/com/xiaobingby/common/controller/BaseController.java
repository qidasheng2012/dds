package com.xiaobingby.common.controller;

import com.xiaobingby.common.result.JsonResult;
import com.xiaobingby.sys.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Author: XiaoBingBy
 * Email: XiaoBingBy@qq.com
 * Date: 2017/9/1
 * Time: 00:00
 * Describe: 基础控制器
 */
public class BaseController {
    /**
     * 渲染失败数据
     *
     * @return result
     */
    protected JsonResult renderError() {
        JsonResult result = new JsonResult();
        result.setSuccess(false);
        result.setStatus("500");
        return result;
    }

    /**
     * 渲染失败数据（带消息）
     *
     * @param msg 需要返回的消息
     * @return result
     */
    protected JsonResult renderError(String msg) {
        JsonResult result = renderError();
        result.setMsg(msg);
        return result;
    }

    /**
     * 渲染成功数据
     *
     * @return result
     */
    protected JsonResult renderSuccess() {
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setStatus("200");
        return result;
    }

    /**
     * 渲染成功数据（带信息）
     *
     * @param msg 需要返回的信息
     * @return result
     */
    protected JsonResult renderSuccess(String msg) {
        JsonResult result = renderSuccess();
        result.setMsg(msg);
        return result;
    }

    /**
     * 渲染成功数据（带数据）
     *
     * @param obj 需要返回的对象
     * @return result
     */
    protected JsonResult renderSuccess(Object obj) {
        JsonResult result = renderSuccess();
        result.setObj(obj);
        return result;
    }

    /**
     * 登录用户名
     */
    public String getCurrentLoginUsername() {
        Subject currentUser = SecurityUtils.getSubject();
        User user = currentUser.getPrincipals().oneByType(User.class);
        return user.getUsername();
    }

    /**
     * 登陆用户id
     * @return
     */
    public Long getCurrentLoginId(){
        Subject currentUser = SecurityUtils.getSubject();
        User user = currentUser.getPrincipals().oneByType(User.class);
        return user.getId();
    }

    /**
     * 登录用户对象
     */
    public User getCurrentUser() {
        Subject currentUser = SecurityUtils.getSubject();
        User user = currentUser.getPrincipals().oneByType(User.class);
        return user;
    }
    
}
