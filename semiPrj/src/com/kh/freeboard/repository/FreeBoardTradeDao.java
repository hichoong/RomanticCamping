package com.kh.freeboard.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static com.kh.common.JDBCTemplate.*;

import com.kh.freeboard.attachment.vo.FreeBoardAttachmentVo;
import com.kh.freeboard.vo.FreeBoardTradeVo;

public class FreeBoardTradeDao {

	
	/*
	 * 글작성 - 중고거래게시판 테이블만 채움 - insert
	 */
	public int insertBoard(Connection conn, FreeBoardTradeVo fvo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		
		String sql = "INSERT INTO BOARD ( NO ,TYPE ,CATEGORY_NO ,TITLE ,CONTENT ,WRITER ) VALUES ( SEQ_BOARD_NO.NEXTVAL , 1 , ? , ? , ? , ? )";


		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fvo.getType());
			pstmt.setString(2, fvo.getTitle());
			pstmt.setString(3, fvo.getContent());
			pstmt.setString(4, fvo.getWriter());
			
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	/*
	 * 게시글 작성 ( FreeBoardATTACHMENT 테이블만 채움 - insert )
	 */
	public int insertAttachment(Connection conn, FreeBoardAttachmentVo fbavo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		
		String sql = "INSERT INTO ATTACHMENT (NO, REF_BNO, ORIGIN_NAME, CHANGE_NAME, FILE_PATH) VALUES(SEQ_ATTACHMENT_NO.NEXTVAL, SEQ_BOARD_NO.CURRVAL, ?, ?, ?)";


		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fbavo.getOriginName());
			pstmt.setString(2, fbavo.getChangeName());
			pstmt.setString(3, fbavo.getFilePath());
			
			result = pstmt.executeUpdate();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		
		return result;
	}

	
}
