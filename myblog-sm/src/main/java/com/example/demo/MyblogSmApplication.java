package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.example.demo.dao") //此包下的所有类型都是 mapper 类
public class MyblogSmApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyblogSmApplication.class, args);
	}

}
