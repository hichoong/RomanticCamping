package com.kh.reservation.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.reservation.service.ReservationService;

@WebServlet(urlPatterns = "/member/cancleReservation")
public class CancleReservationController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("reservationNo");
		
		int result = new ReservationService().cancleReservation(no);
		
		System.out.println(result);
		
		if(result == 1) {
			resp.sendRedirect(req.getContextPath()+"/member/myReservation");
		} else {
			req.getSession().setAttribute("alertMsg", "예약 취소에 실패했습니다. 나중에 다시 시도해주세요");
			resp.sendRedirect(req.getContextPath()+"/member/myReservation");
		}
	
	}
	
}
