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
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/qestionBoardInsert.css">
<title>문의글 수정</title>
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>
	
	
    <div class="outer">

        <form id="enroll-form" action="<%=contextPath %>/question/edit" method="post">
			<input type="hidden" name="num" value="<%=vo.getqNo()%>">
			<input type="hidden" name="writerNo" value="<%=loginMember.getNo()%>">
			
            <table>
                <tr>
                    <th width="70px">제목</th>
                    <td width="500px"><input type="text" size="20" name="title" required value="<%=vo.getqTitle()%>"></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea rows="10" cols="100" style="resize:none;" name="content" required><%=vo.getqContent()%></textarea></td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td><input class="form-control form-control-sm" id="formFileSm" type="file" name="f"></td>
                </tr>
            </table>

            <div align="center">
	             <button type="submit" id="btn" class="b1 btn btn-warning">수정하기</button>
	             <button type="button" id="btn" class="b1 btn btn-warning" onclick="history.go(-1)">목록</button>
            </div>

        </form>

    </div>

              
       <%@ include file="/views/common/footer.jsp" %>
              
</body>
</html>