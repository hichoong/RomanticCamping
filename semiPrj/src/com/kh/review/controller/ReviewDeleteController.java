package com.kh.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.review.service.ReviewService;
import com.kh.review.vo.ReviewVo;

@WebServlet(urlPatterns = "/review/delete")
public class ReviewDeleteController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String reservationNo = req.getParameter("reservationNo");
		
		int result = new ReviewService().delete(reservationNo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "리뷰 삭제 성공!");
			resp.sendRedirect(req.getContextPath() + "/views/member/myBoardList.jsp");
		} else {
			req.getSession().setAttribute("alertMsg", "리뷰 삭제 실패");
			resp.sendRedirect(req.getContextPath() + "/views/member/myBoardList.jsp");
		}
		
	}
	

}
