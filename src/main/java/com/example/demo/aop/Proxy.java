package com.example.demo.aop;

public class Proxy implements Action {

    private Action action;

    public Proxy (Star star){
        this.action = star;
    }
    @Override
    public void sing(String name) {
        System.out.println("代理人通知明星：");
        action.sing(name);
    }
}
