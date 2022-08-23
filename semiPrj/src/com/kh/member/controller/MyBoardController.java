package com.kh.member.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.freeboard.vo.FreeBoardTradeVo;
import com.kh.freeboard.vo.FreeBoardVo;
import com.kh.member.service.MemberBoardService;
import com.kh.member.vo.MemberVo;
import com.kh.review.vo.ReviewVo;
import com.syl.board.vo.QuestionBoardVo;

@WebServlet(urlPatterns = "/member/userBoard")
public class MyBoardController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = ((MemberVo)req.getSession().getAttribute("loginMember")).getNo();
		String type = req.getParameter("type");
		
		if("F".equals(type)) {
			
			List<FreeBoardVo> list = new MemberBoardService().getFreeBoard(no); 
			req.setAttribute("boardList", list);
			
		} else if("T".equals(type)) {
			
			List<FreeBoardTradeVo> list = new MemberBoardService().getTradeBoard(no); 
			req.setAttribute("boardList", list);
			
		} else if("R".equals(type)) {
			
			List<ReviewVo> list = new MemberBoardService().getReview(no); 
			req.setAttribute("boardList", list);
			
		} else if("Q".equals(type)) {
			
			List<QuestionBoardVo> list = new MemberBoardService().getQuestion(no); 
			req.setAttribute("boardList", list);
			
		} else {
			resp.sendRedirect(req.getContextPath());
		}

		req.setAttribute("status", type);
		req.getRequestDispatcher("/views/member/myBoardList.jsp").forward(req, resp);
	
	}
	
}
