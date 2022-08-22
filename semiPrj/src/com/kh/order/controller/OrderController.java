package com.kh.order.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.campzonelist.campzone.vo.CampZoneVo;
import com.kh.coupon.service.CouponService;
import com.kh.coupon.vo.CouponVo;
import com.kh.member.vo.MemberVo;
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
		 * 예약일(체크인 체크아웃 날짜)
		 * 쿠폰 조회할 수 있는 객체가 필요 (회원정보를 통해서 ) 
		 * 
		 */
		
		MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember"); //로그인 유저 정보
		CampZoneVo campZoneVo = (CampZoneVo)req.getAttribute("campZone"); //캠핑장 구역 정보
		
		//유저쿠폰을 조회할 객체 생성하기
		List<CouponVo> couponList = new ArrayList<CouponVo>();
		couponList = new CouponService().selectCouponList(loginMember);
		
		req.setAttribute("캠핑장이름", campZoneVo.getZoneName());
		req.setAttribute("캠핑장숙박인원", campZoneVo.getZoneStayMax());
		req.setAttribute("캠핑장금액", campZoneVo.getZonePrice());
		req.setAttribute("체크인", "해당날짜");
		req.setAttribute("체크아웃", "해당날짜");
		req.setAttribute("couponList", couponList); //유저쿠폰리스트
		
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
		
		MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember"); //로그인 유저 정보
		CampZoneVo campZoneVo = (CampZoneVo)req.getAttribute("campZone"); //캠핑장 구역 정보
		
		
		
		
		String reservationName = req.getParameter("reservationName"); //예약자 명
		String address = req.getParameter("address"); // 전화번호
		String requestion = req.getParameter("requestion"); //요청사항
		String payMethod = req.getParameter("payMethod"); //결제방법
		String couponCode = req.getParameter("couponCode"); //쿠폰번호
		String totalCost = req.getParameter("totalCost"); //쿠폰 가격
		String reservaionNop = req.getParameter("reservaionNop"); //숙박인원
		String userNo = loginMember.getNo(); //로그인 유저 번호
		
		
		
		//결제테이블에 들어갈 값 
		OrderVo orderVo = new OrderVo();
		orderVo.setCouponCode(couponCode);
		orderVo.setPayAmount(totalCost);
		orderVo.setPayMethod(payMethod);
		
		
		
		//예약테이블에 들어갈 값 
		ReservationVo reservationVo = new ReservationVo();
		reservationVo.setRequest(requestion); //요청사항
		reservationVo.setReservationName(reservationName); //예약자 명
		reservationVo.setReservationPhone(address); //전화번호
		reservationVo.setReservationNop(reservaionNop); //숙박인원
		reservationVo.setReservationCheckin(reservationName); //체크인
		reservationVo.setReservationCheckout(reservationName); //체크아웃
		reservationVo.setUserNo(userNo); //유저벊호
		reservationVo.setZoneNo(campZoneVo.getZoneNo());
		
		reservationVo.setReservationNop(totalCost); //총 금액
		
		
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
		
		
		// 두 작업이 모두 성공적으로 이루어 질 시
		if(paymentResult == 1 && reservationResult == 1) {
			//쿠폰 사용 확인
			new CouponService().useCoupon(loginMember, couponCode);
			
			
			req.setAttribute("orderVo", orderVo);
			req.setAttribute("reservationVo", reservationVo);
			req.setAttribute("alertMsg", "결제 성공");
			req.getRequestDispatcher("/views/order/orderSuccess.jsp").forward(req, resp);
		} 
	}
}
