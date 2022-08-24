<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>낭만캠핑</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/memberCommon.css" type="text/css">
<style>
    #sub-nav {
        width: 120px;
        float: left;
        position: fixed;
    }

    .pagination {
        width: 80%;
        margin: auto;
        align-items: center;
        justify-content: center;
    }

    .pagination>li>a {
        border: 1px solid #FFA000;
        color: #FFA000;
    }

    .pagination>li>a:hover {
        border: 1px solid #FFA000;
        color: white;
        background-color: #FFA000;
    }

    .clickBox:hover {
        cursor: pointer;
    }

    .flexstyle-sb {
        display: flex;
        justify-content: space-between;
        padding-bottom: 2px;
    }
    
    .list-group-item.choice {
	    z-index: 2;
	    color: #fff;
	    background-color: ORANGE;
	    border-color: ORANGE;
	    pointer-events: none;
	}

</style>
</head>
<body>
    <%@ include file="/views/common/header.jsp" %>

    <div class="container">
        <ul id="sub-nav" class="list-group">
            <a href="<%=contextPath%>/member/userBoard?type=F" class="list-group-item list-group-item-action">자유게시판</a>
            <a href="<%=contextPath%>/member/userBoard?type=T" class="list-group-item list-group-item-action">중고거래</a>
            <a href="<%=contextPath%>/member/userBoard?type=R" class="list-group-item list-group-item-action">캠핑 리뷰</a>
            <a href="<%=contextPath%>/member/userBoard?type=Q" class="list-group-item list-group-item-action">문의사항</a>
        </ul>
    
        <div class="outer">
    
    		 <c:if test="${ status eq 'F'}">
    		 	<c:forEach items="${boardList}" var="board">
		            <div class="contentBox clickBox" onclick="location.href='<%=contextPath%>/freeBoard/detail?num=${board.no}'">
		                <div class="flexstyle-sb">
		                    <span>제목 : ${board.title}</span>
		                    <span>작성일자 : ${board.enrollDate}</span>
		                </div>
		                <span>내용 : ${board.content} ...</span>
		            </div>
	            </c:forEach>
    		 </c:if>

			<c:if test="${ status eq 'T' }">
    		 	<c:forEach items="${boardList}" var="board">
		            <div class="contentBox clickBox" onclick="location.href='<%=contextPath%>/freeBoard/trade/detail?num2=${board.no}'">
		                <div class="flexstyle-sb">
		                    <span>제목 : ${board.title}</span>
		                    <span>작성일자 : ${board.enrollDate}</span>
		                </div>
		                <span>내용 : ${board.content} ...</span>
		            </div>
	            </c:forEach>
    		 </c:if>

			 <c:if test="${ status eq 'R' }">
    		 	<c:forEach items="${boardList}" var="board">
		            <div class="contentBox">
		            	<div class="flexstyle-sb">
		            		<span>캠핑장 : ${board.campName}</span>
		                    <span>별점 : <c:forEach begin="1" end="${board.starScore}">★</c:forEach></span>
		                    <span>작성일자 : ${board.enrollDate}</span>
		                </div>
		                <span>리뷰 내용 : ${board.reviewContent} </span>
		                <div class="location-right">
		                	<button class="basic-btn" onclick="location.href='<%=contextPath%>/zone/list?campCode=${board.campCode}'">캠핑장 가기</button>
		                	<button class="basic-btn" onclick="location.href='<%=contextPath%>/review/edit?reservationNo=${board.reservationNo}'">리뷰 수정</button>
		                </div>
		            </div>
	            </c:forEach>
    		 </c:if>

			 <c:if test="${ status eq 'Q' }">
    		 	<c:forEach items="${boardList}" var="board">
		            <div class="contentBox clickBox" onclick="location.href='<%=contextPath%>/question/detail?num=${board.qNo}'">
		            	<div class="flexstyle-sb">
		                    <span>제목 : ${board.qTitle}</span>
		                    <span>문의일자 : ${board.qUpdateDate}</span>
		                </div>
		                <%-- <div class="flexstyle-sb">
		                    <span>답변여부 : <strong>${board.qAnswerYN}</strong></span>
		                </div> --%>
		                <span>내용 : ${board.qContent}</span>
		            </div>
	            </c:forEach>
    		 </c:if>
    		 
    		 <c:if test="${ empty boardList }">
            	<div class="contentBox">
				    <div>
				        작성한 글이 없습니다..
				    </div>
			    </div>
            </c:if>

            <!-- <ul class="pagination mt-4">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
              </ul> -->
              
        </div>
    </div>

    <%@ include file="/views/common/footer.jsp" %>

	<script>
    	if(${status eq 'F'}) {
    		$('#sub-nav>a:nth-child(1)').addClass("choice");
    	} else if(${status eq 'T'}) {
    		$('#sub-nav>a:nth-child(2)').addClass("choice");
    	}  else if(${status eq 'R'}) {
    		$('#sub-nav>a:nth-child(3)').addClass("choice");
    	}  else if(${status eq 'Q'}) {
    		$('#sub-nav>a:nth-child(4)').addClass("choice");
    	}
    	
    	
    </script>

</body>
</html>