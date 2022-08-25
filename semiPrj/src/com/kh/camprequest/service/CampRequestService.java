package com.kh.camprequest.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.kh.camprequest.repository.CampRequestDao;
import com.kh.common.JDBCTemplate;
import com.sjy.buisness.camp.vo.BsCampVo;
import com.syl.board.repository.QuestionBoardDao;
import com.syl.board.vo.QuestionBoardVo;

public class CampRequestService {

private final CampRequestDao dao = new CampRequestDao();
	
	// 캠핑장 등록 요청 _ 목록
	public ArrayList<BsCampVo> selectList() {
		
		Connection conn = null;
		ArrayList<BsCampVo> voList = null;
	
		try {
			conn = JDBCTemplate.getConnection();
			
			voList = new CampRequestDao().selectList(conn);
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
		}
				
		return voList;
	}
	
	// 캠핑장 등록 요청 _ 상세 조회
	public BsCampVo selectOne(String num) {
		
		Connection conn = null;
		BsCampVo vo = null;
				
		try {
			conn = getConnection();
			
			vo = new CampRequestDao().selectOne(conn, num);
		}catch(Exception e){
			e.printStackTrace();
		}finally {
			close(conn);
		}
		return vo;
	}
	
	//캠핑장 등록 요청 _ 삭제
	public int delete(String num) {
		
		Connection conn = null;
		int result = 0;
		
		try {
			conn = getConnection();
			
			result = new CampRequestDao().reject(conn, num);
			
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
	
	
	
	
}//class
