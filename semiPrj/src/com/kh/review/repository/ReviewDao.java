package com.kh.review.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.kh.common.JDBCTemplate.*;
import com.kh.review.vo.ReviewVo;

public class ReviewDao {

	//리뷰 작성
	public int reviewInsert(Connection conn, ReviewVo vo) {

		String sql = "INSERT INTO REVIEW ( R_NO ,RE_NO ,R_CONTENT ,R_NUM ) VALUES ( SEQ_REVIEW_NO.NEXTVAL , 1 , ? , ? )";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getrContent());
			pstmt.setString(2, vo.getrNum());

			//SQL 실행
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
	
		return result;
	}

	public int delete(Connection conn, String num) {
		
		String sql = "UPDATE REVIEW SET R_STATUS = 'N' WHERE R_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	//리뷰 조회
	public ReviewVo selectOne(Connection conn, String num) {
	
		String sql = "SELECT R_NO, RE_NO, R_DATE, R_CONTENT, R_NUM, R_STATUS FROM REVIEW WHERE R_NO = ? AND R_STATUS = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewVo vo = null;
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String rNo = rs.getString("R_NO");
				String reNo = rs.getString("RE_NO");
				String rDate = rs.getString("R_DATE");
				String content = rs.getString("R_CONTENT");
				String starScore = rs.getString("R_NUM");
				String status = rs.getString("R_STATUS");
				
				vo = new ReviewVo();
				vo.setrNo(rNo);
				vo.setReNo(reNo);
				vo.setrDate(rDate);
				vo.setrContent(content);
				vo.setrNum(starScore);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return vo;
	}

	//리뷰 수정
	public int edit(Connection conn, ReviewVo vo) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE REVIEW SET R_NUM = ?, R_CONTENT = ? WHERE R_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getrNum());
			pstmt.setString(2, vo.getrContent());
			pstmt.setString(3, vo.getrNo());
		
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
