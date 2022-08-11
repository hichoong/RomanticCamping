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

</style>
</head>
<body>
    <%@ include file="/views/common/header.jsp" %>

    <div class="container">
        <ul id="sub-nav" class="list-group">
            <a href="#" class="list-group-item list-group-item-action">게시글</a>
            <a href="#" class="list-group-item list-group-item-action">캠핑 리뷰</a>
            <a href="#" class="list-group-item list-group-item-action">문의사항</a>
        </ul>
    
        <div class="outer">
    
            <div class="contentBox clickBox">
                <div class="flexstyle-sb">
                    <span>제목 : <strong>겨울캠핑 추천</strong></span>
                    <span>작성일자 : <strong>2022-08-09 00:00</strong></span>
                </div>
                <span>내용 : <strong>~~~~ 한 100글자 정도만... 게시글 볼때 나오는 div</strong></span>
            </div>

            <div class="contentBox clickBox">
                <div class="flexstyle-sb">
                    <span>별점 : ★★★★</span>
                    <span>작성일자 : <strong>2022-08-09 00:00</strong></span>
                </div>
                <span>리뷰 내용 : <strong>이거는 리뷰볼때 나오는 div...</strong></span>
            </div>

            <div class="contentBox clickBox">
                <div class="flexstyle-sb">
                    <span>제목 : <strong>문의 제목</strong></span>
                    <span>문의일자 : <strong>2022-08-09 00:00</strong></span>
                </div>
                <div class="flexstyle-sb">
                    <span>답변여부 : <strong>Y</strong></span>
                </div>
                <span>내용 : <strong>문의 내용이 들어있는.....</strong></span>
            </div>


            <ul class="pagination mt-4">
                <li class="page-item"><a class="page-link" href="#">Previous</a></li>
                <li class="page-item"><a class="page-link" href="#">1</a></li>
                <li class="page-item"><a class="page-link" href="#">2</a></li>
                <li class="page-item"><a class="page-link" href="#">3</a></li>
                <li class="page-item"><a class="page-link" href="#">Next</a></li>
              </ul>
        </div>
    </div>

    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>