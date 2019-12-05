package com.accp.airinInfo.test;

import java.util.Scanner;

import org.junit.Test;

import com.accp.airinInfo.biz.AirinInfobiz;
import com.accp.airinInfo.pojo.AirinInfo;
import com.github.pagehelper.PageInfo;

public class TestAirinInfo {
	Scanner input = new Scanner(System.in);
	AirinInfobiz biz=new AirinInfobiz();
	@Test
	public void TestMenu() throws Exception {
		do {
		System.out.println("-----------欢迎使用航班信息管理系统------------------------");
		System.out.println(
				"1)列出所有航班\r\n" + "2)按起飞时间查询\r\n" + "3)按目的地查询\r\n" + "4)删除航班\r\n" + "5)更新航班\r\n" + "6)退出系统\r\n" + "");
		System.out.println("请选择：");
		int option = input.nextInt();
		switch (option) {
		case 1:
			queryByPage();
			break;
		case 2:
			queryByDate();
			break;
		case 3:
			queryByDestination();
			break;
		case 4:
			daleteAirinInfo();
			break;
		case 5:
			updateAirinInfo();
			break;
		case 6:
			System.out.println("谢谢使用,再见");
			System.exit(0);
			break;

		default:
			System.out.println("不好意思，没有此功能");
			break;
		}
		} while (true);
	}
	
	public void queryByPage() {
		PageInfo<AirinInfo> info=biz.queryAll(1, 7);
		System.out.println("下一页："+info.getNextPage());
		System.out.println("上一页:"+info.getPrePage());
		for (AirinInfo ai : info.getList()) {
			System.out.println("航班编号:"+ai.getId()+"\t航班号:"+ai.getFlight_number()+"\t目的地:"+ai.getDestination()+"\t起飞日期:"+ai.getFlight_date());
		}	
	}
	
	public void queryByDate() {
		System.out.println("请输入要查询的起飞日期(格式为yyyy-MM-dd):");
		String date =input.next();
		
		PageInfo<AirinInfo> info=biz.queryByTerm(date, null, 1, 4);
		for (AirinInfo ai : info.getList()) {
			System.out.println("航班编号:"+ai.getId()+"\t航班号:"+ai.getFlight_number()+"\t目的地:"+ai.getDestination()+"\t起飞日期:"+ai.getFlight_date());
		}	
	}
	
	public void queryByDestination() {
		System.out.println("请输入目的地:");
		String destination=input.next();
		PageInfo<AirinInfo> info=biz.queryByTerm(null, destination, 1, 3);
		for (AirinInfo ai : info.getList()) {
			System.out.println("航班编号:"+ai.getId()+"\t航班号:"+ai.getFlight_number()+"\t目的地:"+ai.getDestination()+"\t起飞日期:"+ai.getFlight_date());
		}
	}
	public void daleteAirinInfo() {
		System.out.println("请输入要删除的航班编号:");
		int id=input.nextInt();
		int count=biz.daleteAirinInfo(id);
		if(count>1) {
			System.out.println("删除成功");
		}
	}
	
	public void updateAirinInfo() {
		System.out.println("请输入要更新的航班编号:");
		int id=input.nextInt();
		System.out.println("请输入要修改的航班号:");
		int hbh=input.nextInt();
		System.out.println("请输入要更新的目的地:");
		String address=input.next();
		System.out.println("请输入要更新的起飞日期：");
		String time=input.next();
		AirinInfo info=new AirinInfo(id,hbh, address, time);
		int count=biz.updateAirinInfo(info);
		if(count>0) {
			System.out.println("更新成功");
		}
	}
}
