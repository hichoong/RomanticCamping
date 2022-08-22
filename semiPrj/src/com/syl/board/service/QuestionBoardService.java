package com.syl.board.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.syl.board.repository.QuestionBoardDao;
import com.syl.board.vo.QuestionBoardVo;

public class QuestionBoardService {

	private final QuestionBoardDao dao = new QuestionBoardDao();

	public ArrayList<QuestionBoardVo> selectList() {
		
		Connection conn = null;
		ArrayList<QuestionBoardVo> voList = null;
		
		try {
			conn = JDBCTemplate.getConnection();
			
			voList = new QuestionBoardDao().selectList(conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
				
		return voList;

	}
	
	
	
	
	
	
}//class
