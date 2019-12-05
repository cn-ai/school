package com.accp.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.accp.dao.IDistrictDao;
import com.accp.dao.IQualityDao;
import com.accp.dao.IQueryVoDao;
import com.accp.pojo.District;
import com.accp.pojo.Quality;
import com.accp.vo.QueryVo;

@Service
@Transactional(propagation=Propagation.SUPPORTS,readOnly=true,isolation=Isolation.DEFAULT)
public class DistrictBiz {
	@Autowired
	private IDistrictDao dao;
	@Autowired
	private IQueryVoDao vodao;
	
	private IQualityDao iQualityDao;
	
	//查询地区
	public List<District> queryDistrict(){
		return dao.findAll();
	}
	//查询列表信息
	public Page<QueryVo> queryQueryVo(Pageable pageable,String name){
		return vodao.queryAll(pageable,name);
	}
	
	public void add(Quality q) {
		iQualityDao.save(q);
	}
}
