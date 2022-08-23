package com.syl.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syl.board.service.QuestionBoardService;
import com.syl.board.vo.QuestionBoardVo;

@WebServlet(urlPatterns = "/question/detail")
public class QuestionBoardDetail extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
			//////////////////////num번 공지사항 조회수 증가//////////////////////
		
				String num = req.getParameter("num");
				
				int result = new QuestionBoardService().increaseBoard(num);
				
				if(result == 1) {
					//DB -> 정보조회
					QuestionBoardVo vo = new QuestionBoardService().selectOne(num);
					
					
					if(vo != null) {
						//조회 성공
						req.setAttribute("vo", vo);
						req.getRequestDispatcher("/views/board/questionBoardDetail.jsp").forward(req, resp);
					}else {
						//조회 실패
						req.setAttribute("errorMsg", "게시글 조회 실패!");
						req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
					}
					
				}else {

					//조회실패
					req.setAttribute("errorMsg", "게시글 조회 실패!");
					req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
					
				}

		}
	
	
}//class
