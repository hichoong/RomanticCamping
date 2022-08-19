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
import com.kh.order.vo.ReservationVo;
import com.kh.reservation.service.ReservationService;

@WebServlet(urlPatterns = "/member/reservationCheck")
public class ReservationCheckController extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("userNo");
			
		List<ReservationVo> list = new ReservationService().reservationCheck(no);
		
		Gson g = new Gson();
		String jsonStr = g.toJson(list);
		resp.getWriter().write(jsonStr);
		
	}
	
}
