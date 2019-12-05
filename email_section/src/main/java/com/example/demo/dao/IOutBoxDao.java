package com.example.demo.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.demo.pojo.Outbox;

public interface IOutBoxDao {
	/**
	 * 查询收件箱
	 * 按照状态查询
	 * 查询当前用户
	 * 排除删除的状态
	 *  默认状态升序  0未读/1已读/2红旗
	 *  默认时间降序
	 * @return
	 */
	List<Outbox> queryOutbix(@Param("state") int state,@Param("inuid") int inuid);
}
