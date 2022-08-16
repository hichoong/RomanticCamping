<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="../../resource/css/qestionBoardDetail.css">
<title>문의글 수정</title>
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>
	
	<div id="outer">
    
            <table id="board">
                <thead>
                  <tr>
                    <th>제목</th>
                    <td colspan="3"><input type="text"></td>
                  </tr>
                  <tr>
                    <th>작성자</th>
                    <td><input type="text"></td>
                    <th>작성일</th>
                    <td>2022/05/01 22:07</td>
                  </tr>
                    </thead>
                    
                    <tbody>
                  <tr>
                    <th>내용</th>
                    <td><textarea></textarea></td>
                  </tr>
                </tbody>
              </table>
            
            <button id="btn" class="b2 btn btn-warning" onclick="history.back();">목록</button>
            <button id="btn" class="b1 btn btn-warning" onclick="history.back();">저장</button>
              
              
       <%@ include file="/views/common/footer.jsp" %>
              
</body>
</html>