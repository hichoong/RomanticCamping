<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	#freeboard-outer{
		border: 1px solid red;
        height: 2000px;
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
		height: 50%;
		border: 1px solid pink;
	}

	.make-reple{
		width: 100%;
		height: 50%;
		border: 1px solid pink;
	}
		
</style>
</head>
<body>

<%@ include file="/views/common/header.jsp" %>	
	
	<h1> 여기는 중고거래게시판 상세보기 게시판</h1>
	<div id="freeboard-outer" class="container">


		

		<!-- 선추가 -->
		<div class="fbt-top-line"></div>


		<div id="d7-d" class="container">

			<div id="fbt-div-outer">

				<div id="fbt-left-div">
					<div id="userId" >작성자 : 행운목</div>
					<div id="userGrade">회원등급 : 골드회원</div>
				</div>



				<div id="fbt-right-div">
					<div id="count">조회수 : 5186</div>
					<div id="update_date"> 작성일자 : 0000-00-00</div>
				</div>

			</div>

		</div>

		<!-- 선추가 -->
		<div class="fbt-top-line"></div>

		<div id="d8-d" class="container">


					<p style="font-size: 3rem;">글제목 보여주는 곳</p>
					<textarea style="font-size: 2rem;" class="fb2-story-content" name="" id="" >글 내용 보여주는 곳 durldp이렇게 엔터키를 치면 어캐보이는지? 
					</textarea>
					<p class="fb2-story-date">작성시간 :</p>
					<p class="fb2-story-date">조회 수 :</p>
					<p class="fb2-story-date">등등</p>
			
			

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
			<div class="select-reple">

				<div class="reple-id"><p >작성자 id</p></div>
				<div class="reple-comment"><p >작성내용 </p></div>
				<div class="reple-sub"><span>작성일자</span> <a>답글쓰기</a></div>

			</div>
			
		
			<!-- 선추가 -->
			<div class="fbt-top-line"></div>
			<!-- 내가 댓글작성하기 -->
			<div class="make-reple"><p>내가 댓글작성하는 공간</p></div>
			
		</div>




		
	</div>

	</div>


</body>
</html>