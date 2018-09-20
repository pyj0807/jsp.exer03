<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@page import="models.IssueDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

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
		<div align="right"
			style="margin-right: 10%; margin-left: 10%; font-size: small;">
			<b><%=session.getAttribute("id") %> |  로그온 | </b>  
				<a href="<%=application.getContextPath()%>/logout.do">로그오프</a>
			<hr/>
			<a href="<%=application.getContextPath() %>/issue/new.do">글쓰기</a>
			<a href="<%=application.getContextPath() %>/issue/trend.do">글목록</a>
		</div>
		<h2>【토론목록】</h2>
		<%
			IssueDao idao = new IssueDao();
			List<Map> list = (List)request.getAttribute("list");
			SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm");
		%>	
		<div style="margin-right: 10%; margin-left: 10%; text-align: left">
			<div style="margin-bottom: 15px;" 
					onmouseenter="highlight(this, true);" onmouseleave="highlight(this, false)">
					<%
						for(int i = 0; i<list.size(); i++){
							Map m = list.get(i);
						
					%>
					
				<p style="text-align: right; color: gray; font-size: small;" >
					<%=m.get("CATE") %>/ <%=m.get("CONTENT") %> / <%=m.get("WRITER")%> / <%=sdf.format(m.get("REGDATE")) %> 				
					
					
				</p>
				<p>
					<a href="<%=application.getContextPath()%>/issue/detail.do?no=<%=m.get("NO")%>"><b>ISSUE.</b> <%=m.get("REP") %></a>
				</p>
				<%}%>
			</div>
			<!-- 
			<div style="margin-bottom: 15px;"
				onmouseenter="highlight(this, true);" onmouseleave="highlight(this, false)">
				<p style="text-align: right; color: gray; font-size: small;" >
					정치 / 111 의견 / 2018.09.16   
				</p>
				<p>
					<a href=""><b>ISSUE.</b> 난 진보일까? 보수일까??</a>
				</p>
			</div>
			 -->
		</div>
		<script>
			var highlight = function(t, e){
				if(e)
					t.style.background ="yellow";
				else
					t.style.background ="white";
			}
		
		
		</script>
		<input >
	</div>
</body>
</html>