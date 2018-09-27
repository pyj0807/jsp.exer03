<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MVC</title>
</head>
<body>
	<div align="center">
		<h1># MVC #</h1>
		<div align="right" style="margin-right: 10%; margin-left: 10%; font-size: small;">
			<!-- 
			<b><%=session.getAttribute("id") %></b>,  로그온 |
			<a href="<%=application.getContextPath() %>/logout.do">로그오프</a>
			 -->
			 <b>${sessionScope.id }</b>,  로그온 |
			 <a href="<c:url value="/logout.do"/>">로그오프</a>
			<hr/>
			<!-- 
			<a href="<%=application.getContextPath() %>/index.do">홈</a>
			<a href="<%=application.getContextPath() %>/issue/new.do">글쓰기</a>
			<a href="<%=application.getContextPath() %>/issue/trend.do">글목록</a>
			 -->
			<a href="<c:url value="/index.do"/>">글목록</a>
			<a href="<c:url value="/issue/new.do"/>">글목록</a>
			<a href="<c:url value="/issue/trend.do"/>">글목록</a>
			
		</div>
		<div style="margin-right: 10%; margin-left: 10%;">
			<h3>가장 뜨거운 이슈!</h3>
			<form action="<c:url value="/search.do"/>">
				<input type="text" style="width:98%;" placeholder="search keyword"/>
			</form>
		</div>
		<div style="margin-right: 10%; margin-left: 10%;">
			
			<h3>최근에 등록된 새로운 이슈!</h3>
			
			<form action="<c:url value="/search.do"/>">
				<input type="text" style="width:98%;" placeholder="search keyword"/>
			</form>
		</div>
		<div style="margin-right: 10%; margin-left: 10%;" align="left">
			<hr/>
			<h3>내가 참여한 이슈들 !</h3>
			<ul>
				<li>24 시간 이내 등록된 이슈가 없습니다</li>
				
			</ul>
		</div>
	</div>
	
</body>
</html>