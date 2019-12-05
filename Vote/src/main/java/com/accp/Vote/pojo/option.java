package com.accp.Vote.pojo;

import java.util.ArrayList;
import java.util.List;
/**
 * 
* @ClassName: option 
* @Description: 投票选项基本信息描述类
* @author 筠颜
* @date 2018年11月14日 下午3:14:34 
*
 */
public class option {
	private Integer id;//投票编号
	private String option;//投票选项
	private Integer sid;//投票内容编号
	
	private List<item> item = new ArrayList<item>();//选项取值
	
	public List<item> getItem() {
		return item;
	}
	public void setItem(List<item> item) {
		this.item = item;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public Integer getSid() {
		return sid;
	}
	public void setSid(Integer sid) {
		this.sid = sid;
	}
	public option(Integer id, String option, Integer sid) {
		super();
		this.id = id;
		this.option = option;
		this.sid = sid;
	}
	public option() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
