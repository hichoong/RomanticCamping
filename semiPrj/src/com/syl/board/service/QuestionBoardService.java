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
		
		Connection conn = null;
		int result = 0;
		
		try {
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
		
		return result;
	
	}

		/////////////////////문의글 조회수 증가/////////////////////
		public int increaseBoard(String num) {
			
			Connection conn = null;
			int result = 0;
			
			try {
				
				conn = getConnection();
				
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

		
		///////////////// 조회수 증가 ////////////////////
		public QuestionBoardVo selectOne(String num) {
			
			Connection conn = null;
			QuestionBoardVo vo = null;
					
			try {
				conn = getConnection();
				
				vo = new QuestionBoardDao().selectOne(conn, num);
			}catch(Exception e){
				e.printStackTrace();
			}finally {
				close(conn);
			}
			return vo;
		}
	
		///////////////// 문의글 삭제 ////////////////////
		public int delete(String num) {
			
			Connection conn = null;
			int result = 0;
			
			try {
				conn = getConnection();
				
				result = new QuestionBoardDao().delete(conn, num);
				
				if(result == 1) {
					commit(conn);
				}else {
					rollback(conn);
				}
			}catch(Exception e){
				rollback(conn);
				e.printStackTrace();
			}finally {
				close(conn);
			}
			
			return result;
		}
		
		///////////////// 문의글 수정 ////////////////////
		public int edit(QuestionBoardVo vo) {
			
			if(vo.getqTitle().length() < 1) {
				return -1;
			}
			
			if(vo.getqContent().length() < 1) {
				return -2;
			}
			Connection conn = null;
			int result = 0;
			
			conn = getConnection();
			try {
			
				result = dao.edit(conn, vo);
				
				if(result == 1) {
					commit(conn);
				}else {
					rollback(conn);
				}
			}catch(Exception e) {
				e.printStackTrace();
				rollback(conn);
			}finally {
				close(conn);
			}
			return result;
		}
		
		
	
}//class
