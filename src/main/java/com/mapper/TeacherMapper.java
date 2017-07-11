package com.mapper;

import java.util.List;

import com.entitys.Teacher;

public interface TeacherMapper {
	public Teacher selectOne(int id);
	public List<Teacher> selectAll();
}
