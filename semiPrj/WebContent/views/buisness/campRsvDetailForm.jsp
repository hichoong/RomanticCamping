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
	<%-- <%@ include file="/views/buisness/bsHeader.jsp" %> --%> 
	<%@ include file="/views/common/header.jsp" %>
	<main class="navbar navbar-expand-sm container">
	<%@ include file="/views/buisness/sidebar.jsp" %>
			
			<div id="content" >
				

					<h2>상세조회</h2>
						<hr>
                        <div style="overflow-x: hidden; width: 100%; height: 700px;">
                        <div><%=num %>번 예약자</div>
						<div>여기는 예약 내용</div>
						
					<div class="md-3">
						<label for="rsvMemberName" class="form-label">* 예약자 이름:</label> <input
							type="text" class="form-control" id="rsvMemberName" name="rsvMemberName" disabled>
					</div>
					
					<div class="md-3">
						<label for="rsvMemberName" class="form-label">*예약자 연락처:</label> <input
							type="text" class="form-control" id="rsvMemberName" name="rsvMemberName" disabled>
					</div>					
					
					<div class="md-3">
						<label for="rsvMemberName" class="form-label">*예약자 요청사항:</label> <input
							type="text" class="form-control" id="rsvMemberName" name="rsvMemberName" disabled>
					</div>
					
					<div class="md-3">
						<label for="rsvMemberName" class="form-label">*예약 캠핑장:</label> <input
							type="text" class="form-control" id="rsvMemberName" name="rsvMemberName" disabled>
					</div>
					
					<div class="md-3">
						<label for="rsvMemberName" class="form-label">*예약 구역번호:</label> <input
							type="text" class="form-control" id="rsvMemberName" name="rsvMemberName" disabled>
					</div>
					
					<div class="md-3">
						<label for="rsvMemberName" class="form-label">*예약 인원:</label> <input
							type="text" class="form-control" id="rsvMemberName" name="rsvMemberName" disabled>
					</div>
					
					<div class="md-3">
						<label for="rsvMemberName" class="form-label">*예약 기간:</label> <input
							type="text" class="form-control" id="rsvMemberName" name="rsvMemberName" disabled>
					</div>
					
					<div class="md-3">
						<label for="rsvMemberName" class="form-label">*결재 금액:</label> <input
							type="text" class="form-control" id="rsvMemberName" name="rsvMemberName" disabled>
					</div>
					
					<div class="md-3">
						<label for="rsvMemberName" class="form-label">*:</label> <input
							type="text" class="form-control" id="rsvMemberName" name="rsvMemberName" disabled>
					</div>
					
						
						<div class="md-3" >
							<label for="comment" class="form-label">* Comment:</label>
							<input type="text" class="form-control" id="comment" placeholder="요청에대한 응답을 작성해주세요" name="comment" required>
						</div>
						<br>
						<div id="end"> 
							<button  id="upDate" >수락</button>
							<button id="delete"  onclick="locaton.href='#'">거절</button>
						</div>
						
				</div>
			</div>

		</main>
	
		<%@ include file="/views/common/footer.jsp" %>
</body>
</html>