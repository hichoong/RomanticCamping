package com.kh.review.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.vo.MemberVo;
import com.kh.reservation.service.ReservationService;

@WebServlet(urlPatterns = "/member/doReview")
public class EnrollCheckController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String reservationNo = req.getParameter("reservationNo");
		String result = new ReservationService().enrollCheck(reservationNo);
		
		resp.getWriter().write(result);
		
	}
}
