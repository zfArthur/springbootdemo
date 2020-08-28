package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.alibaba.fastjson.JSON;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
public class DemoApplication {

	public static void main(String[] args) {
		System.out.print("a1");
		SpringApplication.run(DemoApplication.class, args);
	}

}
