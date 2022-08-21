<%@page import="com.kh.freeboard.vo.FreeBoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	FreeBoardVo fvo = (FreeBoardVo)request.getAttribute("fvo");
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
	#freeboard-detail-outer{
		border: 1px solid red;
        height: auto;
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
        height: 35%;
        margin: 0 auto;
		padding: 0px;
        border: 1px solid red;
		vertical-align: baseline;
    }
    
    #d8-d>form>input{
    	width:100%;
    	font-size: 3rem;
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
        border: 3px solid blue;
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


	/*  */
	.fb2-1-story-outer{
		position: relative;
		overflow: hidden;
		border: 1px solid red;
	}
		
	.fb2-story-date{
		font-size: 2rem;
		margin-top: 6px;
		color: darkgray;
		height: 8%;
		border: 1px solid red;
	}

	.fb2-story-content{
		height: 50%;
		width: 100%;
	}

	#div-btn-area{
    width: 38%;
    margin: auto;
    margin-top: 30px;
   }

		
</style>
</head>
<body>
	
	<%@ include file="/views/common/header.jsp" %>	
	
	<h1> 여기는 중고거래게시판 상세보기 게시판</h1>
	<div id="freeboard-detail-outer" class="container">


		<!-- 선추가 -->
		<div class="fbt-top-line"></div>


		<div id="d7-d" class="container">

			<div id="fbt-div-outer">

				<div id="fbt-left-div">
					<div id="userId" >작성자 : <%= fvo.getWriter() %></div>
					<div id="userGrade">글번호 : <%= fvo.getNo() %></div>
				</div>



				<div id="fbt-right-div">
					<div id="count">조회수 : <%= fvo.getCnt() %></div>
					<div id="update_date"> 작성일자 : <%= fvo.getEnrollDate() %></div>
				</div>

			</div>

		</div>

		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<div id="d8-d" class="container">

			<form action="<%=contextPath%>/freeBoard/edit" method="post">
				<input type="hidden" value="<%= fvo.getNo() %>" name="feditNo">
				<input type="text" value="<%= fvo.getTitle() %>" name="feditTitle">
				<textarea cols="50" rows="13" id="d8-d-textarea" class="fb2-story-content" name="feditContent" id="" ><%= fvo.getContent() %> </textarea>
				
				<p class="fb2-story-date">작성시간 : <%= fvo.getEnrollDate() %></p>
				<p class="fb2-story-date">조회 수 : <%= fvo.getCnt() %></p>
				
				
				<div id="div-btn-area">
					<input class="btn btn-success" type="submit" value="수정하기">
					<input class="btn btn-success" type="reset" value="초기화">
					<input class="btn btn-success" type="button" value="뒤로가기" onclick="history.go(-1)">
				</div>
			</form>		


		</div>




		
		
		
		

	</div>


</body>


<%@ include file="/views/common/footer.jsp" %>
	
</body>
</html>