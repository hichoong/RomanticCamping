<%@page import="java.util.List"%>
<%@page import="com.kh.freeboard.vo.FreeBoardRepleVo"%>
<%@page import="com.kh.freeboard.vo.FreeBoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	
	<%@ include file="/resource/css/freeBoardCSS/freeBoardDetail.css" %>
	
</style>
</head>

	<%@ include file="/views/common/header.jsp" %>

	
<body>

	
	
	<div id="freeboard-detail-outer" class="container">
	
		<!-- 선추가 -->
		<div class="fbt-top-line"></div>
		<h1 style="text-align:center;'">자유 게시글 상세 페이지</h1>
		
		

		<!-- 선추가 -->
		<div class="fbt-top-line"></div>
		
		<!-- 게시글 기본 정보 보여주는 곳 -->
		<div id="freeBoard-info" class="container">

			<div id="freeBoard-info-outer">

				<div id="fbt-left-div">
					<div id="userGrade"><kbd>글번호 : ${fvo.no}</kbd></div>
					<div id="userId" ><kbd>작성자 : ${fvo.writer}</kbd></div>
				</div>



				<div id="fbt-right-div">
					<div id="count"><kbd>조회수 : ${fvo.cnt}</kbd></div>
					<div id="update_date"> <kbd>작성일자 : ${fvo.enrollDate}</kbd></div>
				</div>

			</div>

		</div>

		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<!-- 게시글 제목/내용 등 보여주기 -->
		<div id="freeBoard-section" class="container">
				<p style="font-size: 3rem;">${fvo.title}</p>
				<textarea readonly cols="50" rows="13" id="freeBoard-section-textarea" class="freeBoard-section-content" name="" id="" >${fvo.content}  
				</textarea>
				<p class="freeBoard-section-itmes">작성시간 : ${fvo.enrollDate}</p>
				<p class="freeBoard-section-itmes">조회 수 : ${fvo.cnt}</p>
				
				
			
				<!-- 버튼 영역 -- 글 작성자와 로그인한 사람이 같으면 글 수정/삭제 버튼 보여주기 -->	
				<c:if test="${loginMember.name eq fvo.writer}">
					<a href="<%= contextPath %>/freeBoard/edit?num=${fvo.no}"  class="btn btn-outline-info">게시글 수정하기</a>
					<a href="<%= contextPath %>/freeBoard/delete?num=${fvo.no}"  class="btn btn-outline-danger">게시글 삭제하기</a>
				</c:if>
				
				
		</div>


		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		
		<div id="freeBoard-reple-list" class="container">
			
			
			
			<!-- 작성된 댓글 가져와서 보여주기 ( 댓글목록이 없는경우와 있는경우로 구분해서 처리 )-->
			<h2>댓글 목록</h2>
			
			<!-- 댓글 없는 경우 안내 글자 출력 -->
			<c:if test="${empty frvoList }">
					<h2 id="reple-empty-text">현재 댓글이 없습니다. 댓글을 입력해 주세요</h2>
			</c:if>
			
			<!-- 댓글 있는 경우 모든 댓글 보여주기 -->
			<c:forEach items="${frvoList}" var="fr">
			
				<div class="select-reple">
	
					<div class="reple-id">
						<!-- 로그인한 사람과 현재 보는 글 보는 사람이 같으면 수정 / 삭제 버튼 보이도록 해주기  -->
						<p>
							<c:if test="${loginMember.name eq fr.writer}">
								<a href="<%= contextPath %>/freeBoard/reple/delete?num=${fr.no}&pageNo=${fvo.no}"  class="btn btn-outline-danger">삭제하기</a>
							</c:if>
						</p> 
					</div>
					<div class="reple-content"><p >${fr.content} </p></div>
					<div class="reple-sub"><span>${fr.enrollDate}</span></div>
	
				</div>
			
			
			</c:forEach>
			
		</div>	
		
		
		
		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		
		<!-- 댓글 작성하기 영역 ( 로그인 한 유저만 댓글 작성하도록 처리 )-->
		<div class="container mt-3">
				<h2>댓글 작성하기</h2>
				<form action="<%=contextPath%>/freeBoard/reple/insert" method="post">
					<div class="mb-3 mt-3">
							<input type="hidden" name="num" value="${fvo.no}" >
							<input type="hidden" name="loginName" value="${loginMember.name}">
							<label for="comment">Comments:</label>
							<textarea class="form-control" rows="5" id="comment" name="content" required></textarea>
					</div>
					
				<c:if test="${not empty loginMember}">
					<button type="submit" class="btn btn-primary" style="margin-bottom:10px;">댓글등록하기</button>
				</c:if>
				<c:if test="${empty loginMember}">
					<button type="button" class="btn btn-primary" onclick="alert('로그인 후 작성 가능합니다.')" style="margin-bottom:10px;">댓글 등록하기</button>
				</c:if>
					
				</form>
		</div>
		
		
		

	</div>


</body>


<%@ include file="/views/common/footer.jsp" %>


</html>