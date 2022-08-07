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

    .location-center {
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

        <div class="contentBox">

            <h3 class="mb-4">내정보</h3>

            <form action="" method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">이름:</label>
                    <input type="text" class="form-control" id="name" placeholder="Enter name" name="name" required>
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">휴대폰번호:</label>
                    <input type="text" class="form-control" id="phone" placeholder="ex) 01000000000" name="phone" required>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">이메일:</label>
                    <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
                </div>
                <div class="mb-3">
                    <label for="birth" class="form-label">생년월일:</label>
                    <input type="date" class="form-control" id="birth" placeholder="Enter BithDay" name="birth">
                </div>
                <div class="mb-3">
                    성별: 
                    <label><input type="radio" name="gender" value="M"> 남자</label>
                    <label><input type="radio" name="gender" value="F"> 여자</label>
                </div>

                <div class="location-center">
                    <button type="reset" class="btn-basic">초기화</button>
                    <button type="submit" class="btn-basic">수정완료</button>
                </div>
                <div class="location-right mt-3">
                    <button type="reset" class="btn-basic" data-bs-toggle="modal" data-bs-target="#ChangePwd">비밀번호 변경하기</button>
                </div>
                <div class="location-right mt-4">
                    <a href="" class="a-basic" data-bs-toggle="modal" data-bs-target="#CheckForm">회원탈퇴</a>
                </div>
            </form>
        </div>

        <div class="modal fade" id="ChangePwd" data-bs-backdrop="static" data-bs-keyboard="false">
            <div class="modal-dialog modal-xl">
                <div class="modal-content">
                    <div class="modal-header">
                        <h4 class="modal-title">비밀번호 변경</h4>
                    </div>
                
                    <div class="modal-body">
                        <form action="" method="post">
                            <div class="mb-3">
                              <label for="pwd" class="form-label">기존 비밀번호:</label>
                              <input type="password" class="form-control" id="pwd" placeholder="Enter password" name="pwd" required>
                            </div>
                            <div class="mb-3">
                              <label for="newPwd" class="form-label">신규 비밀번호:</label>
                              <input type="password" class="form-control" id="newPwd" placeholder="Enter password" name="newPwd" required>
                            </div>
                            <div class="mb-3">
                              <label for="newPwdCheck" class="form-label">신규 비밀번호 확인:</label>
                              <input type="password" class="form-control" id="newPwdCheck" placeholder="Enter password" name="newPwdCheck" required>
                            </div>
    
                            <div class="location-right">
                                <button type="submit" class="btn btn-success" data-bs-dismiss="modal">비밀번호 변경</button>
                                <button type="button" class="btn btn-danger" data-bs-dismiss="modal">취소하기</button>
                            </div>
                          </form>
                    </div>
                </div>
            </div>
        </div>

        <div class="modal fade" id="CheckForm" data-bs-backdrop="static" data-bs-keyboard="false">
            <div class="modal-dialog modal-sm">
                <div class="modal-content">
                    <div class="modal-body">
                        <div class="mb-3 location-center">
                            <p>정말 회원탈퇴 하시겠습니까?</p>
                        </div>

                        <div class="location-center">
                            <button type="submit" class="btn btn-success" data-bs-dismiss="modal">탈퇴하기</button>
                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">취소하기</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

</body>
</html>