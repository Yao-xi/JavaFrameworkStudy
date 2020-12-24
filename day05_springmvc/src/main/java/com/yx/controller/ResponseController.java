package com.yx.controller;

import com.yx.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    
    @RequestMapping("/show2")
    @ResponseBody
    public User show2() {
        return new User("张三", 23);
    }
    
    @RequestMapping("/show3")
    @ResponseBody
    public List<User> show3() {
        ArrayList<User> list = new ArrayList<>();
        Collections.addAll(list,
                           new User("张三", 23),
                           new User("李四", 24),
                           new User("王五", 25));
        return list;
    }
    
    @RequestMapping("/show4")
    @ResponseBody
    public List<User> show4(@RequestBody List<User> userList) {
        System.out.println(userList);
        return userList;
    }
    
    @RequestMapping("/show5")
    @ResponseBody
    public List<String> show5(@RequestParam("userList") List<String> userList) {
        System.out.println(userList);
        return userList;
    }
    
}
