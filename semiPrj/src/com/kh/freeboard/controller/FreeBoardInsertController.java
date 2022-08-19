package com.kh.freeboard.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.freeboard.service.FreeBoardService;
import com.kh.freeboard.vo.FreeBoardVo;

@WebServlet(urlPatterns = "/freeboard/insert")
public class FreeBoardInsertController extends HttpServlet{

	
	/*
	 * 자유게시판 글 등록 백엔드
	 */
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String no = req.getParameter("fb-writerNo");
		String title = req.getParameter("fb-title");
		String content = req.getParameter("fb-content");
		
		System.out.println(no);
		System.out.println(title);
		System.out.println(content);
		
		FreeBoardVo vo = new FreeBoardVo();
		vo.setNo(no);
		vo.setTitle(title);
		vo.setContent(content);
		
		//결과 = 서비스 호출
		int result = new FreeBoardService().insertBoard(vo);
		
	}
	
	
}
