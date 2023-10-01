package com.example.demo.controller;


import com.example.demo.common.ResultAjax;
import com.example.demo.common.SessionUtils;
import com.example.demo.dao.ArticleMapper;
import com.example.demo.model.Articleinfo;
import com.example.demo.model.Userinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/art")
public class ArticleController {

    @Autowired
    private ArticleMapper articleMapper;

    /**
     * 得到当前用户的文章列表
     */
    @RequestMapping("/mylist")
    public ResultAjax myList(HttpServletRequest request) {
        //1.得到当前登录用户
        Userinfo userinfo = SessionUtils.getUser(request);
        if(userinfo == null ) {
            return ResultAjax.fail(-1,"请先登录");
        }
        //2.根据用户 id  查询此用户发表的所有文章
        List<Articleinfo> list= articleMapper.getListByUid(userinfo.getId());
        //3.返回给前端
        return ResultAjax.success(list);
    }
}
