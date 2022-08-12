<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>고객센터</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
<link rel="stylesheet" href="../../resource/css/qestionBoard.css">
</head>
<body>
	
	<%@ include file="/views/common/header.jsp" %>
	
	<h2>고객센터</h2>

	<div id="section1">

		<h3>자주 묻는 질문</h3>
		
		<!-- 아코디언 -->
		<div class="accordion" id="accordionExample">
			<div class="accordion-item">
			  <h2 class="accordion-header" id="headingOne">
				<button class="accordion-button" type="button" data-bs-toggle="collapse" data-bs-target="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
					예약을 취소하고 싶어요.
				</button>
			  </h2>
			  <div id="collapseOne" class="accordion-collapse collapse show" aria-labelledby="headingOne" data-bs-parent="#accordionExample">
				<div class="accordion-body">
				  <strong>예약자 본인이 직접 예약확인/취소 가능합니다.</strong>
					<br> 예약/결제 당시 안내된 취소/환불 규정에 따라 처리되며, 취소수수료가 발생 시 취소수수료를 차감한 금액으로 환불 처리됩니다.
				</div>
			  </div>
			</div>
			<div class="accordion-item">
			  <h2 class="accordion-header" id="headingTwo">
				<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
					취소수수료 계산 기준은 어떻게되나요?
				</button>
			  </h2>
			  <div id="collapseTwo" class="accordion-collapse collapse" aria-labelledby="headingTwo" data-bs-parent="#accordionExample">
				<div class="accordion-body">
				  <strong>취소수수료는 숙소별로 상이합니다.</strong>
				  <br> 취소수수료는 예약시점과는 무관하게 '입실일로부터 남은 날짜' 기준으로 부과됩니다.
				  결제금액에서 취소수수료를 차감한 금액으로 환불 처리됩니다.
				  환불 예정금액은 조회 시점 및 실제 환불 진행 시점에 따라 달라질 수 있으므로, 예약/결제 진행 당시 안내된 취소/환불 규정을 꼭 숙지해 주시길 바랍니다.
				</div>
			  </div>
			</div>
			<div class="accordion-item">
			  <h2 class="accordion-header" id="headingThree">
				<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseThree" aria-expanded="false" aria-controls="collapseThree">
					예약취소했는데 언제 환불되나요?
				</button>
			  </h2>
			  <div id="collapseThree" class="accordion-collapse collapse" aria-labelledby="headingThree" data-bs-parent="#accordionExample">
				<div class="accordion-body">
				  <strong>취소 신청 후 간편결제 사업자 또는 은행/신용카드사에 따라 환불 절차에 일정 시간이 소요됩니다.</strong>
				  <br> 영업일 기준(토/일/공휴일 제외)으로 실시간 계좌이체 2~3일, 신용카드 3~5일 소요됩니다.
				</div>
			  </div>
			</div>
		  </div>
		</div>

		<div id="section2">
			<table class="table table-hover" id="board">
					<thead>
					<tr>
						<th>번호</th>
						<th>제목</th>
						<th>작성자</th>
						<th>작성일</th>
						<th>조회수</th>
					</tr>
					</thead>
					<tbody>
					<tr>
						<td>004</td>
						<td>예약 확인은 어떻게 하나요?</td>
						<td>백동팔</td>
						<td>2202/08/05 17:58</td>
						<td>3</td>
					</tr>
					<tr>
						<td>003</td>
						<td>예약 변경 문의합니다</td>
						<td>마두식</td>
						<td>2202/08/05 21:13</td>
						<td>2</td>
					</tr>
					<tr>
						<td>002</td>
						<td>천재지변으로 인한 예약취소는 어떻게 하나요?</td>
						<td>김파인애플</td>
						<td>2202/08/03 13:07</td>
						<td>1</td>
					</tr>
					<tr>
						<td>001</td>
						<td>문의 합니다</td>
						<td>팔봉춘</td>
						<td>2202/08/02 11:15</td>
						<td>2</td>
					</tr>
					<tr>
						<td>000</td>
						<td>객실 타입 변경원합니다</td>
						<td>이왕용</td>
						<td>2202/08/01 09:11</td>
						<td>6</td>
					</tr>
					</tbody>
			</table>
			
			<!-- 작성하기 버튼 -->
			<button type="button" id="btn" class="btn btn-warning" data-bs-toggle="modal" data-bs-target="#exampleModal">
			  작성하기
			</button>
			
			<!-- (Modal) -->
			<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
			  <div class="modal-dialog">
			    <div class="modal-content">
			      <div class="modal-header">
			        <h5 class="modal-title" id="exampleModalLabel">문의글 작성하기</h5>
			        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
			      </div>
			      
			      <div class="modal-body">
			        
			        <!-- 분류 선택 -->
					<select class="form-select" aria-label="Default select example">
						<option selected>문의 카테고리 선택</option>
						<option value="1">예약</option>
						<option value="2">회원</option>
						<option value="3">결제</option>
						<option value="3">기타</option>
					</select>
					
					<!-- 글 제목 / 글 내용 입력-->
					<div class="mb-3">
						<label for="exampleFormControlInput1" class="form-label">제목 : </label>
						<input type="email" class="form-control" id="exampleFormControlInput1" placeholder="문의합니다.">
					  </div>
					  <div class="mb-3">
						<label for="exampleFormControlTextarea1" class="form-label">내용 : </label>
						<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
					  </div>
		
					<!-- 파일 첨부 -->
					  <div class="mb-3">
						<label for="formFile" class="form-label"></label>
						<input class="form-control" type="file" id="formFile">
					  </div>
			        
			      </div>
			      
			      <div class="modal-footer">
			        <button type="button" class="btn btn-warning">작성하기</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
			      </div>
			    </div>
			  </div>
			</div>
						
	
			
		</div>
	
	
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">
	
	<%@ include file="/views/common/footer.jsp" %>

</body>
</html>