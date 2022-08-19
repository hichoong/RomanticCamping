package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberService;

@WebServlet(urlPatterns = "/findPwd")
public class FindPwdController extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/member/findPwdForm.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String id = req.getParameter("id");
		String name = req.getParameter("name");
		String phone = req.getParameter("phone");

		String pwd = new MemberService().findPwd(id, name, phone);
		
		if(pwd != null) {
			req.getSession().setAttribute("alertMsg", "비밀번호는 "+pwd+" 입니다.");
			resp.sendRedirect(req.getContextPath()+"/findPwd");
		} else {
			req.getSession().setAttribute("alertMsg", "비밀번호를 찾을 수 없습니다. 정보를 다시 확인해주세요");
			resp.sendRedirect(req.getContextPath()+"/findPwd");
		}
		
	}
}
