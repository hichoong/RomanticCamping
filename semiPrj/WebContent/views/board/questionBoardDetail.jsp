<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../resource/css/qestionBoardDetail.css">
<title>문의글 상세보기</title>
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>
	
	<div id="outer">
    
            <table id="board">
                <thead>
                  <tr>
                    <th>제목</th>
                    <td colspan="3">애견 동반 문의합니다</td>
                  </tr>
                  <tr>
                    <th>작성자</th>
                    <td>흰둥이</td>
                    <th>작성일</th>
                    <td>2022/05/01 22:07</td>
                  </tr>
                    </thead>
                    
                    <tbody>
                  <tr>
                    <th>내용</th>
                    <td>강아지 데려가도 되는건가요 ^-^ ?</td>
                  </tr>
                </tbody>
              </table>
            
            <button id="btn" class="b1 btn btn-warning" onclick="history.back();">목록</button>
            <button id="btn" class="b1 btn btn-danger" onclick="history.back();">삭제</button>
            <button id="btn" class="b1 btn btn-warning" onclick="location.href='http://127.0.0.1:8803/semiPrj/views/board/questionBoardRevise.jsp'">수정</button>
              
       <%@ include file="/views/common/footer.jsp" %>
              
</body>
</html>