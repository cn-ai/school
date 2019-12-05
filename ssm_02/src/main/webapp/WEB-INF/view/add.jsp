<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增</title>
<style type="text/css">
		.div{
				border: 1px solid #719EF7;
				width: 150px;
				height: 400px;
				margin-top: 50px;
			}
			.form{
				width: 450px;
				height: 300px;
				margin: 0 auto;
				border: 1px solid #719EF7;
				padding: 20px;
			}
				#content{
			width: 1000px;
			height: 430px;
			border: 1px solid red;
		}
</style>
</head>
<body>
	<div id="content">
				<p>您现在的页面是：论文管理页面》论文发表页面</p>
				<form action="/ssm_02/user/add" class="form" method="post" enctype="multipart/form-data">
				<input type="hidden" name="createdBy" value="${user.userName }">
					<p>论文题目：<input name="title" onblur="kong()"/><span id="title">${titlemsg }</span></p>
					<p>论文类型：<select name="type">
									<option>--请选择--</option>
									<c:forEach items="${listcode }" var="code">
										<option value= ${code.cid }>${code.codeTypeName}</option>
									</c:forEach>
							</select>
					</p>
					<p>论文摘要：<textarea name="paperSummary" cols="30" rows="5" onblur="kong()"></textarea><span id="paperSummary"> </span></p>
					<p>论文内容：<input type="file" name="imgFile"/><span>${msg }</span></p>
					<p><input type="submit" value="保存"/>
						<input type="button" value="返回" onclick="b()"/>
					</p>
				</form>
			</div>			
</body>
<script type="text/javascript" src="../js/jquery-1.12.4.js" charset="UTF-8"></script>
<script type="text/javascript">
$(function(){
	kong();
})
	function kong(){
		var name=$("[name=title]").val();
		if(name==""){
			$("#title").text("题目不能为空");
			return false;
		}
		var paperSummary=$("[name=paperSummary]").val();
		if(paperSummary==""){
			$("#paperSummary").text("论文摘要不能为空");
			return false;
		}
		
	}
</script>
</html>