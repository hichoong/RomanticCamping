<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>낭만캠프</title>
<link rel="stylesheet" href="../../resource/css/campDetailRequest.css">
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>
	
	
	<h2>캠핑장 요청</h2>

    <div class="container">

        <div class="contentBox">
            <div class="content">
                <img class="testImg" src="../../resource/img/gsTest2.jpg">
                <div class="mb-4">
                    <span>캠핑장 : 단호박 캠핑장</span>
                    <br><br>
                    <span>연락처</span> : 02) 000-0000</span>
                    <br><br>
                    <span>주소 : 경기 포천시 신북면 간자동길 138-100</span>
                    <br><br>
                    <span>시설 안내 : 2인실, 오토캠핑, 데크 파쇄석, 글램핑, 공용시설, 반려동물, 바비큐장, 계곡 ...</span>
                </div>
            </div>
            <div id="btn">
                <button class="btn btn-warning" onClick="location.href='http://127.0.0.1:8803/semiPrj/views/campRequest/campRequestForm.jsp'">상세보기</button>
            </div>
        </div>

        <div class="contentBox">
            <div class="content">
                <img class="testImg" src="../../resource/img/gsTest2.jpg">
                <div class="mb-4">
                    <span>캠핑장 : 고구마 캠핑장</span>
                    <br><br>
                    <span>연락처 : 02) 000-0000</span>
                    <br><br>
                    <span>주소 : 인천 서구 첨단서로 190 청라 해변 공원 캠핑장</span>
                    <br><br>
                    <span>시설 안내 : 오토캠핑, 카라반, 파쇄석, 데크, 와이파이, 바비큐장, 공용시설, 글램핑 ...</span>
                </div>
            </div>
            <div id="btn">
                <button class="btn btn-warning">상세보기</button>
            </div>
        </div>

        <!-- 페이지네이션 -->
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>

    </div>


	
	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>