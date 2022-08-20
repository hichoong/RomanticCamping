package com.kh.freeboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.freeboard.service.FreeBoardService;
import com.kh.freeboard.service.FreeBoardTradeService;
import com.kh.freeboard.vo.FreeBoardRepleVo;
import com.kh.freeboard.vo.FreeBoardTradeRepleVo;
import com.kh.freeboard.vo.FreeBoardTradeVo;
import com.kh.freeboard.vo.FreeBoardVo;

@WebServlet(urlPatterns = "/freeBoard/trade/detail")
public class FreeBoardTradeDetailController extends HttpServlet{

	/*
	 * 중고거래 게시판 상세조회 화면 보여주기
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("num2");
		
		//조회수 증가시켜주는 update요청
		int result = new FreeBoardTradeService().increaseFreeBoardTrade(num);
	
		if(result ==1) {
			
			//디비에 가서, 특정 공지사항 정보 조회
			FreeBoardTradeVo fbvo = new FreeBoardTradeService().selectOne(num);
			
			//디비에 가서, 특정 게시글 댓글 정보 조회
			List<FreeBoardTradeRepleVo> fbrvoList = new FreeBoardTradeService().selectReple(num);
			
			//정보를 req에 담아서, 다음타자한테 포워딩
			if(fbvo != null) {
				//성공하면 다음타자에게 포워딩
				req.setAttribute("fbvo", fbvo);
				req.setAttribute("fbrvoList", fbrvoList);
				req.getRequestDispatcher("/views/freeBoard/freeBoardTradeDetail.jsp").forward(req, resp);
			}else {
				//실패하면 공지사항글 그대로
				req.setAttribute("errorMsg", "중고거래 게시글 상세 조회 실패!");
				req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
			}
			
		}else {
			//조회실패
			req.setAttribute("errorMsg", "중고거래 게시글 상세 조회 실패!");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
		
	}
	
}//class
