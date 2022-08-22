package com.kh.reservation.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.member.vo.MemberVo;
import com.kh.order.vo.ReservationVo;
import com.kh.reservation.service.ReservationService;

@WebServlet(urlPatterns = "/member/reservationCheck")
public class ReservationCheckController extends HttpServlet {
		
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = ((MemberVo)req.getSession().getAttribute("loginMember")).getNo();
		String type = req.getParameter("type");
			
		List<ReservationVo> list = new ReservationService().reservationCheck(no, type);
		
		req.setAttribute("reservationList", list);
		req.setAttribute("status", type);
		req.getRequestDispatcher("/views/member/myReservationPage.jsp").forward(req, resp);
	}
	
}
