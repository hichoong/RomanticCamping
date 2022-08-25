<%@page import="com.syl.board.vo.QuestionBoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	QuestionBoardVo vo = (QuestionBoardVo)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/qestionBoardDetail.css">
<title>문의글 상세보기</title>
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>
	
	<div id="outer">
    
          <table id="board">
                <thead>
                  <tr>
                    <th>제목</th>
                    <td colspan="3"><%=vo.getqTitle()%></td>
                  </tr>
                  <tr>
                    <th>작성자</th>
                    <td><%=vo.getqWriter()%></td>
                    <th>작성일</th>
                    <td><%=vo.getqUpdateDate()%></td>
                  </tr>
                    </thead>
                    
                    <tbody>
                  <tr>
                    <th>내용</th>
                    <td><%=vo.getqContent()%></td>
                  </tr>
                </tbody>
            </table>
              
          <!-- 댓글달기 -->
          <div id="commentBox">
            <form>
              <div class="form-group">
                <textarea class="form-control" id="comment-content" rows="3"></textarea>
              </div>
              <input type="hidden" id="comment-author" value="익명">
              <input type="submit" value="제출" id="commentBtn" class="b1 btn btn-warning" >
            </form>
          </div>
         
            <button id="btn" class="b1 btn btn-warning" onclick="location.href='<%=contextPath%>/question/list'">목록</button>
			
         	<!-- 작성자 본인만 수정/삭제가능 -->
			<%if(loginMember != null && vo.getqWriter().equals(loginMember.getName())){ %>
            <button id="btn" class="b1 btn btn-danger" onclick="location.href='<%=contextPath%>/question/delete?num=<%=vo.getqNo()%>'">삭제</button>
            <button id="btn" class="b1 btn btn-warning" onclick="location.href='<%=contextPath%>/question/edit?num=<%=vo.getqNo()%>'">수정</button>
            <% } %>
   </div>
   
   
       <%@ include file="/views/common/footer.jsp" %>
              
</body>
</html>