<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String p = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="../../resource/css/SjyCss.css">
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
				<div id="side" class="container">
				<div id="sidebar" class="col">

					<div style="margin-left: 10%; font-size: 20px; color: white;">캠핑장 관리</div>
					<ul class="menu">
						<li>
							<a href="#">등록/조회</a>
							<ul class="submenu">
								<li><a href="<%=p%>/views/buisness/campInsertForm.jsp">캠핑장 등록</a></li>
								<li><a href="<%=p%>/views/buisness/campSerchForm.jsp">캠핑장 조회</a></li>
							</ul>
						</li>
						<li>
							<a href="#">예약관리</a>
							<ul class="submenu">
								<!-- <li><a href="<%=p %>/views/buisness/campRsvForm.jsp">예약 승인</a></li> -->
								<li><a href="<%=p %>/views/buisness/campRsvForm.jsp">예약 조회</a></li>
							</ul>
						</li>
						<li>

					</ul>

				</div>

			</div>
</body>
</html>