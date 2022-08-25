package com.kh.camprequest.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.camprequest.service.CampRequestService;
import com.sjy.buisness.camp.vo.BsCampVo;
import com.syl.board.service.QuestionBoardService;
import com.syl.board.vo.QuestionBoardVo;

@WebServlet(urlPatterns = "/request/list")
public class CampRequestList extends HttpServlet  {

	//캠핑장 등록 요청 목록
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		ArrayList<BsCampVo> voList = new CampRequestService().selectList();
		
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/views/campRequest/campDetailRequest.jsp").forward(req, resp);
		
	}
	
}//class
