<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
		<table border="1" width="500">
		<thead>
			<tr><th colspan="5" rowspan="1">帖子列表</th></tr>
		</thead>
		<thead>
			<tr>
				<th colspan="5" rowspan="1">帖子标题：<input type="text" name="title"><input type="button" onclick="bylike()" value="搜索"></th>
			</tr>
		</thead>
		<thead>
			<tr>
				<th>标题</th>
				<th>内容摘要</th>
				<th>作者</th>
				<th>发布时间</th>
				<th>操作</th>
			</tr>
		</thead>
		<tbody id="personList">
		</tbody>
		<tfoot id="tfoot">
		
			<tr>
			<th>第<span id="curr"></span>/<span id="total"></span></th>
				<th colspan="5"><a id="firstPage" href="javascript:void(0)">首页</a>
					&nbsp;&nbsp; <a id="prePage" href="javascript:void(0)">上一页</a>
					&nbsp;&nbsp; <a id="nextPage" href="javascript:void(0)">下一页</a>
					&nbsp;&nbsp; <a id="lastPage" href="javascript:void(0)">末页</a></th>
			</tr>
		</tfoot>
	</table>
</body>

<script type="text/javascript" src="/myBatis_exam/js/jquery-1.12.4.js"></script>
<script type="text/javascript">
var pi;
//分页方法
function fnGotoPage(page, size,title) {
	$.getJSON("/myBatis_exam/c/tion", {
		"method":"queryAll",
		p : page,
		s : size,
		title:title
	}, function(pageInfo) {
		pi = pageInfo;
		$("#tfoot").html("");
		$("#personList").html("");
		var tr="<tr>"+
				"<th>第<span >"+pageInfo.pageNum+"</span>/<spa>"+pageInfo.pages+"</span></th>"+
			"<th colspan='5'><a id='firstPage' href='javascript:void(0)' onclick='fnGotoPage(1,"+pageInfo.pageSize+")'>首页</a>"+
			"&nbsp;&nbsp; <a id='prePage' href='javascript:void(0)' onclick='fnGotoPage("+pageInfo.prePage+","+pageInfo.pageSize+")'>上一页</a>"+
			"&nbsp;&nbsp; <a id='nextPage' href='javascript:void(0)' onclick='fnGotoPage("+pageInfo.nextPage+","+pageInfo.pageSize+");'>下一页</a>"+
			"&nbsp;&nbsp; <a id='lastPage' href='javascript:void(0)' onclick='fnGotoPage("+pageInfo.lastPage+","+pageInfo.pageSize+");'>末页</a></th>"+
		"</tr>";
		$("#tfoot").append(tr);
		$.each(pageInfo.list, function(i, obj) {
			var $row = $("<tr><td>" + obj.title + "</td><td>" + obj.summary
					+ "</td><td>" + obj.author + "</td><td>" + obj.createdate
					+ "</td><td><a href='../c/tion?method=querydetail&id="+obj.id+"'>回复帖子</a><a href=''>删除帖子</a></td></tr>");
			$("#personList").append($row);
		});

	});
}

fnGotoPage(1,2,"");//初始化
function bylike(){
	title=$("[name=title]").val();
	fnGotoPage(1,2,title);//初始化
}
</script>
</html>