package com.kh.coupon.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.coupon.service.CouponService;
import com.kh.coupon.vo.CouponVo;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/coupon")
public class MyCouponListController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = ((MemberVo)req.getSession().getAttribute("loginMember")).getNo();
		
		List<CouponVo> list = new CouponService().selectCouponList(no);
		
		req.setAttribute("couponList", list);
		req.getRequestDispatcher("/views/member/myCouponList.jsp").forward(req, resp);
		
	}
}
