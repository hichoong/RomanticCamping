<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 성공</title>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">주문 완료</h1>
		</div>
	</div>

	<div class="container">
		<h2 class="alert alert-danger">주문해 주셔서 감사합니다.</h2>
	</div>

	<div class="container">
		<p>예약자 :   </p>
		<p>예약번호 : </p>
		<p>입실시간 : </p>
	</div>

	<div class="container">
		<p><a href="<%=contextPath%>" class="btn btn-secondary">&laquo;메인페이지</a></p>
	</div>
	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>