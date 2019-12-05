package com.example.demo.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IStockDao;
import com.example.demo.pojo.Student;
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, isolation = Isolation.READ_COMMITTED)
public class CronBiz {
	@Autowired
	private IStockDao dao;
public void show() {
	System.out.println("当前统计会员数量XXX");
}
@Transactional(propagation = Propagation.REQUIRED, readOnly = false, isolation = Isolation.READ_COMMITTED)
public void addStudent(Student stu) {
	dao.addStudent(stu);
}

public List<Student> queryStudent() {
	return dao.queryStudent();
}
}
