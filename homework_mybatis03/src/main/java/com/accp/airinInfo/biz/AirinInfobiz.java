package com.accp.airinInfo.biz;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.accp.airinInfo.dao.IAirinInfoDao;
import com.accp.airinInfo.pojo.AirinInfo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class AirinInfobiz {
	private SqlSessionFactory ssf;

	public AirinInfobiz() {
		SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
		try {
			ssf = ssfb.build(Resources.getResourceAsReader("config.xml"));
		} catch (IOException e) {
			throw new RuntimeException("配置错误");
		}
	}
	
	public PageInfo<AirinInfo> queryAll(int pageNum,int pageSize){
		SqlSession session = null;
		try {
			session=ssf.openSession();
			IAirinInfoDao dao=session.getMapper(IAirinInfoDao.class);
			PageHelper.startPage(pageNum, pageSize);//开始分页
			List<AirinInfo> list=dao.queryAll();//数据查询
			PageInfo<AirinInfo> info=new PageInfo<AirinInfo>( list);//分页数据
			return info;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}	
	}
	
	public  PageInfo<AirinInfo> queryByTerm(String time,String destination,int pageNum,int pageSize) {
		SqlSession session = null;
		try {
			session=ssf.openSession();
			
			IAirinInfoDao dao=session.getMapper(IAirinInfoDao.class);
			PageHelper.startPage(pageNum, pageSize);
			List<AirinInfo> data =dao.queryByTerm(time, destination);
			PageInfo<AirinInfo> info=new PageInfo<AirinInfo>( data);//分页数据
			return info;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
	}
	
	public int daleteAirinInfo(int id) {
		SqlSession session = null;
		try {
			session=ssf.openSession();
			IAirinInfoDao dao=session.getMapper(IAirinInfoDao.class);
			int count=dao.daleteAirinInfo(id);
			session.commit();
			return count;
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
	}
	
	public int updateAirinInfo(AirinInfo info) {
		SqlSession session = null;
		try {
			session=ssf.openSession();
			IAirinInfoDao dao=session.getMapper(IAirinInfoDao.class);
			int count=dao.updateAirinInfo(info);
			session.commit();
			return count;
		} catch (Exception e) {
			session.rollback();
			throw new RuntimeException(e);
		}finally {
			session.close();
		}
	}
}
