package com.accp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.accp.vo.QueryVo;

@Repository
public interface IQueryVoDao extends JpaRepository<QueryVo, Integer>{
	
	@Query(value="SELECT air_quality_index.id,district.`name`,air_quality_index.`districtid`,air_quality_index.`monitortime`,air_quality_index.`pm10`,air_quality_index.`pm25`,air_quality_index.`monitoringstation`,air_quality_index.`lastmodifytime` FROM `air_quality_index`  INNER JOIN `district` ON air_quality_index.`districtid`=district.`id` where (district.name=:#{#name} or :#{#name} is null)",countQuery="  SELECT COUNT(*) FROM `air_quality_index`  INNER JOIN `district` ON air_quality_index.`districtid`=district.`id` where (district.name=:#{#name} or :#{#name} is null)",nativeQuery=true)
	public Page<QueryVo> queryAll(Pageable pageable,@Param("name") String name);
}
