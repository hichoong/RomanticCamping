<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="com.sjy.buisness.camp.vo.BsCampVo"%>
<% 
	ArrayList<BsCampVo> voList = (ArrayList<BsCampVo>)request.getAttribute("voList");
	BsCampVo vo = (BsCampVo)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>낭만캠프</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/campDetailRequest.css">
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>
	
	
	<h2>캠핑장 요청</h2>

    <div class="container">
	
       <%for(int i = 0; i < voList.size(); i++){%>
        <div class="contentBox">
            <div class="content">
                <img class="testImg" src="<%=voList.get(i).getCampImgPath()%>">
                <div class="mb-4">
                	<span>NO. <%=voList.get(i).getCampCode()%></span>
                    <br><br>
                    <span>캠핑장 : <%=voList.get(i).getCampName()%></span>
                    <br><br>
                    <span>연락처</span> : <%=voList.get(i).getCampPhone()%></span>
                    <br><br>
                    <span>주소 : <%=voList.get(i).getCampAddress()%></span>
                    <br><br>
                    <span>시설 소개 : <%=voList.get(i).getCampIntro()%></span>
                </div>
            </div>
            <div id="btn">
                <button class="btn btn-warning" onclick="location.href='<%=contextPath%>'" >상세보기</button>
            </div>
        </div>
       <%}%>
       

        <!-- 페이지네이션 -->
        <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
        </ul>

    </div>
    
 
	
	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>