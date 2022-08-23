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
			if(((MemberVo)req.getSession().getAttribute("loginMember")).getNo() != null ) {
			//유저쿠폰을 조회할 객체 생성하기
			String no = ((MemberVo)req.getSession().getAttribute("loginMember")).getNo(); //로그인 유저 정보				
			List<CouponVo> couponList = new CouponService().selectCouponList(no);
			System.out.println("쿠폰리스트 :::" + couponList);
			req.setAttribute("couponList", couponList); //유저쿠폰리스트
			//캠핑존과 관련된 객체 정보
			
			req.setAttribute("reservaionNop", "5"); //숙박인원
			req.setAttribute("originCost", "120,000"); //캠핑장 가격
			req.setAttribute("checkin", "2022/08/23"); //체크인
			req.setAttribute("checkout", "2022/08/24"); //체크아웃
			req.setAttribute("campCode", "5"); //캠핑장 코드
			req.setAttribute("zoneNo", "2");	//캠핑장 구역변호
			req.setAttribute("zoneName", "하늘캠핑장"); //캠핑장 이름
			req.setAttribute("campPrice", "120,000"); //캠핑장 이름
			//화면으로 넘겨주기
			req.getRequestDispatcher("/views/order/orderForm.jsp").forward(req, resp);
		} else {
			List<CouponVo> couponList = new CouponService().selectCouponList("0");
			req.setAttribute("couponList", couponList); //유저쿠폰리스트
		}
	}
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//결제테이블에 들어갈 값 
		OrderVo orderVo = new OrderVo();
		orderVo.setCouponCode(req.getParameter("couponName"));
		orderVo.setPayAmount(req.getParameter("totalCost"));
		orderVo.setPayMethod(req.getParameter("payMethod"));
		//예약테이블에 들어갈 값 
		ReservationVo reservationVo = new ReservationVo();
		reservationVo.setRequest(req.getParameter("requestion")); //요청사항
		reservationVo.setReservationName(req.getParameter("reName")); //예약자 명
		reservationVo.setReservationPhone(req.getParameter("address")); //전화번호
		reservationVo.setReservationNop(req.getParameter("reservaionNop")); //숙박인원
		reservationVo.setReservationCheckin(req.getParameter("Checkin")); //체크인
		reservationVo.setReservationCheckout(req.getParameter("Checkout")); //체크아웃
		reservationVo.setCampCode(req.getParameter("campCode"));//캠프장 코드
		reservationVo.setZoneNo(req.getParameter("zoneNo")); //캠프장 구역 코드
		reservationVo.setUserNo(((MemberVo)req.getSession().getAttribute("loginMember")).getNo()); //유저벊호
		 //비즈니스 로직 실행하기
		int reservationResult = new OrderService().insertReservation(reservationVo);
		int paymentResult = new OrderService().insertPayment(orderVo);	
		// 두 작업이 모두 성공적으로 이루어 질 시
		if(paymentResult == 1 && reservationResult == 1) {
			//쿠폰 사용 확인
			new CouponService().useCoupon(((MemberVo)req.getSession().getAttribute("loginMember")).getNo(), req.getParameter("couponName"));	
			req.setAttribute("orderVo", orderVo);
			req.setAttribute("reservationVo", reservationVo);
			req.setAttribute("zoneName", req.getParameter("zoneName"));
			req.setAttribute("alertMsg", "결제 성공");
			req.getRequestDispatcher("/views/order/orderSuccess.jsp").forward(req, resp);
		} else {
			req.setAttribute("errorMsg", "결제실패");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
	}
}
