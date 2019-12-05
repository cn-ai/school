package com.accp.order.biz;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.log4j.Logger;

import com.accp.order.dao.IStudentDao;
import com.accp.order.pojo.Clazz;
import com.accp.order.pojo.Student;

public class StudentBiz {
	private static StudentBiz studentbiz = new StudentBiz();
	private SqlSessionFactory ssf;
	Logger logger=Logger.getRootLogger();
	private StudentBiz() {
		SqlSessionFactoryBuilder ssfb=new SqlSessionFactoryBuilder();
		try {
			ssf=ssfb.build(Resources.getResourceAsStream("config.xml"));
		} catch (IOException e) {
			logger.error("配置错误！");
		}
	}
	public static StudentBiz stuBiz() {
		return studentbiz;
	}
	public void saveStudentAndClazz(Clazz clazz) {
		SqlSession session = null;
		try {
			session=ssf.openSession();
			IStudentDao dao= session.getMapper(IStudentDao.class);
			dao.saveStudentAndClazz(clazz);
			int clazzid=clazz.getClazzid();
			//查询详情
			for (Student  stu : clazz.getStudent()) {
				stu.setClazzid(clazzid);
				dao.saveStudent(stu);
			}
			session.commit();
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
		
	}
	
	public int delStudent(int sid) {
		SqlSession session = null;
		try {
			session=ssf.openSession();
			IStudentDao dao= session.getMapper(IStudentDao.class);
			int count=dao.delStudent(sid);			
			session.commit();
			return count;
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
	}
	
	public int updateStudent(Student stu) {
		SqlSession session = null;
		try {
			session=ssf.openSession();
			IStudentDao dao= session.getMapper(IStudentDao.class);
			int count=dao.updateStudent(stu);		
			session.commit();
			return count;
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
	}
	public List<Clazz> queryClazzAndStudent(String name){
		SqlSession session = null;
		try {
			session=ssf.openSession();
			IStudentDao dao= session.getMapper(IStudentDao.class);
			 return dao.queryClazzAndStudent(name);		
			
		} catch (Exception e) {
			
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
	}
	
	public List<Student> queryStudentAndClazz(String stuname){
		SqlSession session = null;
		try {
			session=ssf.openSession();
			IStudentDao dao=session.getMapper(IStudentDao.class);
			return dao.queryStudentAndClazz(stuname);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
	}
}
