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



    <div id="outer">

    <div id="search">
        <input type="text">
        <input type="submit" value="검색" class="btn-sm btn btn-warning">
    </div>


        <table id="board">
            <thead>
              <tr>
                <th scope="col">번호</th>
                <th scope="col">제목</th>
                <th scope="col">작성자</th>
                <th scope="col">작성일</th>
                <th scope="col">조회수</th>
              </tr>
            </thead>
            <tbody>
              <tr>
                <th scope="row">001</th>
                <td>애견 동반 문의합니다</td>
                <td>흰둥이</td>
                <td>2022/05/01 22:07</td>
                <td>2</td>
              </tr>
              <tr>
                <th scope="row">002</th>
                <td>쿠폰 적용법 문의</td>
                <td>봉미선</td>
                <td>2022/05/03 15:01</td>
                <td>5</td>
              </tr>
              <tr>
                <th scope="row">003</th>
                <td>예약 날짜 변경 문의합니다</td>
                <td>나미리</td>
                <td>2022/05/04 13:49</td>
                <td>2</td>
              </tr>
              <tr>
                <th scope="row">004</th>
                <td>천재지변으로 인한 예약취소</td>
                <td>신짱구</td>
                <td>2022/05/05 08:10</td>
                <td>3</td>
              </tr>
              <tr>
                <th scope="row">005</th>
                <td>객실 타입 변경 원합니다</td>
                <td>김철수</td>
                <td>2022/05/06 10:11</td>
                <td>1</td>
              </tr>
            </tbody>
          </table>
        
          <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="#">1</a></li>
            <li class="page-item"><a class="page-link" href="#">2</a></li>
            <li class="page-item"><a class="page-link" href="#">3</a></li>
            <li class="page-item"><a class="page-link" href="#">4</a></li>
            <li class="page-item"><a class="page-link" href="#">5</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
         </ul>


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
						<option value="2">대여</option>
						<option value="3">결제</option>
						<option value="4">기타</option>
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

				  <!-- 모달_작성하기 버튼 -->
			      <div class="modal-footer">
			        <button type="button" class="btn btn-warning">작성하기</button>
			        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">닫기</button>
			      </div>
			    </div>
			  </div>
			</div>
  
  </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
    
	
	<%@ include file="/views/common/footer.jsp" %>

</body>
</html>