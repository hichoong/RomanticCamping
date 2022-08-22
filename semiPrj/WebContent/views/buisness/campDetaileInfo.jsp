<%@page import="com.sjy.buisness.camp.vo.BsCampZoneVo"%>
<%@page import="com.sjy.buisness.hashmapping.vo.HashMappingVo"%>
<%@page import="com.kh.camplist.theme.vo.ThemeVo"%>
<%@page import="com.kh.camplist.hashtag.vo.HashTagVo"%>
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
	//모든 리스트가져오기 태마 해쉬태그
	List<HashTagVo> hashTagList = (List<HashTagVo>) request.getAttribute("hashTagList");
	List<ThemeVo> themeList = (List<ThemeVo>) request.getAttribute("themeList");
	
	//선택한 리스트가져오기 태마 해쉬태그
	BsCampVo myTheme = (BsCampVo) request.getAttribute("myTheme");
	List<HashMappingVo> myHashMappingList = (List<HashMappingVo>) request.getAttribute("myHashMappingList");
	String mappings = "";
	for(HashMappingVo vo : myHashMappingList) { 
		mappings = String.join(",",vo.getHtCode());
	}
	
	//캠핑장 구역 정보가져오기
	List<BsCampZoneVo> zoneList = (List<BsCampZoneVo>)request.getAttribute("zoneList");
	
	BsCampVo bsvo = (BsCampVo)request.getAttribute("bsVo");
	System.out.println("bsvo"+bsvo);
%>
<head>


<link rel="stylesheet" href="/resource/css/SjyCss.css">

<style type="text/css">

	
</style>
	<meta charset="UTF-8">
	<title>캠핑장 조회</title>
</head>

<body>
	<%-- <%@ include file="/views/buisness/bsHeader.jsp"%> --%>
	<%@ include file="/views/common/header.jsp" %>
	<main class="navbar navbar-expand-sm container">
		<%@ include file="/views/buisness/sidebar.jsp"%>

		<div id="content">


			<form action="<%=contextPath%>/views/buisness/campUpdateIfo.jsp" method="post">
				<h2>캠핑장 조회 </h2>
				
				<hr>
				<div style="overflow-x: hidden; width: 100%; height: 700px; padding-right: 10%">
					<div><%=bsvo.getCampName() %></div>
					<div class="md-3">
						<label for="campName" class="form-label">* 이름:</label> 
							<input type="text" class="form-control" id="campName"
							placeholder="캠핑장 이름 입력" name="campName" value="<%=bsvo.getCampName() %>" disabled>
					</div>

					<div class="md-3 ">
						<label for="campAdd" class="form-label">* 주소:</label> 
						<select name="city" class="form-select" id="city" disabled><option value="none" ><%=bsvo.getCity() %></option></select> 
						<select name="district" class="form-select" id="district" disabled><option value="none" "><%=bsvo.getDistrict() %></option></select>
					</div>



					<div class="md-3">
						<label for="campDetailAdd">상세주소:</label>
						<textarea class="form-control" rows="3" id="campDetailAdd"
							placeholder="상세주소 입력" name="campDetailAdd" disabled><%=bsvo.getCampAddress() %></textarea>
					</div>

					<div class="md-3">
						<label for="campPhone" class="form-label">* 연락처:</label> <input
							type="text" class="form-control" id="campPhone" maxlength="13"
							placeholder="캠핑장 연락처 입력" name="campPhone" disabled value="<%=bsvo.getCampPhone() %>">
					</div>

					<div class="md-3">
						<label for="campIntro" class="form-label">* 시설소개:</label> <input
							type="text" class="form-control" id="campIntro"
							placeholder="시설소개" name="campIntro" disabled value="<%=bsvo.getCampIntro() %>">
					</div>

					<div class="md-3">
						<label for="campFacility" class="form-label">* 시설현황:(※선택: 이미지 아이콘)</label> <input
							type="text" class="form-control" id="campFacility"
							placeholder="와이파이 전기 온수 반려견동반 매점 장작판매 운동장 산책로 물놀이장" name="camp"
							disabled>
								
							    <input type="checkbox" name="facility" id="ft1" class="facility" value="w">
							    <label for="ft1" >와이파이</label>
							    <input type="checkbox" name="facility" id="ft2" class="facility" value="e">
							    <label for="ft2">전기</label>
							    <input type="checkbox" name="facility" id="ft3" class="facility" value="h">
							    <label for="ft3">온수</label>
							    <input type="checkbox" name="facility" id="ft4" class="facility" value="p">
							    <label for="ft4">반려견동반</label>
							    <input type="checkbox" name="facility" id="ft5" class="facility" value="s">
							    <label for="ft5">매점</label>
							    
							    <input type="checkbox" name="facility" id="ft6" class="facility" value="f">
							    <label for="ft6">장작판매</label>
							    <input type="checkbox" name="facility" id="ft7" class="facility" value="p">
							    <label for="ft7">운동장</label>
							    <input type="checkbox" name="facility" id="ft8" class="facility" value="t">
							    <label for="ft8">산책로</label>
							    <input type="checkbox" name="facility" id="ft9" class="facility" value="o">
							    <label for="ft9">물놀이장</label>
							    
					</div>

					<div class="md-3" id="tdTheme">
						<label for="campTheme" class="form-label">* 테마:(테마를선 택해주세요)</label>
						<!-- <input type="text" class="form-control" id="camp"  placeholder="해변 숲 섬 호수 도심 계곡 산 강" name="camp" disabled> -->
						<table>
							<tr>
								<%for(ThemeVo vo : themeList) { %>
		                      		<td>
		                      		<input type="checkbox" disabled class="btn-check" id="<%=vo.getThemeCode()%>" autocomplete="off" name="theme" value="<%=vo.getThemeCode()%>"> 
									<label class="btn btn-outline-success" for="<%=vo.getThemeCode()%>"><%=vo.getThemeName()%></label>
									</td>
								<%} %>	
							</tr>
						</table>
					</div>
					
										<div class="md-3" id="hashTag">
						<label for="campHashTag" class="form-label">* 태그:(해쉬태그를 선택해주세요)</label>
						<input type="hidden" value="0" name="hashNum" disabled>
						<table>
								<tr >
								<%for(HashTagVo vo : hashTagList) { %>
									<%  String x1 = vo.getHtCode();
									int x =Integer.parseInt(x1);%>
									
										<%if( (x%5)!=0 ){%>
											<td>
		                      				<input style="margin: 10px" type="checkbox" class="btn-check"  disabled
		                      				id="<%=vo.getHtName()%>" autocomplete="off" name="hashTag" value="<%=vo.getHtCode()%>" onclick="getHashNum();"> 
											<label class="btn btn-outline-success" for="<%=vo.getHtName()%>"><%=vo.getHtName()%></label>
											</td>
										<%}else{%>
											<td>
		                      				<input style="margin: 10px" type="checkbox" class="btn-check" disabled
		                      				id="<%=vo.getHtName()%>" autocomplete="off" name="hashTag" value="<%=vo.getHtCode()%>" onclick="getHashNum();"> 
											<label class="btn btn-outline-success" for="<%=vo.getHtName()%>"><%=vo.getHtName()%></label>
											</td></tr>
										<%} %>
									<%} %>
						</table>
					</div>
					
					<div class="md-3">
						<label for="campRefund" class="form-label">* 환불규정:</label> <input
							type="text" class="form-control" id="campRefund"
							placeholder="환불규정" name="campRefund" disabled value="<%=bsvo.getCampRefund()%>">
					</div>


					<div class="mb-3">
						<label for="campRepImg" class="form-label">* 대표이미지:</label> <input
							class="form-control" type="file" name="campRepImg" value="<%=bsvo.getCampImgPath()%>"
							id="campRepImg">
					</div>


					<!-- detailController에서 캠핑장 코드 번호와 일치하는 구역들을 리스트에 담아서 가져오기 -->
					<div class="mb-3">
						<div class="addInput">
								<%System.out.println("zoneList"+zoneList);
								for(BsCampZoneVo vo : zoneList) { %>
									<hr>
									<div class="mb-3">
										<label for="campZoneName" class="form-label">구역이름</label> 
										<input class="form-control" type="text" id="campZoneName" name="campZoneName" value="<%=vo.getZoneName() %>" disabled>
									</div>
									<div class="mb-3 " style="width: 30%">
										<label for="maxGusests" class="form-label">최대 숙박인원(:명)</label> 
										<input class="form-control" type="number" id="maxGusests" name="maxGusests" value="<%=vo.getZoneStayMax() %>" disabled>
									</div>
									<div class="mb-3 " style="width: 30%">
										<label for="maxGusests" class="form-label">일별 예약가능수(:명)</label> 
										<input class="form-control" type="number" id="maxGusests" name="zoneNor0" min="1" value="<%=vo.getZoneNor() %>"" disabled>
									</div>	
									<div class="mb-3 " style="width: 30%">
										<label for="campAreaPrice" class="form-label">가격(:원)</label> 
										<input class="form-control" type="number" id="campZonePrice" name="campZonePrice" min="0" value="<%=vo.getZonePrice() %>" disabled>
									</div>
									<div class="mb-3">
										<label for="campAreaImg" class="form-label">구역이미지</label>
										<img alt="" src="<%=bsvo.getCampImgPath()%>" width="100px" height="100px">
										 <input class="form-control" type="file" id="campZoneImg" name="campZoneImg" >
									</div>
									<br>
								<%} %>
							<br>

						</div>
					</div>

					<div class="md-3">
						<label for="" class="form-label">* 등록일:</label> <input
							type="datetime-local" class="form-control" id=""
							placeholder="등록일" name="" value="<%=toDay%>" disabled>
					</div>

						<div id="end">
							<button  id="upDate" >수정</button>
							<button id="delete" type="button" onclick="locaton.href='#'">삭제요청</button>
						</div>
				</div>

			</form>
		</div>
		<!--content-->



	</main>

	<%@ include file="/views/common/footer.jsp"%>


<script> 
    $(document).ready (function(){
        $('.btnAdd').click(function(){
            $('.addInput').append(
                '<hr>\
				<div class="mb-3">\
					<label for="campZoneName" class="form-label">구역이름</label> \
					<input class="form-control" type="text" id="campZoneName" name="campZoneName" placeholder="구역이름을 입력해주세요" disabled>\
				</div>\
				<div class="mb-3 " style="width: 30%">\
					<label for="maxGusests" class="form-label">최대 숙박인원(:명)</label> \
					<input class="form-control" type="number" id="maxGusests" name="maxGusests" min="1" value="1" disabled>\
				</div>\
				<div class="mb-3 " style="width: 30%">\
					<label for="campAreaPrice" class="form-label">가격(:원)</label> \
					<input class="form-control" type="number" id="campZonePrice" name="campZonePrice" min="0" value="0" disabled>\
				</div>\
				<div class="mb-3">\
					<label for="campAreaImg" class="form-label">구역이미지</label>\
					<input class="form-control" type="file" id="campZoneImg" name="campZoneImg">\
				</div>\
				<button type="button" class="btn btn-danger btnRemove">삭제</button><br><br>'
                );
            $('.btnRemove').on('click',function(){
                /* $(this).prev().remove(); */
				$(this).prev().remove();
				$(this).prev().remove();
				$(this).prev().remove();
				$(this).prev().remove();
				$(this).prev().remove();
                $(this).next().remove();
				$(this).next().remove();
                $(this).remove();//bt

				// $(document.getElementsByClassName('addInput')).children().remove();
            })
        })
    })
</script>

<script>
		$(function() {

			//캠핑장 테마 가져오기
			const theme = '<%=myTheme.getTheme()%>';
			console.log(theme);
			
			//체크박스가져오기
			$('input[name=theme]').each(function(){
				var result = theme.indexOf(this.value);
				console.log(result);
				if (result != -1) {
					this.checked = true;
				}
				
				
			});
			
		})
		
</script>

<script>
		$(function() {

			//캠핑장 테마 가져오기
			const theme = '<%=mappings%>';
			console.log(theme);
			
			//체크박스가져오기
			$('input[name=hashTag]').each(function(){
				var result = theme.indexOf(this.value);
				console.log(result);
				if (result != -1) {
					this.checked = true;
				}
				
				
			});
			
		})
		
	</script>
	
</body>

</html>
