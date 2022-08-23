package com.sjy.buisness.camp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjy.buisness.camp.service.BsCampService;

@WebServlet(urlPatterns = "/bscamp/deleteCamp")
public class BsCampDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//캠핑장 정보로 번호 가져오기
		String campCode = req.getParameter("campCode");
		
		//상태값 변경하기
		int result = new BsCampService().delteCamp(campCode);
		
		if (result ==1) {
			System.out.println("캠핑장 삭제성공!");
			req.getSession().setAttribute("alertMsg", "캠핑장 삭제성공!");
			resp.sendRedirect(req.getContextPath());
		}else {
			System.out.println("캠핑장 삭제실패");
		}
		
	}
}
