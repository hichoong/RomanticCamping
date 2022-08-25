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

	.main-img{
		display: flex;
		flex-direction: row;
		justify-content: space-between;
		width: 100%;
	}
	.img-wrap{
		width: auto;
		margin: 10px;
		margin-top: 70px;
	}
	.img-wrap > img{
		width: 400px;
		height: 500px;
	}
	#main-search{
		width: 100%;
		height: 70px;
		display: flex;
		flex-direction: row;
		justify-content: center;
		position: absolute;
		top: 610px;

	}
	#main-search-val{
		width: 50%;
		border-radius: 50px 0 0 50px;
		font-size: 1.3rem;
		padding-left: 30px;
		outline: none;
		border: none;
	}
	#main-submit{
		width: 10%;
		border-radius: 0 50px 50px 0;
		font-size: 1.3rem;
		background-color: #f5bd5d;
		font-weight: 700;
		border: none;
	}
	.container{
		padding-top: 50px;
	}
	.carousel-item > img{
		opacity: 0.7;
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
					<img src="<%=contextPath%>/resource/img/camp/camp4.jpg" alt="main img1" class="d-block w-100 fix-size">
				</div>
				<div class="carousel-item">
					<img src="<%=contextPath%>/resource/img/camp/camp7.jpg" alt="main img2" class="d-block w-100 fix-size">
				</div>
				<div class="carousel-item">
					<img src="<%=contextPath%>/resource/img/camp/camp10.jpg" alt="main img3" class="d-block w-100 fix-size">
				</div>
			</div>
		
			<button class="carousel-control-prev" type="button" data-bs-target="#main-pic" data-bs-slide="prev">
			<span class="carousel-control-prev-icon"></span>
			</button>
			<button class="carousel-control-next" type="button" data-bs-target="#main-pic" data-bs-slide="next">
			<span class="carousel-control-next-icon"></span>
			</button>

			<div >
				<form action="<%=contextPath%>/camp/campList" method="get" id="main-search">
					<input type="hidden" name="p" value="1">
					<input type="text" name="keyword" id="main-search-val" placeholder="keyword">
					<input type="submit" id="main-submit" value="검색">
				</form>
			</div>
		</div>


		<div class="main-img">
			<div class="img-wrap">
				<img src="<%=contextPath%>/resource/img/camp/mainImg1.jpg" alt="이미지1">
			</div>
			<div class="img-wrap">
				<img src="<%=contextPath%>/resource/img/camp/mainImg2.jpg" alt="이미지2">
			</div>
			<div class="img-wrap">
				<img src="<%=contextPath%>/resource/img/camp/mainImg3.jpg" alt="이미지3">
			</div>
		</div>

		



	</div>

	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>