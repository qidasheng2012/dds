package com.it.sys.controller;

import com.it.common.controller.BaseController;
import com.it.sys.entity.Menu;
import com.it.sys.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * 主页
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private IPermissionService iPermissionService;

    // 主页
    @RequestMapping(value = "/index")
    public String index(Model model) {
        // 获取当前用户菜单
        List<Menu> menus = iPermissionService.createMenu(getCurrentLoginId());
        model.addAttribute("menus", menus);
        return "/index";
    }

    /**
     * 项目技术预览
     *
     * @return
     */
    @RequestMapping(value = "/md")
    public String md() {
        return "/md";
    }

}
