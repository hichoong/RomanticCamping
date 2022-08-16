package com.kh.order.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(urlPatterns = "/order/orderForm")
public class OrderController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		/*
		 * 요청자가 선택한 것
		 * 캠핑장
		 * 금액
		 * 예약일 
		 */
		req.getRequestDispatcher("/views/order/oderForm.jsp").forward(req, resp);
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		/*사용자가 입력한 값
		 * 예약자 명
		 * 이메일 및 휴대폰 번호
		 * 요청사항 등등
		 */
		
		/*
		 * 비즈니스 로직 실행하기
		 */
		
		
		/*
		 * 결과에 따른 화면 출력
		 * 성공 시, orderSuccess.jsp로 이동
		 * 이동 시, 결제 데이터를 가지고서 이동...?
		 */
		
	}
}
