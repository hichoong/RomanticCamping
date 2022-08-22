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
	*{
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}

	/* 제일큰틀 */
	#freeboard-trade-detail-outer{
		border: 3px solid brown;
        height: auto;
		border-radius: 5px;
	}

	
	#fb_img{
        display: flex;
        height: 28%;
        margin: 0 auto;
		padding: 0px;
        /* border: 1px solid red; */
    }


	#fb_info{
		display: flex;
        height: 5%;
        /* border: 1px solid red; */
    }


	#fb_section{
        height: auto;
        margin: 0 auto;
		padding: 0px;
		vertical-align: baseline;
        /* border: 1px solid red; */
    }

	#fb_reple{
		display: flex;
		flex-direction: column;
		flex-wrap: nowrap;
        height: auto;
        /* border: 3px solid blue; */
    }
    
    #fb_my_reple{
    	display: flex;
		flex-direction: column;
    	height:100px;
    	width:100%;
    	/* border: 1px solid red; */
    }

	/* 2차 틀 */
	#fb_img>div{
		margin: 0 auto;
		padding: 0px;
        height: 100%;
        /* border: 2px solid darkred; */
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
		flex-direction: column;
		/* border: 1px solid blue; */
	}


	#fbt-right-div{
		display: flex;
		margin-right: 8px;
		flex-direction: column;
		/* border: 1px solid blue; */
	}



	/* 보더라인 */
	.fbt-top-line{
		width: 100%;
        height: 5px;
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
		/* border: 1px solid red; */
	}

	#fb2-story-content{
		font-size :1.5rem;
		height: auto;
		width: 100%;
	}

	/* 리플창 */
	.select-reple{
		width: 100%;
		height: 150px;
		border: 1px solid blue;
		position: relative;
		margin-bottom: 5px;
	}

	.reple-id>p>a {
		position: absolute;
		right: 3px;
	}

	.reple-sub{
		position: absolute;
		bottom: 5px;
	}
	
	.reple-content{
		height:auto;
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
				
					
					<c:forEach items="${fbavoList}" var="fbao">
					
						<div class="carousel-item active">
								<img  src="<%=contextPath %>/resource/img/freeBoardTrade/${fbao.changeName}" class="img-thumbnail" alt="중고거래 이미지 불러오기 실패" class="d-block" style="width:100%;">
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


		<div id="fb_info" class="container">

			<div id="fbt-div-outer">

				<div id="fbt-left-div">
					<div id="userId" >작성자 :${fbvo.writer}</div>
					<div id="userGrade">글번호 : ${fbvo.no}</div>
				</div>



				<div id="fbt-right-div">
					<div id="count">조회수 : ${fbvo.cnt}</div>
					<div id="update_date"> 작성일자 : ${fbvo.enrollDate}</div>
				</div>

			</div>

		</div>

		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<div id="fb_section" class="container">


					<p style="font-size: 3rem;">${fbvo.title}</p>
					<textarea readonly cols="50" rows="15" name="" id="fb2-story-content" >${fbvo.content} 
					</textarea>
					<p class="fb2-story-date">작성시간 : ${fbvo.enrollDate}</p>
					<p class="fb2-story-date">조회 수 : ${fbvo.cnt}</p>
					
					
					<!-- 글 작성자와 로그인한 사람이 같으면 글 수정/삭제 버튼 보여주기 -->	
					<c:if test="${loginMember.name eq fbvo.writer}">
						<a href="<%= contextPath %>/freeBoard/trade/edit?num=${fbvo.no}"  class="btn btn-outline-info">게시글 수정하기</a>
						<a href="<%= contextPath %>/freeBoard/trade/delete?num=${fbvo.no}"  class="btn btn-outline-danger">게시글 삭제하기</a>
					</c:if>

		</div>


		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<div id="fb_reple" class="container">

			
			
	
			<!-- 작성된 댓글 가져와서 보여주기 -->
			<h2>댓글 목록</h2>
			
			<c:forEach items="${fbrvoList}" var="fbr">
				
				<div class="select-reple container">
	
					<div class="reple-id">
						<p>${fbr.writer}
							<!-- 로그인한 사람과 현재 보는 글 보는 사람이 같으면 수정 / 삭제 버튼 보이도록 해주기  -->
							<c:if test="${loginMember.name eq fbr.writer}">
								<a href="<%= contextPath %>/freeBoard/trade/reple/delete?num=${fbr.no}&pageNo=${fbvo.no}"  class="btn btn btn-outline-danger">삭제하기</a>
							</c:if>
						</p>
					</div>
					<div class="reple-content"><p >${fbr.content} </p></div>
					<div class="reple-sub"><span>${fbr.enrollDate}</span> <a>답글쓰기</a></div>
	
				</div>
				
			</c:forEach>
			

			
		</div>
		
		
		<!-- 선추가 -->
		<div class="fbt-top-line"></div>
		
		<!-- 내가 댓글작성하기 -->
		<div class="container mt-3">
			<h2>댓글 작성하기</h2>
			<p>${loginMember.name }</p>
			<form action="<%=contextPath%>/freeBoard/trade/reple/insert" method="post">
				<div class="mb-3 mt-3">
						<input type="hidden" name="num" value="${fbvo.no}" >
							<input type="hidden" name="loginName" value="${loginMember.name }">
						<label for="comment">Comments:</label>
						<textarea class="form-control" rows="5" id="comment" name="content"></textarea>
				</div>
				
			<c:if test="${not empty loginMember}">
					<button type="submit" class="btn btn-primary">댓글등록하기</button>
			</c:if>
			<c:if test="${empty loginMember}">
				<button type="button" class="btn btn-primary" onclick="alert('로그인 후 작성 가능합니다.')">댓글등록하기</button>
			</c:if>
			
			</form>
	</div>


		
	</div>

	<%@ include file="/views/common/footer.jsp" %>


</body>
</html>