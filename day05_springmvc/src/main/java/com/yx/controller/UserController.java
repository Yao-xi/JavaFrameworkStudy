package com.yx.controller;

import com.yx.domain.User;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/save")
    public String save() {
        System.out.println("user mvcEnableWebMvc controller is running ...");
        return "/success.jsp";
    }
    
    // http://localhost:8080/user/show1?username=zs&age=23
    // 想要啥就写啥
    @RequestMapping("/show1")
    public String show1(String username, Integer age) {
        System.out.println("show1 :: username = " + username);
        System.out.println("show1 :: age = " + age);
        return "/success.jsp";
    }
    
    // http://localhost:8080/user/show2?username=zs&age=23
    @RequestMapping("/show2")
    public String show2(User user) {
        System.out.println("show2 :: user = " + user);
        return "/success.jsp";
    }
    
    // http://localhost:8080/user/show3
    // http://localhost:8080/user/show3?username=bbb
    // @RequestParam:要求参数必须存在,否则报错
    // @RequestParam:可以指定默认值
    @RequestMapping("/show3")
    public String show3(@RequestParam(defaultValue = "aaa") String username) {
        System.out.println("show3 :: username = " + username);
        return "/success.jsp";
    }
    
    //http://localhost:8080/user/show4?strs=aaa&strs=bbb&strs=ccc
    @RequestMapping("/show4")
    public String show4(String[] strs) {
        System.out.println("show4 :: strs = " + Arrays.toString(strs));
        return "/success.jsp";
    }
    
    //http://localhost:8080/user/show5?strs=aaa&strs=bbb&strs=ccc
    @RequestMapping("/show5")
    public String show5(@RequestParam("strs") List<String> list) {
        System.out.println("show5 :: strs = " + list);
        return "/success.jsp";
    }
    
    //http://localhost:8080/user/show6
    @RequestMapping("/show6")
    public String show6(HttpServletRequest request,
                        HttpServletResponse response,
                        HttpSession session) {
        System.out.println("request = " + request);
        System.out.println("response = " + response);
        System.out.println("session = " + session);
        return "/success.jsp";
    }
    
    //http://localhost:8080/user/show7?username=zs&age=23
    @RequestMapping("/show7")
    public String show7(@RequestParam Map<String, Object> map) {
        System.out.println("show7 :: map = " + map);
        return "/success.jsp";
    }
    
    //http://localhost:8080/user/show8?birthday=2020-02-02
    @RequestMapping("/show8")
    public String show8(@DateTimeFormat(pattern = "yyyy-MM-dd") Date birthday) {
        System.out.println("show8 :: birthday = " + birthday);
        return "/success.jsp";
    }
    
    
}
