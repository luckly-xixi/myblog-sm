package com.example.demo.model;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Articleinfo implements Serializable {
    private int id;
    private String title;
    private String content;
    private LocalDateTime createtime;
    private LocalDateTime updatetime;
    private int uid;
    private int rcount;
    private int state;
}
