package com.example.demo.service;


import com.example.demo.dao.ArticleMapper;
import com.example.demo.model.Articleinfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    public List<Articleinfo> getListByUid(int uid) {
        return articleMapper.getListByUid(uid);
    }

}
