package com.syl.board.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.common.JDBCTemplate;
import com.syl.board.repository.QuestionBoardDao;
import com.syl.board.vo.QuestionBoardVo;

public class QuestionBoardService {

	private final QuestionBoardDao dao = new QuestionBoardDao();
	
		/////////////////////문의글 목록//////////////////// 
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
	
		/////////////////////문의글 작성//////////////////////
	public int insertBoard(QuestionBoardVo vo) {
		//비지니스로직
		Connection conn = null;
		int result = 0;
		
		try {
			//DAO 호출
			conn = getConnection();
			result = new QuestionBoardDao().insertBoard(vo, conn);
			
			if(result == 1) {
				commit(conn);
			}else {
				rollback(conn);
			}
		}catch(Exception e) {
			rollback(conn);
		}finally {
			close(conn);
		}
		
		//결과 리턴
		return result;
	
	}

		 /////////////////////문의글 조회수 증가/////////////////////
		public int increaseBoard(String num) {
			
			Connection conn = null;
			int result = 0;
			
			try {
				
				conn = getConnection();
				
				//DAO 호출
				result = new QuestionBoardDao().increaseBoard(conn, num);
				
				if(result == 1) {
					commit(conn);
				}else {
					rollback(conn);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}finally {
				close(conn);
			}
			
			return result;
		}

		
		///////////////// 조회수 ////////////////////
		public QuestionBoardVo selectOne(String num) {
			
			Connection conn = null;
			QuestionBoardVo vo = null;
					
			try {
				conn = getConnection();
				
				//DAO 호출
				vo = new QuestionBoardDao().selectOne(conn, num);
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				close(conn);
			}
			return vo;
		}
	
		
		
	
}//class
