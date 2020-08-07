package com.example.demo.mapper;

import com.example.demo.model.CharTestEntity;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CharTestMapper {


    @Select("SELECT * FROM char_test limit 1")
    List<CharTestEntity> getAll();
}
