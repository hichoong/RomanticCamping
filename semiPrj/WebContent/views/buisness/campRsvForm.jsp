<%@page import="java.sql.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sjy.buisness.reservation.vo.ReservationVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
//오늘 날짜 구하기

SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
SimpleDateFormat time = new SimpleDateFormat("HH:mm");


List<ReservationVo> rvList = (ArrayList<ReservationVo>)request.getAttribute("rvList");
for(ReservationVo vo : rvList){
	System.out.println("no::"+vo.getNo());
	System.out.println("name::"+vo.getName());
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>예약조회</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/SjyCss.css">
<style>
/* 	td>a{
	display: block;
} */
</style>
</head>
<body>
	<%-- <%@ include file="/views/buisness/bsHeader.jsp" %> --%>
	<%@ include file="/views/common/header.jsp" %>
	<main class="navbar navbar-expand-sm container">
	<%@ include file="/views/buisness/sidebar.jsp" %>
			
			<div id="content" >
				

					<h2>예약 조회</h2>
						<hr>
                        
						<table class="table" id="table-main">
							<thead class="table-light">
								<tr>
									<th scope="col">#</th>
									<th scope="col">예약자</th>
									<th scope="col">장소</th>
									<th scope="col">기간</th>
								</tr>
							</thead>
							<tbody>
								<!-- 예약상세보기 페이지를 요청하는 서블릿으로 이동 -->
								<%for(ReservationVo vo : rvList){ %>
								<tr  >
									<input type="hidden" value="예약자의 회원번호">
									<th scope="row"><%=vo.getNo() %></th>
									
									<td><%=vo.getName() %></td>
									<td><%=vo.getCampCode()%></td>
									<td><%=vo.getCheckin() %>~<%=vo.getCheckout() %></td>
								</tr>
								<%} %>
							</tbody>
						</table>



						<nav aria-label="Page navigation example">
							<ul class="pagination justify-content-center">
								<li class="page-item disabled">
									<a class="page-link"><</a>
								</li>
								<li class="page-item active" aria-current="page">
									<a class="page-link" href="#">1</a>
								</li>
								<li class="page-item"><a class="page-link" href="#">2</a></li>
								<li class="page-item"><a class="page-link" href="#">3</a></li>
								<li class="page-item">
									<a class="page-link" href="#">></a>
								</li>
							</ul>
						</nav>
				</div>
			

		</main>
	
		<%@ include file="/views/common/footer.jsp" %>

	<script>
		$(function(){
			$('#table-main>tbody>tr').click(function(){
				//행 클릭 되었을때, 동작할 내용

				//글번호 가져오기
				const num = $(this).children().eq(1).text();
				
				//해당 번호로 요청 보내기
				location.href='<%=contextPath%>/views/buisness/campRsvDetailForm.jsp?num=' + num;
				
			});
		})
	</script>
</body>
</html>