package com.accp.Vote.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.Vote.pojo.item;
import com.accp.Vote.pojo.option;
import com.accp.Vote.pojo.subject;
/**
 * 
* @ClassName: ISubjectDao 
* @Description: 投票系统数据访问接口类
* @author 筠颜
* @date 2018年11月17日 下午3:46:13 
*
 */
public interface ISubjectDao {
	//查询所有投票标题和选项
	public List<subject> querySubject(@Param("subject")Object subject,@Param("type")String type);
	
	//修改停用状态
	public void updateSubjectType(@Param("subject")Object subject);
	
	//新增投票
	public int saveSubject(@Param("subject")Object subject);
	//新增投票选项 
	public void saveOptions(@Param("options")List<option> options,@Param("id")int id);
	
	//修改投票信息
	public void updateSubject(@Param("subject")Object subject);
	//删除修改之前的选项以及之前用户参与的选项
	public void deleteOptions(@Param("id")int id);
	
	//查看用户是否满足参与机制
	public int queryWay(@Param("way")String way,@Param("item")item item);
	//用户参与投票
	public void saveItems(@Param("Items")List<item> Items);
	//修改参与投票人数
	public void updateJoin(@Param("sid")int sid);
	
	//选项票数
	public List<option> queryItems(@Param("sid")Integer sid);
	
	//每日定时结束时间已到期的投票
	public int updateStoptype();
	
	
}
