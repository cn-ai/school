package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Dept;
import com.example.demo.pojo.Emp;

public interface IDeptDao {
	/**
	 * 查询所有的部门
	 * @return
	 */
List<Dept> queryDeptList();
/**
 * 查询各个部门下的所有员工
 * @param did
 * @return
 */
List<Emp> queryEmpList(@Param("did")Integer did);

/**
 * 删除所选员工
 * @param eid
 */
void delEmp(@Param("eid") Integer eid);
}
