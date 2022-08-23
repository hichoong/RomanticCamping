<%@page import="com.kh.coupon.vo.CouponVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%
   		List<CouponVo> couponList = (List<CouponVo>)request.getAttribute("couponList");	
    %>
<!DOCTYPE html>
<html>
<head>
    <title>상품 예약</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-A3rJD856KowSb7dwlZdYEkO39Gagi7vIsF0jrRAoQmDKKtQBHUuLZ9AsSv4jD4Xa" crossorigin="anonymous"></script>
    <script  src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	<!--헤더  -->
	<%@ include file="/views/common/header.jsp" %>
	<!--전체 컨테이너  -->
	<div class="container alert-warning" >
		
		<form class="needs-validation" novalidate action="<%=contextPath%>/order/orderForm" method="post">
		    <div class="py-5 text-center ">
		      <h1>결제하기</h1>
		      <p class="lead"></p>
		    </div>
		    <div class="row g-5">
		      <div class="col-md-5 col-lg-4 order-md-last">
		        <h4 class="d-flex justify-content-between align-items-center mb-3">
		          <span class="text-danger"  id="reservationForm" >예약할 캠핑장</span>
		          <span class="badge bg-danger rounded-pill">1</span>
		        </h4>
		        <ul class="list-group mb-3">
		          <li class="list-group-item d-flex justify-content-between lh-sm">
		            <div>
		              <h6 class="my-0">${zoneName}</h6>
		              <input type="hidden" name="zoneName" id="zoneName">
		              <small class="text-muted" id="reservaionCheckDate"> ${checkin}~${checkout}</small>	
		              <small class="text-muted" id="reservaionNop">숙박인원 : ${reservaionNop} </small>
		            </div>
		            <span class="text-muted" id="campPrice"> ${campPrice}</span>
		            
		          </li>
		          
		          <li class="list-group-item d-flex justify-content-between bg-light">
		            <div class="text-success">
		              <h6 class="my-0">사용할 쿠폰</h6>
		              <small id="couponName">없음</small>
		              <input type="hidden" id="couponName" name="couponName">
		            </div>
		            <small class="text-success" id="couponCost">0</small>		       		
		          </li>
		          <li class="list-group-item d-flex justify-content-between">
		            <span>총 결제금액</span>
		            <strong id="totalCost">${campPrice}</strong>
		            <input type="hidden" id="campPrice" name="campPrice">
		          </li>
		        </ul>
		        
		        
		          <div class="input-group">
		            <input type="text" class="form-control" placeholder="프로모션 코드">
		            <button type="button" class="btn btn-secondary" data-bs-toggle="modal" data-bs-target="#selectCoupon">제출</button>
		          </div>
		       
		      </div>
		      
		       <hr class="my-4">
		 
		      <!--사용자 정보  -->
		      <div class="col-md-7 col-lg-8" >
		     	 
		          <div class="row g-3 alert-light">
		        	<h4 class="mb-3 " >사용자 정보</h4>
		            <div class="col-12">
		              <label for="userName" class="form-label">이름</label>
		              <div class="input-group has-validation">
		                <span class="input-group-text">*</span>
		                <input type="text" class="form-control" name="reName" id="reName"  value="" placeholder="예약자명" required>
		              <div class="invalid-feedback">
		                  이름 작성 필수.
		                </div>
		              </div>
		            </div>
		
		            <div class="col-12">
		              <label for="email" class="form-label">이메일<span class="text-muted">(선택사항)</span></label>
		              <input type="email" class="form-control" name="email" id="email" placeholder="you@naver.com">
		              <div class="invalid-feedback">
		              </div>
		            </div>
		
		            <div class="col-12">
		              <label for="address" class="form-label">연락처</label>
		              <input type="tel" class="form-control" minlength="10" name="address" id="address" placeholder="-부호 제외" required>
		              <div class="invalid-feedback">
		               연락처를 입력해 주세요.
		              </div>
		            </div>
		
		            <div class="col-12">
		              <label for="address2" class="form-label">요청사항<span class="text-muted">(선택사항)</span></label>
		              <input type="text" class="form-control" name="requestion" id="requestion" placeholder="" value="없음">
		            </div>
					<br><br><br><br><br>
		          </div>
		
		          <hr class="my-4">
				  
		          <div class="form-check alert-light">
		          <h2 class="py-5">취소/환불 규정에 대한 동의</h2>
		          		<table class="table table-striped" >
							<tr>
								<th>이용 4일 전까지</th> 
								<th>취소 수수료 없음</th> 
							</tr>
							<tr>
								<td>이용 3일 전</td>
								<td>총결제금액의 10% 차감</td>
							</tr>
							<tr>
								<td>이용 2일 전</td>
								<td>총결제금액의 20% 차감</td>
							</tr>
							<tr>
								<td>이용 1일 전</td>
								<td>총결제금액의 50% 차감</td>
							</tr>
							<tr>
								<td>이용 당일</td>
								<td>환불 불가능</td>
							</tr>
						</table>
		            
		            
		            <input type="checkbox" class="form-check-input" id="agree-notice" required>
		            <label class="form-check-label" for="agree-notice">동의합니다</label>
		            <div class="invalid-feedback">
		                동의해 주세요.
		              </div>
		          </div>
		
					<div class="my-3 alert-waring">
		      		<h4 class="mb-3" >결제방법</h4>
		            <div class="form-check">
		              <input id="payMethod" name="payMethod" type="radio" class="form-check-input" value="카드결제" checked required>
		              <label class="form-check-label" for="credit">카드결제</label>
		            </div>
		          </div>
					
					<hr>
		          
		          <div class="row gy-3 ">
		            <div class="col-md-6">
		              <label for="cc-name" class="form-label" id="결제방법">카드사</label>
		             <select class="form-select" aria-label="Default select example" name="카드사">
						  <option selected>BC카드</option>
						  <option value="1">KB국민카드</option>
						  <option value="2">삼성카드</option>
						  <option value="3">신한카드</option>
						  <option value="3">우리카드</option>
						  <option value="3">하나카드</option>
						  <option value="3">롯데카드</option>
						  <option value="3">현대카드</option>
						  <option value="3">NH농협카드</option>
						</select>
		              <small class="text-muted">카드사를 선택해주세요.</small>
		            </div>
		
		            <div class="col-md-6">
		              <label for="cc-number" class="form-label">카드번호</label>
		              <input type="text" class="form-control" id="cc-number" placeholder="ex)xxxx-xxxx-xxxx-xxxx" minlength="19" required>
		              <div class="invalid-feedback">
		                카드 번호를 입력해 주세요.
		              </div>
		            </div>
		
		            <div class="col-md-3">
		              <label for="cc-expiration" class="form-label">만료일</label>
		              <input type="text" class="form-control" id="cc-expiration" placeholder="ex) 08/22" minlength="5" required>
		              <div class="invalid-feedback">
		               기간 만료일을 기입해 주세요.
		              </div>
		            </div>
		
		            <div class="col-md-3">
		              <label for="cc-cvv" class="form-label">CVV번호</label>
		              <input type="text" class="form-control" id="cc-cvv" placeholder="3자리" minlength="3" required >
		              <div class="invalid-feedback">
		                CVV번호 3자를 입력해 주세요.
		              </div>
		            </div>
		          </div>  
		          
		          <hr class="my-4">
				
				<!--히든으로 값 넘기기 -->
				 <input type="hidden" id="campCode" value="${campCode}" name="campCode">
		         <input type="hidden" id="zoneNo" value="${zoneNo}" name="zoneNo">
	             <input type="hidden"  id="reservaionNop" value="${reservaionNop}" name="reservaionNop">
	             <input type="hidden"  id="reservationAddr" value="${reservationAddr}" name="reservationAddr">
	             <input type="hidden"  id="Checkin" value="${checkin}"  name="Checkin">
		         <input type="hidden"  id="Checkout" value="${checkout}" name="Checkout" >
	             <input type="hidden"  id="couponName" value="${couponName}" name="couponName">
		          <button class="w-100 btn btn-primary btn-lg btn btn-danger" type="submit">결제하기</button>
		        </form>
		      </div>
		    </div>
	</div>


	<!-- Button trigger modal -->
  <!-- Modal -->
  <div class="modal fade" id="selectCoupon" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
	<div class="modal-dialog">
	  <div class="modal-content">
		<!--modal header  -->
		<div class="modal-header">
		  <h5 class="modal-title" id="exampleModalLabel">내가 가진 쿠폰 찾기</h5>
		  <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
		<!--modal body  -->
		</div>
		<form action="" method="post">
		<div class="modal-body">
		  소유한 쿠폰 : 
				<select name="쿠폰선택" id="select-coupon">
				   	<option value="0" id="select-coupon-cost">없음</option>
				 
				 if(couponList != null && couponList != "") <%{%>
				 	 <% for(CouponVo v : couponList) {%>
			   		<option value="<%=v.getCouponDiscount()%>" id="select-coupon-cost"><%=v.getCouponName()%></option>
	   				<%}%>
				<% }%>
				
	   				</select>
		</div>
		<!-- modal footer -->
		<div class="modal-footer">
		 
		  <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">창 닫기</button>
		  <button type="button" class="btn btn-primary" id="coupon-button" >쿠폰 적용하기</button>
		</div>
		</form>
	  </div>
	</div>
  </div>
 
  <script src="<%=request.getContextPath()%>/resource/js/form-validation.js"></script>
	
	<%@ include file="/views/common/footer.jsp" %>


<script>
$(document).ready(function() {
    // 모두 로딩되었을때

	// 쿠폰 모달창 선택 시 이벤트
	$("#coupon-button").click(function(){
    	
		$("#couponCost").text($("#select-coupon").val());
    	$("#couponName").text($("#select-coupon option:selected").text());
    	
    	
    	var  origin= $("#campPrice").text().replace(/,/g, '') ; 
    	
    	var  coupon = $("#select-coupon").val().replace(/,/g, '') ; 
    	
    	var total = origin - coupon;

    	total = $("#totalCost").text(total.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ','));
    	
		
	});
	}); 
	
	
</script>	
</body>
</html>