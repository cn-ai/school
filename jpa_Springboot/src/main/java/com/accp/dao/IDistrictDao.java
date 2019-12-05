package com.accp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accp.pojo.District;

@Repository
public interface IDistrictDao extends JpaRepository<District,Integer>{

	
	
}
