package com.example.demo.copy1;


import java.io.Serializable;

/**
 * @Author zhangfu
 * @Date 2020-10-13 19:23
 */
public class PersonDesc implements Serializable {

    private static final long serialVersionUID = 872390113109L;
    // 描述
    private String desc;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

}