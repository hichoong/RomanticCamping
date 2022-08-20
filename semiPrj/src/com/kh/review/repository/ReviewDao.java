package com.kh.review.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.kh.common.JDBCTemplate.*;

import com.kh.camplist.campinfo.vo.CampInfoVo;
import com.kh.review.vo.ReviewVo;

public class ReviewDao {
	
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
				vo.setReviewNo(rNo);
				vo.setReservationNo(reNo);
				vo.setEnrollDate(rDate);
				vo.setReviewContent(content);
				vo.setStarScore(starScore);
				vo.setReviewStatus(status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return vo;
	}

	//리뷰 작성
	public int reviewInsert(Connection conn, ReviewVo vo) {

		String sql = "INSERT INTO REVIEW ( R_NO ,RE_NO ,R_CONTENT ,R_NUM, CAMP_CODE) VALUES ( SEQ_REVIEW_NO.NEXTVAL , 1 , ? , ?, ? )";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getReviewContent());
			pstmt.setString(2, vo.getStarScore());
			pstmt.setString(3, "1"); //캠핑장 번호 받아오기

			//SQL 실행
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
	
		return result;
	}

	//리뷰 수정
	public int edit(Connection conn, ReviewVo vo) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		String sql = "UPDATE REVIEW SET R_NUM = ?, R_CONTENT = ?, R_UPDATED = SYSDATE WHERE R_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getStarScore());
			pstmt.setString(2, vo.getReviewContent());
			pstmt.setString(3, vo.getReviewNo());
		
			result = pstmt.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
			rollback(conn);
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	//리뷰 삭제
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

	public CampInfoVo selectCamp(Connection conn, String campCode) {
		
//		String sql = "SELECT R_NO, RE_NO, R_DATE, R_CONTENT, R_NUM, R_STATUS FROM REVIEW WHERE R_NO = ? AND R_STATUS = 'Y'";
//		
//		PreparedStatement pstmt = null;
//		ResultSet rs = null;
//		ReviewVo vo = null;
//	
//		try {
//			pstmt = conn.prepareStatement(sql);
//			pstmt.setString(1, num);
//			
//			rs = pstmt.executeQuery();
//			
//			if(rs.next()) {
//				String rNo = rs.getString("R_NO");
//				String reNo = rs.getString("RE_NO");
//				String rDate = rs.getString("R_DATE");
//				String content = rs.getString("R_CONTENT");
//				String starScore = rs.getString("R_NUM");
//				String status = rs.getString("R_STATUS");
//				
//				vo = new ReviewVo();
//				vo.setReviewNo(rNo);
//				vo.setReservationNo(reNo);
//				vo.setEnrollDate(rDate);
//				vo.setReviewContent(content);
//				vo.setStarScore(starScore);
//				vo.setReviewStatus(status);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			close(rs);
//			close(pstmt);
//		}
		
		return null;
	}
		
}
