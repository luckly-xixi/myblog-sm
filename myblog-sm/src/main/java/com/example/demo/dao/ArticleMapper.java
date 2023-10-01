package com.example.demo.dao;

import com.example.demo.model.Articleinfo;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {

    @Select("select * from articleinfo where uid=#{uid}")
    List<Articleinfo> getListByUid(@Param("Uid")int uid);

}
