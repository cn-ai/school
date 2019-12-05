package com.accp.spring01.biz;

import com.accp.spring01.dao.ITestDao;

public class TestBizImpl implements ITestBiz{
public ITestDao dao;

public ITestDao getDao() {
	return dao;
}

public void setDao(ITestDao dao) {
	this.dao = dao;
}
public void add() {
	dao.save();
}
public void del() {
	dao.del();
}
}
