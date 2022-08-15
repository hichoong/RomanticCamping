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
	<title>Insert title here</title>
</head>

<body>
	<%@ include file="/views/buisness/bsHeader.jsp"%>
	<main class="navbar navbar-expand-sm container">
		<%@ include file="/views/buisness/sidebar.jsp"%>

		<div id="content">


			<form action="<%=contextPath%>/business/insert" method="post">
				<h2>캠핑장 등록</h2>
				<%System.out.println(contextPath); %>
				<hr>
				<div style="overflow-x: hidden; width: 100%; height: 700px;">

					<div class="md-3">
						<label for="campName" class="form-label">* 이름:</label> <input
							type="text" class="form-control" id="campName"
							placeholder="캠핑장 이름 입력" name="campName" required>
					</div>

					<div class="md-3 ">
						<label for="campAdd" class="form-label">* 주소:</label> <select
							name="addSido1" class="form-select" id="addSido1"></select> <select
							name="addGugun1" class="form-select" id="addGugun1"></select>
					</div>



					<div class="md-3">
						<label for="campDetailAdd">상세주소:</label>
						<textarea class="form-control" rows="3" id="campDetailAdd"
							placeholder="상세주소 입력" name="campDetailAdd"></textarea>
					</div>

					<div class="md-3">
						<label for="phoneNum" class="form-label">* 연락처:</label> <input
							type="text" class="form-control" id="phoneNum"
							placeholder="캠핑장 연락처 입력" name="phoneNum" required>
					</div>

					<div class="md-3">
						<label for="campIntro" class="form-label">* 시설소개:</label> <input
							type="text" class="form-control" id="campIntro"
							placeholder="시설소개" name="campIntro" required>
					</div>

					<div class="md-3">
						<label for="camp" class="form-label">* 시설현황:</label> <input
							type="text" class="form-control" id="camp"
							placeholder="와이파이 전기 온수 반려견동반 매점 장작판매 운동장 산책로 물놀이장" name="camp"
							disabled>
								<img alt="dd" src="<%=contextPath %>/resource/img/facility.png">
							    <input type="checkbox" id="ft1" class="facility">
							    <label for="ft1" >와이파이</label>
							   	
							    <input type="checkbox" id="ft2" class="facility">
							    <label for="ft2">전기</label>
							    <input type="checkbox" id="ft3" class="facility">
							    <label for="ft3">온수</label>
							    <input type="checkbox" id="ft4" class="facility">
							    <label for="ft4">반려견동반</label>
							    <input type="checkbox" id="ft5" class="facility">
							    <label for="ft5">매점</label>
							    
							    <input type="checkbox" id="ft6" class="facility">
							    <label for="ft6">장작판매</label>
							    <input type="checkbox" id="ft7" class="facility">
							    <label for="ft7">운동장</label>
							    <input type="checkbox" id="ft8" class="facility">
							    <label for="ft8">산책로</label>
							    <input type="checkbox" id="ft9" class="facility">
							    <label for="ft9">물놀이장</label>
					</div>

					<div class="md-3" id="tdTheme">
						<label for="campTheme" class="form-label">* 테마:(테마를
							선택해주세요)</label>
						<!-- <input type="text" class="form-control" id="camp"  placeholder="해변 숲 섬 호수 도심 계곡 산 강" name="camp" disabled> -->
						<table>
							<tr>
								<td><input type="checkbox" class="btn-check" id="beach"
									autocomplete="off" name="theme"> <label
									class="btn btn-outline-success" for="beach">해변</label><br>
								</td>

								<td><input type="checkbox" class="btn-check" id="forest"
									autocomplete="off" name="theme"> <label
									class="btn btn-outline-success" for="forest">숲</label><br>
								</td>

								<td><input type="checkbox" class="btn-check" id="island"
									autocomplete="off" name="theme"> <label
									class="btn btn-outline-success" for="island">섬</label><br>
								</td>

								<td><input type="checkbox" class="btn-check" id="lake"
									autocomplete="off" name="theme"> <label
									class="btn btn-outline-success" for="lake">호수</label><br>
								</td>

								<td><input type="checkbox" class="btn-check" id="downtown"
									autocomplete="off" name="theme"> <label
									class="btn btn-outline-success" for="downtown">도심</label><br>
								</td>

								<td><input type="checkbox" class="btn-check" id="valley"
									autocomplete="off" name="theme"> <label
									class="btn btn-outline-success" for="valley">계곡</label><br>
								</td>

								<td><input type="checkbox" class="btn-check" id="mountain"
									autocomplete="off" name="theme"> <label
									class="btn btn-outline-success" for="mountain">산</label><br>
								</td>

								<td><input type="checkbox" class="btn-check" id="river"
									autocomplete="off" name="theme"> <label
									class="btn btn-outline-success" for="river">강</label><br>
								</td>

							</tr>
						</table>
					</div>

					<div class="md-3">
						<label for="campRefund" class="form-label">* 환불규정:</label> <input
							type="text" class="form-control" id="campRefund"
							placeholder="환불규정" name="campRefund" required>
					</div>

					<div class="mb-3">
						<label for="campRepImg" class="form-label">* 대표이미지:</label> <input
							class="form-control" type="file" name="campRepImg"
							id="campRepImg">
					</div>



					<div class="mb-3">
						<label for="" class="form-label">구역 추가하기</label>
						<button type="button" class="btn btn-success btnAdd"
							onclick="addArea(); ">추가</button>
						<div class="addInput">

							<hr>
							<div class="mb-3">
								<label for="campAreaName" class="form-label">구역이름</label> <input
									class="form-control" type="text" id="campAreaName">
							</div>
							<div class="mb-3">
								<label for="maxGusests" class="form-label">최대 숙박인원</label> <input
									class="form-control" type="text" id="maxGusests">
							</div>
							<div class="mb-3">
								<label for="campAreaPrice" class="form-label">가격</label> <input
									class="form-control" type="text" id="campAreaPrice">
							</div>
							<div class="mb-3">
								<label for="campRepImgMulti" class="form-label">구역
									이미지(※최대 _개)</label> <input class="form-control" type="file"
									id="campRepImgMulti" multiple>
							</div>
							<button type="button" class="btn btn-danger btnRemove">삭제</button>
							<br>
							<br>

						</div>
					</div>

					<div class="md-3">
						<label for="" class="form-label">* 등록일:</label> <input
							type="datetime-local" class="form-control" id=""
							placeholder="등록일" name="" value="<%=toDay%>" disabled>
					</div>

				</div>

				<div id="end">
					<input type="submit" value="등록요청" id="send" class="rounded">
				</div>
			</form>
		</div>
		<!--content-->



	</main>

	<%@ include file="/views/common/footer.jsp"%>
</body>

<script>
	console.log("hi");
	$('document')
			.ready(
					function() {
						var area0 = [ "시/도 선택", "서울특별시", "인천광역시", "대전광역시",
								"광주광역시", "대구광역시", "울산광역시", "부산광역시", "경기도",
								"강원도", "충청북도", "충청남도", "전라북도", "전라남도", "경상북도",
								"경상남도", "제주도" ];
						var area1 = [ "강남구", "강동구", "강북구", "강서구", "관악구", "광진구",
								"구로구", "금천구", "노원구", "도봉구", "동대문구", "동작구",
								"마포구", "서대문구", "서초구", "성동구", "성북구", "송파구",
								"양천구", "영등포구", "용산구", "은평구", "종로구", "중구", "중랑구" ];
						var area2 = [ "계양구", "남구", "남동구", "동구", "부평구", "서구",
								"연수구", "중구", "강화군", "옹진군" ];
						var area3 = [ "대덕구", "동구", "서구", "유성구", "중구" ];
						var area4 = [ "광산구", "남구", "동구", "북구", "서구" ];
						var area5 = [ "남구", "달서구", "동구", "북구", "서구", "수성구",
								"중구", "달성군" ];
						var area6 = [ "남구", "동구", "북구", "중구", "울주군" ];
						var area7 = [ "강서구", "금정구", "남구", "동구", "동래구", "부산진구",
								"북구", "사상구", "사하구", "서구", "수영구", "연제구", "영도구",
								"중구", "해운대구", "기장군" ];
						var area8 = [ "고양시", "과천시", "광명시", "광주시", "구리시", "군포시",
								"김포시", "남양주시", "동두천시", "부천시", "성남시", "수원시",
								"시흥시", "안산시", "안성시", "안양시", "양주시", "오산시",
								"용인시", "의왕시", "의정부시", "이천시", "파주시", "평택시",
								"포천시", "하남시", "화성시", "가평군", "양평군", "여주군", "연천군" ];
						var area9 = [ "강릉시", "동해시", "삼척시", "속초시", "원주시", "춘천시",
								"태백시", "고성군", "양구군", "양양군", "영월군", "인제군",
								"정선군", "철원군", "평창군", "홍천군", "화천군", "횡성군" ];
						var area10 = [ "제천시", "청주시", "충주시", "괴산군", "단양군",
								"보은군", "영동군", "옥천군", "음성군", "증평군", "진천군", "청원군" ];
						var area11 = [ "계룡시", "공주시", "논산시", "보령시", "서산시",
								"아산시", "천안시", "금산군", "당진군", "부여군", "서천군",
								"연기군", "예산군", "청양군", "태안군", "홍성군" ];
						var area12 = [ "군산시", "김제시", "남원시", "익산시", "전주시",
								"정읍시", "고창군", "무주군", "부안군", "순창군", "완주군",
								"임실군", "장수군", "진안군" ];
						var area13 = [ "광양시", "나주시", "목포시", "순천시", "여수시",
								"강진군", "고흥군", "곡성군", "구례군", "담양군", "무안군",
								"보성군", "신안군", "영광군", "영암군", "완도군", "장성군",
								"장흥군", "진도군", "함평군", "해남군", "화순군" ];
						var area14 = [ "경산시", "경주시", "구미시", "김천시", "문경시",
								"상주시", "안동시", "영주시", "영천시", "포항시", "고령군",
								"군위군", "봉화군", "성주군", "영덕군", "영양군", "예천군",
								"울릉군", "울진군", "의성군", "청도군", "청송군", "칠곡군" ];
						var area15 = [ "거제시", "김해시", "마산시", "밀양시", "사천시",
								"양산시", "진주시", "진해시", "창원시", "통영시", "거창군",
								"고성군", "남해군", "산청군", "의령군", "창녕군", "하동군",
								"함안군", "함양군", "합천군" ];
						var area16 = [ "서귀포시", "제주시", "남제주군", "북제주군" ];

						// 시/도 선택 박스 초기화

						$("select[name^=addSido]")
								.each(
										function() {
											$selsido = $(this);
											$
													.each(
															eval(area0),
															function() {
																$selsido
																		.append("<option value='" + this + "'>"
																				+ this
																				+ "</option>");
															});
											$selsido
													.next()
													.append(
															"<option value=''>구/군 선택</option>");
										});

						// 시/도 선택시 구/군 설정

						$("select[name^=addSido]")
								.change(
										function() {
											var area = "area"
													+ $("option", $(this))
															.index(
																	$(
																			"option:selected",
																			$(this))); // 선택지역의 구군 Array
											var $gugun = $(this).next(); // 선택영역 군구 객체
											$("option", $gugun).remove(); // 구군 초기화

											if (area == "area0")
												$gugun
														.append("<option value=''>구/군 선택</option>");
											else {
												$
														.each(
																eval(area),
																function() {
																	$gugun
																			.append("<option value='" + this + "'>"
																					+ this
																					+ "</option>");
																});
											}
										});

					});
</script>

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

<!-- <div class="mb-3">
	<label for="" class="form-label">구역 추가하기</label>
	<button type="button" class="btn btn-success" onclick="addArea()">추가</button>
</div> -->

<!-- <hr><div class="mb-3">
	<label for="maxGusests" class="form-label">최대 숙박인원</label>
	<input class="form-control" type="text" id="maxGusests" >
</div>

<div class="mb-3">
	<label for="campAreaPrice" class="form-label">가격</label>
	<input class="form-control" type="text" id="campAreaPrice" >
</div>

<div class="mb-3">
	<label for="campAreaName" class="form-label">구역이름</label>
	<input class="form-control" type="text" id="campAreaName" >
</div>


<div class="mb-3">
	<label for="campRepImgMulti" class="form-label">구역 이미지(※최대 _개)</label>
	<input class="form-control" type="file" id="campRepImgMulti" multiple>
</div> -->

</html>
