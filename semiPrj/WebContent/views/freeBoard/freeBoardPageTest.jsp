
<%@page import="com.kh.freeboard.vo.FreeBoardTradeVo"%>
<%@page import="com.kh.common.PageVo"%>
<%@page import="com.kh.freeboard.vo.FreeBoardVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%
	List<FreeBoardVo> fvoList = (List<FreeBoardVo>)request.getAttribute("fvoList");
	PageVo fpageVo = (PageVo)request.getAttribute("fpageVo");
	
	List<FreeBoardTradeVo> fbvoList = (List<FreeBoardTradeVo>)request.getAttribute("fbvoList");
	PageVo fbpageVo = (PageVo)request.getAttribute("fbpageVo");

	List<FreeBoardVo> fMainList = (List<FreeBoardVo>)request.getAttribute("fMainList");
	List<FreeBoardTradeVo> fbMainList = (List<FreeBoardTradeVo>)request.getAttribute("fbMainList");
	
	
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
	
	<div id="freeboard-outer" class="container">

		<div id="fb1" class="container">
			<p class="fb1-title">중고거래</p>
			
			
			<p class="fb1-title-2">중고거래 인기글 </p>
			
			
			<div id="fb1-1" class="container">
				
				
			
				<%for(FreeBoardTradeVo fblist : fbMainList) { %>
					<div class ="menu-items">
					<a href="<%=contextPath %>/views/freeboard/trade/detail?num=<%=fblist.getNo() %>">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest2.jpg" alt=""></div>
						<div>
							<div class="fb1-comment-outer"><span><%=fblist.getTitle() %></span></div>
							<p id="fb1-subtitle1"><%=fblist.getWriter() %></p>
							<p id="fb1-subtitle2"><%=fblist.getPrice() %>원</p>
						</div>
					</a>
				</div>
				<%} %>


				

				

			</div>


			<div class="fb1-3" class="container">
				
				<table id="fb-table-main" class="container">

					<thead>
						<tr>
							<th>글번호</th>
							<th>글제목</th>
							<th>작성자</th>
							<th>조회수</th>
							<th>작성일</th>
						</tr>
					</thead>

					<%for(FreeBoardTradeVo fbvo : fbvoList) {%>
					
						<tbody>
							
								<tr>
									<td><%=fbvo.getNo() %></td>
									<td><%=fbvo.getTitle() %></td>
									<td><%=fbvo.getContent() %></td>
									<td><%=fbvo.getWriter() %></td>
									<td><%=fbvo.getEnrollDate() %></td>
								</tr>
							
						</tbody>
					<%} %>
					
					
					


				</table>
				
			
			</div>





			<div class="fb-page-area">

				<a class="btn btn-outline-success btn-sm" href="">1</a>
				<a class="btn btn-outline-success btn-sm" href="">1</a>
				<a class="btn btn-outline-success btn-sm" href="">1</a>
				<a class="btn btn-outline-success btn-sm" href="">1</a>
				<a class="btn btn-outline-success btn-sm" href="">1</a>

				<%if(fbcurrentPage != 1){ %>
					<a class="btn btn-sm btn-primary" href="<%=contextPath %>/freeBoard/page?p2=<%=fbcurrentPage-1 %>"> &lt; </a>
				<%} %>
				
				
				<% for(int i= fbstartPage; i<= fbendPage; i++) { %>
					<%if(i==fbcurrentPage){ %>
						<a class="btn btn-sm btn-primary"><%=i%></a>
					<%} else {%>
						<a class="btn btn-sm btn-primary" href="<%=contextPath%>/freeBoard/page?p2=<%=i%>"><%=i%></a>
					<%} %>
				<%} %>
				
				
				<%if(fbcurrentPage != fbmaxPage){ %>
					<a class="btn btn-sm btn-primary" href="<%=contextPath%>/freeBoard/page?p2=<%=fbcurrentPage+1 %>"> &gt; </a>
				<%} %> 
				
				
				
			</div>

			<!-- 밑에거 이상하며 이거 살려서 다시 작업하기 <div id="fb1-2" ><input class="btn btn-outline-success" type="button" onclick="checkLogin()" value="중고거래 글 작성하기" data-bs-toggle="modal" data-bs-target="#tradeWrite"></div> -->
			
			<div id="fb1-2" >
				<!-- 나중에 != 으로 체인지  -->
				<% if(loginMember == null) { %>
				<input class="btn btn-outline-success" type="button" value="중고거래 글 작성하기" data-bs-toggle="modal" data-bs-target="#tradeWrite">
				<%} else {%>
				<input class="btn btn-outline-success" type="button" value="중고거래 글 작성하기" data-bs-toggle= data-bs-target="">
				<%} %>
			</div>

		</div>
		


		
		<!-- 자유게시판 이동 -->
		
		<div id="fb2" class="container">
			<p class="fb1-title" >자유게시판</p>
			
			<p class="fb1-title-2"> 자유게시판 인기글 목록 </p>
			
			<div id="fb2-1" class="container">


				


				<%for(FreeBoardVo flist : fMainList) { %>
					<div class="fb2-1-story">
						<a href="<%=contextPath %>/freeboard/detail?num=<%=flist.getNo()%>" class="fb2-1-story-outer">
							<p style="font-size: 3rem;"><%=flist.getContent() %></p>
							<p class="fb2-story-date"><%=flist.getEnrollDate() %></p>
							<span class="fb2-story-count" >
								<span><img src="" alt="이미지">"조회수 : "<%=flist.getCnt() %></span>
							</span>
						</a>
					</div>
				<%} %>



			</div>


			<div class="fb1-3" class="container">
				
				<table id="f-table-main" class="container">

					<thead>
						<tr>
							<td>글번호</td>
							<td>글제목</td>
							<td>작성자</td>
							<td>조회수</td>
							<td>작성일</td>
						</tr>
					</thead>
					<%for(FreeBoardVo fb : fvoList) {%>
						
						<tbody>
							
								<tr>
									<td><%= fb.getNo() %></td>
									<td><%= fb.getTitle() %></td>
									<td><%= fb.getContent() %></td>
									<td><%= fb.getWriter() %></td>
									<td><%= fb.getEnrollDate() %></td>
								</tr>
							
						</tbody>
					<%} %>
					

				</table>
			</div>



			<div class="fb-page-area">

				
				<%if(fcurrentPage != 1){ %>
					<a class="btn btn-sm btn-primary" href="<%=contextPath %>/freeBoard/page?p1=<%=fcurrentPage-1 %>"> &lt; </a>
				<%} %>
				
				
				<% for(int i= fstartPage; i<= fendPage; i++) { %>
					<%if(i==fcurrentPage){ %>
						<a class="btn btn-sm btn-primary"><%=i%></a>
					<%} else {%>
						<a class="btn btn-sm btn-primary" href="<%=contextPath %>/freeBoard/page?p1=<%=i%>"><%=i%></a>
					<%} %>
				<%} %>
				
				
				<%if(fcurrentPage != fmaxPage){ %>
					<a class="btn btn-sm btn-primary" href="<%=contextPath %>/freeBoard/page?p1=<%=fcurrentPage+1 %>"> &gt; </a>
				<%} %> 
			</div>


			<div id="fb2-2" >
				<!-- <input class="btn btn-outline-success" type="button" onclick="" value="자유게시판 글 작성하기" data-bs-toggle="modal" data-bs-target="#freeBoardWrite"> -->
				
				<!-- 나중에 != 으로 체인지  -->
				<% if(loginMember == null) { %>
					<input class="btn btn-outline-success" type="button" value="자유게시판 글 작성하기" data-bs-toggle="modal" data-bs-target="#tradeWrite">
				<%} else {%>
					<input class="btn btn-outline-success" type="button" value="자유게시판 글 작성하기" data-bs-toggle= data-bs-target="">
				<%} %>
			</div>
			
			
		</div>


	<script>
		$(function(){
			$('#f-table-main>tbody>tr').click(function(){
				
				const num = $(this).children().eq(0).text();

				location.href='<%=contextPath%>/freeboard/detail?num='+num;
			});
		})
	</script>
	<script>
		$(function(){
			$('#fb-table-main>tbody>tr').click(function(){
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
	        <form action="<%=contextPath %>/freeboard/trade/insert" method="post">
			  <div class="mb-3 mt-3 input-group-lg">
			    <label for="trade-img" class="form-label" ><mark>이미지 선택하기</mark></label>
			    <input type="file" class="form-control" id="trade-img" placeholder="이미지를 선택해주세요" name="trade-img">
			  </div>
			  <div class="mb-3 mt-3 input-group-lg">
			    <label for="trade-title" class="form-label"><mark>글제목</mark></label>
			    <input type="text" class="form-control" id="trade-title" placeholder="제목을 입력하세요" name="trade-title">
			  </div>
			  
			  <label for="trade-price" class="form-label"><mark>희망가격</mark></label><br>
			  <div class="mb-3 input-group input-group-lg">
				<span class="input-group-text">희망가격</span>
				<input type="number" class="form-control" id="trade-price" placeholder="'원'단위로 입력해주세요" name="trade-price">
			  </div>
			  <div class="mb-3 mt-3 input-group-lg">
			    <label for="trade-comment" ><mark>글 내용</mark></label>
				<textarea class="form-control" rows="5" id="trade-comment" name="trade-comment"></textarea>
			  </div>
			  	
			</form>
			
			
	      </div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <input type="submit" class="btn btn-success" value="등록하기" onclick="return checkWrite();">
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">취소하기</button>
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
	      
	      
	        <form action="<%=contextPath %>/freeboard/insert" method="post">
	  			<div class="mb-3 mt-3 input-group-lg">
			    	<label for="fb-title" class="form-label h3"><mark>글제목</mark></label>
			    	<input type="text" class="form-control" id="fb-title" placeholder="제목을 입력하세요" name="fb-title">
				</div>
				
			 	<div class="mb-3 mt-3 input-group-lg">
			    	<label for="fb-content" class="h3"><mark>글 내용</mark></label>
			    	<textarea class="form-control" rows="5" id="fb-content" placeholder="내용을 입력하세요" name="fb-content"></textarea>
				</div>
			  	
			</form>
			
			
	      </div>
	
	      <!-- Modal footer -->
	      <div class="modal-footer">
	        <input type="submit" class="btn btn-success" value="등록하기" onclick="return checkWrite();">
	        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">취소하기</button>
	      </div>
	
	    </div>
	  </div>
	</div>
	
	
	
	
	
	
	
	
</body>
</html>