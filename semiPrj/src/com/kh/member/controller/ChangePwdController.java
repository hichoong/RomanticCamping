package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberService;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/changePwd")
public class ChangePwdController extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String originPwd = req.getParameter("pwd");
		String newPwd = req.getParameter("newPwd");
		String newPwdCheck = req.getParameter("newPwdCheck");
		String id = ((MemberVo)req.getSession().getAttribute("loginMember")).getId();
		
		int result = new MemberService().changePwd(originPwd, newPwd, newPwdCheck, id);
		
		if(result == 1) {
			req.getSession().setAttribute("alertMsg", "비밀번호 변경 성공!");
			resp.sendRedirect(req.getContextPath()+"/member/myPage");
		} else {
			req.getSession().setAttribute("alertMsg", "비밀번호 변경에 실패했습니다. 입력사항을 다시 확인해주세요");
			resp.sendRedirect(req.getContextPath()+"/member/myPage");
		}
		
	}
	
}
