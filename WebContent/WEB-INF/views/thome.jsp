
<h3>
	가장 뜨거운 이슈 ! <i style="font-size: x-small;"><a
		href="${pageContext.servletContext.contextPath }/issue/trend.do">+
			더보기</a></i>
</h3>
<ul>
	<c:choose>
		<c:when test="${!empty sessionScope.gethotissue }">
			<c:forEach var="i" begin="0" end="${requestScope.gethotissue1 }"
				step="1">
				<li>작성자 : ${sessionScope.gethotissue[i].WRITER} / Cate :
					${sessionScope.gethotissue[i].CATE} / 의견수 :
					${sessionScope.gethotissue[i].R} / 내용 : <a
					href="${pageContext.servletContext.contextPath }/issue/detail.do?no=${sessionScope.gethotissue[i].NO}">${sessionScope.gethotissue[i].CONTENT}
				</a> / <b><small>${sessionScope.gethotissue[i].REGDATE}</small></b>
				</li>
			</c:forEach>
		</c:when>
		<c:otherwise>
			<li>등록된 이슈가 없습니다</li>
		</c:otherwise>
	</c:choose>
</ul>
</div>
<div style="margin-right: 10%; margin-left: 10%;" align="left">

	<h3>
		최근 등록된 새로운 이슈 ! <i style="font-size: x-small;"><a
			href="${pageContext.servletContext.contextPath }/issue/trend.do">+
				더보기</a></i>
	</h3>
	<ul>
		<c:choose>
			<c:when test="${!empty sessionScope.getdateissue }">
				<c:forEach var="i" begin="0" end="${requestScope.getdateissue1 }"
					step="1">
					<li>작성자 : ${sessionScope.getdateissue[i].WRITER} / Cate :
						${sessionScope.getdateissue[i].CATE} / 내용 : <a
						href="${pageContext.servletContext.contextPath }/issue/detail.do?no=${sessionScope.getdateissue[i].NO}">${sessionScope.getdateissue[i].CONTENT}
					</a> / <b><small>${sessionScope.gethotissue[i].REGDATE}</small></b>
					</li>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<li>등록된 이슈가 없습니다</li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>

<div style="margin-right: 10%; margin-left: 10%;" align="left">
	<hr />
	<h3>
		내가 참여한 이슈들 <i style="font-size: x-small;"><a
			href="${pageContext.servletContext.contextPath }/issue/trend.do">+
				더보기</a></i>
	</h3>
	<ul>
		<c:choose>
			<c:when test="${!empty sessionScope.getmycoment }">
				<c:forEach var="i" begin="0" end="${requestScope.getmycoment1 }"
					step="1">
					<li>작성자 : ${sessionScope.getmycoment[i].WRITER} / Cate :
						${sessionScope.getmycoment[i].CATE} / 내용 : <a
						href="${pageContext.servletContext.contextPath }/issue/detail.do?no=${sessionScope.getmycoment[i].NO}">${sessionScope.getmycoment[i].CONTENT}
					</a> / <b><small>${sessionScope.getmycoment[i].REGDATE}</small></b>
					</li>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<li>등록된 이슈가 없습니다</li>
			</c:otherwise>
		</c:choose>
	</ul>
</div>
</div>

</body>

</html>

맨위로