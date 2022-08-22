<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/memberCommon.css" type="text/css">
<title>낭만캠핑</title>
<style>
    #sub-nav {
        width: 130px;
        position: fixed;
    }

    span {
        padding-right: 20px;
    }
    
    .list-group-item.choice {
	    z-index: 2;
	    color: #fff;
	    background-color: ORANGE;
	    border-color: ORANGE;
	    pointer-events: none;
	}

</style>
</head>
<body>

    <%@ include file="/views/common/header.jsp" %>

    <div class="container">
        <ul id="sub-nav" class="list-group">
            <a href="<%=contextPath%>/member/reservationCheck?type=S" class="list-group-item list-group-item-action">예약완료</a>
            <a href="<%=contextPath%>/member/reservationCheck?type=W" class="list-group-item list-group-item-action">예약대기</a>
            <a href="<%=contextPath%>/member/reservationCheck?type=D" class="list-group-item list-group-item-action">이용완료</a>
            <a href="<%=contextPath%>/member/reservationCheck?type=N" class="list-group-item list-group-item-action">취소/환불</a>
        </ul>

        <div class="outer">
            
           	<c:forEach items="${reservationList}" var="reservation">
				<div class="contentBox">
				    <div class="mb-4">
				        <span>캠핑장 : <strong> ${reservation.campName}</strong></span>
				        <span>전화번호 : <strong>${reservation.campPhone}</strong></span>
				        <br>
				        <span>상세주소 : <strong>${reservation.campAddr}</strong></span>
				    </div>
				    <div class="location-center mb-4">
				        <span>구역번호 : <strong>${reservation.zoneName}</strong></span>
				        <span>인원수 : <strong>${reservation.reservationNop}</strong></span>
				        <br>
				        <span>체크인 : <strong>${reservation.reservationCheckin}</strong></span>
				        <span>체크아웃 : <strong>${reservation.reservationCheckout}</strong></span>
				        <br>
				        <span>요청사항 : <strong>${reservation.request}</strong></span>
				    </div>
				    <div class="location-right mb-4">
				        <span>예약일자 : <strong>${reservation.reservationDate}</strong></span>
				        <span>처리상태 : <strong>${reservation.getReservationStatusName()}</strong></span>
				        <br>
				        <span>예약자 전화번호 : <strong>${reservation.reservationPhone}</strong></span>
				     </div>
				     <c:if test="${ status eq 'S'or status eq 'W'}">
					     <div class="location-center ">
					         <button class="basic-btn" data-bs-toggle="modal" data-bs-target="#CancleReservation" onclick="getReservationNo(${reservation.reservationNo});">예약취소</button>
					     </div>
				     </c:if>
				     <c:if test="${ status eq 'D'}">
					     <div class="location-center ">
		                    <button class="basic-btn" onclick="location.href='<%=contextPath%>/review/insert?reservationNo=${reservation.reservationNo}'">리뷰작성</button>
		                </div>
				     </c:if>
			    </div>
			</c:forEach>
            
            <c:if test="${ empty reservationList }">
            	<div class="contentBox">
				    <div>
				        예약내역이 없습니다..
				    </div>
			    </div>
            </c:if>
        
        </div>
    </div>

    <div class="modal fade" id="CancleReservation" data-bs-backdrop="static" data-bs-keyboard="false">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="mb-3 location-center">
                        <p>취소 수수료가 발생할 수 있습니다.</p>
                        <p>정말 예약취소 하시겠습니까?</p>
                    </div>

                    <div class="location-center">
                        <button type="button" class="btn btn-success" onclick="deleteReservation();">예약취소</button>
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">돌아가기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="/views/common/footer.jsp" %>
    
    <script>
    	$(if(${status eq 'S'}) {
    		$('#sub-nav>a:nth-child(1)').addClass("choice");
    	} else if(${status eq 'W'}) {
    		$('#sub-nav>a:nth-child(2)').addClass("choice");
    	}  else if(${status eq 'D'}) {
    		$('#sub-nav>a:nth-child(3)').addClass("choice");
    	}  else if(${status eq 'N'}) {
    		$('#sub-nav>a:nth-child(4)').addClass("choice");
    	});
    	
    	
    	var reservationNo;
    	function getReservationNo(No) {
    		reservationNo = No;
    	};
    
    	function deleteReservation() {
    		location.href="/deleteReservation?reservationNo="+reservationNo;
    	}
    	
    </script>
       
</body>
</html>