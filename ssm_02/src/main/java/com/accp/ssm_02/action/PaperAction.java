package com.accp.ssm_02.action;


import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MaxUploadSizeExceededException;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.accp.ssm_02.biz.PaperBiz;
import com.accp.ssm_02.pojo.T_code;
import com.accp.ssm_02.pojo.T_paper;
import com.accp.ssm_02.pojo.T_user;
import com.accp.ssm_02.vo.PaperVo;
import com.github.pagehelper.PageInfo;

@Controller
@RequestMapping("/user")
public class PaperAction {
	@Autowired
	private PaperBiz biz;
	
	@ExceptionHandler(value= {MaxUploadSizeExceededException.class})
	public ModelAndView handlerException(	Exception e,	HttpServletRequest request		) {
		System.out.println("出现异常");
		ModelAndView mav=new ModelAndView("add");
		mav.addObject("msg", "文件太大");
		return mav;
	}
	
	
//登录
	@RequestMapping("login")
	public String Login(Model mo,String userName,String userPassword,HttpSession session) {
		T_user user=biz.Login(userName, userPassword);
		if(user!=null) {	
			session.setAttribute("user", user);
			return "xxs";
		}else {
			mo.addAttribute("msg", "登录失败");
			return "login";
		}
	}
//跳转登录页面
	@RequestMapping("to")
	public String toLogin() {
		return "login";
	}
	@RequestMapping("touserName")
	public String touserName() {
		return "UserName";
	}
//跳转到新增页面
	@RequestMapping("toadd")
	public String toadd(Model mo) {
		List<T_code> list= biz.querylistcode();
		mo.addAttribute("listcode", list);
		return "add";
	}
//查询页面的数据加载
	@RequestMapping("query")
	public String querylist(Model mo,PaperVo pvo,Integer p,Integer s) {
		if(p==null) {
			p=1;
		}
		if(s==null) {
			s=2;
		}
		List<T_code> list= biz.querylistcode();
		PageInfo<PaperVo> info= biz.querypaper(pvo,p,s);
		mo.addAttribute("listcode", list);
		mo.addAttribute("info", info);
		mo.addAttribute("title", pvo.getTitle());
		mo.addAttribute("code", pvo.getCodeTypeName());
		return "list";
	}
	
//删除
	@RequestMapping("del")
	public String delpaper(Model mo,Integer pid) {
		biz.delpaper(pid);
		return "redirect:/user/query";
	}
//新增
	@RequestMapping(value="add",method=RequestMethod.POST)
	public String addPaper(HttpSession session,MultipartFile imgFile, Model mo,T_paper paper) throws IllegalStateException, IOException {
		if(biz.querytitle(paper.getTitle(),-1) != null) {
			mo.addAttribute("titlemsg", "此论文题目已存在");
			return "add";
		}
		String realPath=session.getServletContext().getRealPath("/img");
		String fileName=UUID.randomUUID().toString().replace("-","")+imgFile.getOriginalFilename().substring(imgFile.getOriginalFilename().lastIndexOf("."));
		paper.setPaperPath(fileName);
		biz.addPaper(paper);
		imgFile.transferTo(new File(realPath+File.separator+fileName));
		return "redirect:/user/query";
	}
//跳转到修改页面
	@RequestMapping("toUpdate")
	public String toUpdate(Model mo,Integer pid) {
		T_paper paper=biz.querytitle(null,pid);
		mo.addAttribute("paper", paper);
		List<T_code> list= biz.querylistcode();
		mo.addAttribute("listcode", list);
		return "update";
	}
//修改
	@RequestMapping("update")
	public String updatePaper(Model mo,T_paper paper) {
		int count=biz.updatePaper(paper);
		System.out.println(count);
		return "redirect:/user/query";
	}
}


