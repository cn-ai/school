<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	response.setHeader("Pragma", "No-cache");
	response.setHeader("Cache-Control", "no-cache");
	response.setDateHeader("Expires", 0);
	response.setContentType("text/html;charset=UTF-8");
%> 

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title></title>
<link type="text/css" rel="stylesheet" href="css/style.css" />
</head>
<body>
<div id="message" class="box">
	<h2>提示信息</h2>
	<div class="content">
		<p>恭喜：投票成功！<a href="javascript:void(0)" onclick="fh()" />返回查看投票结果&gt;&gt;</a></p>
	</div>
</div>
<div id="footer" class="wrap">
	北大青鸟 &copy; 版权所有
</div>
</body>
<script type="text/javascript" src="js/jquery-1.8.3.js"></script></head>
<script type="text/javascript">
	function fh() {
		window.location = "view.jsp";
	}
</script>
</html>
