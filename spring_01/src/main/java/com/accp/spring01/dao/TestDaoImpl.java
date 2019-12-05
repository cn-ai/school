package com.accp.spring01.dao;

public class TestDaoImpl implements ITestDao{

	@Override
	public void save() {
		// TODO Auto-generated method stub
		System.out.println("新增持久化操作");
	}

	@Override
	public void del() {
		// TODO Auto-generated method stub
		System.out.println("删除操作");
	}

}
