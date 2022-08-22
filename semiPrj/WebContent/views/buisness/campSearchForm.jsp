<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.sjy.buisness.camp.vo.BsCampVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%
	//오늘 날짜 구하기
	Date today = new Date();
	
	SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
	SimpleDateFormat time = new SimpleDateFormat("HH:mm");
	String d = date.format(today);
	String t = time.format(today);
	
	//등록일 기본값 세팅
	String toDay = d+"T"+t;
	
	List<BsCampVo> bsvo = (ArrayList<BsCampVo>)request.getAttribute("bsVo");
	int CampNum = (int)request.getAttribute("CampNum");
%>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet" href="<%=request.getContextPath() %>/resource/css/SjyCss.css">

<style type="text/css">
	div>a{
		color:black;
		text-decoration: none
	}
	div>img{
		width: 100%;
	}
    #wrap{
        width: 100%;
        margin: 0 auto;
        overflow: hidden;
        padding: 10px;
    } 
	
    div>article{
        float: left;
        margin-left: 50px;
        margin-bottom: 10px;
    } 
    img{display: block;} 
    article:hover {
    	cursor: pointer;
	}
	#wrap>article span{
		color:green;
	}


</style>
	<meta charset="UTF-8">
	<title>Insert title here</title>
<!--등록한 캠핑장 정보가져오기  -->

</head>
<body>
	<%-- <%@ include file="/views/buisness/bsHeader.jsp" %>  --%>
	<%@ include file="/views/common/header.jsp" %>
	<main class="navbar navbar-expand-sm container">
	<%@ include file="/views/buisness/sidebar.jsp" %>
	
	
		<div id="content">
			<h2>My camping</h2>
			<span style="color:gray">&nbsp;&Tab;-&nbsp;내 캠핑장 조회 </span>
			<hr>

			<div id="wrap"  style="overflow-y:scroll;">
                    <!-- 접속id에 맞는 회원의 캠핑장  -->
                     <!-- <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="캠핑장메인이미지" alt=""><span>캠핑장이름</span></a></article> -->
                     
                     <%for(BsCampVo vo : bsvo){%>
                    <article class=" shadow">
                    	<img src="https://placehold.jp/200x200.png" alt="">
                    	<input type="hidden" value="<%=vo.getCampCode()%>">
                    	<span><%=vo.getCampName() %></span>
                    </article>
                    <%}%>

                    <!-- <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp2</span></a></article> -->
                    
                    
            </div>

			
				</div>
	</main><!--#content  -->
			

	<%@ include file="/views/common/footer.jsp" %>
</body>

	<script>
		$(function(){
			$('#wrap>article').click(function(){
				//글번호 가져오기
				const campCode = $(this).children().eq(1).val();
				console.log(campCode);
				//해당 번호로 요청 보내기
				location.href='<%=contextPath%>/bscamp/detail?campCode=' + campCode;
				
			});
		})
	</script>



</html>
