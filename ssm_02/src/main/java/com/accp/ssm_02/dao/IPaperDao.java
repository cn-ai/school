package com.accp.ssm_02.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.ssm_02.pojo.T_code;
import com.accp.ssm_02.pojo.T_paper;
import com.accp.ssm_02.pojo.T_user;
import com.accp.ssm_02.vo.PaperVo;

public interface IPaperDao {
//登录
	T_user Login(@Param("userName") String userName,@Param("userPassword") String userPassword);
//查询类型
	List<T_code> querylistcode();
//查询论文
	List<PaperVo> querypaper(@Param("pvo") PaperVo pvo);
//删除
	int delpaper(@Param("pid") int pid);
//查询是否有重复标题
	T_paper querytitle(@Param("title")  String title,@Param("pid") Integer pid);
//新增论文
	int addPaper(@Param("paper") T_paper paper);
//修改
	int updatePaper(@Param("paper") T_paper paper);
}
