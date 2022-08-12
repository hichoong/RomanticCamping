<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = (String)request.getParameter("num");
	
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/SjyCss.css">
</head>
<body>
	<%@ include file="/views/buisness/bsHeader.jsp" %>
	<main class="navbar navbar-expand-sm container">
	<%@ include file="/views/buisness/sidebar.jsp" %>
			
			<div id="content" >
				

					<h2>상세조회</h2>
						<hr>
                        
                        <div><%=num %>번 예약자</div>
						<div>여기는 예약 내용</div>


						<div class="md-3" >
							<label for="comment" class="form-label">* Comment:</label>
							<input type="text" class="form-control" id="comment" placeholder="요청에대한 응답을 작성해주세요" name="comment" required ">
						</div>
						<br>
						<div id="end"> 
							<button  id="upDate" >수락</button>
							<button id="delete"  onclick="locaton.href='#'">거절</button>
						</div>
				</div>
			

		</main>
	
		<%@ include file="/views/common/footer.jsp" %>
</body>
</html>