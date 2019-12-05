package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.T_record;
import com.example.demo.pojo.T_student;

public interface IStudentDao {
	/**
	 * 登录
	 * @param name 用户名
	 * @param code 密码
	 * @return
	 */
 T_student Login(@Param("name") String name,@Param("code")String code) ;
 
 
 /**
  * 查询所有学生信息
  * @return
  */
 List<T_student> queryStudent();
 
 /**
  * 查询所有的奖惩记录,包含单个,模糊查询
  * @return
  */
 List<T_record> loadRecord(@Param("stucode")String stucode,@Param("stuname") String stuname,@Param("rname") String rname);
 /**
  * 新增某个学生的奖惩记录
  * @param record
  */
 void addRecord(@Param("record") T_record record);
 /**
  * 修改某个学生的奖惩记录
  * @param record
  */
 void updateRecord(@Param("record") T_record record);
 /**
  * 删除某个学生的奖惩记录
  * @param rid
  */
 void delRecord(@Param("rid")int rid);
 /**
  * 修改时先读取数据
  * @param rid
  * @return
  */
 T_record recordOne(@Param("rid")int rid);


}
