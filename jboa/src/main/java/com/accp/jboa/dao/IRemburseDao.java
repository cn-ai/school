package com.accp.jboa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.jboa.pojo.Employee;
import com.accp.jboa.pojo.Tb_check;
import com.accp.jboa.pojo.Tb_reimburse;
import com.accp.jboa.pojo.Tb_status;
import com.accp.jboa.vo.EmployeeVo;
import com.accp.jboa.vo.ReimburseVo;

public interface IRemburseDao {
/**
 * 新增报销表
 * @param remburse
 */
	void addRemburse(@Param("remburse") Tb_reimburse remburse,@Param("year") Integer year,@Param("month") Integer month);
/**
 * 	新增报销表之前查询主键id
 * @return
 */
	int queryRemburse();
/**
 * 查询报销列表	
 * @param emp
 * @return
 */
	List<ReimburseVo> queryList(@Param("emp") Employee emp,@Param("account") String account,@Param("starttime") String starttime,@Param("endtime") String endtime);
/**
 * 查询所有状态	
 * @return
 */
	List<Tb_status> queryStatus();
/**
 * 查询上一级	
 * @param pid
 * @return
 */
	ReimburseVo queryParent(@Param("pid") Integer pid);
/**
 * 查询详情主表
 * @param reimburseid
 * @return
 */
	ReimburseVo queryDetail(@Param("reimburseid") Integer reimburseid);
/**
 * 查询详情
 * @param reimburseid
 * @return
 */
	List<ReimburseVo> queryDetailList(@Param("reimburseid") Integer reimburseid);
/**
 * 查询审查结果	
 * @param reimburseid
 * @return
 */
	List<ReimburseVo> querycheckList(@Param("reimburseid") Integer reimburseid,@Param("typeid")Integer typeid);
/**
 * 新增审查结果
 * @param check
 */
	int addsp(@Param("check") Tb_check check);
	/**
	 * 修改审查后的状态
	 * @param remburse
	 * @return
	 */
	int updateTb_reimburse(@Param("rei")Tb_reimburse remburse);
	/**
	 * 查询个人信息
	 * @param employeeId
	 * @param positionName
	 * @param departmentName
	 * @return
	 */
	public EmployeeVo EmployeeVoByemployeeId(@Param("employeeId")Integer employeeId,@Param("positionName")String positionName,@Param("departmentName")String departmentName);
	
}
