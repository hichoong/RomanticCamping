<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>낭만캠핑</title>
<style>

    .outer-wrapper {
        width: 80%;
        margin: auto;
    }

    .loginBox {
        width: 600px;
        margin: auto;
        margin-top: 100px;
        border: 1px solid #FFA000;
        border-radius: 0.5rem;
        padding: 50px;
    }

    .btn-basic {
        text-align: center;
        vertical-align: middle;
        cursor: pointer;
        border: 1px solid transparent;  
        padding: 0.375rem 0.75rem;
        border-radius: 0.25rem;
        background-color: white;
        border-color: #F57C00;
        color: #F57C00;
    }

    .btn-basic:hover {
        background-color: #F57C00;
        color: white;
    }

    .a-basic {
        text-decoration: none;
        color: black;
        padding: 5px;
    }

    .a-basic:hover {
        color: #FF5722;
    }

    .sub-btn-list {
        padding-top: 30px;
        text-align: center;
    }

    .location-right {
        text-align: end;
    }

    h3 {
        color: #E64A19;
    }

</style>
</head>
<body>

    <%@ include file="/views/common/header.jsp" %>

    <div class="outer-wrapper">

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
                    <button type="submit" class="btn-basic">로그인</button>
                </div>
                <div class="sub-btn-list">
                    <a href="" class="a-basic">아이디 찾기</a> |
                    <a href="" class="a-basic">비밀번호 찾기</a> |
                    <a href="" class="a-basic">회원가입</a>
                </div>
              </form>
        </div>

    </div>

</body>
</html>