package com.kh.order.controller;

import java.io.IOException;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			
			//숙박일수 구하기
			long days = 0;
			try {
				Date format1 = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("checkout"));
				Date format2 = new SimpleDateFormat("yyyy-MM-dd").parse(req.getParameter("checkin"));
				long diffSec = (format1.getTime() - format2.getTime()) / 1000; //초 차이
				days = diffSec / (24*60*60);
			} catch (ParseException e) {
				e.printStackTrace();
			}
			//숙박일에 따른 가격
			int price = Integer.parseInt(req.getParameter("campPrice")) ;
			long result_ = price * days;
			//데이터 포맷(콤마생성하기)
			NumberFormat numberFormat = NumberFormat.getInstance();
			String campPrice = numberFormat.format(result_);
			//유저쿠폰을 조회할 객체 생성하기
			String no = ((MemberVo)req.getSession().getAttribute("loginMember")).getNo(); //로그인 유저 정보				
			List<CouponVo> couponList = new CouponService().selectCouponList(no);
			System.out.println("쿠폰리스트 :::" + couponList);
			req.setAttribute("couponList", couponList); //유저쿠폰리스트
			//캠핑존과 관련된 객체 정보
			req.setAttribute("campPrice", campPrice); // 캠핑장 가격
			req.setAttribute("address", req.getParameter("address")); //전화번호
			req.setAttribute("reservaionNop", req.getParameter("reservationNop")); //숙박인원
			req.setAttribute("checkin", req.getParameter("checkin")); //체크인
			req.setAttribute("checkout", req.getParameter("checkout")); //체크아웃
			req.setAttribute("campCode", req.getParameter("campCode")); //캠핑장 코드
			req.setAttribute("zoneNo", req.getParameter("zoneNo"));	//캠핑장 구역변호
			req.setAttribute("zoneName", req.getParameter("zoneName")); //캠핑장 이름
			req.setAttribute("reservationName", req.getParameter("reservationName"));
			req.setAttribute("requestion", req.getParameter("reservationComment"));
			req.setAttribute("address", req.getParameter("reservationPhone"));
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
		orderVo.setCouponCode(req.getParameter("couponCode"));
		orderVo.setPayAmount(req.getParameter("totalCost"));
		orderVo.setPayMethod(req.getParameter("payMethod"));
		//예약테이블에 들어갈 값 
		ReservationVo reservationVo = new ReservationVo();
		reservationVo.setCampName(req.getParameter("zoneName"));
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
			new CouponService().useCoupon(((MemberVo)req.getSession().getAttribute("loginMember")).getNo(), req.getParameter("couponCode"));	
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
