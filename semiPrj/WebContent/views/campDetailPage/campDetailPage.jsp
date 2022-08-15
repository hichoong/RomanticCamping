<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    

    
    
<!DOCTYPE html>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    <%@ include file="/resource/css/gsCampD.css" %>
    <%@ include file="/resource/css/gsCampReview.css" %>
</style>

</head>
<body>

	<%@ include file="/views/common/header.jsp" %>

	<h1>여기다가 이제 구역 상세 페이지123</h1>
	
	
	

    <div id="detail-outer" class="container">

	    <div class="cdetail-top-line container"></div>
        <header class="container">
            <div id="cd-back"><button type="button" id="btn-back" name="btn-back" class="btn btn-outline-warning" onclik="history.back()" >&lg;</button></div>
            <div id="cd-name"><p class="btn btn-outline-warning" >낭 만 캠 핑</p></div>
            <div id="cd-name2"></div>
        </header>

        <!-- 1. 구역상세이미지 부분 -->
        <div id="d1" class="container">
            
                <!-- Carousel -->
                <div id="demo" class="carousel container" data-bs-ride="carousel">
        
                    <!-- Indicators/dots -->
                    <div class="carousel-indicators">
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
                    </div>
                        
                    <!-- The slideshow/carousel -->
                    <div class="carousel-inner"  >
                        <div class="carousel-item active">
                                <img src="<%=contextPath %>/resource/img/gsTest1.jpg" class="img-thumbnail" alt="Los Angeles" class="d-block" style="width:100%; height: 100%;">
                        </div>
                        <div class="carousel-item">
                                <img  src="<%=contextPath %>/resource/img/gsTest2.jpg" class="img-thumbnail" alt="Chicago" class="d-block" style="width:100%">
                        </div>
                        <div class="carousel-item">
                                <img  src="<%=contextPath %>/resource/img/gsTest3.jpg" class="img-thumbnail" alt="New York" class="d-block" style="width:100%">
                        </div>
                    </div>
                        
                    <!-- Left and right controls/icons -->
                    <button class="carousel-control-prev" type="button" data-bs-target="#demo" data-bs-slide="prev">
                        <span class="carousel-control-prev-icon"></span>
                    </button>

                    <button class="carousel-control-next" type="button" data-bs-target="#demo" data-bs-slide="next">
                        <span class="carousel-control-next-icon"></span>
                    </button>
                </div>
            
            
        </div>
        



        <div class="cdetail-top-line container"></div>
        <!-- 2. 캠핑장 소개 부분 -->
        <div id="d2" class="container">
            <div id="d2-d">
                <div id="d2-1"  class="display-5 display-5-gplus">캠핑장 소개</div>
                <div id="d2-2" >
                    <p class="display-6">캠핑장 이름 -( CAMP-NAME )</p>
                    <br>
                    <p class="d2-2-campInfo">캠핑장설명 - ( CAMP-INTRO ) 사랑이 넘치는 우리의 보금자리 합천 꿈꾸는 캠핑장</p>
                </div>
                <div id="d2-3">
                    <span class="d2-3-sp">##캠핑장 코드(CAMP_INFO)와 해시태그(HASHTAG_MAPPING) 맵핑</span>
                    <span class="d2-3-sp">##CAMP_CODE 와 HT_CODE JOIN HASGTAG 테이블에서 HT_NAME가져오기</span>
                    <span class="d2-3-sp">#합천꿈꾸는캠핑장</span>
                </div>
            </div>    
        </div>



        <div class="cdetail-top-line container"></div>
        <!-- 3. 캠핑장 기본정보 부분 -->
        <div id="d3" class="container">
            <div id="d3-d">
                <div id="d3-1" class="display-5 display-5-gplus">캠핑장 기본정보</div>
                <div id="d3-2" class="menu-content">
                    <ul>
                        <li><div class="info-title">캠핑장 이름</div><p class="info-content">CAMP_NAME</p></li>
                        <li><div class="info-title">캠핑 테마</div><p class="info-content">THEME_CODE</p></li>
                        <li><div class="info-title">캠핑장 주소</div><p class="info-content">CITY + DISTRICT</p></li>
                        <li><div class="info-title">전화번호</div><p class="info-content">CAMP_PHONE</p></li>
                        <li><div class="info-title">등록일</div><p class="info-content">RG_DATE</p></li>
                    </ul>
                </div>
            </div>    
        </div>

        <div class="cdetail-top-line container"></div>
        <!-- 4. 캠핑장 시설소개 부분 -->
        <div id="d4" class="container">
            <div id="d4-d">
                <div id="d4-1" class="display-5 display-5-gplus">캠핑장 시설소개</div>
                <div id="d4-2" class="menu-content">
                    <div id="d4-2-1">
                        <div class="info-title">기본시설</div>
                        <div class="fac-content-outer">
                            <li class="fac-content"><img width="50" height="50" src="<%=contextPath %>/resource/img/gsTest1.jpg" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="<%=contextPath %>/resource/img/gsTest1.jpg" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="<%=contextPath %>/resource/img/gsTest1.jpg" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="<%=contextPath %>/resource/img/gsTest1.jpg" alt=""><br>화장실</li>
                        </div>
                    </div>
                    <div style="border-top: 5px dashed darkkhaki; margin-bottom:20px;"></div>
                    <div id="d4-2-2">
                        <div class="info-title">부가시설</div>
                        <div class="fac-content-outer">
                            <li class="fac-content"><img width="50" height="50" src="<%=contextPath %>/resource/img/gsTest2.jpg" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="<%=contextPath %>/resource/img/gsTest2.jpg" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="<%=contextPath %>/resource/img/gsTest2.jpg" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="<%=contextPath %>/resource/img/gsTest2.jpg" alt=""><br>화장실</li>
                        </div>
                    </div>
                </div>
            </div>  
        </div>
        
        <div class="cdetail-top-line container"></div>
        <!-- 5. 캠핑장 운영정책 부분 -->
        <div id="d5" class="container ">
            <div id="d5-d">
                <div id="d5-1" class="display-5 display-5-gplus">캠핑장 운영정책</div>
                <div id="d5-2" class="menu-content">
                    <div id="d5-2-1">
                        <div class="info-title" style="width: 100%;">행복한 캠핑을 위해서 필독 후 이용 부탁드립니다.</div>
                        <div class="info-content" style="width: 100%; margin:0px;">캠핑장 운영정책에는 환불,양도양수 등 캠핑장 이용에 관한 가이드가 포함되어 있습니다.</div>
                    </div>
                    <button type="button" id="d5-2-2" class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#camp-policy"><span>캠핑장 운영정책 더보기</span></button>
                </div>
            </div>  
        </div>

        

        <div class="cdetail-top-line container"></div>
        <!-- 6. 캠핑장 구역상세 -->
        <div id="d6" class="container ">
            <div id="d6-d">
                <div id="d6-1" class="display-5 display-5-gplus">캠핑장 예약하기</div>
                <div id="d6-2" class="menu-content">
                    <div id="d6-2-1">
                        <div class="info-title" style="width: 100%;">캠핑장이 마음에 들었다면 예약을 진행해보세요</div>
                        <div class="info-content" style="width: 100%; margin:0px;">예약하기버튼을 통해 예약가능날짜 확인 및 세부사항을 확인하고 진행할 수 있습니다.</div>
                    </div>
                    <button type="button" id="d6-2-2" class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#camp-policy"><span>캠핑장 예약하기</span></button>
                </div>
            </div>  
        </div>
        
        
        



        <div class="cdetail-top-line container"></div>	
        <!-- 9. 리뷰페이지 -->
        <div id="d9" class="container">
            <div class="container">
                
                <div class="review-title">
                    review
                </div>

                <section>
                        
                    <div class="camp-review-result">
                        <div class="camp-review-scope">
                            <span class="star">★</span>
                            <span class="star-scope-avg">4.16</span>
                        </div>
                        <div>리뷰 수</div>
                    </div>

                    <div class="camp-review-list">
                        <div class="camp-review">
                            <div class="star-scope">
                                ★★★★★
                            </div>
                            <div class="name-date">
                                김 **  2022.08.07
                            </div>
                            <div class="review-text">
                                캠핑장이 좋네요 짱짱 굿 
                            </div>
                        </div>
                    </div>


                    <div class="camp-review-list">
                        <div class="camp-review">
                            <div class="star-scope">
                                ★★★★★
                            </div>
                            <div class="name-date">
                                김 **  2022.08.07
                            </div>
                            <div class="review-text">
                                캠핑장이 좋네요 짱짱 굿 
                            </div>
                        </div>
                    </div>
                    <div class="camp-review-list">
                        <div class="camp-review">
                            <div class="star-scope">
                                ★★★★★
                            </div>
                            <div class="name-date">
                                김 **  2022.08.07
                            </div>
                            <div class="review-text">
                                캠핑장이 좋네요 짱짱 굿 
                            </div>
                        </div>
                    </div>
                    <div class="camp-review-list">
                        <div class="camp-review">
                            <div class="star-scope">
                                ★★★★★
                            </div>
                            <div class="name-date">
                                김 **  2022.08.07
                            </div>
                            <div class="review-text">
                                캠핑장이 좋네요 짱짱 굿 
                            </div>
                        </div>
                    </div>

                </section>

            </div>
        </div>
		

	





    </div><!-- 아우터 끝  -->


	<%@include file="/views/common/footer.jsp" %>


	
	
	
	
	<!-- The Modal -->
	<div class="modal" id="camp-policy">
	  <div class="modal-dialog modal-xl">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="camp-policy--title">캠핑장 운영정책</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	        <div class="mb-3 mt-3 input-group-lg">
			    <label for="trade-title" class="camp-name"><mark>캠핑장 이름</mark></label>
			    <input type="text" class="form-control" id="camp-name" name="camp-name" value="캠핑장 이름(CAMP_NAME)">
			</div>
			<div class="mb-3 mt-3 input-group-lg">
			    <label for="trade-title" class="camp-refund"><mark>환불 규정</mark></label>
			    <input type="text" class="form-control" id="camp-refund" name="camp-refund" value="환불규정내용이 들어올 칸입니다.(CAMP_REFUND)">
			</div>
	        <div class="mb-3 mt-3 input-group-lg">
			    <label for="trade-title" class="camp-phone"><mark>캠핑장 연락처</mark></label>
			    <input type="text" class="form-control" id="camp-phone" name="camp-phone" value="캠핑장 전화번호(CAMP_PHONE)">
			</div>
	      </div>
	
	     
	
	    </div>
	  </div>
	</div>
	
	

</body>
</html>