package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberService;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/user/join")
public class UserJoinController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberVo vo = new MemberVo();
		
		vo.setId(req.getParameter("id"));
		vo.setPwd(req.getParameter("pwd"));
		vo.setPwdCheck(req.getParameter("pwdCheck"));
		vo.setName(req.getParameter("name"));
		vo.setPhone(req.getParameter("phone"));
		vo.setEmail(req.getParameter("email"));
		vo.setBirthday(req.getParameter("birth"));
		vo.setGender(req.getParameter("gender"));
		
		int result = new MemberService().userJoin(vo);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "회원가입 성공!");
			resp.sendRedirect(req.getContextPath());
		} else {
			req.setAttribute("errorMsg", "회원가입에 실패했습니다. 입력하신 내용을 다시 확인해주세요");
			req.getRequestDispatcher("/views/member/joinForm.jsp").forward(req, resp);
		}
		
	}
	
}
