package com.example.demo.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IStudentDao;
import com.example.demo.pojo.T_record;
import com.example.demo.pojo.T_student;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class StudentBiz {
	@Autowired
	private IStudentDao dao;
	/**
	 * 登录
	 * @param name 用户名
	 * @param code 密码
	 * @return
	 */
 public T_student Login(String name,String code) {
	 return dao.Login(name, code);
 }
 
 
 /**
  * 查询所有学生信息
  * @return
  */
public PageInfo<T_student>  queryStudent(Integer pageNum,Integer pageSize){
	 PageHelper.startPage(pageNum, pageSize);
	 List<T_student> list=dao.queryStudent();
	 PageInfo<T_student> info=new PageInfo<T_student>(list);
	 return info;
 }
 
 /**
  * 查询所有的奖惩记录,包含单个,模糊查询
  * @return
  */
 public PageInfo<T_record> loadRecord(String stucode, String stuname,String rname,Integer pageNum,Integer pageSize){
	 PageHelper.startPage(pageNum, pageSize);
	 List<T_record> list= dao.loadRecord(stucode, stuname, rname);
	 PageInfo<T_record> info=new PageInfo<T_record>(list);
	 return info;
	 
 }
 /**
  * 新增某个学生的奖惩记录
  * @param record
  */
 @Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
 public void addRecord(T_record record) {
	  dao.addRecord(record);
 }
 /**
  * 修改某个学生的奖惩记录
  * @param record
  */
 @Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
public  void updateRecord( T_record record) {
	 dao.updateRecord(record);
 }
 /**
  * 删除某个学生的奖惩记录
  * @param rid
  */
 @Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
 public void delRecord(int rid) {
	 dao.delRecord(rid);
 }
 /**
  * 查询所有学生的姓名
  * @return
  */
 public List<T_student> loadStudent(){
	 return dao.queryStudent();
 }
 
 public T_record recordOne(int rid) {
	return dao.recordOne(rid);
 }
}
