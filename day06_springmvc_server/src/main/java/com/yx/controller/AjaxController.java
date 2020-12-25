package com.yx.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@Controller
@RequestMapping("/ajax")
public class AjaxController {
    @RequestMapping("/show1")
    @ResponseBody
    public String show1() {
        return "success";
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
