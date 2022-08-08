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
</style>

</head>
<body>

	<%@ include file="/views/common/header.jsp" %>

	<h1>여기다가 이제 상세 페이지</h1>
	
	
	
	

    <div id="detail-outer">

        <header>
            <div id="cd-back"><button type="button" id="btn-back" name="btn-back" class="btn btn-outline-warning" ><</button></div>
            <div id="cd-name"><p class="btn btn-outline-warning" >낭 만 캠 핑</p></div>
            <div id="cd-name2"></div>
        </header>

        <!-- 1. 대표이미지 부분 -->
        <div id="d1">
            
                <!-- Carousel -->
                <div id="demo" class="carousel " data-bs-ride="carousel">
        
                    <!-- Indicators/dots -->
                    <div class="carousel-indicators">
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
                    </div>
                        
                    <!-- The slideshow/carousel -->
                    <div class="carousel-inner" style="width: 1100px;">
                        <div class="carousel-item active">
                                <img src="/semiPrj/resource/img/gsTest1.jpg" class="img-thumbnail" alt="Los Angeles" class="d-block" style="width:100%; height: 100%;">
                        </div>
                        <div class="carousel-item">
                                <img  src="/semiPrj/resource/img/gsTest2.jpg" class="img-thumbnail" alt="Chicago" class="d-block" style="width:100%">
                        </div>
                        <div class="carousel-item">
                                <img  src="/semiPrj/resource/img/gsTest3.jpg" class="img-thumbnail" alt="New York" class="d-block" style="width:100%">
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
        




        <!-- 2. 캠핑장 소개 부분 -->
        <div id="d2">
            <div id="d2-d">
                <div id="d2-1"  class="display-5">캠핑장 소개</div>
                <div id="d2-2" ><p class="display-6">캠핑장 이름 -( CAMP-NAME )</p><br><p class="d2-2-campInfo">캠핑장설명 - ( CAMP-INTRO ) 사랑이 넘치는 우리의 보금자리 합천 꿈꾸는 캠핑장</p></div>
                <div id="d2-3">
                    <span class="d2-3-sp">##캠핑장 코드(CAMP_INFO)와 해시태그(HASHTAG_MAPPING) 맵핑</span>
                    <span class="d2-3-sp">##CAMP_CODE 와 HT_CODE JOIN HASGTAG 테이블에서 HT_NAME가져오기</span>
                    <span class="d2-3-sp">#합천꿈꾸는캠핑장</span>
                    <span class="d2-3-sp">#합천꿈꾸는캠핑장</span>
                    <span class="d2-3-sp">#합천꿈꾸는캠핑장</span>
                    <span class="d2-3-sp">#합천꿈꾸는캠핑장</span>
                </div>
            </div>    
        </div>




        <!-- 3. 캠핑장 기본정보 부분 -->
        <div id="d3">
            <div id="d3-d">
                <div id="d3-1" class="display-5">캠핑장 기본정보</div>
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


        <!-- 4. 캠핑장 시설소개 부분 -->
        <div id="d4">
            <div id="d4-d">
                <div id="d4-1" class="display-5">캠핑장 시설소개</div>
                <div id="d4-2" class="menu-content">
                    <div id="d4-2-1">
                        <div class="info-title">기본시설</div>
                        <div class="fac-content-outer">
                            <li class="fac-content"><img width="50" height="50" src="" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="" alt=""><br>화장실</li>
                        </div>
                    </div>
                    <div id="d4-2-2">
                        <div class="info-title">부가시설</div>
                        <div class="fac-content-outer">
                            <li class="fac-content"><img width="50" height="50" src="" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="" alt=""><br>화장실</li>
                        </div>
                    </div>
                </div>
            </div>  
        </div>
        

        <!-- 5. 캠핑장 운영정책 부분 -->
        <div id="d5">
            <div id="d5-d">
                <div id="d5-1" class="display-5">캠핑장 운영정책</div>
                <div id="d5-2" class="menu-content">
                    <div id="d5-2-1">
                        <div class="info-title" style="width: 100%;">행복한 캠핑을 위해서 필독 후 이용 부탁드립니다.</div>
                        <div class="info-content" style="width: 100%; margin:0px;">캠핑장 운영정책에는 환불,양도양수 등 캠핑장 이용에 관한 가이드가 포함되어 있습니다.</div>
                    </div>
                    <button type="button"  id="d5-2-2" class="btn btn-outline-success"><span>캠핑장 운영정책 더보기</span></button>
                </div>
            </div>  
        </div>


        <!-- 6. 캠핑장 구역상세 부분 -->
        <div id="d6">
            <div id="d6-2d" class="display-5"> 캠핑장 구역상세</div>
            
                <div id="d6-d">
                    <!-- Carousel -->
                    <div id="demo" class="carousel slide" data-bs-ride="carousel">

                        <!-- Indicators/dots -->
                        <div class="carousel-indicators" >
                            <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
                            <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
                            <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
                        </div>
                    
                        <!-- The slideshow/carousel -->
                        <div  class="carousel-inner" style="width: 1100px;" >

                            <div class="carousel-item active" >
                                <img src="/semiPrj/resource/img/gsTest1.jpg" alt="Los Angeles" class="d-block w-100">
                                <div class="carousel-caption">
                                    <h3 style="margin-bottom: 50px;">구역이름</h3>
                                </div>
                            </div>

                            <div class="carousel-item">
                                <img src="/semiPrj/resource/img/gsTest2.jpg" alt="Chicago" class="d-block w-100">
                                <div class="carousel-caption">
                                    <h3 style="margin-bottom: 50px;">구역이름</h3>
                                </div>
                            </div>

                            <div class="carousel-item">
                                <img src="/semiPrj/resource/img/gsTest3.jpg" alt="New York" class="d-block w-100">
                                <div class="carousel-caption">
                                    <h3 style="margin-bottom: 50px;">구역이름</h3>
                            </div>
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

            
        </div>


        <!-- 7. 캠핑장 예약 -->
        <div id="d7">
            <div id="d7-d">
                <div id="d7-1" class="display-5">캠핑장 예약</div>
                <div id="d7-2">
                    <div id="d7-2-1">
                        <div class="info-title" style="width: 100%;">망설이지 말고 지금 예약해보세요</div>
                        <div  class="info-content" style="width: 100%; margin:0px;">고민은 시간낭비일 뿐 지금바로 예약해보세요</div>
                    </div>
                    <button type="button"  id="d7-2-2" class="btn btn-outline-success"><span>캠핑장 예약하기</span></button>
                </div>
            </div>  
        </div>
        

        <!-- 8. 캠핑로그 -->
        <div id="d8">
            <div id="d8-d">
                <div id="d8-1" class="display-5">캠핑로그</div>
                <div id="d8-2">
                    <div id="d8-2-1">
                        <div class="info-title" style="width: 100%;">캠핑장을 이용한 이용자들의 로그를 확인해 보세요</div>
                        <div class="info-content" style="width: 100%; margin:0px;">캠핑장 이용자들의 생생한 캠핑로그를 확인하고 체험해보세요</div>
                    </div>
                    <button type="button"  id="d8-2-2" class="btn btn-outline-success"><span>캠핑장 로그보기</span></button>
                </div>
            </div>  
        </div>











    </div>



</body>
</html>