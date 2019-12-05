package com.accp.exam.biz;

import java.util.List;

import com.accp.exam.dao.IInvitationDao;
import com.accp.exam.pojo.Detail;
import com.accp.exam.pojo.Invitation;
import com.accp.exam.util.SqlSessionUtil;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class InvitationBiz {
//查询所有帖子
	public PageInfo<Invitation>  queryAll(String title,int pageNum,int pageSize){
		PageHelper.startPage(pageNum, pageSize);
		IInvitationDao dao=SqlSessionUtil.getSession().getMapper(IInvitationDao.class);
		List<Invitation> list=dao.queryAll(title);
		PageInfo<Invitation> info=new PageInfo<Invitation>(list);
		return info;
	}
//查询回复
	public List<Detail> queryDetail(int id){
		IInvitationDao dao=SqlSessionUtil.getSession().getMapper(IInvitationDao.class);
		return dao.querydetail(id);
	}
}
