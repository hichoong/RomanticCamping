<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>낭만캠핑</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/reviewInsertForm.css">
</head>
<body>
	
	<%@include file="/views/common/header.jsp" %>
	
	<div class="container">
        <section>
        
        	
            <div id="camp-info">
                <div class="card mb-3" style="max-width: 1000px;">
                    <div class="row no-gutters">
                      <div class="col-md-4">
                        <img src="${campInfoVo.campImgpath}" class="card-img" alt="캠핑장 대표이미지">
                      </div>
                      <div class="col-md-8">
                        <div class="card-body">
                          <h5 class="card-title">${campInfoVo.campName}</h5>
                          <p class="card-text">${campInfoVo.campIntro}</p>
                          <p class="card-text"><small class="text-muted"></small></p>
                        </div>
                      </div>
                    </div>
                </div>
            </div> 
            <form action="<%=contextPath%>/review/insert" method="post" id="review-write">
            	<input type="hidden" name="reservationNo" value="${param.reservationNo}">
            	<input type="hidden" name="campCode" value="${campInfoVo.campCode}">
                <div class="review-star">
                    <span class="text-bold">별점을 선택해주세요</span>
                    <input type="radio" name="reviewStar" value="5" id="rate1"><label
                        for="rate1">★</label>
                    <input type="radio" name="reviewStar" value="4" id="rate2"><label
                        for="rate2">★</label>
                    <input type="radio" name="reviewStar" value="3" id="rate3"><label
                        for="rate3">★</label>
                    <input type="radio" name="reviewStar" value="2" id="rate4"><label
                        for="rate4">★</label>
                    <input type="radio" name="reviewStar" value="1" id="rate5" checked><label
                        for="rate5">★</label>
                    
                </div>

                <textarea name="review-content" id="review-text" spellcheck="false" onfocus="this.value='';" >내용을 입력해주세요.</textarea>

                <div id="review-notice">
                    <span>리뷰 작성 시 유의사항</span> <br>
                    <span>
                        다음에 해당하는 리뷰는 삭제조치 될 수 있습니다.
                        <ul>
                            <li>캠핑장과 관련 없는 글</li>
                            <li>부적절한 글</li>
                            <li>타인에게 불쾌감을 조성하는 글</li>
                        </ul>
                    </span>
                </div>

                <input type="submit" value="리뷰 등록하기" id="review-insert" class="btn btn-warning">
                
            </form>

        </section>
    </div>
	
	
	<%@include file="/views/common/footer.jsp" %>
	
</body>
</html>