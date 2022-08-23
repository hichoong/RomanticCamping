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
            <c:forEach items="${couponList}" var="coupon">
	            <div class="couponBox">
	                <span id="couponDDay" class="coupon-text mb-3">D-${coupon.couponDDay}</span>
	                <div class="location-center">
	                    <p id="couponName" class="coupon-text">${coupon.couponName}</p>
	                    <p id="couponPrice" class="coupon-text">${coupon.couponDiscount}</p>
	                </div>
	                <div class="location-right">
	                    <span>${coupon.couponStartDay}</span>
	                    ~
	                    <span>${coupon.couponEndDay}</span>
	                </div>
	            </div>
            </c:forEach>
        </div>
        
    </div>


    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>