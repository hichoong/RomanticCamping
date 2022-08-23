package com.kh.member.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;

import com.kh.freeboard.vo.FreeBoardTradeVo;
import com.kh.freeboard.vo.FreeBoardVo;
import com.kh.review.vo.ReviewVo;
import com.syl.board.vo.QuestionBoardVo;

public class MemberBoardDao {

	public List<FreeBoardVo> getFreeBoard(Connection conn, String no) {

		String sql = "SELECT F_NO, F_TITLE, SUBSTR(F_CONTENT, 1, 30) CONTENT, F_ENROLL_DATE FROM FREEBOARD WHERE F_WRITER = ? AND F_STATUS = 'N' ORDER BY F_ENROLL_DATE DESC, F_NO DESC";
		
		List<FreeBoardVo> list = new ArrayList<FreeBoardVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FreeBoardVo vo = new FreeBoardVo();
				
				vo.setNo(rs.getString("F_NO"));
				vo.setTitle(rs.getString("F_TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setEnrollDate(rs.getString("F_ENROLL_DATE"));
				
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}

	public List<FreeBoardTradeVo> getTradeBoard(Connection conn, String no) {

		String sql = "SELECT FB_NO, FB_TITLE, SUBSTR(FB_CONTENT, 1, 30) CONTENT, FB_ENROLL_DATE FROM FREEBOARD_TRADE WHERE FB_WRITER = ? AND FB_STATUS = 'N' ORDER BY FB_ENROLL_DATE DESC, FB_NO DESC";
		
		List<FreeBoardTradeVo> list = new ArrayList<FreeBoardTradeVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				FreeBoardTradeVo vo = new FreeBoardTradeVo();
				
				vo.setNo(rs.getString("FB_NO"));
				vo.setTitle(rs.getString("FB_TITLE"));
				vo.setContent(rs.getString("CONTENT"));
				vo.setEnrollDate(rs.getString("FB_ENROLL_DATE"));
				
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}

	public List<ReviewVo> getReview(Connection conn, String no) {

		String sql = "SELECT R.R_NO, R.R_DATE, SUBSTR(R.R_CONTENT, 1, 30) CONTENT, R.R_NUM, R.RE_NO, C.CAMP_NAME FROM REVIEW R JOIN RESERVATION RE ON R.RE_NO = RE.NO JOIN CAMP_INFO C ON R.CAMP_CODE = C.CAMP_CODE WHERE RE.USER_NO = ? AND R.R_STATUS = 'Y' ORDER BY R_DATE DESC ";
		
		List<ReviewVo> list = new ArrayList<ReviewVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReviewVo vo = new ReviewVo();
				
				vo.setReviewNo(rs.getString("R_NO"));
				vo.setReviewContent(rs.getString("CONTENT"));
				vo.setStarScore(rs.getString("R_NUM"));
				vo.setEnrollDate(rs.getString("R_DATE"));
				vo.setReservationNo(rs.getString("RE_NO"));
				vo.setCampName(rs.getString("CAMP_NAME"));
				
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}

	public List<QuestionBoardVo> getQuestion(Connection conn, String no) {
		
		String sql = "SELECT Q_NO, Q_TITLE, SUBSTR(Q_CONTENT, 1, 30) CONTENT, Q_UPDATE_DATE FROM QUESTIONBOARD WHERE Q_WRITER = ? ORDER BY Q_UPDATE_DATE DESC, Q_NO DESC";
		
		List<QuestionBoardVo> list = new ArrayList<QuestionBoardVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				QuestionBoardVo vo = new QuestionBoardVo();
				
				vo.setqNo(rs.getString("Q_NO"));
				vo.setqTitle(rs.getString("Q_TITLE"));
				vo.setqContent(rs.getString("CONTENT"));
				vo.setqUpdateDate(rs.getString("Q_UPDATE_DATE"));
//				vo.setqAnswerYN(rs.getString("ANS_YN"));
			
				list.add(vo);
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}

}
