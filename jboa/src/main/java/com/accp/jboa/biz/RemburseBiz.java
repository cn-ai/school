package com.accp.jboa.biz;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.jboa.dao.IRemburseDao;
import com.accp.jboa.pojo.Employee;
import com.accp.jboa.pojo.Tb_check;
import com.accp.jboa.pojo.Tb_count;
import com.accp.jboa.pojo.Tb_reimburse;
import com.accp.jboa.pojo.Tb_status;
import com.accp.jboa.vo.ReimburseVo;
import com.accp.jboa.vo.Tb_reimburseVo;
import com.accp.jboa.vo.EmployeeVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class RemburseBiz {
	@Autowired
	private IRemburseDao redao;
	
/**
 * 新增报销表
 * @param remburse 主表对象
 * @param year 年
 * @param month 月
 * @param departmentid 部门
 * @param employeeid	员工
 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public 	void addRemburse(Tb_reimburse remburse,Integer year,Integer month) {
		redao.addRemburse(remburse, year, month);
	}
	/**
	 * 	新增报销表之前查询主键id
	 * @return
	 */

	public 	int queryRemburse() {
		return redao.queryRemburse();
	}
/**
 * 查询报销列表
 * @param emp
 * @param pageNum
 * @param pageSize
 * @return
 */
	public PageInfo<ReimburseVo> queryList(Employee emp,Integer pageNum,Integer pageSize, String account, String starttime,String endtime){
		PageHelper.startPage(pageNum, pageSize);
		List<ReimburseVo> list=redao.queryList(emp, account, starttime, endtime);
		PageInfo<ReimburseVo> info=new PageInfo<ReimburseVo>(list);
		return info;
	}
/**
 * 查询所有状态	
 * @return
 */
	public List<Tb_status> queryStatus(){
		return redao.queryStatus();
	}
/**
 * 查询上一级	
 * @param pid
 * @return
 */
	public ReimburseVo queryParent(Integer pid){
		return redao.queryParent(pid);
	}
	
	/**
	 * 查询详情主表
	 * @param reimburseid
	 * @return
	 */
		public ReimburseVo queryDetail( Integer reimburseid) {
			return redao.queryDetail(reimburseid);
		}
	/**
	 * 查询详情
	 * @param reimburseid
	 * @return
	 */
		public List<ReimburseVo> queryDetailList( Integer reimburseid){
			return redao.queryDetailList(reimburseid);
		}
	/**
	 * 查询审查结果	
	 * @param reimburseid
	 * @return
	 */
		public List<ReimburseVo> querycheckList( Integer reimburseid,Integer typeid){
			return redao.querycheckList(reimburseid,typeid);
		}
	/**
	 * 审批
	 */
		@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
		public int addsp( Tb_check check) {
			return redao.addsp(check);
		}
}

