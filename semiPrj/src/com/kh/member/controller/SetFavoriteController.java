package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberFavoriteService;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/setFavorite")
public class SetFavoriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String campCode = req.getParameter("campCode");
		String no = ((MemberVo)req.getSession().getAttribute("loginMember")).getNo();
		int result = -1;
		if(campCode != null) {			
			result = new MemberFavoriteService().setFavorite(campCode, no);
		}
		
		
		if(result == 1) {
			resp.getWriter().write("T");
		} else {
			resp.getWriter().write("F");
		}
		
	}
}
