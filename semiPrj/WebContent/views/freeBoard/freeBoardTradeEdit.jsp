<%@page import="com.kh.freeboard.vo.FreeBoardTradeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	FreeBoardTradeVo fbvo = (FreeBoardTradeVo)request.getAttribute("fbvo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	*{
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}

	/* 제일큰틀 */
	#freeboard-trade-detail-outer{
		border: 1px solid red;
        height: auto;
	}

	
	#fb_img{
        display: flex;
        height: 28%;
        margin: 0 auto;
		padding: 0px;
        border: 1px solid red;
    }


	#fb_info{
		display: flex;
        height: 5%;
        border: 1px solid red;
    }


	#fb_section{
        height: auto;
        margin: 0 auto;
		padding: 0px;
        border: 1px solid red;
		vertical-align: baseline;
    }

	#fbeditTitle{
		width : 100%;
		font-size : 3rem;
	}
	
	#textarea{
		width : 100%;
		border :1px solid red;
	}
	
	#fb_reple{
		display: flex;
		flex-direction: column;
		flex-wrap: nowrap;
        height: auto;
        border: 3px solid blue;
    }
    
    #fb_my_reple{
    	display: flex;
		flex-direction: column;
    	height:100px;
    	width:100%;
    	border: 1px solid red;
    }

	/* 2차 틀 */
	#fb_img>div{
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


	/*  */

		
	.fb2-story-date{
		font-size: 2rem;
		margin-top: 6px;
		color: darkgray;
		height: 8%;
		border: 1px solid red;
	}

	#fb2-story-content{
		font-size :1.5rem;
		height: auto;
		width: 100%;
	}



		
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>	
	
	<h1> 여기는 중고거래게시판 상세보기 게시판</h1>
	<div id="freeboard-trade-detail-outer" class="container">


		<div id="fb_img" class="container">
			<!-- Carousel -->
			<div id="demo" class="carousel container " data-bs-ride="carousel">
	
				<!-- Indicators/dots -->
				<div class="carousel-indicators container">
					<button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
					<button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
					<button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
				</div>
					
				<!-- The slideshow/carousel -->
				<div class="carousel-inner container" style="width: 100%; height:600px;">
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


		<div id="fb_info" class="container">

			<div id="fbt-div-outer">

				<div id="fbt-left-div">
					<div id="userId" >작성자 :<%= fbvo.getWriter() %></div>
					<div id="userGrade">회원등급 : <%= fbvo.getCnt() %></div>
				</div>



				<div id="fbt-right-div">
					<div id="count">조회수 : <%= fbvo.getCnt() %></div>
					<div id="update_date"> 작성일자 : <%= fbvo.getEnrollDate() %></div>
				</div>

			</div>

		</div>

		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<div id="fb_section" class="container">

			<form action="<%=contextPath%>/freeBoard/trade/edit" method="post">
				<input type="hidden" value="<%= fbvo.getNo() %>" name="fbeditNo">
				<input type="text" value="<%= fbvo.getTitle() %>" name="fbeditTitle" id="fbeditTitle">
				<textarea cols="130%" rows="13" id="d8-d-textarea" class="fb2-story-content" name="fbeditContent" id="fbeditContent" ><%= fbvo.getContent() %> </textarea>
				
				<p class="fb2-story-date">작성시간 : <%= fbvo.getEnrollDate() %></p>
				<p class="fb2-story-date">조회 수 : <%= fbvo.getCnt() %></p>
				
				
				<div id="div-btn-area">
					<input class="btn btn-success" type="submit" value="수정하기">
					<input class="btn btn-success" type="reset" value="초기화">
					<input class="btn btn-success" type="button" value="뒤로가기" onclick="history.go(-1)">
				</div>
			</form>		
			
			
				
			
			

		</div>






		
	</div>

	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>