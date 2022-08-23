package com.kh.member.service;

import java.sql.Connection;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;

import com.kh.freeboard.vo.FreeBoardTradeVo;
import com.kh.freeboard.vo.FreeBoardVo;
import com.kh.member.repository.MemberBoardDao;
import com.kh.review.vo.ReviewVo;
import com.syl.board.vo.QuestionBoardVo;

public class MemberBoardService {

	MemberBoardDao dao = new MemberBoardDao();
	
	public List<FreeBoardVo> getFreeBoard(String no) {

		Connection conn = getConnection();
		List<FreeBoardVo> list = dao.getFreeBoard(conn, no);  
		
		close(conn);
		
		return list;
	}

	public List<FreeBoardTradeVo> getTradeBoard(String no) {
		
		Connection conn = getConnection();
		List<FreeBoardTradeVo> list = dao.getTradeBoard(conn, no);  
		
		close(conn);
		
		return list;
	}

	public List<ReviewVo> getReview(String no) {
		
		Connection conn = getConnection();
		List<ReviewVo> list = dao.getReview(conn, no);  
		
		close(conn);
		
		return list;
	}

	public List<QuestionBoardVo> getQuestion(String no) {
		
		Connection conn = getConnection();
		List<QuestionBoardVo> list = dao.getQuestion(conn, no);  
		
		close(conn);
		
		return list;
	}

}
