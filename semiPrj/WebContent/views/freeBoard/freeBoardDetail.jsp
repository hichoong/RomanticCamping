<%@page import="java.util.List"%>
<%@page import="com.kh.freeboard.vo.FreeBoardRepleVo"%>
<%@page import="com.kh.freeboard.vo.FreeBoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	FreeBoardVo fvo = (FreeBoardVo)request.getAttribute("fvo");
	List<FreeBoardRepleVo> frvoList = (List<FreeBoardRepleVo>)request.getAttribute("frvoList");
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

	/* 리플창 */
	.select-reple{
		width: 100%;
		height: auto;
		border: 1px solid pink;
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
				<p style="font-size: 3rem;"><%= fvo.getTitle() %></p>
				<textarea readonly cols="50" rows="13" id="d8-d-textarea" class="fb2-story-content" name="" id="" ><%= fvo.getContent() %>  
				</textarea>
				<p class="fb2-story-date">작성시간 : <%= fvo.getEnrollDate() %></p>
				<p class="fb2-story-date">조회 수 : <%= fvo.getCnt() %></p>
				
				
				<!-- 로그인한 사람과 현재 보는 글 보는 사람이 같으면 수정 / 삭제 버튼 보이도록 해주기  -->
				<%-- <%if( loginMember != null && fvo.getWriter().equals(loginMember.getName()) ){ %> --%>
					<a href="<%= contextPath %>/freeBoard/edit?num=<%=fvo.getNo()%>"  class="btn btn-warning">수정하기</a>
					<a href="<%= contextPath %>/freeBoard/delete?num=<%=fvo.getNo()%>"  class="btn btn-warning">삭제하기</a>
				<%-- <%} %> --%>
		</div>


		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<div id="d9-d" class="container">

				<!-- 작성된 댓글 가져와서 보여주기 -->
			
				<div class="select-reple">

					<div class="reple-id"><p >작성자 id</p></div>
					<div class="reple-comment"><p >작성내용 </p></div>
					<div class="reple-sub"><span>작성일자</span> <a>답글쓰기</a></div>

				</div>
			
			<%for( FreeBoardRepleVo fr : frvoList ) {%>			
				<div class="select-reple">
	
					<div class="reple-id">
					<p><%= fr.getWriter() %></p> 
						<!-- 로그인한 사람과 현재 보는 글 보는 사람이 같으면 수정 / 삭제 버튼 보이도록 해주기  -->
						<%-- <%if( loginMember != null && fr.getWriter().equals(loginMember.getName()) ){ %> --%>
							<a href="<%= contextPath %>/freeBoard/reple/edit?num=<%=fr.getNo()%>&pageNo=<%= fvo.getNo() %>"  class="btn btn-warning">수정하기</a>
							<a href="<%= contextPath %>/freeBoard/reple/delete?num=<%=fr.getNo()%>&pageNo=<%= fvo.getNo() %>"  class="btn btn-warning">삭제하기</a>
						<%-- <%} %> --%>
					</div>
					<div class="reple-comment"><p ><%= fr.getContent() %> </p></div>
					<div class="reple-sub"><span><%= fr.getEnrollDate() %></span> <a>답글쓰기</a></div>
	
				</div>
			<%} %>
		</div>	
		
		
		
		<!-- 선추가 -->
		<div class="fbt-top-line"></div>
		
		<!-- 내가 댓글작성하기 -->
			
		<div class="container mt-3">
				<h2>댓글 작성하기</h2>
				<p>로그인안햇으면 오류남 - 있을때 없을때 구분해야할 듯 밑에 HIDDEN 벨류도 조절 필요<%-- <%=loginMember.getName() %> --%></p>
				<form action="<%=contextPath%>/freeBoard/reple/insert" method="post">
					<div class="mb-3 mt-3">
							<input type="hidden" name="num" value="<%= fvo.getNo() %>" >
							<input type="hidden" name="loginName" value="admin<%-- <%=loginMember.getName()%> --%>">
							<label for="comment">Comments:</label>
							<textarea class="form-control" rows="5" id="comment" name="content"></textarea>
					</div>
				<button type="submit" class="btn btn-primary">댓글등록하기</button>
				</form>
		</div>
		
		
		

	</div>


</body>


<%@ include file="/views/common/footer.jsp" %>


</html>