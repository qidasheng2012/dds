package com.it.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.common.controller.BaseController;
import com.it.common.result.JsonResult;
import com.it.common.utils.StringUtil;
import com.it.entity.Role;
import com.it.entity.User;
import com.it.service.IRoleService;
import com.it.service.IUserService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;

    /**
     * 用户列表页面
     *
     * @return
     */
    @RequiresPermissions("user:show")
    @GetMapping("/toList")
    public String toList(ModelMap map) {
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByAsc("sort");
        List<Role> allRole = iRoleService.list(queryWrapper);
        map.put("allRole", allRole);
        return "/user/list";
    }

    /**
     * 获取用户列表
     *
     * @param pageNumber 当前页
     * @param pageSize   每页显示条数
     * @param searchText 搜索名称
     * @return
     */
    @ResponseBody
    @GetMapping("/list")
    public Map<String, Object> list(int pageNumber, int pageSize, String searchText) {
        Map<String, Object> result = new HashMap<String, Object>();
        Page<User> page = new Page<>(pageNumber, pageSize);
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        if (StringUtil.isNotEmpty(searchText)) {
            queryWrapper.like("username", searchText);
        }
        IPage<User> userPage = iUserService.page(page, queryWrapper);
        result.put("total", userPage.getTotal());
        result.put("rows", userPage.getRecords());
        return result;
    }

    /**
     * 添加用户
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUser")
    public JsonResult addUser(User user) {
        // 创建盐, 散列加密
        String salt = String.valueOf(System.currentTimeMillis());
        SimpleHash password = new SimpleHash("MD5", user.getPassword(), salt);
        user.setSalt(salt);
        user.setPassword(password.toString());
        return iUserService.save(user) ? renderSuccess("添加成功") : renderError("添加失败");
    }

    /**
     * 修改用户
     *
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateUser")
    public JsonResult updateUser(User user) {
        return iUserService.updateById(user) ? renderSuccess("修改成功") : renderError("修改失败");
    }

    /**
     * 审核用户
     *
     * @param users
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/optionUserStatus")
    public JsonResult optionUserStatus(@RequestBody List<User> users) {
        for (User user : users) {
            user.setNickname(null);
            user.setPassword(null);
            user.setUsername(null);
            user.setEmail(null);
            user.setSalt(null);
            user.setStatus(1);
        }
        return iUserService.updateBatchById(users) ? renderSuccess("审核成功") : renderError("审核失败");
    }

    /**
     * 删除用户
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/delete")
    public JsonResult delete(@RequestParam(value = "id", required = false) String id) {
        if (StringUtil.isEmpty(id)) {
            return renderError("请选择数据");
        }
        return iUserService.deleteUserByIdAndRole(id) ? renderSuccess("删除成功") : renderError("删除失败");
    }

}
