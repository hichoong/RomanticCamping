<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td>a{
	display: block;
}
</style>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/SjyCss.css">
</head>
<body>
	<%@ include file="/views/buisness/bsHeader.jsp" %>
	<main class="navbar navbar-expand-sm container">
    <div id="side"  class="shadow">
        <div id="sidebar" class="col">

            <div style="margin-left: 10%; font-size: 20px; color: white;">고객센터</div>
            <ul class="menu">
                <li>
                    <a href="#">문의</a>
                    <ul class="submenu">
                        
                        <li style="font-size: 14px;"><a href="<%=contextPath%>/views/buisness/campSvcCenter.jsp">문의 내역조회</a></li>
                    </ul>
                </li>

            </ul>

        </div>

    </div>
			
			<div id="content" >
				

					<h2>문의 사항 작성</h2>
						<hr>

						<form action="">
                        
						<div class="md-3" >
							<label for="userName" class="form-label">* 이름:</label>
							<input type="text" class="form-control" id="userName" placeholder="로그인한 회원이름" name="userName" required disabled>
						</div>
										
						<div class="md-3" >
							<label for="title" class="form-label">* 제목:</label>
							<input type="text" class="form-control" id="title" placeholder="제목 입력" name="title" required >
						</div>


						<div class="md-3" >
							<label for="userContent">내용:</label>
							<textarea class="form-control" rows="3" id="userContent" placeholder="문의 내용 입력" name="userContent"></textarea>
						</div>


						<div id="end">
							<button  onclick="location.href='#'" id="send" class="rounded">등록</button>
						</div>
					</form>
						
						
					</div>
					
					
				</main>
	
		<%@ include file="/views/common/footer.jsp" %>
</body>
</html>