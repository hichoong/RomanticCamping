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

            <h3 class="mb-4">로그인</h3>

            <form action="" method="post">
                <div class="mb-4 mt-4">
                  <label for="id" class="form-label">아이디:</label>
                  <input type="text" class="form-control" id="id" placeholder="아이디를 입력하세요." name="id">
                </div>
                <div class="mb-3">
                  <label for="pwd" class="form-label">비밀번호:</label>
                  <input type="password" class="form-control" id="pwd" placeholder="비밀번호를 입력하세요." name="pwd">
                </div>
                <div class="form-check mb-3">
                  <label class="form-check-label">
                    <input class="form-check-input" type="checkbox" name="remember"> 아이디 저장
                  </label>
                </div>
                <div class="location-right">
                    <button type="submit" class="basic-btn">로그인</button>
                </div>
                <div class="sub-btn-list">
                    <a href="<%=contextPath%>/views/member/findIdForm.jsp" class="basic-a">아이디 찾기</a> |
                    <a href="<%=contextPath%>/views/member/findPwdForm.jsp" class="basic-a">비밀번호 찾기</a> |
                    <a href="<%=contextPath%>/views/member/joinForm.jsp" class="basic-a">회원가입</a>
                </div>
              </form>
        </div>

    </div>

    <%@ include file="/views/common/footer.jsp" %>

</body>
</html>