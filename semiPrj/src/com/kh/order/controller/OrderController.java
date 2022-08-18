package com.kh.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.order.service.OrderService;
import com.kh.order.vo.OrderVo;
import com.kh.order.vo.ReservationVo;
@WebServlet(urlPatterns = "/order/orderForm")
public class OrderController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * 요청자가 선택한 것
		 * 캠핑장
		 * 금액
		 * 예약일
		 * 쿠폰 조회할 수 있는 객체가 필요 (회원정보를 통해서 ) 
		 */
		
		
		req.getRequestDispatcher("/views/order/oderForm.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*사용자가 입력한 값 
		 * 예약자 명
		 * 이메일 및 휴대폰 번호
		 * 요청사항 등등
		 * 
		 * 캠핑장 구역번호, 인원수, 날짜와 같은 정보 
		 * 
		 * 
		 */
		
		
		String loginMember = req.getParameter("loginMember"); 
		String userName = req.getParameter("username");
		String address = req.getParameter("address");
		String requestion = req.getParameter("requestion");
		String paymentMethod = req.getParameter("paymentMethod");
		String couponName = req.getParameter("couponName");
		String totalCost = req.getParameter("totalCost");
		String reservaionNop = req.getParameter("reservaionNop");
		
		//결제테이블에 들어갈 값 
		OrderVo orderVo = new OrderVo();
		orderVo.setCouponCode(couponName);
		orderVo.setPayAmount(couponName);
		orderVo.setPayAmount(totalCost);
		
		//예약테이블에 들어갈 값 
		ReservationVo reservationVo = new ReservationVo();
		reservationVo.setRequest(requestion);
		
		reservationVo.setReservationNop(totalCost);
		
		
		/*
		 * 비즈니스 로직 실행하기
		 */
		int paymentResult = new OrderService().insertPayment(orderVo);
		int reservationResult = new OrderService().insertReservation(reservationVo);
		/*
		 * 결과에 따른 화면 출력
		 * 성공 시, orderSuccess.jsp로 이동
		 * 이동 시, 결제 데이터를 가지고서 이동...?
		 */
		
	}
}
