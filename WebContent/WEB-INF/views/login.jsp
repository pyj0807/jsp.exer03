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
		<h1>〔로그인〕</h1>
		<%if(request.getAttribute("err") != null) { %>
		<p id="msg"
			style="font-size: small; color: red;">
			아이디나 비밀번호가 일치하지 않습니다. <b>［x］</b></p>
		<script>
			document.getElementById("msg").onclick = function() {
				this.style.display = "none";
			};
		</script>
		<%} %>
		<div style="margin-left: 10%; margin-right: 10%; text-align: left;">
		<form action="<%=application.getContextPath() %>/session.do" method="post" autocomplete="off" >
			<p>
				<b>계정 아이디</b><br/>
				<input type="text" name="id" placeholder="account id" style="width: 99%;"/>
			</p>
			<p>
				<b>계정 비밀번호</b><br/>	
				<input type="password" name="pass" placeholder="account pass" style="width: 99%;"/>
			</p>
			<p>
				<button type="submit" style="width: 100%;">로그인</button>
			</p>
		</form>
		</div>
	</div>
</body>
</html>