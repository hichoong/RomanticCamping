
<%@page import="com.kh.freeboard.attachment.vo.FreeBoardAttachmentVo"%>
<%@page import="com.kh.freeboard.vo.FreeBoardTradeVo"%>
<%@page import="com.kh.common.PageVo"%>
<%@page import="com.kh.freeboard.vo.FreeBoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"  %>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
<%@ taglib prefix="fm" uri="http://java.sun.com/jsp/jstl/fmt" %>  
<%

	PageVo fpageVo = (PageVo)request.getAttribute("fpageVo");
	
	PageVo fbpageVo = (PageVo)request.getAttribute("fbpageVo");
	
	int fcurrentPage = fpageVo.getCurrentPage();
	int fstartPage = fpageVo.getStartPage();
	int fendPage = fpageVo.getEndPage();
	int fmaxPage = fpageVo.getMaxPage();
 	
	int fbcurrentPage = fbpageVo.getCurrentPage();
	int fbstartPage = fbpageVo.getStartPage();
	int fbendPage = fbpageVo.getEndPage();
	int fbmaxPage = fbpageVo.getMaxPage();
 %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자유게시판</title>
<style>
	
	 <%@ include file="/resource/css/gsFreeB.css" %>
	
	
</style>
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>
	
	
	<!-- href링크는 게시글 번호로 그 번호에 맞는 상세페이지로 이동시키기 -->
	
	<div id="freeBoardTrade-outer" class="container">

		<div id="tradeBoard" class="container">
			<p class="tradeBoard-title">중고거래</p>
			
			
			<p class="tradeBoard-title-2">중고거래 인기글 </p>
			
			
			<div id="tradeBoard-1" class="container">
				
				
				<c:forEach items="${fbMainList}" var="fblist" >
						<div class ="menu-items">
						<a href="<%=contextPath %>/freeBoard/trade/detail?num2=${fblist.no}">
						
							<div id="tradeBoard-img-outer"><img src="<%=contextPath %>/resource/img/freeBoardTrade/${fblist.changeName}" alt=""></div>
							<div >
								<div class="tradeBoard-comment-outer"><span>${fblist.title}</span></div>
								<p id="tradeBoard-subtitle1">${fblist.writer}</p>
								<p><fm:setLocale value="ko_KR"/><fm:formatNumber type="currency" value="${fblist.price}" />원</p>

							</div>
						</a>
					</div>
				</c:forEach>
				
			

			</div>


			<div class="Board-table-outer" class="container">
				
				<table id="Board-table-outer-main" class="container">

					<thead>
						<tr>
							<th>글번호</th>
							<th>글제목</th>
							<th>작성자</th>
							<th>판매가격</th>
							<th>작성일</th>
						</tr>
					</thead>

					<c:forEach items ="${fbvoList}" var="fbvo">
					
						<tbody>
							
								<tr>
									<td>${fbvo.no}</td>
									<td class="fb-tr-Title">${fbvo.title}</td>
									<td class="fb-tr-Content">${fbvo.content}</td>
									<td>
										<fm:formatNumber type="number" maxFractionDigits="3" value="${fbvo.price}" />원
									</td>
									<td>
										<fm:parseDate value="${fbvo.enrollDate}" var="enrollDate" pattern="yyyy-MM-dd HH:mm:ss"></fm:parseDate>
										<fm:formatDate value="${enrollDate}" pattern="yyyy년 MM월 dd일" />
									</td>
								</tr>
							
						</tbody>
						
					</c:forEach>
					
					


				</table>
				
			
			</div>





			<div class="fb-page-area">

			
				<%if(fbcurrentPage != 1){ %>
					<a class="btn btn-sm btn-outline-success" href="<%=contextPath %>/freeBoard/page?p1=1&p2=<%=fbcurrentPage-1 %>"> &lt; </a>
				<%} %>
				
				
				<% for(int i= fbstartPage; i<= fbendPage; i++) { %>
					<%if(i==fbcurrentPage){ %>
						<a class="btn btn-sm btn-outline-success"><%=i%></a>
					<%} else {%>
						<a class="btn btn-sm btn-outline-success" href="<%=contextPath%>/freeBoard/page?p1=1&p2=<%=i%>"><%=i%></a>
					<%} %>
				<%} %>
				
				
				<%if(fbcurrentPage != fbmaxPage){ %>
					<a class="btn btn-sm btn-outline-success" href="<%=contextPath%>/freeBoard/page?p1=1&p2=<%=fbcurrentPage+1 %>"> &gt; </a>
				<%} %> 
				
				
				
			</div>

			
			<div id="tradeBoard-2" >
				
				
				<c:if test="${empty loginMember}">
					<input class="btn btn-outline-success" type="button" value="중고거래 글 작성하기" data-bs-toggle= data-bs-target="" onclick="alert('로그인 후 작성 가능합니다.')">
				</c:if>
				
				<c:if test="${not empty loginMember}">
					<input class="btn btn-outline-success" type="button" value="중고거래 글 작성하기" data-bs-toggle="modal" data-bs-target="#tradeWrite">
				</c:if>
			</div>

		</div>
		


		
		<!-- 자유게시판 이동 -->
		
		<div id="freeBoard" class="container">
			<p class="tradeBoard-title" >자유게시판</p>
			
			<p class="tradeBoard-title-2"> 자유게시판 인기글 목록 </p>
			
			<div id="freeBoard-1" class="container">


				<!-- el문으로 -->
				<c:forEach items="${fMainList}" var="flist">
							<div class="freeBoard-1-story">
								<a href="<%=contextPath %>/freeBoard/detail?num=${flist.no}" class="freeBoard-1-story-outer">
									<p id="freeBoard-1-pcontent">${flist.content}</p>
									<p class="freeBoard-story-date">${flist.enrollDate}</p>
									<span class="freeBoard-story-count" >
										<span><img src="<%=contextPath %>/resource/img/freeBoardTrade/views.png" alt="이미지"" style="height:100%;">    ${flist.cnt}</span>
									</span>
								</a>
							</div>
				</c:forEach>

			</div>


			<div class="Board-table-outer" class="container">
				
				<table id="Borad-table-main" class="container">

					<thead>
						<tr>
							<td>번호</td>
							<td>제목</td>
							<td>내용</td>
							<td>조회수</td>
							<td>작성일</td>
						</tr>
					</thead>
					
					<!-- 자유게시판 글 전부 가져와서 보여주기 -->
					<c:forEach items ="${fvoList}" var="fb">
					
						<tbody>
							
								<tr>
									<td>${fb.no}</td>
									<td class="fb-tr-Title">${fb.title}</td>
									<td class="fb-tr-Content">${fb.content}</td>
									<td>${fb.cnt}</td>
									<td>
										<fm:parseDate value="${fb.enrollDate}" var="enrollDate" pattern="yyyy-MM-dd HH:mm:ss"></fm:parseDate>
										<fm:formatDate value="${enrollDate}" pattern="yyyy년 MM월 dd일" />
									</td>
								</tr>
							
						</tbody>
						
					</c:forEach>

				</table>
			</div>



			<div class="fb-page-area">

				
				<%if(fcurrentPage != 1){ %>
					<a class="btn btn-sm btn-outline-success" href="<%=contextPath %>/freeBoard/page?p1=<%=fcurrentPage-1 %>&p2=1"> &lt; </a>
				<%} %>
				
				
				<% for(int i= fstartPage; i<= fendPage; i++) { %>
					<%if(i==fcurrentPage){ %>
						<a class="btn btn-sm btn-outline-success"><%=i%></a>
					<%} else {%>
						<a class="btn btn-sm btn-outline-success" href="<%=contextPath %>/freeBoard/page?p1=<%=i%>&p2=1"><%=i%></a>
					<%} %>
				<%} %>
				
				
				<%if(fcurrentPage != fmaxPage){ %>
					<a class="btn btn-sm btn-outline-success" href="<%=contextPath %>/freeBoard/page?p1=<%=fcurrentPage+1 %>&p2=1"> &gt; </a>
				<%} %> 
			</div>


			<div id="freeBoard-2" >
				
				<!-- 로그인 여부에 따라 버튼 기능 차이 -->
				<c:if test="${empty loginMember}">
					<input class="btn btn-outline-success" type="button" value="자유게시판 글 작성하기" onclick="alert('로그인 후 작성 가능합니다.')">
				</c:if>
				
				<c:if test="${not empty loginMember}">
					<input class="btn btn-outline-success" type="button" value="자유게시판 글 작성하기" data-bs-toggle="modal" data-bs-target="#freeBoardWrite">
				</c:if>
				
			</div>
			
			
		</div>


	<script>
		$(function(){
			$('#Borad-table-main>tbody>tr').click(function(){
				
				const num = $(this).children().eq(0).text();

				location.href='<%=contextPath%>/freeBoard/detail?num='+num;
			});
		})
	</script>
	<script>
		$(function(){
			$('#Board-table-outer-main>tbody>tr').click(function(){
				//행 클릭 되었을 때, 동작할 내용
				
				//1.글 번호 가져오기
				//현재 tr에서 자식중에 첫 번째 요소의 text를 가져온다.
				const num2 = $(this).children().eq(0).text();

				//2.해당번호로 요청 보내기
				//상세페이지 보여주는 서블릿에게 요청보내기 쿼리스트링과 함께
				location.href='<%=contextPath%>/freeBoard/trade/detail?num2='+num2;
			});
		})
	
	</script>







	</div><!-- body 끝 -->

	<%@include file="/views/common/footer.jsp" %>
	
	
	<!-- 중고거래 작성 모달 The Modal -->
	<div class="modal" id="tradeWrite" data-bs-backdrop="static" data-bs-keyboard="false">
	  <div class="modal-dialog modal-xl modal-dialog-centered">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title display-6 style="color: brown; ">중고거래 게시판 글 작성하기</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	      
			<!-- 등록하기 누르면 submit-등록 요청으로  -->	      
	        <form action="<%=contextPath %>/freeBoard/trade/insert" method="post" enctype="multipart/form-data">
			  <div class="mb-3 mt-3 input-group-lg">
			  
			  	<input type="hidden" name="fbt-writerNo" value="${loginMember.no }">
			    <label for="trade-img" class="form-label" ><mark>이미지 선택하기</mark></label>
			    <input type="file" class="form-control" id="trade-img" placeholder="이미지를 선택해주세요" name="fbt-img" >
			  </div>
			  <div class="mb-3 mt-3 input-group-lg">
			    <label for="trade-title" class="form-label"><mark>글제목</mark></label>
			    <input type="text" class="form-control" id="trade-title" placeholder="제목을 입력하세요" name="fbt-title">
			  </div>
			  
			  <label for="trade-price" class="form-label"><mark>희망가격</mark></label><br>
			  <div class="mb-3 input-group input-group-lg">
				<span class="input-group-text">희망가격</span>
				<input type="number" class="form-control" id="trade-price" placeholder="'원'단위로 입력해주세요" name="fbt-price">
			  </div>
			  <div class="mb-3 mt-3 input-group-lg">
			    <label for="trade-comment" ><mark>글 내용</mark></label>
				<textarea class="form-control" rows="5" id="trade-comment" name="fbt-content"></textarea>
			  </div>
			  	
		      <!-- Modal footer -->
		      <div class="modal-footer">
		        <input type="submit" class="btn btn-success" value="등록하기" >
		        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">취소하기</button>
		      </div>
		      
			</form>
			
			
	      </div>
	
	
	    </div>
	  </div>
	</div>
	
	
	
	
	<!-- 자유게시판 작성 모달 The Modal -->
	<div class="modal" id="freeBoardWrite" data-bs-backdrop="static" data-bs-keyboard="false">
	  <div class="modal-dialog modal-xl modal-dialog-centered">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="modal-title display-6" style="color: brown;">자유게시판 글 작성하기</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	      
	      
	        <form action="<%=contextPath %>/freeBoard/insert" method="post">
	  			<div class="mb-3 mt-3 input-group-lg">
	  			
	  				<!-- value값 로그인멤버 번호로 변경하기 -->
	  				<input type="hidden" name="fb-writerNo" value="${loginMember.no}">
			    	<label for="fb-title" class="form-label h3"><mark>글제목</mark></label>
			    	<input type="text" class="form-control" id="fb-title" placeholder="제목을 입력하세요" name="fb-title">
				</div>
				
			 	<div class="mb-3 mt-3 input-group-lg">
			    	<label for="fb-content" class="h3"><mark>글 내용</mark></label>
			    	<textarea class="form-control" rows="5" id="fb-content" placeholder="내용을 입력하세요" name="fb-content"></textarea>
				</div>
			  	
		      <!-- Modal footer -->
		      <div class="modal-footer">
		        <input type="submit" class="btn btn-success" value="등록하기" >
		        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">취소하기</button>
		      </div>
			</form>
			
			
	      </div>
	
	
	    </div>
	  </div>
	</div>
	
	
	
	
	
	
	
	
</body>
</html>