<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/SjyCss.css">
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
        /* border-top: 1px solid #FFA000; */
        /* border-bottom: 1px solid #FFA000; */
        box-shadow: 0 0 6px #FFA000;
      }

    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
      <a class="navbar-brand title-text" href="<%=contextPath%>/views/buisness/bsMainForm.jsp">&#x26FA 낭만캠핑</a>
      
      <ul class="navbar-nav">
        <li class="nav-item">
          <a class="nav-link menu-text" href="<%=contextPath%>/views/buisness/campSearchForm.jsp">캠핑장</a>
        </li>
        <li class="nav-item">
          <a class="nav-link menu-text" href="<%=contextPath%>/views/buisness/campQuestion.jsp">문의사항</a>
        </li>
        <li class="nav-item">
          <a class="nav-link menu-text" href="<%=contextPath%>/views/buisness/campSvcCenter.jsp">고객센터</a>
        </li>
      </ul>
    
    </div>
    
    <div class="dropdown user-btn">
      <button type="button" class="btn btn-primary rounded-pill" data-bs-toggle="dropdown">
        &#128512;
      </button>
      <ul class="dropdown-menu dropdown-menu-end">
        <li><a class="dropdown-item" href="<%=contextPath%>/views/buisness/campRsvForm.jsp">예약 확인</a></li>
        <li><a class="dropdown-item" href="<%=contextPath%>/views/buisness/campSearchForm.jsp">내 캠핑장</a></li>
        <li><a class="dropdown-item" href="#">마이페이지</a></li>
        <li><a class="dropdown-item" href="<%=contextPath%>/views/buisness/logout">로그아웃</a></li>
        <hr>
        <li><a class="dropdown-item" href="<%=contextPath%>/views/buisness/bsMainForm.jsp">메인으로</a></li>
        <li><a class="dropdown-item" href="<%=contextPath%>/views/buisness/campQuestion.jsp">캠핑장 문의사항</a></li>
        <li><a class="dropdown-item" href="<%=contextPath%>/views/buisness/campSvcCenter.jsp">고객센터 Q&A</a></li>
        
      </ul>
    </div>
  </nav>

</body>
</html>