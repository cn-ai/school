package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Student;

public interface IStockDao {
void addStudent(@Param("stu") Student stu);

List<Student> queryStudent();
}
