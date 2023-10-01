package com.example.demo.controller;


import com.example.demo.common.AppVariable;
import com.example.demo.common.ResultAjax;
import com.example.demo.model.Userinfo;
import com.example.demo.model.vo.UserinfoVO;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 注册接口
     * @param userinfo
     * @return
     */
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


    /**
     * 登录接口
     */
    @RequestMapping("/login")
    public ResultAjax login(UserinfoVO userinfoVO, HttpServletRequest request) {
        //校验参数
        if(userinfoVO == null || !StringUtils.hasLength(userinfoVO.getUsername())
        || !StringUtils.hasLength(userinfoVO.getPassword())) {
            return ResultAjax.fail(-1,"非法参数");
        }
        //根据用户名查询对象
        Userinfo userinfo = userService.getUserByName(userinfoVO.getUsername());
        if(userinfo == null || userinfo.getId() == 0) {
            return ResultAjax.fail(-2,"用户名或密码错误");
        }
        //使用对象中密码和用户输入的密码进行比较
        if(!userinfoVO.getPassword().equals(userinfo.getPassword())) {
            return ResultAjax.fail(-2,"用户名或密码错误");
        }
        //比较成功，存储到session中
        HttpSession session = request.getSession();
        session.setAttribute(AppVariable.SESSION_USERINFO_KEY,userinfo);

        //返回结果
        return ResultAjax.success(1);

    }
}
