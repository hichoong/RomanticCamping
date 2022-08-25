package com.kh.camprequest.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.camprequest.service.CampRequestService;
import com.sjy.buisness.camp.vo.BsCampVo;
import com.syl.board.vo.QuestionBoardVo;

@WebServlet(urlPatterns = "/request/detail")
public class CampRequestFormDetail extends HttpServlet {
	
	//캠핑장 등록 요청 상세보기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num = req.getParameter("num");
		
		BsCampVo vo = new CampRequestService().selectOne(num);
		
		if(vo != null) {
			//조회 성공
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/views/campRequest/campRequestForm.jsp").forward(req, resp);
			
		}else {
			//조회 실패
			req.setAttribute("errorMsg", "게시글 조회 실패!");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
		
	}

}//class
