package com.accp.mybatis_house.biz;


import java.util.List;

import com.accp.mybatis_house.dao.IHouseDao;
import com.accp.mybatis_house.dao.IUserDao;
import com.accp.mybatis_house.pojo.Area;
import com.accp.mybatis_house.pojo.District;
import com.accp.mybatis_house.pojo.Img;
import com.accp.mybatis_house.pojo.Info;
import com.accp.mybatis_house.pojo.Type;
import com.accp.mybatis_house.pojo.User;
import com.accp.mybatis_house.util.SqlSessionUtil;
import com.accp.mybatis_house.vo.vo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

public class UserBiz {
	
	//登录
	public User Login(String uname,String upwd) {
			IUserDao dao= SqlSessionUtil.getSession().getMapper(IUserDao.class);
			return dao.Login(uname, upwd);
			
	}
//注册
	public int zc(User user) {
			IUserDao dao= SqlSessionUtil.getSession().getMapper(IUserDao.class);			
			int count=dao.zc(user);
			return count;
	}
	//查询地区
	public	List<District> querydistrict(){
		IUserDao dao= SqlSessionUtil.getSession().getMapper(IUserDao.class);
		return dao.querydistrict();
	}
//查询房型
	public List<Type> querytype(){
		IUserDao dao= SqlSessionUtil.getSession().getMapper(IUserDao.class);
		return dao.querytype();
	}
//查询面积
	public List<Area> queryarea(){
		IUserDao dao= SqlSessionUtil.getSession().getMapper(IUserDao.class);
		return dao.queryarea();
	} 
//查询房屋信息
	public PageInfo<vo> queryVo(vo o,String search,String priceBegin,String priceEnd, int pageNum,int pageSize){
		IHouseDao dao= SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		PageHelper.startPage(pageNum, pageSize);
		List<vo> list=dao.queryVo(o, search, priceBegin, priceEnd);
		PageInfo<vo> info=new PageInfo<vo>(list);
		
		return info;
	}
//加载房屋详情
	public vo loadHouse(String hid) {
		IHouseDao dao= SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		return dao.loadHouse(hid);
	}
	//新增房屋
		public int addInfo(Info info) {
			IHouseDao dao=SqlSessionUtil.getSession().getMapper(IHouseDao.class);
			return dao.addInfo(info); 
		}
		//获取新增商品的id
		public String queryInfoById() {
			IHouseDao dao=SqlSessionUtil.getSession().getMapper(IHouseDao.class);
			return dao.queryInfoById();
		}
		//获取房屋末尾自增id
		public Integer queryInfoByAtuoId() {
			IHouseDao dao=SqlSessionUtil.getSession().getMapper(IHouseDao.class);
			return dao.queryInfoByAtuoId();
		}
//新增图片
	public int addImg(Img img) {
		IHouseDao dao=SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		return dao.addImg(img);
	}
//加载图片
	public Img loadImg(String byId) {
		IHouseDao dao= SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		return dao.loadImg(byId);
	}
//修改状态
	public int updateInfo(Info info) {
		IHouseDao dao= SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		return dao.updateInfo(info);
	}
	//加载单个房屋类型
	public Info loadInfo(String hid) {
		IHouseDao dao= SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		return dao.loadInfo(hid);
	}
//删除房屋信息
	public int delInfo(String hid) {
		IHouseDao dao= SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		return dao.delInfo(hid);
	}
//查询所有图片
	public List<Img> listImg(String hid){
		IHouseDao dao= SqlSessionUtil.getSession().getMapper(IHouseDao.class);
		return dao.listImg(hid);
	}
}
