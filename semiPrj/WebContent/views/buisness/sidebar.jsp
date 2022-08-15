<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="<%=path %>/resource/css/SjyCss.css">
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

</style>
</head>
<body>
	
				<div id="side" class="shadow">
				<div id="sidebar" class="col">

					<div style="margin-left: 10%; font-size: 20px; color: white;">캠핑장 관리</div>
					
					<ul class="menu">
						<li>
							<a href="#">등록/조회</a>
							<ul class="submenu">
								<li><a href="<%=path%>/views/buisness/campSearchForm.jsp">캠핑장 조회</a></li>
								<li><a href="<%=path%>/views/buisness/campInsertForm.jsp">캠핑장 등록</a></li>
								<li><a href="<%=path%>/views/buisness/campZoneManage.jsp">구역 관리</a></li>
							</ul>
						</li>
						<li>
							<a href="#">예약관리</a>
							<ul class="submenu">
								
								<li><a href="<%=path %>/views/buisness/campRsvForm.jsp">예약 조회</a></li>
							</ul>
						</li>
						<li>

					</ul>

				</div>

			</div>
</body>
</html>