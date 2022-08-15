<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>낭만캠핑</title>
<link rel="stylesheet" href="/semiPrj/resource/css/campZoneList.css">
</head>
<body>

	<%@ include file = "/views/common/header.jsp" %>
	
    <div class="container">
        <section>
            <div id="info-box">
              <div class="camp-name">캠핑장 1</div>
              <img id="camp-zone-img" src="/semiPrj/resource/img/test.jpg" alt="캠핑장 대표 이미지">
              <div id="camp-addr">서울시 강남구 역삼동</div>  
              <div id="camp-phone">02-222-2222</div>
            </div>

            <div class="camp-list">
                 <div class="card mb-3" style="max-width: 800px;">
                    <div class="row no-gutters">
                      <div class="col-md-4">
                        <img src="../../resource/img/test.jpg" class="card-img" alt="캠핑장 구역이미지">
                      </div>
                      <div class="col-md-8">
                        <div class="card-body">
                          <h5 class="card-title">버드나무존 1</h5>
                          <p class="card-text">최대인원 5</p>
                          <p class="card-text"><small class="text-muted">예약가능 객실 수 : 4</small></p>
                        </div>
                      </div>
                    </div>
                </div>

                <div class="card mb-3" style="max-width: 800px;">
                  <div class="row no-gutters">
                    <div class="col-md-4">
                      <img src="../../resource/img/test.jpg" class="card-img" alt="캠핑장 구역이미지">
                    </div>
                    <div class="col-md-8">
                      <div class="card-body">
                        <h5 class="card-title">버드나무존 1</h5>
                        <p class="card-text">최대인원 5</p>
                        <p class="card-text"><small class="text-muted">예약가능 객실 수 : 4</small></p>
                      </div>
                    </div>
                  </div>
              </div>

              <div class="card mb-3" style="max-width: 800px;">
                <div class="row no-gutters">
                  <div class="col-md-4">
                    <img src="../../resource/img/test.jpg" class="card-img" alt="캠핑장 구역이미지">
                  </div>
                  <div class="col-md-8">
                    <div class="card-body">
                      <h5 class="card-title">버드나무존 1</h5>
                      <p class="card-text">최대인원 5</p>
                      <p class="card-text"><small class="text-muted">예약가능 객실 수 : 4</small></p>
                    </div>
                  </div>
                </div>
            </div>
		</div>	
                
        </section>

    </div>
    
    <%@include file="/views/common/footer.jsp" %>
    
</body>
</html>