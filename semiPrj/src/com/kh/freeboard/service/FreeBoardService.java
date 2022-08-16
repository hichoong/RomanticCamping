package com.kh.freeboard.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

import com.kh.freeboard.repository.FreeBoardDao;
import com.kh.freeboard.vo.FreeBoardVo;

public class FreeBoardService {

	FreeBoardDao dao = new FreeBoardDao();
	
	
	/*
	 * 자유게시판 게시글 작성 
	 */
	public int insertBoard(FreeBoardVo vo) {
		
		//선언먼저~
		Connection conn = getConnection();
		
		int result  = dao.insertBoard(conn, vo);
		
		if(result ==1 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
			
		close(conn);
		
		//결과 리턴 
		return result;
		
	}

}
