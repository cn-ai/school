package com.accp.order.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.order.pojo.Clazz;
import com.accp.order.pojo.Student;

public interface IStudentDao {
	int saveStudentAndClazz(@Param("clazz") Clazz clazz);
	int delStudent(@Param("sid") int sid);
	int updateStudent(@Param("stu")Student stu);
	List<Clazz> queryClazzAndStudent(@Param("name")String name);
	int saveStudent(@Param("stu")Student stu);
	List<Student> queryStudentAndClazz(@Param("stuname") String stuname);
}
