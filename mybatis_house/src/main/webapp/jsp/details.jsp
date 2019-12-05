<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta charset="UTF-8">
		<title>详情</title>
		<link href="../css/style.css" rel="stylesheet" />
		<style type="text/css">
			#position{
			width: 500px;
			height:50px;
			margin-top:100px;
			}
		#position p{
		margin-left:-230px;
		}
		</style>
	</head>
<BODY>
<%@include file="first.jsp"%>
<!--
	作者：offline
	时间：2018-10-31
	描述：logo
-->
<div class="search">
	<div id="logo"><img src="../img/logo.gif"></div>
	<div class="ss">
	<input type="text" placeholder="请输入搜索关键字" name="name">
		<input type="button" name="button">		
	</div>
</div>

<DIV id=position class=wrap><p>当前位置：青鸟租房网 - 房屋详情</p></DIV>
<DIV id=view class="main wrap">
<DIV class=intro>
<DIV class=lefter>
<H1 >${info.title }</H1>
<DIV class=subinfo>${info.fabutime }</DIV>
<DIV class=houseinfo>

<P>价        格：<span>${info.price }元/月</span></P>
<P>户　　型：<SPAN>${info.tname }</SPAN></P>
<P>面　　积：<SPAN>${info.areanum }m<SUP>2</SUP></SPAN></P>
<P>位　　置：<SPAN>${info.name}——${info.addressDetail }</SPAN></P>
<P>联系方式：<SPAN>${info.phone }</SPAN></P></DIV></DIV>
<DIV class=side>
<P><A class=bold href="http://localhost:8080/House-2/#">北京青鸟房地产经纪公司</A></P>
<P>资质证书：有</P>
<P>内部编号:1000</P>
<P>联 系 人：</P>
<P>联系电话：<SPAN></SPAN></P>
<P>手机号码：<SPAN>暂无</SPAN></P></DIV>
<DIV class=clear></DIV>
<DIV class=introduction>
<H2><SPAN><STRONG>房源详细信息</STRONG></SPAN></H2>
<DIV class=content>
<P>${info.detail }</P></DIV></DIV></DIV></DIV>
<DIV id=footer class=wrap>
<DL>
  <DT>青鸟租房 © 2010 北大青鸟 京ICP证1000001号</DT>
  <DD>关于我们 · 联系方式 · 意见反馈 · 帮助中心</DD></DL></DIV>
			
</BODY>
  <script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
  <script type="text/javascript">
  	$("[name=button]").click(function(){
  		location.href="../c/user?method=querydistrict";
  	})
  </script>
</HTML>
