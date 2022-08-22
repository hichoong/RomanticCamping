package com.syl.board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.syl.board.service.QuestionBoardService;
import com.syl.board.vo.QuestionBoardVo;

@WebServlet (urlPatterns = "/question/list")
public class QuestionBoardList extends HttpServlet {

	//글 목록 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
		ArrayList<QuestionBoardVo> voList = new QuestionBoardService().selectList();
			
		req.setAttribute("voList", voList);
		req.getRequestDispatcher("/views/board/questionBoard.jsp").forward(req, resp);
	}
	
	
	
	
	
	
	
	
	
	
}//class
