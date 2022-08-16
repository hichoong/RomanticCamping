package com.kh.freeboard.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.kh.common.JDBCTemplate.*;
import com.kh.freeboard.vo.FreeBoardVo;

public class FreeBoardDao {

	/*
	 * 자유게시판 글 작성
	 */
	public int insertBoard(Connection conn, FreeBoardVo vo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			String sql = "INSERT INTO NOTICE ( NO, TITLE, CONTENT, WRITER ) VALUES ( SEQ_NOTICE_NO.NEXTVAL, ?, ?, ? )";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getTitle());
			pstmt.setString(2, vo.getContent());
			pstmt.setString(3, vo.getNo());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
		
		
	}

}
