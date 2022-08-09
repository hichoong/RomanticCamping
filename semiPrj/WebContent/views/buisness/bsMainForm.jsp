<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>낭만캠핑</title>
<style>

	#index-wrapper {
		width: 90%;
		margin: auto;
		padding-top: 10px;
	}

	#img-div {
		width: 500x;
		height: 500px;
		background-color: lightcoral;
	}


</style>
</head>
<body>
	<%@ include file="/views/buisness/bsHeader.jsp" %>
	
	<!-- <h1>index(경로: http://localhost:8803/camp/ )</h1> -->
	
	<div id="index-wrapper">
		<div id="index-main" >
			<div id="img-div">사진으로 바꿀 div</div>
		</div>
		<div id="index-sub">
			<div>사진으로 바꿀 div</div>
			<div>사진으로 바꿀 div</div>
			<div>사진으로 바꿀 div</div>
		</div>
	</div>

	<%@ include file="/views/common/footer.jsp" %>
</body>
</html>