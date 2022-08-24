package com.syl.board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.vo.MemberVo;
import com.syl.board.service.QuestionBoardService;
import com.syl.board.vo.QuestionBoardVo;

@WebServlet(urlPatterns = "/question/insert")
public class QuestionBoardInsertController extends HttpServlet {
	
		//문의글 작성 페이지 보여주기
		@Override
		protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

			req.getRequestDispatcher("/views/board/questionBoardInsert.jsp").forward(req, resp);
		
		}
		
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
			// 로그인 한 상태에서는 정상 작동, 로그인하지 않았을 때는 에러 발생..
			// 로그인 했는 지 안했는지 한번 걸러주는 작업이 필요합니다.
			String no = ((MemberVo)req.getSession().getAttribute("loginMember")).getNo();

			String title = req.getParameter("title");
			String content = req.getParameter("content");
			
			QuestionBoardVo vo = new QuestionBoardVo();
			vo.setqWriter(no);
			vo.setqTitle(title);
			vo.setqContent(content);
			
			//결과 = 서비스호출
			int result = new QuestionBoardService().insertBoard(vo);
			//결과에 따라, 화면 선택
			if(result == 1) {
				//성공 -> 목록 (alertMsg)
				req.getSession().setAttribute("alertMsg","문의글 작성 완료!");
				resp.sendRedirect(req.getContextPath()+"/question/list");
			}else {
				//실패 -> 에러(errorMsg)
				req.setAttribute("errorMsg", "문의글 작성 실패!");
				req.getRequestDispatcher("/question/list").forward(req, resp);
			}
		}
	
}//class
