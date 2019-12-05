package com.accp.airinInfo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.airinInfo.pojo.AirinInfo;

public interface IAirinInfoDao {
	// 查询所有航班
	List<AirinInfo> queryAll();

	// 按照起飞时间查询
	List<AirinInfo> queryByTerm(@Param("time") String time,@Param("destination") String destination);

	// 删除航班
	int daleteAirinInfo(@Param("id")  int id);

	// 更新航班
	int updateAirinInfo(@Param("info") AirinInfo info);
}
