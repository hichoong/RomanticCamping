package com.kh.freeboard.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.freeboard.service.FreeBoardService;
import com.kh.freeboard.vo.FreeBoardVo;

@WebServlet(urlPatterns = "/freeBoard/edit")
public class FreeBoardEditController extends HttpServlet{

	/*
	 * 수정하기 화면 보여주기 ( select )
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String num = req.getParameter("num");
		
		//서비스호출 - 만들어놓은 조회해오는 메서드활용
		FreeBoardVo fvo = new FreeBoardService().selectOne(num);
		
		//결과에 따라, 화면 선택
		if(fvo != null) {
			//성공 //수정하기 화면 보여주기
			req.setAttribute("fvo", fvo);
			req.getRequestDispatcher("/views/freeBoard/freeBoardEdit.jsp").forward(req, resp);
		}else {
			//실패
			req.setAttribute("errorMsg", "공지사항 수정하기 화면 불러오는 중 에러 발생!");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
		
	}
	
	/*
	 * 수정하기 디비 작업 ( update )
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("feditNo");
		String title = req.getParameter("feditTitle");
		String content = req.getParameter("feditContent");
		FreeBoardVo fvo = new FreeBoardVo();
		
		fvo.setNo(no);
		fvo.setTitle(title);
		fvo.setContent(content);
		
		int result = new FreeBoardService().editFreeBoard(fvo);
		
		//결과에 따라 화면 선택
		if(result==1) {
			//성공 -> 상세보기 페이지
			resp.sendRedirect(req.getContextPath() + "/freeBoard/detail?num=" + no);
		}else {
			//실패
			req.setAttribute("errorMsg", "공지사항 수정 실패");
			
			
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
		
	}
	
}//class
