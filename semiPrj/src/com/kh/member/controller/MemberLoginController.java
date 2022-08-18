package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberService;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/login")
public class MemberLoginController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/member/loginForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String pwd = req.getParameter("pwd");
		
		MemberVo memberVo = new MemberVo();
		memberVo.setId(id);
		memberVo.setPwd(pwd);
		
		MemberVo loginMember = new MemberService().login(memberVo);
		
		if(loginMember != null) {
			req.getSession().setAttribute("loginMember", loginMember);
			resp.sendRedirect(req.getContextPath());
		} else {
			req.setAttribute("errorMsg", "아이디 또는 비밀번호를 잘못 입력했습니다.<br> 입력하신 내용을 다시 확인해주세요");
			req.getRequestDispatcher("/views/member/loginForm.jsp").forward(req, resp);
		}
	
	}
	
}
