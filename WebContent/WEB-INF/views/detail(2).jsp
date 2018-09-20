<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>MVC</title>
<link rel="stylesheet"
	href="<%=application.getContextPath()%>/css/style.css" />
</head>
<body>
	<div align="center">
		<h1># MVC</h1>
		<div align="right"
			style="margin-right: 10%; margin-left: 10%; font-size: small;">
			<b>blahblah</b>, 로그온 | <a
				href="<%=application.getContextPath()%>/logout.do">로그오프</a>
			<hr />
			<a href="<%=application.getContextPath() %>/issue/new.do">글쓰기</a>
			<a href="<%=application.getContextPath() %>/issue/trend.do">글목록</a>
		</div>
		<h2>【토론배틀】</h2>
		<small style="font-style: italic;">찬성이냐, 반대냐 그것이 문제로다!</small>
		<%
			Map is = (Map) request.getAttribute("issue");
		%>
		<div style="margin-right: 10%; margin-left: 10%; text-align: left;">
			<%
				String str = (String) is.get("CONTENT");
				if (str.indexOf("\n") != -1) {
			%>
			<h3>
				#.<%=str.substring(0, str.indexOf("\n"))%></h3>
			<%
				} else {
			%>
			<h3>
				#.<%=str%></h3>
			<%
				}
			%>
			<p>
				<%=str.replace("\n", "<br/>")%>
			</p>
		</div>
		<div
			style="margin-right: 10%; margin-left: 10%; text-align: left; margin-top: 55px; font-size: small;">
			<p style="color: blue">
				<b>YES</b>
				<%=is.get("AGREE")%>. <span>221</span> 명
			</p>
			<p style="color: red">
				<b>NO</b>
				<%=is.get("DISAGREE")%>. <span>721</span> 명
			</p>
		</div>

		<div
			style="margin-right: 10%; margin-left: 10%; text-align: left; margin-top: 55px;">
			<p>
				<b>〔의견남기기〕</b><br />
			</p>
			<p>
				<select id="choice" name="choice">
					<option value="1">YES</option>
					<option value="0">NO</option>
				</select> <input type="text" style="width: 80%" id="ment" name="ment"
					onchange="opinionAjax();" />
			</p>
			<script>
			var ino = <%=is.get("NO")%>;
			var opinionAjax = function() {
				if(document.getElementById("ment").value.trim().length >0) {
					var xhr = new XMLHttpRequest();
					var param = "choice="+document.getElementById("choice").value;
						param += "&ment="+document.getElementById("ment").value;
						param += "&ino="+ino;
					xhr.open("post","<%=application.getContextPath()%>/issue/opinion.do", true);
					xhr.setRequestHeader("Content-type","application/x-www-form-urlencoded");
					xhr.onreadystatechange =function(){
						if(this.readyState==4) {
							var obj = JSON.parse(this.responseText);
							if(obj.rst) {
								// location.reload();
								document.getElementById("ajaxresult").innerHTML = "의견이 등록되었습니다."
								document.getElementById("ajaxresult").innerHTML += "즉시 변경을 원하면 새로고침을 눌러주세요.";
								document.getElementById("ment").value="";
								document.getElementById("choice").value=1;
							} else {
								document.getElementById("ajaxresult").innerHTML = "의견 등록과정에 장애가 발생하였습니다.<br/>"
							}
						}
					}
					xhr.send(param);
				}
			};
			</script>
		</div>

		<div
			style="margin-right: 10%; margin-left: 10%; text-align: left; margin-top: 35px;">
			<p>
				<b>〔전체의견 / <span><%=((List) request.getAttribute("opinions")).size()%></span>〕</b>
				<br />
			</p>
			<%
				List<Map> ops = (List) request.getAttribute("opinions");
			%>
			<ul style="list-style: none; font-size: smaller;">
				<%
					for (int i = 0; i < ops.size(); i++) {
						Map e = ops.get(i);
				%>
				<li>
					<%
						if (((Number) e.get("CHOICE")).intValue() == 1) {
					%> <b
					style="color: blue">YES</b> <%
 	} else {
 %> <b style="color: red">NO</b>
					<%
						}
					%> <%=e.get("MENT")%>
				</li>
				<%
					}
				%>
			</ul>
		</div>
	</div>
</body>
</html>