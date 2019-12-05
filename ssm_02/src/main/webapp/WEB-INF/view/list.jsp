<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

#content {
	width: 1075px;
	height: 498px;
	border: 1px solid red;
	margin: 0px auto;
}
</style>
<body>
	<div id="content">
		<p>你所在的位置是:论文管理页面</p>
		<form action="/ssm_02/user/query">
					<p>论文主题：<input name="title" value="${title }"/>
						论文类型：<select name="codeTypeName" >
									<c:forEach items="${listcode }" var="code">	
										<option value="${code.codeTypeName }" ${code.codeTypeName ==code?"selected":"" } >${code.codeTypeName}</option>
										
									</c:forEach>
								</select>
						<input type="submit" value="查询"/>
						<a href="/ssm_02/user/toadd" class="3">添加论文</a>
					</p>					
				</form>

		<table border="1" cellspacing="" cellpadding="">
			<thead>
				<tr>
					<th>论文主题</th>
					<th>作者</th>
					<th>论文类型</th>
					<th>发表时间</th>
					<th>修改时间</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${info.list }" var="l">
						<tr>
							<td>${l.title }</td>
							<td>${l.createdBy }</td>
							<td>${l.codeTypeName }</td>
							<td>${l.creationDate }</td>
							<td>${l.modifyDate }</td>
							<td><a href="/ssm_02/user/toUpdate?pid=${l.pid }">修改</a>&nbsp;<a href="/ssm_02/user/del?pid=${l.pid }">删除</a></td>
						</tr>
				</c:forEach>
			</tbody>
			<tfoot>
				<tr>
				<th colspan="6">
				<span>共${info.total }条记录&nbsp;&nbsp;${info.pageNum }/${info.pages }页</span>
				<a
					href="/ssm_02/user/query?p=1&s=${info.pageSize}&title=${title}&CodeTypeName=${code}">首页</a>
					&nbsp;&nbsp; <c:if test="${info.isHasPreviousPage()}">
						<a
							href="/ssm_02/user/query?p=${info.prePage}&s=${info.pageSize}&title=${title}&CodeTypeName=${code}">上一页</a>
					</c:if> &nbsp;&nbsp; <c:if test="${info.isHasNextPage()}">
						<a
							href="/ssm_02/user/query?p=${info.nextPage}&s=${info.pageSize}&title=${title}&CodeTypeName=${code}">下一页</a>
					</c:if> &nbsp;&nbsp; <a
					href="/ssm_02/user/query?p=${info.lastPage}&s=${info.pageSize}&title=${title}&CodeTypeName=${Code}">末页</a>
				</th>
			</tr> 
			</tfoot>
		</table>

		<form action="" method="post">
			跳转置<input type="text" name="p" id="" value="" />页 <input
				type="button" value="go" name="sb"/>
		</form>
	</div>
</body>
<script type="text/javascript" src="../js/jquery-1.12.4.js" charset="UTF-8"></script>
<script type="text/javascript">

</script>
</html>