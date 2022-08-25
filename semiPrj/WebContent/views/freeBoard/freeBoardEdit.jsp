<%@page import="com.kh.freeboard.vo.FreeBoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판 게시글 수정 페이지</title>
<style>

	 <%@ include file="/resource/css/freeBoardCSS/freeBoardEdit.css" %>
	 
</style>
</head>
	<%@ include file="/views/common/header.jsp" %>
		
<body>
	
	<div id="freeboard-edit-outer" class="container">

		<!-- 선추가 -->
		<div class="fbt-top-line"></div>
		
		<h1 style="text-align:center;">게시글 수정하기 페이지</h1>
		
		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<!-- 작성자의 기본 정보 보여주는 곳 -->
		<div id="edit-info-outer" class="container">

			<div id="edit-info-div-outer">

				<div id="edit-left-div">
					<div id="userGrade"><kbd>글번호 : ${fvo.no}</kbd></div>
					<div id="userId" ><kbd>작성자 : ${fvo.writer}</kbd></div>
				</div>



				<div id="edit-right-div">
					<div id="count"><kbd>조회수 : ${fvo.cnt}</kbd></div>
					<div id="update_date"> <kbd>작성일자 : ${fvo.enrollDate}</kbd></div>
				</div>

			</div>

		</div>


		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<!-- 원래 본문의 글 내용 보여주는 곳 - ( 내용 수정할 수 있도록 input readonly 속성 제거 ) -->
		<div id="edit-info-main" class="container">

			<form action="<%=contextPath%>/freeBoard/edit" method="post">
				<input type="hidden" value="${fvo.no}" name="feditNo">
				<input id="edit-info-main-title" type="text" value="${fvo.title}" name="feditTitle">
				<textarea cols="50" rows="13" id="edit-info-main-textarea"  name="feditContent" id="" >${fvo.content}</textarea>
				
				<p class="edit-info-main-items">작성자 : ${fvo.writer}</p>
				<p class="edit-info-main-items">조회 수 : ${fvo.cnt} </p>
				<p class="edit-info-main-items">작성일자 : ${fvo.enrollDate}</p>
				
				<!-- 선추가 -->
				<div class="fbt-top-line"></div>
				
				<!-- 버튼 영역 - 수정(update)요청  -->
				<div id="edit-info-main-btn">
					<input class="btn btn-primary" type="submit" value="수정하기">
					<input class="btn btn-primary" type="reset" value="초기화">
					<input class="btn btn-outline-light text-dark" type="button" value="뒤로가기" onclick="history.go(-1)">
				</div>
			</form>		


		</div>
		
		
		

	</div>


</body>


<%@ include file="/views/common/footer.jsp" %>
	
</body>
</html>