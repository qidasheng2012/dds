package com.it.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.it.common.controller.BaseController;
import com.it.common.result.JsonResult;
import com.it.common.utils.StringUtil;
import com.it.entity.Role;
import com.it.entity.User;
import com.it.entity.UserRole;
import com.it.service.IRoleService;
import com.it.service.IUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController extends BaseController {

    @Autowired
    private IRoleService iRoleService;
    @Autowired
    private IUserRoleService iUserRoleService;

    /**
     * 角色列表页面
     *
     * @return
     */
    @GetMapping("/toList")
    public String toList() {
        return "/role/list";
    }

    /**
     * 获取角色列表
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
        Page<Role> page = new Page<>(pageNumber, pageSize);
        QueryWrapper<Role> queryWrapper = new QueryWrapper<>();
        if (StringUtil.isNotEmpty(searchText)) {
            queryWrapper.like("name", searchText);
        }
        queryWrapper.orderByAsc("sort");
        IPage<Role> rolePage = iRoleService.page(page, queryWrapper);
        result.put("total", rolePage.getTotal());
        result.put("rows", rolePage.getRecords());
        return result;
    }

    /**
     * 添加用户
     *
     * @param role
     * @return
     */
    @ResponseBody
    @PostMapping("/addRole")
    public JsonResult addRole(Role role) {
        return iRoleService.save(role) ? renderSuccess("添加成功") : renderError("添加失败");
    }

    /**
     * 修改用户
     *
     * @param role
     * @return
     */
    @ResponseBody
    @PostMapping("/updateRole")
    public JsonResult updateRole(Role role) {
        return iRoleService.updateById(role) ? renderSuccess("修改成功") : renderError("修改失败");
    }

    /**
     * 删除角色
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
        return iRoleService.deleteRoleByIdAndPermission(id) ? renderSuccess("删除成功") : renderError("删除失败");
    }

    /**
     * 分配角色
     * 查询用户拥有的角色
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/getUserRole")
    public JsonResult getUserRole(@RequestBody User user) {
        QueryWrapper<UserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("uid", user.getId());
        List<UserRole> userRoles = iUserRoleService.list(queryWrapper);
        return renderSuccess(userRoles);
    }

    /**
     * 分配用户角色
     *
     * @return
     */
    @ResponseBody
    @RequestMapping("/modifyUserRole")
    public JsonResult modifyUserRole(@RequestBody List<UserRole> userRoles) {
        return iRoleService.modifyUserRole(userRoles) ? renderSuccess("分配成功") : renderError("分配失败");
    }

}
