<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>자유게시판</title>
<style>
	
	 <%@ include file="/resource/css/gsFreeB.css" %>

</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	
	<h1>여기다가 자유게시판 </h1>
	
	<div id="freeboard-outer">

		<div id="fb1">
			<p class="fb1-title">중고거래</p>
			<div id="fb1-1">
				

				<div class ="menu-items">
					<a href="누르면 연결될 상세페이지">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest3.jpg" alt=""></div>
						<div id="fb1-comment-outer" >
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>

				<div class ="menu-items">
					<a href="누르면 연결될 상세페이지">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest2.jpg" alt=""></div>
						<div>
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>

				<div class ="menu-items">
					<a href="누르면 연결될 상세페이지">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest2.jpg" alt=""></div>
						<div>
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>

				<div class ="menu-items">
					<a href="누르면 연결될 상세페이지">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest1.jpg" alt=""></div>
						<div>
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>

				<div class ="menu-items">
					<a href="누르면 연결될 상세페이지">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest3.jpg" alt=""></div>
						<div>
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>

				<div class ="menu-items">
					<a href="누르면 연결될 상세페이지">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest1.jpg" alt=""></div>
						<div>
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>

				<div class ="menu-items">
					<a href="누르면 연결될 상세페이지">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest2.jpg" alt=""></div>
						<div>
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>

				<div class ="menu-items">
					<a href="누르면 연결될 상세페이지">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest2.jpg" alt=""></div>
						<div>
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>

				<div class ="menu-items">
					<a href="누르면 연결될 상세페이지">
						<div id="fb1-img-outer"><img src="<%=contextPath %>/resource/img/gsTest2.jpg" alt=""></div>
						<div>
							<div class="fb1-comment-outer"><span>거래물품제목쓰는곳</span></div>
							<p id="fb1-subtitle1">서울 종로구 관철동</p>
							<p id="fb1-subtitle2">130만원</p>
						</div>
					</a>
				</div>

				
				
			</div>

			<div id="fb1-2" onclick=""><input class="btn btn-outline-success" type="button" value="중고거래 글 작성하기" data-bs-toggle="modal" data-bs-target="#tradeWrite"></div>

		</div>
		



		<div id="fb2">
			<p class="fb1-title" >자유게시판</p>
			<div id="fb2-1">


				<div class="fb2-1-story">
					<a href="" class="fb2-1-story-outer">
						<p style="font-size: 3rem;">글내용작성하는 곳</p>
						<p class="fb2-story-date">작성일 보여주기</p>
						<span class="fb2-story-count" >
							<span><img src="" alt="이미지">"조회수 : "</span>
						</span>
					</a>
				</div>



				<div class="fb2-1-story">
					<a href="" class="fb2-1-story-outer">
						<p style="font-size: 3rem;">글내용작성하는 곳</p>
						<p class="fb2-story-date">작성일 보여주기</p>
						<span class="fb2-story-count" >
							<span><img src="" alt="이미지">"조회수 : "</span>
						</span>
					</a>
				</div>


				<div class="fb2-1-story">
					<a href="" class="fb2-1-story-outer">
						<p style="font-size: 3rem;">글내용작성하는 곳</p>
						<p class="fb2-story-date">작성일 보여주기</p>
						<span class="fb2-story-count" >
							<span><img src="" alt="이미지">"조회수 : "</span>
						</span>
					</a>
				</div>



				<div class="fb2-1-story">
					<a href="" class="fb2-1-story-outer">
						<p style="font-size: 3rem;">글내용작성하는 곳</p>
						<p class="fb2-story-date">작성일 보여주기</p>
						<span class="fb2-story-count" >
							<span><img src="" alt="이미지">"조회수 : "</span>
						</span>
					</a>
				</div>

				







			</div>

			<div id="fb2-2" onclick=""><input class="btn btn-outline-success" type="button" value="자유게시판 글 작성하기" data-bs-toggle="modal" data-bs-target="#freeBoardWrite"></div>
			
			
		</div>










	</div><!-- 끝 -->

	
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
	      
	      
	        <form action="" method="post">
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
	      
	      
	        <form action="" method="post">
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