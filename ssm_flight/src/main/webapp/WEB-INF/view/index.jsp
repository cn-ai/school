<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
       <h1>查询结果</h1>
          <h3>${msg }</h3>
   <c:forEach items="${list }" var="l">  
   <c:if test="${l.flightid == flightid}">
      	<p>${flightid }次航班信息</p>
       		<table border="1" > 
       			<thead>
       				<tr>
       					<td>航空公司</td>
       					<td>出发机场</td>
       					<td>到达机场</td>
       					<td>出发时间</td>
       					<td>到达时间</td>
       					<td>机型</td>      					
       				</tr>
       			</thead>
       			<tbody>  		
       					<tr>
       						<td>${l.company }</td>
       						<td>${l.leaveAirport }</td>
       						<td>${l.arriveAirport }</td>
       						<td>${l.leavetime }</td>
       						<td>${l.arrivetime }</td>
       						<td>${l.airplane }</td>  
       					</tr>
       					
       			</tbody>
       		</table>
   </c:if> 
    </c:forEach>
   <a href="/ssm_flight/flight/to">返回</a>  
    </body>
</html>
