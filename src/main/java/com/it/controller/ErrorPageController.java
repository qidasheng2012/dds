package com.it.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 错误页处理controller
 */
@Controller
@RequestMapping("/errorPage")
public class ErrorPageController {

    @RequestMapping("/{code}")
    public String toErrorPage(@PathVariable int code) {
        return "/error/" + code;
    }

}
