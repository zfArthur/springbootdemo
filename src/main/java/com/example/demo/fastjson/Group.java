package com.example.demo.fastjson;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author zhangfu
 * @Date 2020-08-28 17:18
 */
@Data
public class Group {
    private Long       id;
    private String     name;
    private List<User> users = new ArrayList<User>();

    public void addUser(User user) {
        users.add(user);
    }

}
