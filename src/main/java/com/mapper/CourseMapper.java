package com.mapper;

import java.util.List;

import com.entitys.Course;

public interface CourseMapper {
	public Course selectOne(int cid);
	public List<Course> selectAll();
}
