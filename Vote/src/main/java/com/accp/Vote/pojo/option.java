package com.accp.Vote.pojo;

import java.util.ArrayList;
import java.util.List;
/**
 * 
* @ClassName: option 
* @Description: ͶƱѡ�������Ϣ������
* @author ����
* @date 2018��11��14�� ����3:14:34 
*
 */
public class option {
	private Integer id;//ͶƱ���
	private String option;//ͶƱѡ��
	private Integer sid;//ͶƱ���ݱ��
	
	private List<item> item = new ArrayList<item>();//ѡ��ȡֵ
	
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
