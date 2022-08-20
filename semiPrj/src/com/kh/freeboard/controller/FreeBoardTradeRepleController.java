package com.kh.freeboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.freeboard.service.FreeBoardTradeService;
import com.kh.freeboard.vo.FreeBoardRepleVo;
import com.kh.freeboard.vo.FreeBoardTradeRepleVo;

@WebServlet(urlPatterns = "/freeBoard/trade/reple/insert")
public class FreeBoardTradeRepleController extends HttpServlet{

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = req.getParameter("num");
		String writer = req.getParameter("loginName");
		String content = req.getParameter("content");

		FreeBoardTradeRepleVo vo = new FreeBoardTradeRepleVo();
		vo.setNo(no);
		vo.setWriter(writer);
		vo.setContent(content);
		
		//결과 = 서비스 호출
		int result = new FreeBoardTradeService().insertRepleTradeBoard(vo);
		
	
	}
	
	
	
}//class
