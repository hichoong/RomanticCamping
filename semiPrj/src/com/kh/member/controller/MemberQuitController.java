package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberService;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/quit")
public class MemberQuitController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		MemberVo loginMember = (MemberVo)req.getSession().getAttribute("loginMember");
		int result = 0;
		
		if(loginMember != null) {	
			result = new MemberService().quit(loginMember.getNo());
		} else {
			req.getSession().setAttribute("alertMsg", "로그인 후 접근 가능합니다");
			resp.sendRedirect(req.getContextPath());
		}
		
		if(result > 0) {
			req.getSession().invalidate();
			req.getSession().setAttribute("alertMsg", "회원탈퇴에 성공했습니다");
			resp.sendRedirect(req.getContextPath());
		} else {
			req.getSession().setAttribute("alertMsg", "회원탈퇴에 실패했습니다. 나중에 다시 시도해주세요.");
			resp.sendRedirect(req.getContextPath()+"/member/myPage");
		}
		
	}
}
