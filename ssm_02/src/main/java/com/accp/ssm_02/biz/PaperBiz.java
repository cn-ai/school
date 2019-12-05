package com.accp.ssm_02.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.accp.ssm_02.dao.IPaperDao;
import com.accp.ssm_02.pojo.T_code;
import com.accp.ssm_02.pojo.T_paper;
import com.accp.ssm_02.pojo.T_user;
import com.accp.ssm_02.vo.PaperVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class PaperBiz {
	@Autowired
	private IPaperDao dao;
//登录
	public T_user Login(String userName,String userPassword) {
		return dao.Login(userName, userPassword);
	}
//查询类型
	public List<T_code> querylistcode(){
		return dao.querylistcode();
	}
//查询论文
	public PageInfo<PaperVo> querypaper(PaperVo pvo,int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<PaperVo> list= dao.querypaper(pvo);
		PageInfo<PaperVo> info=new PageInfo<PaperVo>(list);
		return info;
	}
//删除
	public int delpaper(int pid) {
		int count=dao.delpaper(pid);
		return count;
	}
	public T_paper querytitle(String title,Integer pid) {
		return dao.querytitle(title,pid);
	}
//新增
	public int addPaper(T_paper paper) {
		return dao.addPaper(paper);
	}
//修改
	public int updatePaper(T_paper paper) {
		return dao.updatePaper(paper);
	}
}
