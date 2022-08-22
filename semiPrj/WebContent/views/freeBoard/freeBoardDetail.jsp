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
	*{
		margin: 0;
		padding: 0;
		box-sizing: border-box;
	}

	/* 제일큰틀 */
	#freeboard-detail-outer{
		height: auto;
		border: 3px solid brown;
		border-radius: 5px;
	}

	
	#d6-d{
        display: flex;
        height: 30%;
        margin: 0 auto;
		padding: 0px;
        border: 1px solid burlywood;
    }


	#d7-d{
		display: flex;
        height: 5%;
        /* border: 1px solid red; */
    }


	#d8-d{
        height: 35%;
        margin: 0 auto;
		padding: 0px;
		vertical-align: baseline;
        /* border: 1px solid red; */
    }
    
    #d8-d-textarea{
    	font-size : 2rem;
    	height:auto;
    	width: 100%
    }

	#d9-d{
		display: flex;
		flex-direction: column;
		flex-wrap: nowrap;
        height: 20%;
        /* border: 3px solid blue; */
    }

	/* 2차 틀 */
	#d6-d>div{
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
		/* border: 1px solid brown; */
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
	.fb2-1-story-outer{
		position: relative;
		overflow: hidden;
		/* border: 1px solid red; */
	}
		
	.fb2-story-date{
		font-size: 2rem;
		margin-top: 6px;
		color: darkgray;
		height: 8%;
		/* border: 1px solid red; */
	}

	.fb2-story-content{
		height: 50%;
		width: 100%;
	}

	/* 리플창 */
	.select-reple{
		width: 100%;
		height: 150px;
		border: 1px solid pink;
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
	
	
	<div id="freeboard-detail-outer" class="container">


		<!-- 선추가 -->
		<div class="fbt-top-line"></div>


		<div id="d7-d" class="container">

			<div id="fbt-div-outer">

				<div id="fbt-left-div">
					<div id="userId" >작성자 :${fvo.writer}</div>
					<div id="userGrade">글번호 : ${fvo.no}</div>
				</div>



				<div id="fbt-right-div">
					<div id="count">조회수 : ${fvo.cnt}</div>
					<div id="update_date"> 작성일자 : ${fvo.enrollDate}</div>
				</div>

			</div>

		</div>

		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<div id="d8-d" class="container">
				<p style="font-size: 3rem;">${fvo.title}</p>
				<textarea readonly cols="50" rows="13" id="d8-d-textarea" class="fb2-story-content" name="" id="" >${fvo.content}  
				</textarea>
				<p class="fb2-story-date">작성시간 : ${fvo.enrollDate}</p>
				<p class="fb2-story-date">조회 수 : ${fvo.cnt}</p>
				
				
			
				<!-- 글 작성자와 로그인한 사람이 같으면 글 수정/삭제 버튼 보여주기 -->	
				<c:if test="${loginMember.name eq fvo.writer}">
					<a href="<%= contextPath %>/freeBoard/edit?num=${fvo.no}"  class="btn btn-outline-info">게시글 수정하기</a>
					<a href="<%= contextPath %>/freeBoard/delete?num=${fvo.no}"  class="btn btn-outline-danger">게시글 삭제하기</a>
				</c:if>
				
				
		</div>


		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<div id="d9-d" class="container">

				<!-- 작성된 댓글 가져와서 보여주기 -->
			<h2>댓글 목록</h2>
			
			
			<c:forEach items="${frvoList}" var="fr">
				<div class="select-reple">
	
					<div class="reple-id">
						<p>${fr.writer}
							
							<c:if test="${loginMember.name eq fr.writer}">
								<a href="<%= contextPath %>/freeBoard/reple/delete?num=${fr.no}&pageNo=${fvo.no}"  class="btn btn-outline-danger">삭제하기</a>
							</c:if>
						</p> 
					</div>
					<div class="reple-content"><p >${fr.content} </p></div>
					<div class="reple-sub"><span>${fr.enrollDate}</span> <a>답글쓰기</a></div>
	
				</div>
			
			
			</c:forEach>
			
		</div>	
		
		
		
		<!-- 선추가 -->
		<div class="fbt-top-line"></div>
		
		<!-- 내가 댓글작성하기 -->
			
		<div class="container mt-3">
				<h2>댓글 작성하기</h2>
				<p>${login.name}</p>
				<form action="<%=contextPath%>/freeBoard/reple/insert" method="post">
					<div class="mb-3 mt-3">
							<input type="hidden" name="num" value="${fvo.no}" >
							<input type="hidden" name="loginName" value="${loginMember.name}">
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


</body>


<%@ include file="/views/common/footer.jsp" %>


</html>