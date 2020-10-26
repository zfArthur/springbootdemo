package com.example.demo.copy;

import lombok.Data;

/**
 * @Author zhangfu
 * @Date 2020-10-13 19:05
 */
@Data
public class PersonDesc1 implements Cloneable {
    // 描述
    private String desc;
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
