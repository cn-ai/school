package com.accp.exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.exam.pojo.Detail;
import com.accp.exam.pojo.Invitation;

public interface IInvitationDao {
//查询帖子
	List<Invitation> queryAll(@Param("title") String title);
//查询回复
	List<Detail> querydetail(int iid);
}
