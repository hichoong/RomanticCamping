package com.kh.freeboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.freeboard.service.FreeBoardService;
import com.kh.freeboard.service.FreeBoardTradeService;
import com.kh.freeboard.vo.FreeBoardTradeVo;
import com.kh.freeboard.vo.FreeBoardVo;

@WebServlet(urlPatterns = "/freeBoard/trade/edit")
public class FreeBoardTradeEditController extends HttpServlet{

	/*
	 * 수정하기 화면 보여주기
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("num");
		
		//서비스호출 - 만들어놓은 조회해오는 메서드활용
		FreeBoardTradeVo fbvo = new FreeBoardTradeService().selectOne(num);
		
		//결과에 따라, 화면 선택
		if(fbvo != null) {
			//성공 //수정하기 화면 보여주기
			req.setAttribute("fbvo", fbvo);
			req.getRequestDispatcher("/views/freeBoard/freeBoardTradeEdit.jsp").forward(req, resp);
		}else {
			//실패
			req.setAttribute("errorMsg", "중고거래 게시글 수정하기 화면 불러오는 중 에러 발생!");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
		
	}
	
	/*
	 * 수정하기 db 작업 
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("fbeditNo");
		String title = req.getParameter("fbeditTitle");
		String content = req.getParameter("fbeditContent");
		FreeBoardTradeVo fbvo = new FreeBoardTradeVo();
		
		fbvo.setNo(no);
		fbvo.setTitle(title);
		fbvo.setContent(content);
		
		int result = new FreeBoardTradeService().editFreeBoardTrade(fbvo);
		
		//결과에 따라 화면 선택
		if(result==1) {
			//성공 -> 상세보기 페이지
			resp.sendRedirect(req.getContextPath() + "/freeBoard/trade/detail?num2=" + no);
		}else {
			//실패
			req.setAttribute("errorMsg", "중고거래 게시글 수정 실패");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
		
	}	
	
	
}//class
