package com.kh.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.review.service.ReviewService;
import com.kh.review.vo.ReviewVo;

@WebServlet(urlPatterns = "/review/insert")
public class ReviewInsertController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/camp/reviewInsertForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String starScore = req.getParameter("reviewStar");
		String content = req.getParameter("review-content");
		
		ReviewVo vo = new ReviewVo();
		vo.setStarScore(starScore);
		vo.setReviewContent(content);
		
		int result = new ReviewService().reviewInsert(vo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "리뷰 작성 완료!");
			resp.sendRedirect(req.getContextPath() + "/views/member/myBoardList.jsp");
		}else {
			req.getSession().setAttribute("alertMsg", "리뷰 작성 실패");
			resp.sendRedirect(req.getContextPath() + "/views/member/myBoardList.jsp");
		}
		
		
	}
	
	
}
