<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <style type="text/css">
    	*{
			padding: 0px;
			margin: 0px;
			list-style: none;
		}
		#content{
			width: 1075px;
			height: 498px;
			border: 1px solid red;
		}
		p{
			margin: 15px;
		}
		p:nth-of-type(1){
			margin-left: 40px;
		}
    </style>
    <body>
    	<div id="content">
    		<p class="userName">${user.userName }</p>
    		<p>欢迎来到论文管理系统！</p>
    	</div>
 	</body>
 	<script type="text/javascript" src="../js/jquery-1.12.4.js" charset="UTF-8"></script>
	<script type="text/javascript">
		
	</script>
</html>