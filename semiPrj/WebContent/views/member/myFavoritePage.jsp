<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/memberCommon.css" type="text/css">
<title>낭만캠핑</title>
<style>
    
    .favoriteImg {
        width: 150px;
        height: 150px;
    }

    span {
        padding-right: 20px;
    }
    
    .content {
        display: flex;
    }

    .content>img {
        margin-right: 20px;
    }

</style>
</head>
<body>

    <%@ include file="/views/common/header.jsp" %>

    <div class="container">

        <h3 class="mb-4">찜목록</h3>

		<c:forEach items="${favoriteList}" var="favorite">
	        <div class="contentBox">
	            <div class="content">
	                <img class="favoriteImg" src="<%=request.getContextPath()%>/resource/img/test.jpg">
	                <div class="mb-4">
	                    <span>캠핑장 : ${favorite.campName}</span>
	                    <span>전화번호 : ${favorite.campPhone}</span>
	                    <br>
	                    <span>상세주소 : ${favorite.campAddress}</span>
	                    <br><br>
	                    <span>시설소개 : ${favorite.campIntro}</span>
	                </div>
	            </div>
	            <div class="location-right">
	                <button class="reversed-btn">캠핑장 바로가기</button>
	                <button class="reversed-btn" data-bs-toggle="modal" data-bs-target="#CancleWish" >찜삭제</button>
	            </div>
	        </div>
        </c:forEach>
        
        <c:if test="${ empty favoriteList }">
          	<div class="contentBox">
			    <div>
			        찜목록이 비어있습니다..
			    </div>
		    </div>
        </c:if>

    </div>

    <div class="modal fade" id="CancleWish" data-bs-backdrop="static" data-bs-keyboard="false">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="mb-3 location-center">
                        <p>정말 삭제 하시겠습니까?</p>
                    </div>

                    <div class="location-center">
                        <button type="submit" class="btn btn-success" onclick="">삭제하기</button>
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">돌아가기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="/views/common/footer.jsp" %>
    
</body>
</html>