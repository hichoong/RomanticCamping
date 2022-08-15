<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주문 성공</title>
</style>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
<style>
	.outer {
		width: 80%;
	    min-width: 600px;
	    margin: auto;
	    margin-top: 100px;
	    border: 1px solid #FFA000;
	    border-radius: 0.5rem;
	    padding: 20px;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	
<div class="outer">
	<div class="jumbotron">
		<div class="container">
			<h1 class="display-3">예약완료</h1>
		</div>
	</div>

	<div class="container">
		<h2 class="alert alert-warning">하늘캠핑장을 예약해 주셔서 감사합니다.</h2>
	</div>

	<div class="container" >
		<p>예약자 명 : 김충희  </p>
		<p>결제금액 : 580,000</p>
		<p>예약번호 : 20220815-12341234</p>
		<p>예약날짜 : 22.08.14~22.08.15</p>
		<p>예약인원 : 5명</p>
		<p>요청사항 : 조금 늦을수도 있습니다~</p>
	</div>

	<div class="container">
			<p><a href="<%=contextPath%>" class="btn btn-warning ">
			<svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-backspace-fill" viewBox="0 0 16 16">
	  		<path d="M15.683 3a2 2 0 0 0-2-2h-7.08a2 2 0 0 0-1.519.698L.241 7.35a1 1 0 0 0 0 1.302l4.843 5.65A2 2 0 0 0 6.603 15h7.08a2 2 0 0 0 2-2V3zM5.829 5.854a.5.5 0 1 1 .707-.708l2.147 2.147 2.146-2.147a.5.5 0 1 1 .707.708L9.39 8l2.146 2.146a.5.5 0 0 1-.707.708L8.683 8.707l-2.147 2.147a.5.5 0 0 1-.707-.708L7.976 8 5.829 5.854z"/>
			</svg> 메인페이지</a></p>
	</div>
</div>
	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>