package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@MapperScan("com.example.demo.mapper")
@ImportResource({"classpath:spring-dubbo.xml", "classpath:dubbo-consumer.xml", "classpath:dubbo-provider.xml", "classpath:spring-mcq.xml"})
public class DemoApplication {

	public static void main(String[] args) {
		System.out.print("a1");
		SpringApplication.run(DemoApplication.class, args);
	}

}
