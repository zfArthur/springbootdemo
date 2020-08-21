package com.example.demo.aop;

public class ProxyTest {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new Star());
        proxy.sing("饿狼传说");
    }
}

