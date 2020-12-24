package com.yx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/resp")
public class ResponseController {
    @RequestMapping("/show1")
    public String show1() {
        // "redirect:" 重定向到指定页面
        // "forward:"  转发到指定页面
        // 不写默认转发
        return "redirect:/success.jsp";
    }
}
