package com.xiaobingby.sys.controller;

import com.xiaobingby.sys.entity.Menu;
import com.xiaobingby.sys.service.IPermissionService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.awt.*;
import java.util.List;
import java.util.Map;

import static java.awt.SystemColor.menu;

/**
 * 主页、登陆
 * Created by XiaoBingBy on 2017/9/23.
 */
@Controller
@RequestMapping(value = "/admin")
public class IndexController {

    @Autowired
    private IPermissionService iPermissionService;

    // 主页
    @RequestMapping(value = "/index")
    public String index(Model model) {
        // 获取当前用户菜单
        List<Menu> menus = iPermissionService.createMenu(2l);
        model.addAttribute("menus",menus);
        return "/admin/index";
    }

    /**
     * 登陆页面
     * @return
     */
    @GetMapping("/login")
    public String loginForm() {
        return "/admin/login";
    }

    /**
     * 登陆提交页面
     * @param username
     * @param password
     * @param map
     * @return
     */
    @RequestMapping("/mylogin")
    public String mylogin(String username, String password, Map<String, Object> map) {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            String simpleName = e.getClass().getSimpleName();
            if ("UnknownAccountException".equals(simpleName)) {
                map.put("msg", "用户不存在");
                return "/admin/login";
            } else if("IncorrectCredentialsException".equals(simpleName)){
                map.put("msg", "密码不正确");
                return "/admin/login";
            }
        }
        boolean authenticated = subject.isAuthenticated();
        if (authenticated) {
            return "redirect:/admin/index.html";
        }
        return "redirect:/admin/login.html";
    }

}
