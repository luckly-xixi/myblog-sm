package com.example.demo.controller;


import com.example.demo.common.ResultAjax;
import com.example.demo.model.Userinfo;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;


    @RequestMapping("/reg")
    public ResultAjax reg(Userinfo userinfo) {
        //1.参数校验
        if(userinfo==null || !StringUtils.hasLength(userinfo.getUsername())
                || !StringUtils.hasLength(userinfo.getPassword())) {
            return ResultAjax.fail(-1,"非法参数");
        }

        //2.请求service进行添加操作
        int result = userService.reg(userinfo);
        //3.将执行的结果返回给前端
        return ResultAjax.success(result);
    }
}
