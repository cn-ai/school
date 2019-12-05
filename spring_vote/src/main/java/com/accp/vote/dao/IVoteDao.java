package com.accp.vote.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.vote.pojo.Option;
import com.accp.vote.pojo.Subject;
import com.accp.vote.pojo.User;

public interface IVoteDao {
	/**
	 * 登录
	 * @param uname
	 * @param upwd
	 * @return
	 */
	User Login(@Param("uname") String uname,@Param("upwd")String upwd);
	/**
	 * 注册
	 * @param uname
	 * @param upwd
	 * @return
	 */
	int saveReg(@Param("uname") String uname,@Param("upwd")String upwd);
	/**
	 * 查询登录后的主页
	 * @param sub
	 * @return
	 */
	List<Subject> querySub(@Param("title") String title);
	/**
	 * 维护前的查询
	 * @param sid
	 * @return
	 */
	Subject loadSub(@Param("sid") int sid);
	/**
	 * 进行维护功能
	 * @param sub
	 * @return
	 */
	int updateSub(@Param("sub") Subject sub);

}
