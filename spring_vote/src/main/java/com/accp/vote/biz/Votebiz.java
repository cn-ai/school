package com.accp.vote.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.accp.vote.dao.IVoteDao;
import com.accp.vote.pojo.Subject;
import com.accp.vote.pojo.User;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class Votebiz {
	@Autowired
	private IVoteDao dao;
/**
 * 登录
 * @param uname
 * @param upwd
 * @return
 */
	public User Login(String uname,String upwd) {
		return dao.Login(uname, upwd);
	}
	/**
	 * 注册
	 * @param uname
	 * @param upwd
	 * @return
	 */
	public int saveReg(String uname,String upwd) {
		return dao.saveReg(uname, upwd);
	}
	/**
	 * 查询登录后的主页
	 * @param pageNum
	 * @param pageSize
	 * @param sub
	 * @return
	 */
	public PageInfo<Subject> querySub(String title,int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<Subject> list=dao.querySub(title);
		PageInfo<Subject> info=new PageInfo<Subject>(list);
		return info;
	}
	/**
	 * 修改前的查询
	 * @param sid
	 * @return
	 */
	public Subject loadSub(int sid) {
		return dao.loadSub(sid);			
	}
	
	public int updateSub(Subject sub) {
		return dao.updateSub(sub);
	}
}
