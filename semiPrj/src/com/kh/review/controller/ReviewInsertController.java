package com.kh.review.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.camplist.campinfo.vo.CampInfoVo;
import com.kh.member.vo.MemberVo;
import com.kh.order.vo.ReservationVo;
import com.kh.reservation.service.ReservationService;
import com.kh.review.service.ReviewService;
import com.kh.review.vo.ReviewVo;

@WebServlet(urlPatterns = "/review/insert")
public class ReviewInsertController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String reservationNo = req.getParameter("reservationNo");
//		String reservationNo = "1";
		CampInfoVo campInfoVo = new ReviewService().campSelect(reservationNo);
		
		req.setAttribute("reservationNo", reservationNo);
		req.setAttribute("campInfoVo", campInfoVo);
		req.getRequestDispatcher("/views/camp/reviewInsertForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		String starScore = req.getParameter("reviewStar");
		String content = req.getParameter("review-content");
		String reservationNo = req.getParameter("reservationNo");
		String campCode = req.getParameter("campCode");
		
		ReviewVo vo = new ReviewVo();
		vo.setStarScore(starScore);
		vo.setReviewContent(content);
		vo.setReservationNo(reservationNo);
		vo.setCampCode(campCode);
		
		System.out.println(reservationNo);
		
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