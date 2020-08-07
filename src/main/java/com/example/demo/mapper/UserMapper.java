package com.example.demo.mapper;

import com.example.demo.model.CharTestEntity;

import java.util.List;

public interface UserMapper {
	
	List<CharTestEntity> getAll();

	CharTestEntity getOne(Long id);

	void insert(CharTestEntity user);

	void update(CharTestEntity user);

	void delete(Long id);

}