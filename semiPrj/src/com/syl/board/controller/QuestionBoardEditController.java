package com.syl.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syl.board.service.QuestionBoardService;
import com.syl.board.vo.QuestionBoardVo;

@WebServlet(urlPatterns = "/question/edit")
public class QuestionBoardEditController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num = req.getParameter("num");
		
		QuestionBoardVo vo = new QuestionBoardService().selectOne(num);
		
		if(vo != null) {
			//성공 -> 수정하기 화면 보여주기
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/views/board/questionBoardRevise.jsp").forward(req, resp);
			
		}else {
			//실패 -> 에러페이지
			req.setAttribute("errorMsg", "공지사항 수정하기 화면 불러오는 중 에러 발생!");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
	}
	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String num = req.getParameter("num");
		
		QuestionBoardVo vo = new QuestionBoardVo();
		vo.setqTitle(title);
		vo.setqContent(content);
		vo.setqNo(num);
		
		int result = new QuestionBoardService().edit(vo);  //update 쿼리
		
		if(result == 1) {
			//성공 -> 상세보기 페이지
			resp.sendRedirect(req.getContextPath() + "/question/detail?num=" + num);
			
		}else {
			//실패 -> 에러페이지
			req.setAttribute("errorMsg", "공지사항 수정 실패");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
		
	}
	
	
}//class
