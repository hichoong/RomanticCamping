<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>낭만캠핑</title>
<style>

	#index-wrapper {
		width: 90%;
		margin: auto;
		padding-top: 10px;
	}

	#img-div {
		width: 500x;
		height: 500px;
		background-color: lightcoral;
	}

	.fix-size {
		width: 500px;
		height: 700px;
	}


</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	
	<!-- <h1>index(경로: http://localhost:8803/camp/ )</h1> -->
	
	<div class="container">

		<div id="main-pic" class="carousel slide" data-bs-ride="carousel">

			<div class="carousel-indicators">
				<button type="button" data-bs-target="#main-pic" data-bs-slide-to="0" class="active"></button>
				<button type="button" data-bs-target="#main-pic" data-bs-slide-to="1"></button>
				<button type="button" data-bs-target="#main-pic" data-bs-slide-to="2"></button>
			</div>
		
			<div class="carousel-inner fix-size">
				<div class="carousel-item active">
					<img src="<%=contextPath%>/resource/img/test.jpg" alt="main img1" class="d-block w-100 fix-size">
				</div>
				<div class="carousel-item">
					<img src="<%=contextPath%>/resource/img/gsTest1.jpg" alt="main img2" class="d-block w-100 fix-size">
				</div>
				<div class="carousel-item">
					<img src="<%=contextPath%>/resource/img/gsTest2.jpg" alt="main img3" class="d-block w-100 fix-size">
				</div>
			</div>
		
			<button class="carousel-control-prev" type="button" data-bs-target="#main-pic" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
			</button>
			<button class="carousel-control-next" type="button" data-bs-target="#main-pic" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
			</button>
		</div>
	</div>

	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>