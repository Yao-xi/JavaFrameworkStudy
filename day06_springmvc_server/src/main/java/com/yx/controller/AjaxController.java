package com.yx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/ajax")
@CrossOrigin // 允许跨域
public class AjaxController {
    @RequestMapping("/show1")
    @ResponseBody
    public String show1() {
        return "success";
    }
    
    @RequestMapping("/show2")
    @ResponseBody
    public String show2(String name, Integer age) {
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return name + " " + age;
    }
    
    @RequestMapping("/show3")
    @ResponseBody
    public String show3(@RequestBody String str) {
        System.out.println(str);
        return str;
    }
    
    @RequestMapping("/upload")
    @ResponseBody
    public String fileUpload(MultipartFile file, HttpServletRequest request) throws IOException {
        if (file != null && !file.isEmpty()) {
            String realPath = request.getServletContext().getRealPath("/upload");
            String fileName = System.currentTimeMillis() + "_" + file.getOriginalFilename();
            file.transferTo(new File(realPath, fileName));
        }
        return "success";
    }
}
