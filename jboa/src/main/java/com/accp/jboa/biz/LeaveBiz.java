package com.accp.jboa.biz;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.jboa.dao.ILeaveDao;
import com.accp.jboa.pojo.Employee;
import com.accp.jboa.pojo.Tb_check;
import com.accp.jboa.pojo.Tb_leave;
import com.accp.jboa.pojo.Tb_message;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class LeaveBiz {
	@Autowired
	private ILeaveDao leavedao;
/**
 * 新增请假
 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	
	public void addLeave(Tb_leave leave) {
		leavedao.addLeave(leave);
	}
/**
 * 新增信息
 * @param leave
 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void addMessage(Tb_leave leave) {
		leavedao.addMessage(leave);
	}
/**
 * 查询请假
 * @param leave
 * @param pageNum
 * @param pageSize
 * @return
 */
	public PageInfo<Tb_leave> queryLeave(Tb_leave leave,Employee emp,Integer pageNum,Integer pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Tb_leave> list=leavedao.queryLeave(leave,emp);
		PageInfo<Tb_leave> info=new PageInfo<Tb_leave>(list);
		return info;
	}
/**
 * 请假详情
 * @return
 */
	public Tb_leave loadLeave(Tb_leave leave) {
		return leavedao.queryLeave(leave, new Employee()).get(0);
	}
	/**
	 * 审批请假
	 * @param leave
	 * @param check
	 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	
	public	void updateLeave(Tb_leave leave,Tb_check check) {
			leavedao.updateLeave(leave, check);
		}
	/**
	 *  查看消息
	 */
	public	PageInfo<Tb_message> queryMessage(int addressees_id,Integer pageNum,Integer pageSize){
			PageHelper.startPage(pageNum, pageSize);
			List<Tb_message> list=leavedao.queryMessage(addressees_id);
			PageInfo<Tb_message> pageinfo=new PageInfo<Tb_message>(list);
			return pageinfo;
		}
	/**
	 * 修改查看消息后的状态
	 * @param bizId
	 * @param addressees_id
	 */
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	
	public	void updateMessage(int bizId,int addressees_id) {
			leavedao.updateMessage(bizId, addressees_id);
		}
	
}
