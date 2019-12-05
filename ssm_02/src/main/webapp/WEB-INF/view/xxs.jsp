<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>JSP Page</title>
</head>
<style type="text/css">
* {
	padding: 0px;
	margin: 0px;
	list-style: none;
}

#content>div {
	display: inline-block;
}

#content {
	width: 1300px;
	border: 1px solid red;
	margin: 0px auto;
}

.left {
	position: absolute;
	width: 200px;
	top: 90px;
	border: 1px solid beige;
}

.rigth>iframe {
	width: 1080px;
	height: 500px;
	margin-left: 220px;
	border: none;
}

a {
	text-decoration: underline;
	color: blue;
}

.left>ul li {
	margin: 8px 0px 8px 70px;
}

.left>ul li:nth-of-type(4) {
	/*margin-bottom: 400px;*/
	
}

h3 {
	margin: 10px 60px;
}

#hy {
	margin: 5px;
	margin-left: 60px;
}
</style>

<body>
	<div id="content">
		<h1 style="text-align: center; margin: 5px;">论文管理系统</h1>
		<p id="hy">
			欢迎您！<span class="userName">${user.userName}</span><a
				class="tuichu">注销</a>
		</p>
		<div class="left">
			<h3>功能列表</h3>
			<ul>
				<li><a url="">用戶管理</a></li>
				<li><a url="query">论坛管理</a></li>
				<li><a url="">公共代码</a></li>
				<li><a url="">退出系统</a></li>
			</ul>
		</div>
		<div class="rigth">
			<iframe src="/ssm_02/user/touserName"> </iframe>
		</div>
	</div>
</body>
<script type="text/javascript" src="../js/jquery-1.12.4.js"></script>
<script type="text/javascript">
	$("a").click(function() {
		var url = $(this).attr("url");
		$(".rigth iframe").attr("src", url);
	})
</script>
</html>