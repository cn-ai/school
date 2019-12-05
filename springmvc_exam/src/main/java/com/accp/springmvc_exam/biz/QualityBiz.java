package com.accp.springmvc_exam.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.springmvc_exam.dao.IQualityDao;
import com.accp.springmvc_exam.pojo.District;
import com.accp.springmvc_exam.pojo.air_quality_index;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
@Transactional(propagation=Propagation.SUPPORTS,isolation=Isolation.READ_COMMITTED,readOnly=true)
public class QualityBiz {
	@Autowired
	private IQualityDao dao;
	
	public List<District> queryDistrict(){
		return dao.queryDistrict();
	}
	
	public PageInfo<air_quality_index> queryAll(Integer districtid,Integer pageNum,Integer pageSize){
		PageHelper.startPage(pageNum, pageSize);
		List<air_quality_index> list=dao.queryAll(districtid);
		PageInfo<air_quality_index> info=new PageInfo<air_quality_index>(list);
		return info;
	}
	
//新增
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void insertAir(air_quality_index air) {
		 dao.insertAir(air);
	}
//删除
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void delAir(int id) {
		dao.delAir(id);
	}
//加载单个空气值
	public air_quality_index loadAir(int id) {
		return dao.loadAir(id);
	}
//修改
	@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.READ_COMMITTED,readOnly=false)
	public void updateAir(air_quality_index air) {
		dao.updateAir(air);
	}
}
