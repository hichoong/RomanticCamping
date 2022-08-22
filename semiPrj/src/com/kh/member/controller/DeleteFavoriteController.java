package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberService;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/deleteFavorite")
public class DeleteFavoriteController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String campCode = req.getParameter("campNo");
		String no = ((MemberVo)req.getSession().getAttribute("loginMember")).getNo();
		
		int result = new MemberService().deleteFavorite(campCode, no);
		
		if(result == 1) {
			resp.sendRedirect(req.getContextPath()+"/member/favorite");
		} else {
			req.getSession().setAttribute("alertMsg", "찜 삭제에 실패했습니다. 나중에 다시 시도해주세요");
			resp.sendRedirect(req.getContextPath()+"/member/favorite");
		}
		
	}
}
