<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>낭만캠핑</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/memberCommon.css" type="text/css">
<style>

    .couponBox {
        display: inline-block;
        width: 400px;
        margin: auto;
        margin-top: 30px;
        border: 1px solid #FFA000;
        border-radius: 0.5rem;
        padding: 15px;
    }

    .coupon-text {
        margin: 0px;
    }

    #couponDDay {
        font-size: 28px;
        font-weight: 800;
        border: 1px solid #FFA000;
        border-radius: 1rem;
        padding: 5px;
        color: #FFA000;
    }

    #couponName {
        padding-top: 5px;
        font-size: 20px;
    }

    #couponPrice {
        font-size: 30px;
        padding-bottom: 5px;
    }

    .flexstyle-st {
        display: flex;
        justify-content: flex-start;
        flex-wrap: wrap;
    }
    
</style>
</head>
<body>

    <%@ include file="/views/common/header.jsp" %>

    <div class="container">

        <h3 class="mb-4">보유쿠폰</h3>

        <div class="flexstyle-st">
            <div class="couponBox">
                <span id="couponDDay" class="coupon-text mb-3">남은 기간</span>
                <div class="location-center">
                    <p id="couponName" class="coupon-text">쿠폰명</p>
                    <p id="couponPrice" class="coupon-text">할인금액</p>
                </div>
                <div class="location-right">
                    <span>쿠폰 시작 기간</span>
                    ~
                    <span>쿠폰 종료 기간</span>
                </div>
            </div>
    
            <div class="couponBox">
                <span id="couponDDay" class="coupon-text mb-3">D-30</span>
                <div class="location-center">
                    <p id="couponName" class="coupon-text">신규회원가입쿠폰</p>
                    <p id="couponPrice" class="coupon-text">20000원</p>
                </div>
                <div class="location-right">
                    <span>2022-08-03</span>
                    ~
                    <span>2022-09-03</span>
                </div>
            </div>

            <div class="couponBox">
                <span id="couponDDay" class="coupon-text mb-3">D-30</span>
                <div class="location-center">
                    <p id="couponName" class="coupon-text">신규회원가입쿠폰</p>
                    <p id="couponPrice" class="coupon-text">20000원</p>
                </div>
                <div class="location-right">
                    <span>2022-08-03</span>
                    ~
                    <span>2022-09-03</span>
                </div>
            </div>

            <div class="couponBox">
                <span id="couponDDay" class="coupon-text mb-3">D-30</span>
                <div class="location-center">
                    <p id="couponName" class="coupon-text">신규회원가입쿠폰</p>
                    <p id="couponPrice" class="coupon-text">20000원</p>
                </div>
                <div class="location-right">
                    <span>2022-08-03</span>
                    ~
                    <span>2022-09-03</span>
                </div>
            </div>
        </div>
        
    </div>


    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>