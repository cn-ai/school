package com.accp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.accp.pojo.Quality;

@Repository
public interface IQualityDao extends JpaRepository<Quality, Integer>{

}
