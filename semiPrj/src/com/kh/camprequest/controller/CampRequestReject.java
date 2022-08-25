package com.kh.camprequest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.camprequest.service.CampRequestService;
import com.syl.board.service.QuestionBoardService;

@WebServlet(urlPatterns = "/request/reject")
public class CampRequestReject extends HttpServlet{

		//요청 글 삭제
		@Override
			protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
					
				String num = req.getParameter("num");
					
				int result = new CampRequestService().delete(num);
					
				if(result == 1) {
					//삭제 성공 -> 글 목록 보여주기
					String cp = req.getContextPath();
					req.getSession().setAttribute("alertMsg", "등록 요청을 거절하였습니다");
					resp.sendRedirect(cp + "/question/list");
				}else {
					//삭제 실패 -> 에러페이지로 보내기
					req.setAttribute("errorMsg", "실패하였습니다");
					req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
				}

			}
	
	
}//class
