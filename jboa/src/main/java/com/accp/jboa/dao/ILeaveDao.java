package com.accp.jboa.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.jboa.pojo.Employee;
import com.accp.jboa.pojo.Tb_check;
import com.accp.jboa.pojo.Tb_leave;
import com.accp.jboa.pojo.Tb_message;

public interface ILeaveDao {
	/**
	 * 新增请假
	 * @param leave
	 */
void  addLeave(@Param("leave")Tb_leave leave);
/**
 * 新增消息
 */
void addMessage(@Param("leave")Tb_leave leave );
/**
 * 查看请假
 * @return
 */
	List<Tb_leave> queryLeave(@Param("leave")Tb_leave leave,@Param("emp") Employee emp);
/**
 * 审批请假
 * @param leave
 * @param check
 */
	void updateLeave(@Param("leave")Tb_leave leave,@Param("check") Tb_check check);
/**
 *  查看消息
 */
	List<Tb_message> queryMessage(@Param("addressees_id")int addressees_id);
/**
 * 修改查看消息后的状态
 * @param bizId
 * @param addressees_id
 */
	void updateMessage(@Param("bizId")int bizId,@Param("addressees_id")int addressees_id);
}
