package com.accp.mybatis_house.action;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.Base64InputStream;
import org.apache.commons.codec.binary.Base64OutputStream;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.fileupload.DiskFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.accp.mybatis_house.biz.UserBiz;
import com.accp.mybatis_house.dao.IUserDao;
import com.accp.mybatis_house.pojo.Area;
import com.accp.mybatis_house.pojo.District;
import com.accp.mybatis_house.pojo.Img;
import com.accp.mybatis_house.pojo.Info;
import com.accp.mybatis_house.pojo.User;
import com.accp.mybatis_house.pojo.Type;
import com.accp.mybatis_house.util.SqlSessionUtil;
import com.accp.mybatis_house.util.sendsms;
import com.accp.mybatis_house.vo.vo;
import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageInfo;

/**
 * Servlet implementation class UserAction
 */
public class UserAction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       UserBiz ubiz=com.accp.mybatis_house.util.CgLibTransProxyUtil.getTransProxyObject(UserBiz.class);
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method=req.getParameter("method");
		Class clazz=this.getClass();
		try {
			Method m=clazz.getDeclaredMethod(method, HttpServletRequest.class,HttpServletResponse.class);
			m.invoke(this, req,resp);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}

	public void dl(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		HttpSession session = req.getSession();
		PrintWriter out=resp.getWriter();
		String uname=req.getParameter("uname");
		String upwd=req.getParameter("upwd");
		User u=ubiz.Login(uname, DigestUtils.md5Hex(upwd));
		if(u!=null) {
			
			out.write("yes");
			session.setAttribute("user", u);
		}else {
			out.write("no");
		}
	}
	
	public void zc(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		PrintWriter out=resp.getWriter();
		String uname=req.getParameter("username");
		String upwd=req.getParameter("password");
		String utel=req.getParameter("phoneNum");
		User u=new User();
		u.setUaccount(uname);
		u.setUpwd(DigestUtils.md5Hex(upwd));
		u.setUtel(utel);	
		u.setUname("匿名名称");
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");		
		u.setAddtime(sdf.format(new Date()));
		int count=ubiz.zc(u);
		if(count>0) {
			req.getRequestDispatcher("../jsp/denglu.jsp?a=2").forward(req, resp);
		}
	}
	
	public void code(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		int mobile_code=(int) ((Math.random()*9+1)*100000);
		
		sendsms send=new sendsms();
		String smsMob=req.getParameter("tel");
		boolean bol=send.send(smsMob, mobile_code);
		if(bol){
			resp.getWriter().print(bol);
		}
	}
	//查询地区
	public void querydistrict(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<District> list=ubiz.querydistrict();
		req.setAttribute("list", list);
		List<Type> tlist=ubiz.querytype();
		req.setAttribute("tlist", tlist);
		List<Area> alist=ubiz.queryarea();
		req.setAttribute("alist", alist);
		req.getRequestDispatcher("../jsp/home.jsp").forward(req, resp);
	}
	//查询房屋信息
	public void queryHouseVo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		String jsonObj=req.getParameter("jsonObj");
		vo v=JSON.parseObject(jsonObj,vo.class);
		System.out.println("status"+v.getStatus());
		String search=req.getParameter("search");
		String priceBegin=req.getParameter("priceBegin");
		String priceEnd=req.getParameter("priceEnd");
		String pageNum=req.getParameter("pageNum");
		int cpage = 1;
		if (pageNum != null) {
			cpage = Integer.parseInt(pageNum);
		}
		int psize =2;
		PageInfo<vo> info= ubiz.queryVo(v, search, priceBegin, priceEnd, cpage, psize);
		String json=JSON.toJSONStringWithDateFormat(info, "yyyy-MM-dd");
		out.println(json);
	}
//查询房屋详情
	public void loadInfo(HttpServletRequest req, HttpServletResponse resp) throws Exception {
		String hid=req.getParameter("hid");
		vo v=ubiz.loadHouse(hid);
		req.setAttribute("info", v);
		req.getRequestDispatcher("../jsp/detail.jsp").forward(req, resp);
	}
//查询新增中的户型和地区
	public void queryAdd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<District> list=ubiz.querydistrict();
		req.setAttribute("list", list);
		List<Type> tlist=ubiz.querytype();
		req.setAttribute("tlist", tlist);
		req.getRequestDispatcher("../jsp/fabu.jsp").forward(req, resp);
	}
//新增房屋信息
	public void addInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		String strobj=req.getParameter("jsonobj");
		Info info=JSON.parseObject(strobj,Info.class);
		Integer id = ubiz.queryInfoByAtuoId()+1;
		info.setHid(info.getHid()+id);
		ubiz.addInfo(info);	
		out.print("yes");
	}
//上传图片
	public void addImg(HttpServletRequest req, HttpServletResponse resp) {

		String url=req.getRealPath("/img");
		//判断提交过来的表单方式
		boolean bool=ServletFileUpload.isMultipartContent(req);
		if(bool){
			FileItemFactory factory=new DiskFileItemFactory();
			ServletFileUpload upload=new ServletFileUpload(factory);
			try {
				List<FileItem> list=upload.parseRequest(req);											
						
					for(FileItem f:list){
							if(f.isFormField()){
								continue;
							}
							
							String fileName=f.getName();
							String uuid=UUID.randomUUID().toString();
							//获取后缀
							String hz=fileName.substring(fileName.lastIndexOf("."));
							File fi=new File(url+"/"+uuid+hz);	
						
							Img img=new Img();
							img.setAddress(uuid+hz);
							String hid=ubiz.queryInfoById();
							img.setManageid(hid);
							ubiz.addImg(img);
							f.write(fi);
				}
					
					
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
//加载首页图片
	public void loadImg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();	
		String hid=req.getParameter("hid");
		System.out.println("hid"+hid);
		Img im=ubiz.loadImg(hid);
		out.write(JSON.toJSONString(im));
		out.flush();
		out.close();
	}
//修改状态和房屋信息
	public void updateInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();	
		String jsonobj=req.getParameter("jsonobj");
		Info info=JSON.parseObject(jsonobj,Info.class);
		int count=ubiz.updateInfo(info);
		out.print(count);
	}
//加载单个房屋类型
	public void loadInfo2(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();	
		String hid=req.getParameter("hid");
		Info info=ubiz.loadInfo(hid);
		String json=JSON.toJSONString(info);
		out.write(json);
		out.flush();
		out.close();
	}
//删除
	public void delInfo(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();	
		String hid=req.getParameter("hid");
		int count=ubiz.delInfo(hid);
		out.print(count);
	}
//退出会话
	public void outSession(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		HttpSession session = req.getSession();
		session.invalidate();
		out.write("yes");
		out.flush();
		out.close();
	}
//查询所有图片
	public void listImg(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		PrintWriter out=resp.getWriter();
		String hid =req.getParameter("hid");
		List<Img> list=ubiz.listImg(hid);
		String json=JSON.toJSONString(list);
		out.write(json);
		out.flush();
		out.close();
	}
}
