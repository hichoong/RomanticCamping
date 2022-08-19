package com.kh.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.member.service.MemberService;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/myPage")
public class MyPageController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/member/myPage.jsp").forward(req, resp);	
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		MemberVo vo = new MemberVo();
		
		vo.setNo(((MemberVo)req.getSession().getAttribute("loginMember")).getNo());
		vo.setName(req.getParameter("name"));
		vo.setPhone(req.getParameter("phone"));
		vo.setEmail(req.getParameter("email"));
		vo.setBirthday(req.getParameter("birth"));
		vo.setGender(req.getParameter("gender"));
		
		MemberVo updateVo = new MemberService().edit(vo);
		
		if(updateVo != null) {
			req.getSession().setAttribute("loginMember", updateVo);
			req.getSession().setAttribute("alertMsg", "회원 정보 수정을 완료했습니다");
			resp.sendRedirect(req.getContextPath()+"/member/myPage");
		} else {
			req.getSession().setAttribute("alertMsg", "정보수정에 실패했습니다. 입력하신 내용을 다시 확인해주세요");
			resp.sendRedirect(req.getContextPath()+"/member/myPage");
		}
		
	}
	
}
