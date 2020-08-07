package com.example.demo.controller;

import com.example.demo.mapper.UserMapper;
import com.example.demo.model.CharTestEntity;
import com.example.demo.dto.TestReqDto;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/test")
@RestController
@Slf4j
public class TestController {

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/ceshi")
    public List<CharTestEntity> equals(@RequestBody TestReqDto testReqDto) {
        log.info(new Gson().toJson(testReqDto));
        List<CharTestEntity> list=  userMapper.getAll();
        log.info(new Gson().toJson(list));
        return list;
    }
}
