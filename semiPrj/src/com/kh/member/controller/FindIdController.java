package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberService;

@WebServlet(urlPatterns = "/findId")
public class FindIdController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		req.getRequestDispatcher("/views/member/findIdForm.jsp").forward(req, resp);
	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String name = req.getParameter("name");
		String phone = req.getParameter("phone");
		
		String id = new MemberService().findId(name, phone);
		
		if(id != null) {
			req.getSession().setAttribute("alertMsg", "아이디는 "+id+" 입니다.");
			resp.sendRedirect(req.getContextPath()+"/findId");
		} else {
			req.getSession().setAttribute("alertMsg", "아이디를 찾을 수 없습니다. 정보를 다시 확인해주세요");
			resp.sendRedirect(req.getContextPath()+"/findId");
		}
		
	}

}
