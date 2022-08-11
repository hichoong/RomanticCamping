<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}

	/* 제일큰틀 */
	#freeboard-outer{
		border: 1px solid red;
        height: 2000px;
	}

	
	#d6-d{
        display: flex;
        height: 30%;
        margin: 0 auto;
		padding: 0px;
        border: 1px solid red;
    }


	#d7-d{
		display: flex;
        height: 5%;
        border: 1px solid red;
    }


	#d8-d{
        height: 20%;
        margin: 0 auto;
		padding: 0px;
        border: 1px solid red;
		vertical-align: baseline;
    }

	#d9-d{
		display: flex;
        height: 35%;
        border: 1px solid red;
    }

	/* 2차 틀 */
	#d6-d>div{
		margin: 0 auto;
		padding: 0px;
        height: 100%;
        border: 2px solid darkred;
    }

	/* 꾸미기 */

	#fbt-div-outer{
		margin: 0 auto;
		height: 100%;
		width: 100%;
		display: flex;
		align-items: center;
		justify-content: space-between;
		border: 1px solid brown;
	}


	#fbt-left-div{
		display: flex;
		margin-left: 8px;
		border: 1px solid blue;
		flex-direction: column;
	}


	#fbt-right-div{
		display: flex;
		margin-right: 8px;
		border: 1px solid blue;
		flex-direction: column;
	}



	/* 보더라인 */
	.fbt-top-line{
		width: 100%;
        height: 1%;
		background-color: rgb(240, 225, 203);
        margin-bottom: 1%;
        margin-top: 1%;
	}

</style>
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>	
	
	<h1> 여기는 중고거래게시판 상세보기 게시판</h1>
	<div id="freeboard-outer" class="container">


		<div id="d6-d" class="container">
                
			<!-- Carousel -->
			<div id="demo" class="carousel container " data-bs-ride="carousel">
	
				<!-- Indicators/dots -->
				<div class="carousel-indicators container">
				<button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
				<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
				<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
				</div>
					
				<!-- The slideshow/carousel -->
				<div class="carousel-inner container" style="width: 100%; height:100%;">
					<div class="carousel-item active">
							<img  src="<%=contextPath %>/resource/img/gsTest1.jpg" class="img-thumbnail" alt="Los Angeles" class="d-block" style="width:100%;">
					</div>
					<div class="carousel-item">
							<img  src="<%=contextPath %>/resource/img/gsTest2.jpg" class="img-thumbnail" alt="Chicago" class="d-block" style="width:100%; ">
					</div>
					<div class="carousel-item">
							<img  src="<%=contextPath %>/resource/img/gsTest3.jpg" class="img-thumbnail" alt="New York" class="d-block" style="width:100%; ">
					</div>
				</div>
					
				<!-- Left and right controls/icons -->
				<button class="carousel-control-prev container" type="button" data-bs-target="#demo" data-bs-slide="prev">
					<span class="carousel-control-prev-icon"></span>
				</button>

				<button class="carousel-control-next container" type="button" data-bs-target="#demo" data-bs-slide="next">
					<span class="carousel-control-next-icon"></span>
				</button>
			</div>

		</div>

		<!-- 선추가 -->
		<div class="fbt-top-line"></div>


		<div id="d7-d" class="container">

			<div id="fbt-div-outer">

				<div id="fbt-left-div">
					<div id="userId" >작성자 : 행운목</div>
					<div id="userGrade">회원등급 : 골드회원</div>
				</div>



				<div id="fbt-right-div">
					<div id="count">조회수 : 5186</div>
					<div id="update_date"> 작성일자 : 0000-00-00</div>
				</div>

			</div>


		</div>

		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<div id="d8-d" class="container">

			<h1>글제목</h1>
			
			
			<p>글내용</p>
			<p>작성시간</p>
			<p>조회수</p>
			<p>등등</p>

		</div>


		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<div id="d9-d" class="container">

	


			
		</div>






















		
	</div>






	</div>








</body>
</html>