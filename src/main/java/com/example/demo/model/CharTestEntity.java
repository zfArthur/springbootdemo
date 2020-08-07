package com.example.demo.model;


import lombok.Data;

import java.io.Serializable;


@Data
public class CharTestEntity implements Serializable {
    /**
     * 序列化
     */
    private static final long serialVersionUID = 1L;

    /**
     * 是否可以为NULL：no
     * 列类型：int(11)
     * 默认值：
     * 列的数据类型的长度：10.0
     * 列注释：
     * 列的扩展：auto_increment
     * 列名：id
     * 列的数据类型：int
     * 是否是主键：是
     */
    //@JsonProperty("id")
    private Integer id;
    private String userName;
    private String passWord;
    private String nickName;

}