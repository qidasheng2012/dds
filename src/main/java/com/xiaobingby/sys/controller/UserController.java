package com.xiaobingby.sys.controller;


import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.xiaobingby.common.controller.BaseController;
import com.xiaobingby.common.result.JsonResult;
import com.xiaobingby.common.utils.StringUtil;
import com.xiaobingby.sys.entity.Role;
import com.xiaobingby.sys.entity.User;
import com.xiaobingby.sys.service.IRoleService;
import com.xiaobingby.sys.service.IUserService;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import org.springframework.stereotype.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * user 用户表 前端控制器
 * </p>
 *
 * @author XiaoBingBy
 * @since 2017-09-23
 */
@Controller
@RequestMapping("/admin/user")
public class UserController extends BaseController {

    @Autowired
    private IUserService iUserService;
    @Autowired
    private IRoleService iRoleService;

    /**
     * 用户列表页面
     * @return
     */
    @GetMapping("/list")
    public String list(Model model) {
        EntityWrapper<Role> wrapper = new EntityWrapper<>();
        wrapper.or("sort", true);
        List<Role> allRole = iRoleService.selectList(wrapper);
        model.addAttribute("allRole", allRole);
        return "/admin/user/list";
    }

    /**
     * 获取用户列表
     * @param pageNumber 当前页
     * @param pageSize 每页显示条数
     * @param searchText 搜索名称
     * @return
     */
    @ResponseBody
    @PostMapping("/getList")
    public Map<String, Object> getUserList(int pageNumber, int pageSize, String searchText) {
        Map<String,Object> result = new HashMap<String,Object>();
        Page<User> page = new Page<>(pageNumber, pageSize);
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        if (StringUtil.isNotEmpty(searchText)) {
            wrapper.like("username", searchText);
        }
        Page<User> userPage = iUserService.selectPage(page, wrapper);
        result.put("total", userPage.getTotal());
        result.put("rows", userPage.getRecords());
        return result;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addUser")
    public JsonResult addUser(User user) {
        // 创建盐, 散列加密
        String salt = String.valueOf(System.currentTimeMillis());
        SimpleHash password = new SimpleHash("MD5", user.getUsername(), salt);
        user.setSalt(salt);
        user.setPassword(password.toString());
        return  iUserService.insert(user) ? renderSuccess("添加成功") : renderError("添加失败");
    }

    /**
     * 修改用户
     * @param user
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updateUser")
    public JsonResult updateUser(User user) {
        return iUserService.updateById(user) ? renderSuccess("修改成功") : renderError("修改失败");
    }

    /**
     * 删除用户
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
