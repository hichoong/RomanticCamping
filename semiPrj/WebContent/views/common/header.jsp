<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

    <!-- Latest compiled and minified CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    
    <style>

      .header {
        height: 50px;
      }

      .header>div {
        padding-top: 10px;
        padding-left: 10px;
      }

      .title-text {
        color: #BC5100;
        font-size: 32px;
        font-weight: bold;
      }

      .title-text:hover {
        color: #BC5100;
      }

      .menu-text {
        color: #E64A19;
        font-size: 24px;
      }

      .menu-text:hover {
        color: #FF5722;
        font-weight: bold;
      }

      .user-btn {
        padding-left: 30px;
        padding-right: 30px;
      }

      .container-fluid {
        width: 90%;
      }

      .nav-border {
        margin-top: 20px;
        margin-bottom: 20px;
        box-shadow: 0 0 6px #FFA000;
      }

    </style>
</head>
<body>

  <header class="header">
    <div>
      <span>tel: 000-0000-0000</span>
      <span>email: 000</span>
    </div>
  </header>

  <nav class="navbar navbar-expand-sm nav-border">
    <div class="container-fluid">          
      <a class="navbar-brand title-text" href="<%=contextPath%>">&#x26FA 낭만캠핑</a>
      
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link menu-text" href="<%=contextPath%>/camp/campList">캠핑장</a>
        </li>
        <li class="nav-item">
          <a class="nav-link menu-text" href="<%=contextPath%>/views/freeBoard/freeBoardPage.jsp">자유게시판</a>
        </li>
        <li class="nav-item">
          <a class="nav-link menu-text" href="<%=contextPath%>/views/board/qestionBoard.jsp">고객센터</a>
        </li>
      </ul>
    
    </div>
    
    <div class="dropdown user-btn">
      <button type="button" class="btn btn-primary rounded-pill" data-bs-toggle="dropdown">
        &#128512;
      </button>
      <ul class="dropdown-menu dropdown-menu-end">
        <li><a class="dropdown-item" href="<%=contextPath%>/views/member/loginForm.jsp">로그인</a></li>
        <li><a class="dropdown-item" href="<%=contextPath%>/views/member/joinForm.jsp">회원가입</a></li>
        <li><hr class="dropdown-divider"></hr></li>
        <li><a class="dropdown-item" href="<%=contextPath%>/views/member/myPage.jsp">마이페이지</a></li>
        <li><a class="dropdown-item" href="<%=contextPath%>/views/member/myReservationPage.jsp">캠핑 예약확인</a></li>
        <li><a class="dropdown-item" href="<%=contextPath%>/views/member/wishListPage.jsp">찜목록</a></li>
        <li><a class="dropdown-item" href="<%=contextPath%>/views/member/myBoardList.jsp">내가 쓴 글</a></li>
        <li><a class="dropdown-item" href="<%=contextPath%>/views/member/myCouponList.jsp">내 쿠폰함</a></li>
      </ul>
    </div>
  </nav>

</body>
</html>