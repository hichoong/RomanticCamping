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
</style>
	<meta charset="UTF-8">
	<title>Insert title here</title>
</head>

<body>
	<%-- <%@ include file="/views/buisness/bsHeader.jsp" %>  --%>
	<%@ include file="/views/common/header.jsp" %>
	<main class="navbar navbar-expand-sm container">
	<%@ include file="/views/buisness/sidebar.jsp" %>
	

		<div id="content">
			<h2>My camping</h2>
			<hr>

			<div id="wrap"  style="overflow-y:scroll;">
                    <!-- 접속id에 맞는 회원의 캠핑장  -->
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp1</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp2</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp3</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp4</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp5</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp6</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp1</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp2</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp3</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp4</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp5</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp6</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp2</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp3</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp4</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp5</span></a></article>
                    <article class=" shadow"><a href="campDetaileInfo.jsp"><img src="https://placehold.jp/200x200.png" alt=""><span>camp6</span></a></article>
                    
            </div>

			
				</div>
	</main><!--#content  -->
			

	<%@ include file="/views/common/footer.jsp" %>
</body>

<script>

</script>



</html>
