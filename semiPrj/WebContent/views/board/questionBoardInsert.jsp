<%@page import="com.syl.board.vo.QuestionBoardVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/resource/css/qestionBoardInsert.css">
<title>문의글 상세보기</title>
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>

	 <div class="outer">

        <form id="enroll-form" action="<%=contextPath%>/question/insert" method="post">

            <table>
                <tr>
                    <th width="70px"></th>
                    <td width="500px">
                        
                    </td>
                </tr>
                <tr>
                    <th>제목</th>
                    <td><input type="text" name="title" required></td>
                </tr>
                <tr>
                    <th>내용</th>
                    <td><textarea name="content" rows="10" style="resize:none;" required></textarea></td>
                </tr>
                <tr>
                    <th>첨부파일</th>
                    <td><input class="form-control form-control-sm" id="formFileSm" type="file" name="f"></td>
                </tr>
            </table>

            <div align="center">
                <button type="submit" id="btn" class="b1 btn btn-warning">작성하기</button>
                <button type="reset" id="btn" class="b1 btn btn-warning" onclick="history.go(-1)">취소하기</button>
            </div>

        </form>

    </div>

	<%@ include file="/views/common/footer.jsp" %>

</body>
</html>