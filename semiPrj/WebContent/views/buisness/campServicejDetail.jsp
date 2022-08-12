<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String num = (String)request.getParameter("num");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/SjyCss.css">
<style>
	td>a{
	display: block;
}
</style>
</head>
<body>
	<%@ include file="/views/buisness/bsHeader.jsp" %>
    <main class="navbar navbar-expand-sm container">
    <div id="side"  class="shadow">
        <div id="sidebar" class="col">

            <div style="margin-left: 10%; font-size: 20px; color: white;">고객센터</div>
            <ul class="menu">
                <li>
                    <a href="#">문의</a>
                    <ul class="submenu">
                        
                        <li style="font-size: 14px;"><a href="<%=contextPath%>/views/buisness/campSvcCenter.jsp">문의 내역조회</a></li>
                    </ul>
                </li>

            </ul>

        </div>

    </div>
			
			<div id="content" >
				<h2>문의 상세 조회</h2>
				<hr>
                <div>게시글번호: <%=num %></div>
				<label for="">작성자: </label>
                <br><br>
                <label for="">내용:  </label>
                <div>Lorem ipsum, dolor sit amet consectetur adipisicing elit. Consequatur mollitia ducimus dolore in minus, consectetur sed? Vero aperiam vitae, itaque repellendus laboriosam hic quasi odio eius dolore ipsa beatae dignissimos?</div>


                <hr>
                댓글
			</div>
			

		</main>
	
		<%@ include file="/views/common/footer.jsp" %>
</body>
</html>