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

</style>
</head>
<body>

    <%@ include file="/views/common/header.jsp" %>

    <div class="container">
        <ul id="sub-nav" class="list-group">
            <a href="#" class="list-group-item list-group-item-action">예약완료</a>
            <a href="#" class="list-group-item list-group-item-action">이용완료</a>
            <a href="#" class="list-group-item list-group-item-action">취소/환불</a>
        </ul>

        <div class="outer">
            <div class="contentBox">
                <div class="mb-4">
                    <span>캠핑장 : <strong>낭만캠핑장</strong></span>
                    <span>전화번호 : <strong>02)000-0000</strong></span>
                    <br>
                    <span>상세주소 : <strong>서울시 강남구 테헤란로</strong></span>
                </div>
                <div class="location-center mb-4">
                    <span>구역번호 : <strong>B구역</strong></span>
                    <span>인원수 : <strong>5명</strong></span>
                    <br>
                    <span>체크인 : <strong>2022/08/08 1:00pm</strong></span>
                    <span>체크아웃 : <strong>2022/08/09 10:00am</strong></span>
                    <br>
                    <span>요청사항 : <strong>숯불바베큐 장비도 대여합니다!</strong></span>
                </div>
                <div class="location-right mb-4">
                    <span>예약일자 : <strong>2022/07/10</strong></span>
                    <span>처리상태 : <strong>예약승인</strong></span>
                    <br>
                    <span>예약자 전화번호 : <strong>010-1111-1111</strong></span>
                </div>
                <div class="location-center ">
                    <button class="basic-btn" data-bs-toggle="modal" data-bs-target="#CancleReservation">예약취소</button>
                </div>
            </div>
    
            <div class="contentBox">
                <div class="mb-4">
                    <span>캠핑장 : <strong>낭만캠핑장</strong></span>
                    <span>전화번호 : <strong>02)000-0000</strong></span>
                    <br>
                    <span>상세주소 : <strong>서울시 강남구 테헤란로</strong></span>
                </div>
                <div class="location-center mb-4">
                    <span>구역번호 : <strong>B구역</strong></span>
                    <span>인원수 : <strong>5명</strong></span>
                    <br>
                    <span>체크인 : <strong>2022/08/08 1:00pm</strong></span>
                    <span>체크아웃 : <strong>2022/08/09 10:00am</strong></span>
                    <br>
                    <span>요청사항 : <strong>숯불바베큐 장비도 대여합니다!</strong></span>
                </div>
                <div class="location-right mb-4">
                    <span>예약일자 : <strong>2022/07/10</strong></span>
                    <span>처리상태 : <strong>이용완료</strong></span>
                    <br>
                    <span>예약자 전화번호 : <strong>010-1111-1111</strong></span>
                </div>
                <div class="location-center ">
                    <button class="basic-btn">리뷰작성</button>
                </div>
            </div>

            <div class="contentBox">
                <div class="mb-4">
                    <span>캠핑장 : <strong>낭만캠핑장</strong></span>
                    <span>전화번호 : <strong>02)000-0000</strong></span>
                    <br>
                    <span>상세주소 : <strong>서울시 강남구 테헤란로</strong></span>
                </div>
                <div class="location-center mb-4">
                    <span>구역번호 : <strong>B구역</strong></span>
                    <span>인원수 : <strong>5명</strong></span>
                    <br>
                    <span>체크인 : <strong>2022/08/08 1:00pm</strong></span>
                    <span>체크아웃 : <strong>2022/08/09 10:00am</strong></span>
                    <br>
                    <span>요청사항 : <strong>숯불바베큐 장비도 대여합니다!</strong></span>
                </div>
                <div class="location-right">
                    <span>예약일자 : <strong>2022/07/10</strong></span>
                    <span>처리상태 : <strong>예약취소</strong></span>
                    <br>
                    <span>예약자 전화번호 : <strong>010-1111-1111</strong></span>
                </div>
            </div>
        </div>

    </div>

    <div class="modal fade" id="CancleReservation" data-bs-backdrop="static" data-bs-keyboard="false">
        <div class="modal-dialog modal-sm">
            <div class="modal-content">
                <div class="modal-body">
                    <div class="mb-3 location-center">
                        <p>정말 예약취소 하시겠습니까?</p>
                    </div>

                    <div class="location-center">
                        <button type="submit" class="btn btn-success" data-bs-dismiss="modal">예약취소</button>
                        <button type="button" class="btn btn-danger" data-bs-dismiss="modal">돌아가기</button>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>