package com.kh.freeboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.freeboard.service.FreeBoardService;
import com.kh.freeboard.vo.FreeBoardRepleVo;
import com.kh.freeboard.vo.FreeBoardVo;

@WebServlet(urlPatterns = "/freeBoard/reple/insert")
public class FreeBoardRepleInsertController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String no = req.getParameter("num");
		String writer = req.getParameter("loginName");
		String content = req.getParameter("content");

		FreeBoardRepleVo vo = new FreeBoardRepleVo();
		vo.setNo(no);
		vo.setWriter(writer);
		vo.setContent(content);
		
		//결과 = 서비스 호출
		int result = new FreeBoardService().insertRepleBoard(vo);
		
		
		//다음 타자 선택
		if(result == 1) {
			resp.sendRedirect(req.getContextPath()+"/freeBoard/detail?num="+no);
		} else {
			req.setAttribute("errorMsg", "중고거래 게시글 상세 조회 실패!");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
		
		
	}
	
	
}//class
