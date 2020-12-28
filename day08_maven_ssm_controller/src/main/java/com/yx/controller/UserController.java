package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.controller.result.Result;
import com.yx.controller.result.ResultFlag;
import com.yx.domain.User;
import com.yx.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @Resource
    private UserService userService;
    
    @DeleteMapping("/{id}")
    public Result deleteByPrimaryKey(@PathVariable Integer id) {
        boolean b = userService.deleteByPrimaryKey(id);
        return new Result(b ? ResultFlag.OK : ResultFlag.ERR, null, null);
    }
    
    @PostMapping
    public Result insert(User user) {
        boolean b = userService.insert(user);
        return new Result(b ? ResultFlag.OK : ResultFlag.ERR, null, null);
    }
    
    @PutMapping
    public Result updateByPrimaryKey(@RequestBody User user) {
        boolean b = userService.updateByPrimaryKey(user);
        return new Result(b ? ResultFlag.OK : ResultFlag.ERR, null, null);
    }
    
    @GetMapping("/{pageNum}/{pageSize}")
    public Result findAll(@PathVariable int pageNum, @PathVariable int pageSize) {
        PageInfo<User> all = userService.findAll(pageNum, pageSize);
        return new Result(all != null ? ResultFlag.OK : ResultFlag.ERR, all, null);
    }
    
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) {
        User user = userService.findById(id);
        if (id == 10) {
            // 模拟异常
            throw new RuntimeException("查询出错...");
        }
        return new Result(user != null ? ResultFlag.OK : ResultFlag.ERR, user, null);
    }
    
    @PostMapping("/{username}")
    public Result login(@PathVariable String username, String password) {
        User user = userService.login(username, password);
        return new Result(user != null ? ResultFlag.OK : ResultFlag.ERR, user, null);
    }
}
