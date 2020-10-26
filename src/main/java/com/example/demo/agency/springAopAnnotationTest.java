package com.example.demo.agency;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author zhangfu
 * @Date 2020-10-19 17:02
 */
public class springAopAnnotationTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop-annotation.xml");

        Object star = applicationContext.getBean("star");

        ShowService showService = (ShowService)star;
        showService.sing("Mockingbird");
    }

}
