<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/SjyCss.css">
<style>
	td>a{
	display: block;
}
</style>
</head>
<body>
	<%@ include file="/views/buisness/bsHeader.jsp" %>
	<main class="navbar navbar-expand-sm container">
    <div id="side"  class="shadow">
        <div id="sidebar" class="col">

            <div style="margin-left: 10%; font-size: 20px; color: white;">문의 사항</div>
            <ul class="menu">
                <li>
                    <a href="#">문의 내역</a>
                    <ul class="submenu">
                        <li><a href="<%=contextPath%>/views/buisness/campQuestion.jsp">조회</a></li>
                        
                    </ul>
                </li>

            </ul>

        </div>

    </div>
			
			<div id="content" >
				

					<h2>문의 조회</h2>
					<span style="color:gray">&nbsp;&Tab;-&nbsp;내 캠핑장 문의조회</span>
						<hr>
                        
						<table class="table" id="table-main">
							<thead class="table-light">
								<tr>
									<th scope="col">#</th>
									<th scope="col">문의자</th>
									<th scope="col">제목</th>
									<th scope="col">문의내용</th>
								</tr>
							</thead>
							<tbody>
								<!-- 예약상세보기 페이지를 요청하는 서블릿으로 이동 -->
								<tr>
									<input type="hidden" value="예약자의 회원번호">
									<th scope="row">1</th>
									<td>Mark</td>
									<td>캠핑...</td>
									<td>캠핑장 조회 할때...</td>
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
		<script>
		$(function(){
			$('#table-main>tbody>tr').click(function(){
				//행 클릭 되었을때, 동작할 내용

				//글번호 가져오기
				const num = $(this).children().eq(1).text();
				
				//해당 번호로 요청 보내기
				location.href='<%=contextPath%>/views/buisness/campQuestionDeatil.jsp?num=' + num;
				
			});
		})
	</script>
		
</body>
</html>