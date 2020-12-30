package com.yx.controller;

import com.github.pagehelper.PageInfo;
import com.yx.controller.result.Result;
import com.yx.controller.result.ResultFlag;
import com.yx.domain.User;
import com.yx.service.UserService;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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
    //使用@Valid开启校验，使用@Validated也可以开启校验
    //Errors对象用于封装校验结果，如果不满足校验规则，对应的校验结果封装到该对象中，包含校验的属性名和校验不通过返回的消息
    //如果不获取Errors对象,则方法体不执行直接报错 Errors对象相当于try-catch
    //可以根据Errors对象信息 判断是否要接收这个未通过校验的值
    public Result insert(@Validated User user, Errors errors) {
        //判定Errors对象中是否存在未通过校验的字段
        if (errors.hasErrors()) {
            List<String> result = checkResult(errors);
            //返回校验结果
            return new Result(ResultFlag.ERR, result, "校验不通过");
        }
        boolean b = userService.insert(user);
        return new Result(b ? ResultFlag.OK : ResultFlag.ERR, null, null);
    }
    
    private List<String> checkResult(Errors errors) {
        //获取所有未通过校验规则的信息
        List<FieldError> fieldErrors = errors.getFieldErrors();
        List<String> result = new ArrayList<>();
        System.out.println(fieldErrors.size());
        for (FieldError error : fieldErrors) {
            System.out.println(error.getField());
            System.out.println(error.getDefaultMessage());
            result.add(error.getField() + "::" + error.getDefaultMessage());
        }
        return result;
    }
    
    @PutMapping
    public Result updateByPrimaryKey(@Validated @RequestBody User user, Errors errors) {
        //判定Errors对象中是否存在未通过校验的字段
        if (errors.hasErrors()) {
            //获取所有未通过校验规则的信息
            List<String> result = checkResult(errors);
            //返回校验结果
            return new Result(ResultFlag.ERR, result, "校验不通过");
        }
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
