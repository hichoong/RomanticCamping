<%@page import="com.sjy.buisness.camp.vo.BsCampVo"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%
	BsCampVo vo = (BsCampVo)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>

<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

<link rel="stylesheet" href="/resource/css/SjyCss.css">

<style type="text/css">

</style>
	<meta charset="UTF-8">
	<title>캠핑장 등록 요청 상세보기</title>
</head>

<body>
	<%@ include file="/views/buisness/bsHeader.jsp" %>
	<main class="navbar navbar-expand-sm container">
	<%@ include file="/views/buisness/sidebar.jsp" %>
			
			<div id="content" >
		
		
				<form action="<%=contextPath %>/business/insert" method="post">
					<h2>캠핑장 등록 요청 상세페이지</h2>
					<hr>
					<div style="overflow-x: hidden; width: 100%; height: 700px;">
		
						<div class="md-3">
							<label for="campName" class="form-label">* 이름:</label>
							<span><%=vo.getCampName()%></span>
						</div>
		
						<div class="md-3 ">
							<label for="campAdd" class="form-label">* 주소:</label>
							<span><%=vo.getCity()%></span>
							<span><%=vo.getDistrict()%></span>
						</div>
		
						<div class="md-3">
							<label for="campDetailAdd">* 상세주소:</label>
							<span> <%=vo.getCampAddress()%> </span>
						</div>
		
						<div class="md-3">
							<label for="phoneNum" class="form-label">* 연락처:</label>
							<span><%=vo.getCampPhone()%></span>
						</div>
		
						<div class="md-3">
							<label for="campIntro" class="form-label">* 시설소개:</label>
							<span><%=vo.getCampIntro()%></span>
						</div>

						<div class="md-3">
							<label for="camp" class="form-label">* 시설현황:</label>
							<input type="text" class="form-control" id="camp" placeholder="와이파이 전기 온수 반려견동반 매점 장작판매 운동자 산책로 물놀이장" name="camp" disabled>
						</div>

						<div class="md-3">
							<label for="campRefund" class="form-label">* 환불규정:</label>
							<span><%=vo.getCampRefund()%></span>
						</div>
		
						<div class="mb-3">
							<label for="campRepImg" class="form-label">* 대표이미지:</label>
							<input class="form-control" type="file" name="campRepImg" id="campRepImg">
						</div>
		
						

						<div class="mb-3">
							<label for="" class="form-label">추가된 구역</label>
							<button type="button" class="btn btn-success btnAdd" onclick="addArea();">보기</button>
							<div class="addInput"></div>
							
						</div>

							<div class="md-3">
							<label for="" class="form-label">* 등록일:</label>
							<input type="datetime-local" class="form-control" id="" placeholder="등록일" name=""value="<%=vo.getRgDate()%>" disabled>
						</div>
		
						</div>
		
						<div id="end">
							<input type="button" value="수락" id="send" class="btn btn-warning onclick=" location.href='<%=contextPath%>/request/reject?num=<%=vo.getCampCode()%>'">
							<input type="button" value="거절" id="send" class="btn btn-warning">
						</div>
					</div>
		
				</form>
			</div>
		
		</main>

		<%@ include file="/views/common/footer.jsp" %>
</body>


<script> 
    $(document).ready (function(){
        $('.btnAdd').click(function(){
            $('.addInput').append(
                '<hr>\
					<div class="mb-3">\
								<label for="campAreaName" class="form-label">구역이름 : </label>\
								<span></span>\
								</div>\
					<div class="mb-3">\
								<label for="maxGusests" class="form-label">최대 숙박인원 : </label>\
								<span></span>\
							</div>\
							<div class="mb-3">\
								<label for="campAreaPrice" class="form-label">가격 : </label>\
								<span></span>\
					</div>\
					<div class="mb-3">\
							<label for="campRepImgMulti" class="form-label">구역 이미지(※최대 _개)</label>\
							<input class="form-control" type="file" id="campRepImgMulti" multiple>\
					</div>\<br><br>'
                );
            $('.btnRemove').on('click',function(){
                $(this).prev().remove();
				$(this).prev().remove();
				$(this).prev().remove();
				$(this).prev().remove();
				$(this).prev().remove();
				$(this).prev().remove();
                $(this).next().remove();
				$(this).next().remove();
                $(this).remove();

            })
        })
    })
</script>


</html>
