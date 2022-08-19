package com.kh.freeboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.freeboard.service.FreeBoardService;
import com.kh.freeboard.vo.FreeBoardRepleVo;
import com.kh.freeboard.vo.FreeBoardVo;

@WebServlet(urlPatterns = "/freeBoard/detail")
public class FreeBoardDetailController extends HttpServlet{
	
	/*
	 * 자유게시판 상세페이지 보여주기 ( 조회수 증가 )
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String num = req.getParameter("num");
		
		//조회수 증가시켜주는 update요청
		int result = new FreeBoardService().increaseNotice(num);
		
		if(result ==1) {
			
			//디비에 가서, 특정 게시글 정보 조회
			FreeBoardVo fvo = new FreeBoardService().selectOne(num);
			
			//디비에 가서, 특정 게시글 댓글 정보 조회
			List<FreeBoardRepleVo> frvoList = new FreeBoardService().selectReple(num);
			/* FreeBoardRepleVo frvo = new FreeBoardService().selectReple(num); */
			
			
			//정보를 req에 담아서, 다음타자한테 포워딩
			if(fvo != null) {
				//성공하면 다음타자에게 포워딩
				req.setAttribute("fvo", fvo);
				req.setAttribute("frvoList", frvoList);
				req.getRequestDispatcher("/views/freeBoard/freeBoardDetail.jsp").forward(req, resp);
			}else {
				//실패하면 공지사항글 그대로
				req.setAttribute("errorMsg", "공지사항 상세 조회 실패!");
				req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
			}
			
		}else {
			//조회실패
			req.setAttribute("errorMsg", "공지사항 상세 조회 실패!");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
		
		
		
		
	}
	
}//class
