<%@page import="com.kh.freeboard.attachment.vo.FreeBoardAttachmentVo"%>
<%@page import="com.kh.freeboard.vo.FreeBoardTradeRepleVo"%>
<%@page import="java.util.List"%>
<%@page import="com.kh.freeboard.vo.FreeBoardTradeVo"%>
<%@page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
    
  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	<%@ include file="/resource/css/freeBoardCSS/freeBoardTradeDetail.css" %>
</style>
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>	
	
	<div id="freeboard-trade-detail-outer" class="container">
		<!-- 선추가 -->
		<div class="fbt-top-line"></div>
		<h1 style="text-align:center;'">중고거래 게시글 상세 페이지</h1>
		
		<!-- 선추가 -->
		<div class="fbt-top-line"></div>
		<div id="tradeBoard-img-outer" class="container">
		
		
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


		<div id="tradeBoard-section-info" class="container">

			<div id="tradeBoard-section-info-items">

				<div id="fbt-left-div">
					<div id="userGrade"><kbd>글번호 : ${fbvo.no}</kbd></div>
					<div id="userId" ><kbd>작성자 : ${fbvo.writer}</kbd></div>
				</div>



				<div id="fbt-right-div">
					<div id="count"><kbd>조회수 : ${fbvo.cnt}</kbd></div>
					<div id="update_date"><kbd> 작성일자 : ${fbvo.enrollDate}</kbd></div>
				</div>

			</div>

		</div>

		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<div id="tradeBoard-section-content" class="container">


					<p style="font-size: 3rem;">${fbvo.title}</p>
					<textarea readonly cols="50" rows="15" name="" id="tradeBoard-section-content-text" >${fbvo.content} 
					</textarea>
					<p class="tradeBoard-section-info-datas">작성시간 : ${fbvo.enrollDate}</p>
					<p class="tradeBoard-section-info-datas">조회 수 : ${fbvo.cnt}</p>
					
					
					<!-- 글 작성자와 로그인한 사람이 같으면 글 수정/삭제 버튼 보여주기 -->	
					<c:if test="${loginMember.name eq fbvo.writer}">
						<a href="<%= contextPath %>/freeBoard/trade/edit?num=${fbvo.no}"  class="btn btn-outline-info">게시글 수정하기</a>
						<a href="<%= contextPath %>/freeBoard/trade/delete?num=${fbvo.no}"  class="btn btn-outline-danger">게시글 삭제하기</a>
					</c:if>

		</div>


		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<div id="tradeBoard-reple-outer" class="container">

			
			
	
			<!-- 작성된 댓글 가져와서 보여주기 ( 댓글목록이 없는경우와 있는경우로 구분해서 처리 )-->
			<h2>댓글 목록</h2>
			
			<!-- 댓글 없는 경우 안내 글자 출력 -->
			<c:if test="${empty fbrvoList }">
					<h2 id="reple-empty-text">현재 댓글이 없습니다. 댓글을 입력해 주세요</h2>
			</c:if>
			
			<!-- 댓글 있는 경우 모든 댓글 보여주기 -->
			<c:forEach items="${fbrvoList}" var="fbr">
				
				<div class="select-reple container">
	
					<div class="reple-id">
						<p> 
							<!-- 로그인한 사람과 현재 보는 글 보는 사람이 같으면 수정 / 삭제 버튼 보이도록 해주기  -->
							<c:if test="${loginMember.name eq fbr.writer}">
								<a href="<%= contextPath %>/freeBoard/trade/reple/delete?num=${fbr.no}&pageNo=${fbvo.no}"  class="btn btn btn-outline-danger">삭제하기</a>
							</c:if>
						</p>
					</div>
					<div class="reple-content"><p >${fbr.content} </p></div>
					<div class="reple-sub"><span>${fbr.enrollDate}</span> </div>
	
				</div>
				
			</c:forEach>
			

			
		</div>
		
		
		<!-- 선추가 -->
		<div class="fbt-top-line"></div>
		
		<!-- 내가 댓글작성하기 -->
		<div class="container mt-3">
			<h2>댓글 작성하기</h2>
			<form action="<%=contextPath%>/freeBoard/trade/reple/insert" method="post">
				<div class="mb-3 mt-3">
						<input type="hidden" name="num" value="${fbvo.no}" >
						<input type="hidden" name="loginName" value="${loginMember.name }">
						<label for="comment">Comments:</label>
						<textarea class="form-control" rows="5" id="comment" name="content" required></textarea>
				</div>
				
			<c:if test="${not empty loginMember}">
					<button type="submit" class="btn btn-primary" style="margin-bottom:10px;">댓글등록하기</button>
			</c:if>
			<c:if test="${empty loginMember}">
				<button type="button" class="btn btn-primary" onclick="alert('로그인 후 작성 가능합니다.')" style="margin-bottom:10px;">댓글등록하기</button>
			</c:if>
			
			</form>
	</div>


		
	</div>

	<%@ include file="/views/common/footer.jsp" %>


</body>
</html>