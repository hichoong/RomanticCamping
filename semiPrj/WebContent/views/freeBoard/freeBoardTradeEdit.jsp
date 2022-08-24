<%@page import="com.kh.freeboard.vo.FreeBoardTradeVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>중고게시판 상세보기 페이지</title>
<style>

	<%@ include file="/resource/css/freeBoardCSS/freeBoardTradeEdit.css" %>

</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>	
	
	
		
	<div id="freeboard-trade-edit-outer" class="container">
	
		<!-- 선추가 -->
		<div class="fbt-top-line"></div>
		
		<h1 style="text-align:center;">게시글 수정하기 페이지</h1>
		
		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<div id="trade-edit-img-outer" class="container">
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
					
					<c:forEach items="${fbavoList}" var="fbao">
					
						<div class="carousel-item active">
								<img  src="<%=contextPath %>/resource/img/freeBoardTrade/${fbao.changeName}" class="img-thumbnail" alt="중고거래 이미지 불러오기 실패" class="d-block" style="width:100%; height:600px;">
						</div>
					
					</c:forEach>
					
					
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


		<div id="trade-edit-info" class="container">

			<div id="trade-edit-info-items">

				<div id="fbt-left-div">
					<div id="userGrade"><kbd>글번호 : ${fbvo.no }</kbd></div>
					<div id="userId" ><kbd>작성자 :${fbvo.writer }</kbd></div>
				</div>


				<div id="fbt-right-div">
					<div id="count"><kbd>조회수 : ${fbvo.cnt }</kbd></div>
					<div id="update_date"> <kbd>작성일자 : ${fbvo.enrollDate}</kbd></div>
				</div>

			</div>

		</div>

		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<div id="trade-edit-section-main" class="container">

			<form action="<%=contextPath%>/freeBoard/trade/edit" method="post">
				<input type="hidden" value="${fbvo.no}" name="fbeditNo">
				<input type="text" value="${fbvo.title}" name="fbeditTitle" id="fbeditTitle">
				<textarea cols="130%" rows="13"   name="fbeditContent" id="trade-edit-main-textarea" >${fbvo.content} </textarea>
				
				<p class="trade-edit-main-items">작성시간 : ${fbvo.enrollDate}</p>
				<p class="trade-edit-main-items">조회 수 : ${fbvo.cnt}</p>
				
				<!-- 선추가 -->
				<div class="fbt-top-line"></div>
				
				<div id="trade-edit-btn" class="container">
					<input class="btn btn-primary" type="submit" value="수정하기">
					<input class="btn btn-primary" type="reset" value="초기화">
					<input class="btn btn-outline-light text-dark" type="button" value="뒤로가기" onclick="history.go(-1)">
				</div>
			</form>		
			
			
				
			
			

		</div>






		
	</div>

	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>