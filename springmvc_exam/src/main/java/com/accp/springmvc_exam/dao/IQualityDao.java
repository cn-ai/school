package com.accp.springmvc_exam.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.accp.springmvc_exam.pojo.District;
import com.accp.springmvc_exam.pojo.air_quality_index;

public interface IQualityDao {
/**
 * 按区域查询或查询所有
 * @param districtid
 * @return
 */
	List<air_quality_index> queryAll(@Param("districtid") Integer districtid);
/**
 * 查询所有区域
 * @return
 */
	List<District> queryDistrict();
/**
 * 新增
 * @param air
 */
	void insertAir(@Param("air") air_quality_index air);
/**
 * 删除	
 * @param id
 */
	void delAir(@Param("id") int id);
/**
 * 加载单个空气值	
 * @param id
 * @return
 */
	air_quality_index loadAir(@Param("id") int id);
/**
 * 修改	
 * @param air
 */
	void updateAir(@Param("air") air_quality_index air);
}
