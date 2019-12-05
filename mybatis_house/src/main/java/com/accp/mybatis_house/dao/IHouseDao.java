package com.accp.mybatis_house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.mybatis_house.pojo.Img;
import com.accp.mybatis_house.pojo.Info;
import com.accp.mybatis_house.vo.vo;

public interface IHouseDao {
	//查询房屋详情
		List<vo> queryVo(@Param("o") vo o,@Param("search") String search,@Param("priceBegin") String priceBegin,@Param("priceEnd") String priceEnd);
	//加载房屋信息
		vo loadHouse(@Param("hid") String hid);
	//新增
		int addInfo(@Param("info") Info info);
	//获取房屋末尾自增id
		Integer queryInfoByAtuoId();
	//获取房屋id
		String queryInfoById();
	//新增图片
		int addImg(@Param("img") Img img);
	//读取首页图片
		Img loadImg(@Param("byId") String byId);
	//改变出租状态和房屋信息
		int updateInfo(@Param("info") Info info);
	//加载单个房屋类型
		Info loadInfo(@Param("hid") String hid);
	//删除的房屋
		int delInfo(@Param("hid")String hid);
	//查询所有图片
		List<Img> listImg(@Param("hid") String hid);
	
}
