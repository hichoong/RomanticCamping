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
							<span>단호박 캠핑장</span>
						</div>
		
						<div class="md-3 ">
							<label for="campAdd" class="form-label">* 주소:</label>
							<span>경기도 포천시</span>
						</div>
		
						<div class="md-3">
							<label for="campDetailAdd">상세주소:</label>
							<span> 신북면 간자동길 138-100 </span>
						</div>
		
						<div class="md-3">
							<label for="phoneNum" class="form-label">* 연락처:</label>
							<span>02) 000-0000</span>
						</div>
		
						<div class="md-3">
							<label for="campIntro" class="form-label">* 시설소개:</label>
							<span>시설소개 블라블라블라ㅏㅏ</span>
						</div>

						<div class="md-3">
							<label for="camp" class="form-label">* 시설현황:</label>
							<input type="text" class="form-control" id="camp" placeholder="와이파이 전기 온수 반려견동반 매점 장작판매 운동자 산책로 물놀이장" name="camp" disabled>
						</div>

						<div class="md-3" id="tdTheme">
							<label for="campTheme" class="form-label">* 테마:(테마를 선택해주세요)</label>
							<!-- <input type="text" class="form-control" id="camp"  placeholder="해변 숲 섬 호수 도심 계곡 산 강" name="camp" disabled> -->
							<table >
								<tr>
									<td >
										<input type="checkbox" class="btn-check" id="beach" autocomplete="off" name="theme">
										<label class="btn btn-outline-success" for="beach">해변</label><br>
									</td>

									<td>
										<input type="checkbox" class="btn-check" id="forest" autocomplete="off" name="theme">
										<label class="btn btn-outline-success" for="forest">숲</label><br>
										</td>

									<td>
										<input type="checkbox" class="btn-check" id="island" autocomplete="off" name="theme">
										<label class="btn btn-outline-success" for="island">섬</label><br>
									</td>

									<td>
										<input type="checkbox" class="btn-check" id="lake" autocomplete="off" name="theme">
										<label class="btn btn-outline-success" for="lake">호수</label><br>
									</td>

									<td>
										<input type="checkbox" class="btn-check" id="downtown" autocomplete="off" name="theme">
										<label class="btn btn-outline-success" for="downtown">도심</label><br>
									</td>

									<td>
										<input type="checkbox" class="btn-check" id="valley" autocomplete="off" name="theme">
										<label class="btn btn-outline-success" for="valley">계곡</label><br>
										</td>

									<td>
										<input type="checkbox" class="btn-check" id="mountain" autocomplete="off" name="theme">
										<label class="btn btn-outline-success" for="mountain">산</label><br>
									</td>

									<td>
										<input type="checkbox" class="btn-check" id="river" autocomplete="off" name="theme">
										<label class="btn btn-outline-success" for="river">강</label><br>
									</td>
							</table>
						</div>
						
		
						<div class="md-3">
							<label for="campRefund" class="form-label">* 환불규정:</label>
							<span>환불규정 블라라블라라ㅏ블라ㅏㅏㅏ</span>
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
							<input type="datetime-local" class="form-control" id="" placeholder="등록일" name=""value="<%=toDay%>" disabled>
						</div>
		
						</div>
		
						<div id="end">
							<input type="button" value="수락" id="send" class="btn btn-warning">
							<input type="button" value="거절" id="send" class="btn btn-warning">
						</div>
					</div><!--content-->
		
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
								<label for="campAreaName" class="form-label">구역이름</label>\
								<input class="form-control" type="text" id="campAreaName" >\
							</div>\
					<div class="mb-3">\
								<label for="maxGusests" class="form-label">최대 숙박인원</label>\
								<input class="form-control" type="text" id="maxGusests" >\
							</div>\
							<div class="mb-3">\
								<label for="campAreaPrice" class="form-label">가격</label>\
								<input class="form-control" type="text" id="campAreaPrice" >\
					</div>\
					<div class="mb-3">\
							<label for="campRepImgMulti" class="form-label">구역 이미지(※최대 _개)</label>\
							<input class="form-control" type="file" id="campRepImgMulti" multiple>\
					</div>\
				<button type="button" class="btn btn-danger btnRemove">삭제</button><br><br>'
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

				// $(document.getElementsByClassName('addInput')).children().remove();
            })
        })
    })
</script>


</html>
