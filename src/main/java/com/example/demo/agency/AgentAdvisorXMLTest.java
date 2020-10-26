package com.example.demo.agency;

/**
 * @Author zhangfu
 * @Date 2020-10-19 16:50
 */
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhoujunfu on 2018/9/7.
 */
public class AgentAdvisorXMLTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-aop.xml");

        Object star = applicationContext.getBean("star");

        ShowService showService = (ShowService)star;
        showService.sing("Mockingbird");
    }
}
