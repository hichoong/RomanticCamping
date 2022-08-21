package com.kh.freeboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.freeboard.service.FreeBoardService;

@WebServlet(urlPatterns = "/freeBoard/reple/delete")
public class FreeBoardRepleDelete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num = req.getParameter("num");
		String pageNo = req.getParameter("pageNo");
		
		System.out.println(num);
		System.out.println(pageNo);
		
		int result = new FreeBoardService().deleteRepleBoard(num);
		
		if(result ==1) {
			//삭제 성공 //리스트로 보내기
			req.getSession().setAttribute("alertMag", "자유게시판 댓글 삭제 성공!");
			resp.sendRedirect(req.getContextPath()+"/freeBoard/detail?num="+ pageNo);
		}else {
			//삭제 실패 //에러페이지로 보내기
			req.setAttribute("errorMsg", "자유게시판 글 삭제 실패");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
		
		
	}
	
	
}//class
