package com.kh.review.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static com.kh.common.JDBCTemplate.*;

import com.kh.camplist.campinfo.vo.CampInfoVo;
import com.kh.review.vo.ReviewVo;

public class ReviewDao {
	
	//캠핑장 정보 조회
	public CampInfoVo campSelect(Connection conn, String reservationNo) {
		
		String sql = "SELECT CAMP_CODE, CAMP_NAME, CITY, DISTRICT, CAMP_ADDRESS, CAMP_INTRO, CAMP_IMGPATH FROM CAMP_INFO WHERE CAMP_CODE IN (SELECT CAMP_CODE FROM RESERVATION WHERE NO = ? ) AND CAMP_STATUS = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CampInfoVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reservationNo);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				String campCode = rs.getString("CAMP_CODE");
				String campName = rs.getString("CAMP_NAME");
				String city = rs.getString("CITY");
				String district = rs.getString("DISTRICT");
				String address = rs.getString("CAMP_ADDRESS");
				String campIntro = rs.getString("CAMP_INTRO");
				String campImgpath = rs.getString("CAMP_IMGPATH");

				vo = new CampInfoVo();
				vo.setCampCode(campCode);
				vo.setCampName(campName);
				vo.setCity(city);
				vo.setDistrict(district);
				vo.setCampAddress(address);
				vo.setCampIntro(campIntro);
				vo.setCampImgpath(campImgpath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return vo;
	}
	
	//리뷰 조회
	public ReviewVo selectOne(Connection conn, String reservationNo) {
	
		String sql = "SELECT R_NO, RE_NO, R_DATE, R_CONTENT, R_NUM, R_STATUS FROM REVIEW WHERE RE_NO = ? AND R_STATUS = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewVo vo = null;
	
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reservationNo);
			
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

		String sql = "INSERT INTO REVIEW ( R_NO ,RE_NO ,R_CONTENT ,R_NUM, CAMP_CODE) VALUES ( SEQ_REVIEW_NO.NEXTVAL , ? , ? , ?, ? )";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getReservationNo());
			pstmt.setString(2, vo.getReviewContent());
			pstmt.setString(3, vo.getStarScore());
			pstmt.setString(4, vo.getCampCode());

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
		
		String sql = "UPDATE REVIEW SET R_NUM = ?, R_CONTENT = ?, R_UPDATED = SYSDATE WHERE RE_NO = ? AND R_STATUS = 'Y'";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getStarScore());
			pstmt.setString(2, vo.getReviewContent());
			pstmt.setString(3, vo.getReservationNo());
		
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
	public int delete(Connection conn, String reservationNo) {
		
		String sql = "UPDATE REVIEW SET R_STATUS = 'N' WHERE RE_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, reservationNo);
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}


	

	

	

	
		
}
