
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    
<%-- <%
	여기는 페이징 좀 하고 ㅊ리 MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
	List<FreeBoardVo> fbvoList = (Lists<FreeBoardVo>)request.getAttribute("list");
	
	PageVo pv = (PageVo)request.getAttribute("pv");

	int currentPage = pv.getCurrentpage();
	int startPage = pv.getStartPage();
	int endPage = pv.getEndPage();
	int maxPage = pv.getMaxPage();
 	
 %>  --%>   
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
	
	<h1>여기다가 자유게시판 </h1>
	<a href="<%=contextPath%>/freeBoard/page?p1=1&p2=1">테스트 링크 </a>
	
	
	
	<!-- href링크는 게시글 번호로 그 번호에 맞는 상세페이지로 이동시키기 -->
	
	<div id="freeboard-outer" class="container">

		<div id="fb1" class="container">
			<p class="fb1-title">중고거래</p>
			
			
			<p class="fb1-title-2">중고거래 인기글 </p>
			
			
			<div id="fb1-1" class="container">
				
				
				<div class ="menu-items">
					<a href="<%=contextPath %>/views/freeBoard/TradeDetail.jsp">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest3.jpg" alt=""></div>
						<div id="fb1-comment-outer" >
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>

				<div class ="menu-items">
					<a href="<%=contextPath %>/views/freeBoard/TradeDetail.jsp">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest2.jpg" alt=""></div>
						<div>
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>

				<div class ="menu-items">
					<a href="<%=contextPath %>/views/freeBoard/TradeDetail.jsp">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest2.jpg" alt=""></div>
						<div>
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>

				<div class ="menu-items">
					<a href="<%=contextPath %>/views/freeBoard/TradeDetail.jsp">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest1.jpg" alt=""></div>
						<div>
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>

				<div class ="menu-items">
					<a href="<%=contextPath %>/views/freeBoard/TradeDetail.jsp">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest3.jpg" alt=""></div>
						<div>
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>

				<div class ="menu-items">
					<a href="<%=contextPath %>/views/freeBoard/TradeDetail.jsp">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest1.jpg" alt=""></div>
						<div>
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>
				

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

					<%-- 여기도 셀렉트 쿼리한다음 처리 <%for(FreeBoardTradeVo fbvo : fbvoList) {%>
					
						<tbody>
							
								<tr>
									<td><%=fbvo.getNo() %>B_NO</td>
									<td><%=fbvo.getTitle() %>B_TITLE</td>
									<td><%=fbvo.getContent() %>B_CONTENT</td>
									<td><%=fbvo.getWriter() %>BOARD_WRITER</td>
									<td><%=fbvo.getEnrollDate() %>UPDATE_DATE</td>
								</tr>
							
						</tbody>
					<%} %> --%>
					<tbody>
						
						<tr>
							<td>B_NO</td>
							<td>B_TITLE</td>
							<td>B_CONTENT</td>
							<td>BOARD_WRITER</td>
							<td>UPDATE_DATE</td>
						</tr>
					
					</tbody>
					<tbody>
							
						<tr>
							<td>B_NO</td>
							<td>B_TITLE</td>
							<td>B_CONTENT</td>
							<td>BOARD_WRITER</td>
							<td>UPDATE_DATE</td>
						</tr>
					
					</tbody>
					<tbody>
							
						<tr>
							<td>B_NO</td>
							<td>B_TITLE</td>
							<td>B_CONTENT</td>
							<td>BOARD_WRITER</td>
							<td>UPDATE_DATE</td>
						</tr>
					
					</tbody>
					<tbody>
							
						<tr>
							<td>B_NO</td>
							<td>B_TITLE</td>
							<td>B_CONTENT</td>
							<td>BOARD_WRITER</td>
							<td>UPDATE_DATE</td>
						</tr>
					
					</tbody>


				</table>
				
			
			</div>


			<div class="fb-page-area">

				<a class="btn btn-outline-success btn-sm" href="">1</a>
				<a class="btn btn-outline-success btn-sm" href="">1</a>
				<a class="btn btn-outline-success btn-sm" href="">1</a>
				<a class="btn btn-outline-success btn-sm" href="">1</a>
				<a class="btn btn-outline-success btn-sm" href="">1</a>

				<%-- 페이징 처리하고 나서 처리 <%if(currentPage != 1){ %>
					<a class="btn btn-sm btn-primary" href="<%=contextPath %>/freeBoard/list?p=<%=currentPage-1 %>"> &lt; </a>
				<%} %>
				
				<% for(int i= startPage; i<= endPage; i++) { %>
					<%if(i==currentPage){ %>
						<a class="btn btn-sm btn-primary"><%=i%></a>
					<%} else {%>
						<a class="btn btn-sm btn-primary" href="<%=contextPath%>/board/list?p=<%=i%>"><%=i%></a>
					<%} %>
				<%} %>
				
				<%if(currentPage != maxPage){ %>
					<a class="btn btn-sm btn-primary" href="/semi/board/list?p=<%=currentPage+1 %>"> &gt; </a>
				<%} %> --%>
				
				
				
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


				<div class="fb2-1-story">
					<a href="<%=contextPath %>/views/freeBoard/freeBoardDetail.jsp" class="fb2-1-story-outer">
						<p style="font-size: 3rem;">글내용작성하는 곳</p>
						<p class="fb2-story-date">작성일 보여주기</p>
						<span class="fb2-story-count" >
							<span><img src="" alt="이미지">"조회수 : "</span>
						</span>
					</a>
				</div>



				<div class="fb2-1-story">
					<a href="<%=contextPath %>/views/freeBoard/freeBoardDetail.jsp" class="fb2-1-story-outer">
						<p style="font-size: 3rem;">글내용작성하는 곳</p>
						<p class="fb2-story-date">작성일 보여주기</p>
						<span class="fb2-story-count" >
							<span><img src="" alt="이미지">"조회수 : "</span>
						</span>
					</a>
				</div>


				<div class="fb2-1-story">
					<a href="<%=contextPath %>/views/freeBoard/freeBoardDetail.jsp" class="fb2-1-story-outer">
						<p style="font-size: 3rem;">글내용작성하는 곳</p>
						<p class="fb2-story-date">작성일 보여주기</p>
						<span class="fb2-story-count" >
							<span><img src="" alt="이미지">"조회수 : "</span>
						</span>
					</a>
				</div>



				<div class="fb2-1-story">
					<a href="<%=contextPath %>/views/freeBoard/freeBoardDetail.jsp" class="fb2-1-story-outer">
						<p style="font-size: 3rem;">글내용작성하는 곳</p>
						<p class="fb2-story-date">작성일 보여주기</p>
						<span class="fb2-story-count" >
							<span><img src="" alt="이미지">"조회수 : "</span>
						</span>
					</a>
				</div>

				







			</div>

			<div class="fb1-3" class="container">
				
				<table id="fb-table-main" class="container">

					<thead>
						<tr>
							<td>글번호</td>
							<td>글제목</td>
							<td>작성자</td>
							<td>조회수</td>
							<td>작성일</td>
						</tr>
					</thead>

					<tbody>
						
							<tr>
								<td>B_NO</td>
								<td>B_TITLE</td>
								<td>B_CONTENT</td>
								<td>BOARD_WRITER</td>
								<td>UPDATE_DATE</td>
							</tr>
						
					</tbody>
					<tbody>
						
						<tr>
							<td>B_NO</td>
							<td>B_TITLE</td>
							<td>B_CONTENT</td>
							<td>BOARD_WRITER</td>
							<td>UPDATE_DATE</td>
						</tr>
					
					</tbody>
					<tbody>
							
						<tr>
							<td>B_NO</td>
							<td>B_TITLE</td>
							<td>B_CONTENT</td>
							<td>BOARD_WRITER</td>
							<td>UPDATE_DATE</td>
						</tr>
					
					</tbody>
					<tbody>
							
						<tr>
							<td>B_NO</td>
							<td>B_TITLE</td>
							<td>B_CONTENT</td>
							<td>BOARD_WRITER</td>
							<td>UPDATE_DATE</td>
						</tr>
					
					</tbody>
					<tbody>
							
						<tr>
							<td>B_NO</td>
							<td>B_TITLE</td>
							<td>B_CONTENT</td>
							<td>BOARD_WRITER</td>
							<td>UPDATE_DATE</td>
						</tr>
					
					</tbody>


				</table>
			</div>



			<div class="fb-page-area">

				<a class="btn btn-outline-success btn-sm" href="">1</a>
				<a class="btn btn-outline-success btn-sm" href="">1</a>
				<a class="btn btn-outline-success btn-sm" href="">1</a>
				<a class="btn btn-outline-success btn-sm" href="">1</a>
				<a class="btn btn-outline-success btn-sm" href="">1</a>

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










	</div><!-- 끝 -->

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