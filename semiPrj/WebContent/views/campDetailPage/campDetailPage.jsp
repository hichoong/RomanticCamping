<%@page import="java.time.LocalDate"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%
	List<String> hashTag = (List<String>)request.getAttribute("hashTag");
	List<String> facList = (List<String>)request.getAttribute("facList");
	LocalDate todayDate = LocalDate.now();
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    <%@ include file="/resource/css/freeBoardCSS/campDetailPage.css" %>
    <%@ include file="/resource/css/freeBoardCSS/gsCampReview.css" %>
</style>

</head>
	<%@ include file="/views/common/header.jsp" %>
	
<body>
	

    <div id="detail-outer" class="container">
    
    	<!-- 선 추가 -->
	    <div class="campDetail-line container"></div>
		<h1 style="text-align:center;"> 캠핑장 구역 상세 페이지 </h1>
		
		<!-- 선 추가 -->
	    <div class="campDetail-line container"></div>
	    
	    <!-- 0. 헤더부분 캠핑장 구역이름 보여주기 -->
        <header class="container">
            <div id="cd-back"><button type="button" id="btn-back" name="btn-back" class="btn btn-outline-warning" onclik="history.back()" >&lt;</button></div>
            <div id="cd-name"><p class="btn btn-outline-warning" >${campVo.name} - ${campVo.getzName() }</p></div>
            <div id="cd-name2"></div>
        </header>

        <!-- 1. 구역상세이미지 부분 -->
        <div id="campDetail-img-outer" class="container">
            	
                <!-- Carousel -->
                <div id="demo" class="carousel container" data-bs-ride="carousel">
        
                    <!-- Indicators/dots -->
                    <div class="carousel-indicators">
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="0" class="active"></button>
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="1"></button>
                    <button type="button" data-bs-target="#demo" data-bs-slide-to="2"></button>
                    </div>
                        
                    <!-- The slideshow/carousel -->
                    <div class="carousel-inner" style="width:100%; height:100%" >
                        <%-- <div class="carousel-item active">
                                <img src="<%=contextPath %>/resource/img/gsTest1.jpg" class="img-thumbnail" alt="Los Angeles" class="d-block" style="width:100%; height: 650px;">
                        </div>
                        <div class="carousel-item">
                                <img  src="<%=contextPath %>/resource/img/gsTest2.jpg" class="img-thumbnail" alt="Chicago" class="d-block" style="width:100%; height: 650px;">
                        </div>
                         --%>
                         <!-- 경로 수정되면 이걸로 사용하기 -->
                        <div class="carousel-item">
                        	<img  src="<%=contextPath %>/resource/img/upload/campImg/${campAttachVo.campChangeName}" class="img-thumbnail" alt="New York" class="d-block" style="width:100%; height: 650px;">
                        	<%-- <img  src="${campVo.imgePath }" class="img-thumbnail" alt="New York" class="d-block" style="width:100%; height: 650px;"> --%>
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
        


		<!-- 선 추가 -->
        <div class="campDetail-line container"></div>
        
        <!-- 2. 캠핑장 소개 부분 -->
        <div id="campDetail-introduce" class="container">
            <div id="campDetail-introduce-d">
                <div id="campDetail-introduce-1"  class="display-5 main-title-font-style">캠핑장 소개</div>
                <div id="campDetail-introduce-2" >
                    <p class="display-6">${campVo.name} ---- ${campVo.getzName()}</p>
                    <br>
                    <p class="campDetail-sub-font-style"> 캠핑장 소개 - ${campVo.intro}</p>
                    <p class="campDetail-sub-font-style"> 캠핑장 테마 - ${campVo.themeCode}</p>
                    <p class="campDetail-sub-font-style"> 구역 최대 숙박인원 - ${campVo.stayMax} 명 </p>
                    <p class="campDetail-sub-font-style"> 일별 예약가능 팀 수 - ${campVo.getzNor()} 팀</p>
                </div>
                
                <!-- 해시태그 불러오기 -->
                <div id="campDetail-introduce-3">
                   
                    <%for(int i=0; i<hashTag.size(); i++) {%>
                    	<span class="campDetail-introduce-3-sp"><%=hashTag.get(i)%></span>
                    <%} %>	
                    
                    
                </div>
            </div>    
        </div>



        <div class="campDetail-line container"></div>
        
        <!-- 3. 캠핑장 기본정보 부분 -->
        <div id="campDetail-info" class="container">
            <div id="campDetail-info-d">
                <div id="campDetail-info-1" class="display-5 main-title-font-style">캠핑장 기본정보</div>
                <div id="campDetail-info-2" class="menu-content">
                    <ul>
                        <li><div class="info-title">캠핑장 이름</div><p class="info-content">${campVo.name} ---- ${campVo.getzName()}</p></li>
                        <li><div class="info-title">캠핑 가격</div><p class="info-content">${campVo.price}원  (1박기준)</p></li>
                        <li><div class="info-title">캠핑장 주소</div><p class="info-content">${campVo.city}  ${campVo.district}  ${campVo.address}</p></li>
                        <li><div class="info-title">전화번호</div> <p class="info-content"> ${campVo.phone}</p> </li>
                        <li><div class="info-title">등록일</div><p class="info-content">${campVo.rgDate}</p></li>
                    </ul>
                </div>
            </div>    
        </div>
        
		<!-- 선추가 -->
        <div class="campDetail-line container"></div>
        
        <!-- 4. 캠핑장 시설소개 부분 -->
        <div id="campDetail-facility" class="container">
            <div id="campDetail-facility-d">
                <div id="campDetail-facility-1" class="display-5 main-title-font-style">캠핑장 시설소개</div>
                <div id="campDetail-facility-2" class="menu-content">
                    <div id="campDetail-facility-2-1">
                        <div class="info-title">기본시설</div>
                        <div class="fac-content-outer">
                            <li class="fac-content"><img width="50" height="50" src="<%=contextPath %>/resource/img/freeBoardTrade/toilet.png" alt=""><br>화장실</li>
                            <li class="fac-content"><img width="50" height="50" src="<%=contextPath %>/resource/img/freeBoardTrade/shower.png" alt=""><br>샤워실</li>
                            <li class="fac-content"><img width="50" height="50" src="<%=contextPath %>/resource/img/freeBoardTrade/sink.png" alt=""><br>개수대</li>
                        </div>
                    </div>
                    <div style="border-top: 5px dashed darkkhaki; margin-bottom:20px;"></div>
                    <div id="campDetail-facility-2-2">
                        <div class="info-title">부가시설</div>
                        
                        <!--시설이름에 맞춰 이미지 보여주기  -->
                        <div class="fac-content-outer">
                        	<%for(int i=0; i<facList.size(); i++) {
                        		String facImgName = "";
                        		switch (facList.get(i)) {
                        		case "와이파이": facImgName = "wifi.png"; break;
                        		case "전기": facImgName = "electricity.png"; break;
                        		case "온수": facImgName = "hotWater.png"; break;
                        		case "반려견동반": facImgName = "pet.png"; break;
                        		case "매점": facImgName = "store.png"; break;
                        		case "장작판매": facImgName = "fs.jpg"; break;
                        		case "운동장": facImgName = "playground.png"; break;
                        		case "산책로": facImgName = "path.png"; break;
                        		case "물놀이장": facImgName = "waterSlide.png"; break;
                        		}%>
                        		<li class="fac-content"><img width="50" height="50" src="<%=contextPath %>/resource/img/facility/<%=facImgName %>" alt=""><br><%=facList.get(i)%></li>
                    		<%} %>	
                            
                        </div>
                    </div>
                </div>
            </div>  
        </div>
        
        
        <!-- 선추가 -->
        <div class="campDetail-line container"></div>
        
        <!-- 5. 캠핑장 운영정책 부분 -->
        <div id="campDetail-policy" class="container ">
            <div id="campDetail-policy-d">
                <div id="campDetail-policy-1" class="display-5 main-title-font-style">캠핑장 운영정책</div>
                <div id="campDetail-policy-2" class="menu-content">
                    <div id="campDetail-policy-2-1">
                        <div class="info-title" style="width: 100%;">행복한 캠핑을 위해서 필독 후 이용 부탁드립니다.</div>
                        <div class="info-content" style="width: 100%; margin:0px;">캠핑장 운영정책에는 환불,양도양수 등 캠핑장 이용에 관한 가이드가 포함되어 있습니다.</div>
                    </div>
                    <button type="button" id="campDetail-policy-2-2" class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#camp-policy"><span>캠핑장 운영정책 더보기</span></button>
                </div>
            </div>  
        </div>

        
		<!-- 선추가 -->
        <div class="campDetail-line container"></div>
        
        <!-- 6. 캠핑장 예약하기 -->
        <div id="campDetail-reservation" class="container ">
            <div id="campDetail-reservation-d">
                <div id="campDetail-reservation-1" class="display-5 main-title-font-style">캠핑장 예약하기</div>
                <div id="campDetail-reservation-2" class="menu-content">
                    <div id="campDetail-reservation-2-1">
                        <div class="info-title" style="width: 100%;">캠핑장이 마음에 들었다면 예약을 진행해보세요</div>
                        <div class="info-content" style="width: 100%; margin:0px;">예약하기버튼을 통해 예약날짜 선택 및 세부사항을 확인하고 진행할 수 있습니다.</div>
                    </div>

                    <button type="button" id="campDetail-reservation-2-2" class="btn btn-outline-success" data-bs-toggle="modal" data-bs-target="#camp-reservation"><span>캠핑장 예약하기</span></button>
                    
                </div>
            </div>  
        </div>
        
        
        


		<!-- 선추가 -->
        <div class="campDetail-line container"></div>	
        
        <!-- 9. 리뷰페이지 -->
        <div id="campDetail-review-section" class="container">
            <div class="container">
                
                <div class="review-title">
                    review
                </div>
				
				<!-- 리뷰 보여주기 -->
                <section>
                        
                    <!-- 리뷰 없으면 안내 글  -->    
                    <c:if test="${empty reviewVo}">
                    	<h2 style="text-align:center; color:lightgray;"> 리뷰를 기다리고 있습니다. </h2>
                    </c:if>    
                        
                        
                    <!-- 리뷰 있으면 리뷰 모두 보여주기 -->    
                    <c:if test="${not empty reviewVo }">
	                    <div class="camp-review-result">
	                        <div class="camp-review-scope">
	                            <span class="star">★</span>
	                            <span class="star-scope-avg">${reviewVo.starScore}</span>
	                        </div>
	                    </div>
						
						
						
	                    <div class="camp-review-list">
	                        <div class="camp-review">
	                            <div class="star-scope">
	                              ★ ${reviewVo.starScore} 점
	                            </div>
	                            <div class="name-date">
	                                ${reviewVo.reviewUpdated}<br>
	                                <fmt:parseDate value="${reviewVo.enrollDate}" var="reviewDate" pattern="yyyy-MM-dd HH:mm:ss"></fmt:parseDate>
									<fmt:formatDate value="${reviewDate}" pattern="yyyy년 MM월 dd일" />
	                            </div>
	                            <div class="review-text">
	                                ${reviewVo.reviewContent}
	                            </div>
	                        </div>
	                    </div>
					</c:if>

              

                </section>

            </div>
        </div>
		

	





    </div><!-- 아우터 끝  -->


	<%@include file="/views/common/footer.jsp" %>


	
	
	
	
	<!-- 캠핑장 운영정책 더보기 모달 -->
	<div class="modal" id="camp-policy" >
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
			    <input type="text" readonly class="form-control" id="camp-name" name="camp-name" value="${campVo.name} --- ${campVo.getzName()}">
			</div>
			<div class="mb-3 mt-3 input-group-lg">
			    <label for="trade-title" class="camp-refund"><mark>환불 규정</mark></label>
			    <input type="text" readonly class="form-control" id="camp-refund" name="camp-refund" value="${campVo.refund}">
			</div>
	        <div class="mb-3 mt-3 input-group-lg">
			    <label for="trade-title" class="camp-phone"><mark>캠핑장 연락처</mark></label>
			    <input type="text" readonly class="form-control" id="camp-phone" name="camp-phone" value="${campVo.phone}">
			</div>
	      </div>
	
	     
	
	    </div>
	  </div>
	</div>
	
	
	
	
	<!-- 캠핑장 예약하기 모달 -->
	<div class="modal" id="camp-reservation" data-bs-backdrop="static" data-bs-keyboard="false">
	  <div class="modal-dialog modal-xl">
	    <div class="modal-content">
	
	      <!-- Modal Header -->
	      <div class="modal-header">
	        <h4 class="camp-policy--title">캠핑장 예약하기</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body">
	        <div class="mb-3 mt-3 input-group-lg">
			    <label for="trade-title" class="camp-name"><mark>캠핑장 이름</mark></label>
			    <input type="text" readonly class="form-control" id="camp-name"  value="${campVo.name} ---- ${campVo.getzName()}">
			</div>
			<div class="mb-3 mt-3 input-group-lg">
			    <label for="trade-title" class="camp-refund"><mark>환불 규정</mark></label>
			    <input type="text" readonly class="form-control" id="camp-refund" value="${campVo.refund}">
			</div>
	        <div class="mb-3 mt-3 input-group-lg">
			    <label for="trade-title" class="camp-phone"><mark>캠핑장 연락처</mark></label>
			    <input type="text" readonly class="form-control" id="camp-phone"  value="${campVo.phone}">
			</div>
			<div class="mb-3 mt-3 input-group-lg">
			    <label for="trade-title" class="camp-price"><mark>캠핑장 연락처</mark></label>
			    <input type="text" readonly class="form-control" id="camp-price"  value="${campVo.price} 원">
			</div>
			
			
			<!-- 결제에 필요한 정보들 넘겨주기  -->
			<form action="<%=contextPath %>/order/orderForm" method="get">
			  <div style="width:100%; height:auto; border-bottom: 2px dashed lightgray; border-top: 2px dashed lightgray;">
				  가는날 선택 : <input type="date" value="<%= todayDate%>" min="<%= todayDate%>" max="2022-10-16" name="checkin">
	               오는날 선택 : <input type="date" value="<%= todayDate%>" min="<%= todayDate%>" max="2022-10-16" name="checkout">
			  </div>
			  <div class="mb-3 mt-3">
			  	<input type="hidden" value="${campVo.code }" name="campCode">
			  	<input type="hidden" value="${campVo.sectionNo }" name="zoneNo">
			  	<input type="hidden" value="${campVo.price}" name="campPrice">
			  	<input type="hidden" value="${campVo.name}" name="campName">
			  	<input type="hidden" value="${campVo.getzName()}" name="zoneName">
			    <label for="reser-name" class="form-label">예약자명:</label>
			    <input type="text" class="form-control" id="reser-name" placeholder="예약자분 이름을 입력해 주세요" name="reservationName" required>
			  </div>
			  <div class="mb-3">
			    <label for="reser-phone" class="form-label">전화번호:</label>
			    <input type="text" class="form-control" id="reser-phone" placeholder="예시) 01012345678" name="reservationPhone" required>
			  </div>
			  
			  
			  <div>	  
			  	   <label for="sel1" class="form-label">인원수를 체크해주세요</label>
				    <select class="form-select" id="sel1" name="reservationNop">
				      <option>1</option>
				      <option>2</option>
				      <option>3</option>
				      <option>4</option>
				      <option>5</option>
				      <option>6</option>
				    </select>
			  </div>
			  <div style="margin: 5px;">
				  <label for="comment">요청사항:</label>
				  <textarea class="form-control" rows="5" id="comment" name="reservationComment"></textarea>
			  </div>
			  
			  <input type="submit" class="btn btn-success" value="예약하기" >
		      <button type="button" class="btn btn-danger" data-bs-dismiss="modal">취소하기</button>
			</form>
			
			
			
			
	      </div>
	
	     
	
	    </div>
	  </div>
	</div>
	
	

</body>
</html>