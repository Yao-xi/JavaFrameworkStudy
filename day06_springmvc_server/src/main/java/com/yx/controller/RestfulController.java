package com.yx.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rest")
public class RestfulController {
    @GetMapping()
    @ResponseBody
    public String show1() {
        return "success";
    }
    
    @GetMapping("{id}")
    @ResponseBody
    public String show2(@PathVariable String id) {
        return "show2::" + id;
    }
    
    @DeleteMapping("{id}")
    @ResponseBody
    public String show3(@PathVariable String id) {
        return "show3::" + id;
    }
}
