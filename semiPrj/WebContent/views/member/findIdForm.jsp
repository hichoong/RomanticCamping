<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>낭만캠핑</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/memberCommon.css" type="text/css">
<style>

    .loginBox {
        width: 600px;
        margin: auto;
        margin-top: 100px;
        border: 1px solid #FFA000;
        border-radius: 0.5rem;
        padding: 50px;
    }

    .sub-btn-list {
        padding-top: 30px;
        text-align: center;
    }

</style>
</head>
<body>

    <%@ include file="/views/common/header.jsp" %>

    <div class="container">

        <div class="loginBox">

            <h3 class="mb-4">아이디 찾기</h3>

            <form action="" method="post">
                <div class="mb-4 mt-4">
                  <label for="name" class="form-label">이름:</label>
                  <input type="text" class="form-control" id="name" placeholder="이름를 입력하세요." name="name">
                </div>
                <div class="mb-3">
                  <label for="phone" class="form-label">핸드폰 번호:</label>
                  <input type="tel" class="form-control" id="phone" placeholder="핸드폰 번호를 입력하세요." name="phone">
                </div>
                <div class="location-right">
                    <button type="submit" class="basic-btn">아이디 찾기</button>
                </div>
                <div class="sub-btn-list">
                  <a href="<%=contextPath%>/views/member/findPwdForm.jsp" class="basic-a">비밀번호 찾기</a> |
                  <a href="<%=contextPath%>/views/member/loginForm.jsp" class="basic-a">로그인하기</a> |
                    <a href="<%=contextPath%>/views/member/joinForm.jsp" class="basic-a">회원가입</a>
                </div>
              </form>
        </div>

    </div>

    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>