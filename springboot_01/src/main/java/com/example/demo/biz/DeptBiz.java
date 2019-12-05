package com.example.demo.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dao.IDeptDao;
import com.example.demo.pojo.Dept;
import com.example.demo.pojo.Emp;

@Service
@Transactional(propagation = Propagation.SUPPORTS, isolation = Isolation.READ_COMMITTED, readOnly = true)
public class DeptBiz {
	@Autowired
	private IDeptDao dao;

	/**
	 * 查询所有的部门
	 * 
	 * @return
	 */
	public List<Dept> queryDeptList(){
		return dao.queryDeptList();
	}

	/**
	 * 查询各个部门下的所有员工
	 * 
	 * @param did
	 * @return
	 */
	public List<Emp> queryEmpList(Integer did){
		return dao.queryEmpList(did);
	}

	/**
	 * 删除所选员工
	 * 
	 * @param eid
	 */
	@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, readOnly =false)
	public  void delEmp(Integer eid) {
		dao.delEmp(eid);
	}
}
