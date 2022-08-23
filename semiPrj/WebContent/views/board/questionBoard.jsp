<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="com.syl.board.vo.QuestionBoardVo"%>
<%@page import="java.util.ArrayList"%>
<% 
	ArrayList<QuestionBoardVo> voList = (ArrayList<QuestionBoardVo>)request.getAttribute("voList"); 
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>낭만캠프</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/qestionBoard.css">
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
              <%for(int i = 0; i < voList.size(); i++){%>
              <tr>
                <th scope="row"><%=voList.get(i).getqNo()%></th>
                <td><%=voList.get(i).getqTitle()%></td>
                <td><%=voList.get(i).getqWriter()%></td>
                <td><%=voList.get(i).getqUpdateDate()%></td>
                <td><%=voList.get(i).getqCnt()%></td>
              </tr>
              <%}%>
            </tbody>
            
          </table>
        
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


    <button type="button" id="btn" class="btn btn-warning" onclick="location.href='<%=request.getContextPath()%>/question/insert'" >
			작성하기
	</button>
    
    
  	</div>
    
    <script>
		$(function(){
			$('#board>tbody>tr').click(function(){
				//행 클릭 되었을 때, 동작할 내용
				
				//글 번호 가져오기
				const num = $(this).children().eq(0).text();
				//해당 번호 이용해서 요청 보내기
				location.href='/semiPrj/question/detail?num=' + num;
			});
		})
	</script>
	
	<%@ include file="/views/common/footer.jsp" %>

</body>
</html>