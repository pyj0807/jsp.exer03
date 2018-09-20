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
</head>
<body>
	<div align="center">
		<h1># MVC</h1>
		<div align="right"
			style="margin-right: 10%; margin-left: 10%; font-size: small;">
			<b><%=session.getAttribute("id") %></b>, 로그온 | <a
				href="<%=application.getContextPath()%>/logout.do">로그오프</a>
			<hr />
			<a href="<%=application.getContextPath() %>/issue/new.do">글쓰기</a>
			<a href="<%=application.getContextPath() %>/issue/trend.do">글목록</a>
		</div>
		<h2>【토론배틀】</h2>
		<small style="font-style: italic;">찬성이냐, 반대냐 그것이 문제로다!</small>
		<%
			Map is = (Map)request.getAttribute("issue");
		%>
		<div style="margin-right: 10%; margin-left: 10%; text-align: left;">
			<%
				String str =(String)is.get("CONTENT");
				if(str.indexOf("\n") != -1) {
			%>
			<h3>#.<%=str.substring(0, str.indexOf("\n")) %></h3>
			<%	}else {%>
			<h3>#.<%=str %></h3>	
			<%	} %>
			<p>
				<%=str.replace("\n", "<br/>") %>
			</p>
		</div>
		<div style="margin-right: 10%; margin-left: 10%; text-align: left; margin-top: 	55px; font-size: small;">
			<p style="color: blue">
				<b>YES</b> <%=is.get("AGREE") %>. <span>221</span> 명 
			</p>
			<p style="color: red">
				<b>NO</b> <%=is.get("DISAGREE") %>. <span>721</span> 명 
			</p>
		</div>
		
		<div style="margin-right: 10%; margin-left: 10%; text-align: left; margin-top: 	55px;">
			<input type="hidden" id="ino" value="<%=is.get("NO") %>"/>
			<p>
			<b>〔의견남기기〕</b><br/>
			</p>
			<p>
			<select id="choice" name="choice">
				<option value="1">YES</option>
				<option value="0">NO</option>
			</select>
			<input type="text" style="width: 80%" id="ment" name="ment" onchange="opinionAjax();"/>
			</p>
			<script>
				
				var ino = <%=is.get("NO")%>;
				var opinionAjax = function() {
					if(document.getElementById("ment").value.trim().length >0) {
						var xhr = new XMLHttpRequest();
						xhr.open("post","<%=application.getContextPath()%>/issue/opinion.do", true);
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
						var param = {"ino":ino,
							"ment":document.getElementById("ment").value, 
							"choice" : document.getElementById("choice").value
							};
						var param =JSON.stringify(param);
						console.log(param);
						
						xhr.send(param);
					}
				};
			</script>
			<small id="ajaxresult"></small>
		</div>
		
		<div style="margin-right: 10%; margin-left: 10%; text-align: left; margin-top: 	35px;">
			<p>
				<b>〔전체의견 / <span id="tot"><%=((List)request.getAttribute("opinions")).size() %></span>〕</b><br/>
			
			</p>
			<%
				List<Map> ops = (List)request.getAttribute("opinions");
			%>
			<ul style="list-style: none; font-size: smaller;" id="ments">
				<%for(int i=0; i<ops.size(); i++){ 
						Map e = ops.get(i);
					%>
				<li>
					<%if(((Number)e.get("CHOICE")).intValue() == 1) {%>
						<b style="color:blue">YES</b>
					<%}else { %>
						<b style="color:red">NO</b>
					<%} %>
					<%=e.get("MENT") %>
				</li>
				<%} %>
			</ul>
			<script>
				
				var latestAjax = function () {
					var xhr = new XMLHttpRequest();
					xhr.open("get","<%=application.getContextPath()%>/issue/opinion.do?ino=<%=is.get("NO")%>", true);
					xhr.onreadystatechange =function(){
						if(this.readyState==4){
							var obj = JSON.parse(this.responseText);
							var html = "";
							// 받아온 객체 배열을 가지고 원래 찍어두던 형태의 HTML을 만들어서
							// 위영역에 innerHTML로 세팅
							for(var i = 0; i<obj.length;i++){
								/* 
								 html +="<li>"
								 html +=obj[i].CHOICE == 1? ("<b style=\"color:blue\">YES </b>" +obj[i].MENT) : ("<b style=\"color:red\">NO </b>" +obj[i].MENT ) ;
								 html +="</li>"; 
								  */
								  
								 if(obj[i].CHOICE ==1){
									 html += "<li><b style=\"color:blue\">YES </b>"; 
								 }else{
									 html += "<li><b style=\"color:red\">NO </b>";
								 }	
								  	html += obj[i].MENT+"</li>";
								 
							}
							console.log(html);
							document.getElementById("ments").innerHTML = html;					
							document.getElementById("tot").innerHTML = "";
							console.log(html);
						}
				}						
					xhr.send();
			};
			var time = 3;
			window.setInterval( function(){
				time --;
				if(time==0){
					latestAjax();
					time=3;
				}
			},1000);	
			// whindow.setInterval(latestAjax, 10000) 10초에 한번씩 호출하는 것
			//	
			
			</script>
			
			
		</div>
	</div>
</body>
</html>