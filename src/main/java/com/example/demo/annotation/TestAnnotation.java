package com.example.demo.annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author zhangfu
 * @Date 2020-10-26 14:07
 */
public class TestAnnotation {
    public static void main(String[] args){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("annotation-spring.xml");
        School school = (School)ctx.getBean("school");
       System.out.println(school.toString());
    }
}
