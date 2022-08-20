<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>낭만캠핑</title>
<link rel="stylesheet" href="/semiPrj/resource/css/reviewInsertForm.css">
</head>
<body>
	
	<%@include file="/views/common/header.jsp" %>
	
	<div class="container">
        <section>
            <div id="camp-info">
                <div class="card mb-3" style="max-width: 1000px;">
                    <div class="row no-gutters">
                      <div class="col-md-4">
                        <img src="logo.png" class="card-img" alt="캠핑장 대표이미지">
                      </div>
                      <div class="col-md-8">
                        <div class="card-body">
                          <h5 class="card-title">캠핑장1</h5>
                          <p class="card-text">여유로움을 즐길 수 있는 캠핑장1 입니다</p>
                          <p class="card-text"><small class="text-muted">#여유 #힐링</small></p>
                        </div>
                      </div>
                    </div>
                </div>
            </div>

            <form action="<%=contextPath%>/review/edit?num=${vo.reviewNo}" method="post" id="review-write">
            	<input type="hidden" name="camp-code" value="캠핑장 코드">
				<div id="camp-info">
                <div class="card mb-3" style="max-width: 1000px;">
                    <div class="row no-gutters">
                      <div class="col-md-4">
                        <img src="logo.png" class="card-img" alt="캠핑장 대표이미지">
                      </div>
                      <div class="col-md-8">
                        <div class="card-body">
                          <h5 class="card-title">캠핑장1</h5>
                          <p class="card-text">여유로움을 즐길 수 있는 캠핑장1 입니다</p>
                          <p class="card-text"><small class="text-muted">#여유 #힐링</small></p>
                        </div>
                      </div>
                    </div>
                </div>
         	   </div>	                
				                
                <div class="review-star">
                    <span class="text-bold">별점을 선택해주세요</span>
                    <input type="hidden" name="rNum" value="${vo.starScore}">
                    <input type="radio" name="reviewStar" value="5" id="rate1"><label
                        for="rate1">★</label>
                    <input type="radio" name="reviewStar" value="4" id="rate2"><label
                        for="rate2">★</label>
                    <input type="radio" name="reviewStar" value="3" id="rate3"><label
                        for="rate3">★</label>
                    <input type="radio" name="reviewStar" value="2" id="rate4"><label
                        for="rate4">★</label>
                    <input type="radio" name="reviewStar" value="1" id="rate5"><label
                        for="rate5">★</label>
                </div>

                <script>
                    $(function(){
                        //작성했던 별점 표시
                        $('input[value=${vo.starScore}]').attr("checked","checked");
                    })
                </script>


                <textarea name="review-content" id="review-text" spellcheck="false">${vo.reviewContent}</textarea>

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

                <div id="review-update-buttons">
                    <input type="submit" value="리뷰 수정하기" id="review-update" class="btn btn-warning">
                    <button type="button" class="btn btn-warning" id="review-delete" onclick="location.href='<%=contextPath%>/review/delete?num=${vo.reviewNo }'">삭제하기</button>
                </div>
                
            </form>

        </section>
    </div>
	
	<%@include file="/views/common/footer.jsp" %>
	
</body>
</html>