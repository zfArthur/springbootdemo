package com.example.demo.dubbo;

/**
 * @Author zhangfu
 * @Date 2020-10-20 10:32
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public String hello(String name) {
        return "hello" + name;
    }
}
