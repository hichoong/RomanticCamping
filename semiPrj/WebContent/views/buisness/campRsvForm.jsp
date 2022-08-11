<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/resource/css/SjyCss.css">
<style>
	td>a{
	display: block;
}
</style>
</head>
<body>
	<%@ include file="/views/buisness/bsHeader.jsp" %>
	<main class="navbar navbar-expand-sm container">
	<%@ include file="/views/buisness/sidebar.jsp" %>
			
			<div id="content" >
				

					<h2>예약 조회</h2>
						<hr>
                        
						<table class="table">
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
								<tr onclick="location.href='campRsvDetailForm.jsp?&<%="no=1" %>'" style="cursor:hand">
									<input type="hidden" value="예약자의 회원번호">
									<th scope="row">1</th>
									
									<td>Mark</td>
									<td>_ _ _캠프</td>
									<td>22-08-01~22-08-03</td>
								</tr>

								<tr onclick="location.href='campRsvDetailForm.jsp?&<%="no=2" %>'" style="cursor:hand">
									<th scope="row">2</th>
									
									<td>Mark</td>
									<td>_ _ _캠프</td>
									<td>22-08-01~22-08-03</td>
								</tr>

								<tr onclick="location.href='campRsvDetailForm.jsp?&<%="no=3" %>'" style="cursor:hand">
									<th scope="row">3</th>
								
									<td>Mark</td>
									<td>_ _ _캠프</td>
									<td>22-08-01~22-08-03</td>
								</tr>
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
</body>
</html>