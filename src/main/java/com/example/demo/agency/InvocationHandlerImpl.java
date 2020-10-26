package com.example.demo.agency;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Author zhangfu
 * @Date 2020-10-19 16:06
 */
public class InvocationHandlerImpl implements InvocationHandler {

    ShowService target;

    public InvocationHandlerImpl(ShowService target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 表演开始前收钱
        getMoney();
        // 明星开始唱歌
        Object invoke = method.invoke(target, args);
        // 表演结束后开发票
        writeReceipt();
        return invoke;
    }

    private void getMoney() {
        System.out.println("get money");
    }

    private void writeReceipt() {
        System.out.println("write receipt");
    }

}
