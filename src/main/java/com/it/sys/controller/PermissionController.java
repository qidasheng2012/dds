package com.it.sys.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.it.common.controller.BaseController;
import com.it.common.result.JsonResult;
import com.it.common.utils.StringUtil;
import com.it.sys.entity.Permission;
import com.it.sys.entity.RolePermission;
import com.it.sys.entity.ZNodes;
import com.it.sys.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * permission 权限表 前端控制器
 * </p>
 */
@Controller
@RequestMapping("/permission")
public class PermissionController extends BaseController {

    @Autowired
    private IPermissionService iPermissionService;

    /**
     * 权限列表页面
     *
     * @return
     */
    @GetMapping("/list")
    public String list() {
        return "/permission/list";
    }

    /**
     * 获取权限列表
     *
     * @return
     */
    @ResponseBody
    @GetMapping("/getList")
    public List<Permission> getUserList() {
        // 排序
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort");
        List<Permission> permissions = iPermissionService.list(wrapper);
        return permissions;
    }

    /**
     * 查询所有权限树形展示 并且选中角色拥有的树节点
     *
     * @param roleId
     * @return
     */
    @ResponseBody
    @RequestMapping("/getPermissionZTreeNodes")
    public List<ZNodes> getPermissionZTreeNodes(Long roleId) {
        return iPermissionService.findPermissionZTreeNodes(roleId);
    }

    /**
     * 修改角色权限
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/modifyRolePermission")
    public JsonResult modifyRolePermission(@RequestBody List<RolePermission> rolePermissions) {
        return iPermissionService.modifyRolePermission(rolePermissions) ? renderSuccess("分配成功") : renderError("分配失败");
    }

    /**
     * 添加权限
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addPermission")
    public JsonResult addPermission(Permission permission) {
        if (permission.getType() == 0) {
            permission.setPid(0l);
        }
        return iPermissionService.save(permission) ? renderSuccess("添加成功") : renderError("添加失败");
    }

    /**
     * 修改权限
     *
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/updatePermission")
    public JsonResult updatePermission(Permission permission) {
        if (permission.getType() == 0) {
            permission.setPid(0l);
        }
        return iPermissionService.updateById(permission) ? renderSuccess("修改成功") : renderError("修改失败");
    }

    /**
     * 删除权限 和 权限角色表数据
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping("/deletePermissionRole")
    public JsonResult deletePermissionRole(@RequestParam(value = "id", required = false) String id) {
        if (StringUtil.isEmpty(id)) {
            return renderError("请选择数据");
        }
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.eq("pid", id);
        List<Permission> permissions = iPermissionService.list(wrapper);
        if (permissions.size() >= 1) {
            return renderError("请删除子节点数据");
        }
        return iPermissionService.deletePermissionRole(id) ? renderSuccess("删除成功") : renderError("删除失败");
    }

    /**
     * 获取父级select
     *
     * @param type
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getTypePermission/{type}")
    public List<Permission> getTypePermission(@PathVariable("type") Integer type) {
        if (type == null) {
            type = 0;
        }
        if (type < 0 || type > 1) {
            return null;
        }
        QueryWrapper<Permission> permissionEntityWrapper = new QueryWrapper<>();
        permissionEntityWrapper.eq("type", type);
        permissionEntityWrapper.orderByAsc("sort");
        List<Permission> permissions = iPermissionService.list(permissionEntityWrapper);
        return permissions;
    }

    /**
     * 传入Id 查询一条权限值返回
     *
     * @param id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getPermissionById")
    public Permission getPermissionById(Long id) {
        return iPermissionService.getById(id);
    }

}
