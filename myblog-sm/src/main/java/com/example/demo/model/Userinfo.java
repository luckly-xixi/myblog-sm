package com.example.demo.model;


import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Userinfo implements Serializable {
    //继承可以实现序列化和反序列化
    private int id;
    private String username;
    private String password;
    private String photo;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private int state;
}
