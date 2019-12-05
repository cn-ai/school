package com.accp.jboa.action;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.accp.jboa.biz.RemburseBiz;
import com.accp.jboa.pojo.Employee;
import com.accp.jboa.pojo.Reimburse_detail;
import com.accp.jboa.pojo.Tb_check;
import com.accp.jboa.pojo.Tb_reimburse;
import com.accp.jboa.pojo.Tb_status;
import com.accp.jboa.util.Base64ConvertImageUtil;
import com.accp.jboa.vo.Base64ImageVo;
import com.accp.jboa.vo.ReimburseVo;
import com.accp.jboa.vo.Tb_reimburseVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/remburse")
public class RemburseAction {
	@Autowired
	private RemburseBiz rebiz;
	
	/**
	 * 新增报销表
	 * @param remburse 主表对象
	 * @param year 年
	 * @param month 月
	 * @param departmentid 部门
	 * @param employeeid	员工
	 */
	//@RequestBody:请求方法必须是json格式
		@RequestMapping(value = "addRemburse", method = RequestMethod.POST)
		@ResponseBody
		public Map<String, String> addRemburse(@RequestBody Tb_reimburse re,HttpSession session) {
			Map<String, String> message = new HashMap<String, String>();
			int id=rebiz.queryRemburse();
			re.setReimburseid(id+1);
			// 获得远程路径
			String realPath = session.getServletContext().getRealPath("/images");
				
			List<Reimburse_detail> d=re.getDetails();
			
				for (Reimburse_detail reimburse_detail : d) {	
				
				// uuid另存为文件名
				String newFileName = UUID.randomUUID().toString().replace("-", "")
						+reimburse_detail.getPictruename() .substring(reimburse_detail.getPictruename() .lastIndexOf("."));
				reimburse_detail.setMainid(id+1);
				reimburse_detail.setPictruename(newFileName);
				reimburse_detail.setPictruepath(realPath);
				
			
				//base64反序列化
				Base64ConvertImageUtil.generateImageFromBase64(reimburse_detail.getPictruepath(), realPath+File.separator+newFileName);
			}
			
			rebiz.addRemburse(re,2012, 4);
			
		
			message.put("code", "200");
			message.put("msg", "ok");
			return message;
		}
/**
 * 查询报销列表
 * @param mo
 * @param emp
 * @param num
 * @param size
 * @return
 */
		@RequestMapping("querylist")
		public String queryList(Model mo,Integer num,Integer size,String account,String starttime,String endtime) {
			if(num==null) {
				num=1;
			}
			if(size==null) {
				size=10;
			}
		RequestAttributes ra=RequestContextHolder.getRequestAttributes();
		HttpServletRequest request= ((ServletRequestAttributes)ra).getRequest();
		Employee empl=(Employee) request.getSession().getAttribute("emp");
		
		Employee emp=new Employee();
		emp.setEmployeename(empl.getEmployeename());
		emp.setPid(empl.getEmployeeid());
		ReimburseVo parentList =rebiz.queryParent(emp.getPid());
		List<Tb_status> list=rebiz.queryStatus();
		PageInfo<ReimburseVo> pageInfo=	rebiz.queryList(emp, num, size, account, starttime, endtime);
		mo.addAttribute("pageinfo", pageInfo);
		mo.addAttribute("list", list);
		mo.addAttribute("parent", parentList);
		mo.addAttribute("account", account);
		mo.addAttribute("starttime", starttime);
		mo.addAttribute("endtime", endtime);
		return "queryBX";
		}
		@RequestMapping("detail")
		public String queryDetail(Model mo,Integer reimburseid,Integer typeid) {
			ReimburseVo reimburse=rebiz.queryDetail(reimburseid);//查询主信息
			List<ReimburseVo> detaillist=rebiz.queryDetailList(reimburseid);//查询详情
			List<ReimburseVo> checklist=rebiz.querycheckList(reimburseid,typeid);//查询审查
			
			mo.addAttribute("reimburse", reimburse);
			
			mo.addAttribute("detaillist", detaillist);
			mo.addAttribute("checklist", checklist);
			return "bxdetail";
		
		}
		@RequestMapping("sh")
		public String querysh(Model mo,Integer reimburseid,Integer typeid) {
			ReimburseVo reimburse=rebiz.queryDetail(reimburseid);//查询主信息
			List<ReimburseVo> detaillist=rebiz.queryDetailList(reimburseid);//查询详情
			List<ReimburseVo> checklist=rebiz.querycheckList(reimburseid,typeid);//查询审查
			
			mo.addAttribute("reimburse", reimburse);
			mo.addAttribute("detaillist", detaillist);
			mo.addAttribute("checklist", checklist);
			return "look1";
		
		}
		/**
		 * 新增审核
		 * @param check
		 * @return
		 */
		@RequestMapping("addsp")
		@ResponseBody
		public String addsp(Tb_check check,String button,Tb_reimburseVo vo) {
			int count=rebiz.addsp(check);
		
			return "<script type='text/javascript'charset='utf-8'>location.href='/jboa/remburse/querylist';</script>";
		}
		
		
}
