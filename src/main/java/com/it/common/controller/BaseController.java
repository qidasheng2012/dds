package com.it.common.controller;

import com.it.common.result.JsonResult;
import com.it.entity.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

/**
 * Describe: 基础控制器
 */
public class BaseController {
    /**
     * 渲染失败数据
     *
     * @return result
     */
    protected JsonResult renderError() {
        return renderError(null);
    }

    /**
     * 渲染失败数据（带消息）
     *
     * @param msg 需要返回的消息
     * @return result
     */
    protected JsonResult renderError(String msg) {
        JsonResult result = new JsonResult();
        result.setSuccess(false);
        result.setStatus("500");
        result.setMsg(msg);
        return result;
    }

    /**
     * 渲染成功数据
     *
     * @return result
     */
    protected JsonResult renderSuccess() {
        return renderSuccess(null);
    }

    /**
     * 渲染成功数据（带信息）
     *
     * @param msg 需要返回的信息
     * @return result
     */
    protected JsonResult renderSuccess(String msg) {
        JsonResult result = new JsonResult();
        result.setSuccess(true);
        result.setStatus("200");
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
     * 登录用户对象
     */
    public User getCurrentUser() {
        Subject currentUser = SecurityUtils.getSubject();
        return currentUser.getPrincipals().oneByType(User.class);
    }

    /**
     * 登录用户名
     */
    public String getCurrentLoginUsername() {
        return getCurrentUser().getUsername();
    }

    /**
     * 登陆用户id
     *
     * @return
     */
    public Long getCurrentLoginId() {
        return getCurrentUser().getId();
    }

}
