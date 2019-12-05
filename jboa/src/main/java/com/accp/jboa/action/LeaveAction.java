package com.accp.jboa.action;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.accp.jboa.biz.LeaveBiz;
import com.accp.jboa.pojo.Employee;
import com.accp.jboa.pojo.Tb_check;
import com.accp.jboa.pojo.Tb_leave;
import com.accp.jboa.pojo.Tb_message;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/leave")
public class LeaveAction {
	@Autowired
	private LeaveBiz leavebiz;
/**
 * 申请请假
 * @param leave
 * @return
 */
	@RequestMapping(value="addleave",produces="text/html;charset=utf-8")
	@ResponseBody
	public String addleave(Tb_leave leave) {
		leavebiz.addLeave(leave);	
		leavebiz.addMessage(leave);
		return "<script type='text/javascript'charset='utf-8'>alert('申请成功');location.href='/jboa/leave/queryLeave';</script>";
	}
/**
 * 查询请假列表	
 * @return
 */
	@RequestMapping(value="queryLeave",produces="text/html;charset=utf-8")
	public String queryLeave(Tb_leave leave, Employee emp, Integer pageNum,Integer pageSize, Model model) {
		if(pageSize==null) {
			pageSize=10;
		}
		if(pageNum==null) {
			pageNum=1;
		}
		model.addAttribute("pageinfo", leavebiz.queryLeave(leave, emp, pageNum, pageSize));
		model.addAttribute("startTime", leave.getStarttime());
		model.addAttribute("endtTme", leave.getCreatetime());
		return "pages/show/leaveList";
	}
	// 查看请假详情
		@RequestMapping("queryLeavedetail")
		public String queryLeave(Tb_leave leave, String type, Model model) {
			model.addAttribute("Page", leavebiz.loadLeave(leave));
			if (type.equals("审批")) {
				return "pages/show/leaveExamine";
			} else {
				return "pages/show/leaveDetails";
			}

		}
/**
 * 审批请假
 * @return
 */
@RequestMapping(value="updateLeave",produces="text/html;charset=utf-8")
@ResponseBody
public String updateLeave(Model model,Tb_leave leave,Tb_check check,Employee emp, Integer pageNum,Integer pageSize) {
	leavebiz.updateLeave(leave, check);
	
	return "<script type='text/javascript'charset='utf-8'>alert('审批成功');location.href='/jboa/leave/queryLeave';</script>";
}	
/**
 * ajax轮询处理消息通知
 */
@RequestMapping("queryMessageAjax")
@ResponseBody
public PageInfo<Tb_message> queryMessageAjax(int addressees_id,Integer pageNum,Integer pageSize) {
	if(pageSize==null) {
		pageSize=10;
	}
	if(pageNum==null) {
		pageNum=1;
	}
	return leavebiz.queryMessage(addressees_id, pageNum, pageSize);
}
/**
 * 修改消息状态
 * @param bizId
 * @param addressees_id
 */
@RequestMapping("updateMessageajax")
@ResponseBody
public void updateMessageajax(int bizId,int addressees_id) {
	 leavebiz.updateMessage(bizId, addressees_id);
}
// 查看邮箱
@RequestMapping("queryMessage")
public String queryMessages(int addressees_id, Integer pageNum, Model model) {
	model.addAttribute("pageinfo", leavebiz.queryMessage(addressees_id, pageNum,10));
	return "mailbox";
}
}
