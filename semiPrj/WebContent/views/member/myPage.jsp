<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>낭만캠핑</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/memberCommon.css" type="text/css">
<style>

</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>

    <div class="container">

        <div class="contentBox">

            <h3 class="mb-4">내정보</h3>

            <form action="<%=contextPath%>/member/myPage" method="post">
                <div class="mb-3">
                    <label for="name" class="form-label">이름:</label>
                    <input type="text" class="form-control" id="name" value="${loginMember.name}" name="name" required>
                </div>
                <div class="mb-3">
                    <label for="phone" class="form-label">휴대폰번호:</label>
                    <input type="text" class="form-control" id="phone" value="${loginMember.phone}" placeholder="ex) 01012345678" name="phone" required>
                </div>
                <div class="mb-3">
                    <label for="email" class="form-label">이메일:</label>
                    <input type="email" class="form-control" id="email" value="${loginMember.email}" placeholder="ex) example@ex.com" name="email">
                </div>
                <% if(loginMember.getType().equals("U")) { %>
	                <div class="mb-3">
	                    <label for="birth" class="form-label">생년월일:</label>
	                    <input type="date" class="form-control" id="birth" value="<%=loginMember.getBirthdayToDate()%>" name="birth">
	                </div>
	                <div class="mb-3">
	                    성별: 
	                    <label><input type="radio" name="gender" value="M"> 남자</label>
	                    <label><input type="radio" name="gender" value="F"> 여자</label>
	                </div>
                <%} %>
                <div class="location-center">
                    <button type="reset" class="basic-btn" onclick="genderCheck();">초기화</button>
                    <button type="submit" class="basic-btn">수정완료</button>
                </div>
                <div class="location-right mt-3">
                    <button type="reset" class="reversed-btn" data-bs-toggle="modal" data-bs-target="#ChangePwd">비밀번호 변경하기</button>
                </div>
                <div class="location-right mt-4">
                    <a href="" class="basic-a" data-bs-toggle="modal" data-bs-target="#CheckForm">회원탈퇴</a>
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
                        <form action="<%=contextPath%>/member/changePwd" method="post">
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
                                <button type="submit" class="btn btn-success" onclick="return checkPwd();">비밀번호 변경</button>
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
                            <button type="submit" class="btn btn-success" onclick="location.href='<%=contextPath%>/member/quit'">탈퇴하기</button>
                            <button type="button" class="btn btn-danger" data-bs-dismiss="modal">취소하기</button>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <%@ include file="/views/common/footer.jsp" %>

	<script>
		
		$(function genderCheck(){
			$('input[name=gender]').each(function(){
				if(this.value =='${loginMember.gender}') {
					this.checked = true;
				}
			});
		})
	
		function checkPwd(){
			isSame = $('input[name=newPwd]').val() == $('input[name=newPwdCheck]').val();
			if(isSame) {
				return true;
			} else {
				alert("신규 비밀번호가 일치하지 않습니다.");
				return false;
			}
		}
		
	</script>

</body>
</html>