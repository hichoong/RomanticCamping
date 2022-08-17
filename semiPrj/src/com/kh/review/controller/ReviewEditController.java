package com.kh.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.review.service.ReviewService;
import com.kh.review.vo.ReviewVo;

@WebServlet(urlPatterns = "/review/edit")
public class ReviewEditController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num = req.getParameter("num");
		ReviewVo vo = new ReviewService().selectOne(num);
		
		if(vo != null) {
			//성공
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/views/camp/reviewEdit.jsp").forward(req, resp);
		} else {
			//실패 에러페이지
			System.out.println("리뷰 불러오기 실패");
			req.getRequestDispatcher("/views/camp/reviewEdit.jsp").forward(req, resp);
		}
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String reviewStar = req.getParameter("reviewStar"); 
		String content = req.getParameter("review-content");
		String num = req.getParameter("num");
		
		ReviewVo vo = new ReviewVo();
		vo.setrNum(reviewStar);
		vo.setrContent(content);
		vo.setrNo(num);
		
		int result = new ReviewService().edit(vo);
		
		if(result == 1) {
			//성공
			req.getSession().setAttribute("alertMsg", "리뷰수정 성공");
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/views/member/myBoardList.jsp").forward(req, resp);
		} else {
			//실패 에러페이지
			req.getSession().setAttribute("alertMsg", "리뷰수정 실패");
			req.getRequestDispatcher("/views/camp/reviewEdit.jsp").forward(req, resp);
		}
		
		
	
	}
}
