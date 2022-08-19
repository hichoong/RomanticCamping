package com.kh.freeboard.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;

import com.kh.common.PageVo;
import com.kh.freeboard.attachment.vo.FreeBoardAttachmentVo;
import com.kh.freeboard.vo.FreeBoardRepleVo;
import com.kh.freeboard.vo.FreeBoardTradeRepleVo;
import com.kh.freeboard.vo.FreeBoardTradeVo;

public class FreeBoardTradeDao {

	
	/*
	 * 글작성 - 중고거래게시판 테이블만 채움 - insert
	 */
	public int insertBoard(Connection conn, FreeBoardTradeVo fvo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		
		String sql = "INSERT INTO FREEBOARD_TRADE ( FB_NO, FB_TITLE ,FB_CONTENT, FB_PRICE ,FB_WRITER ) VALUES ( SEQ_FREEBOARD_TRADE_NO.NEXTVAL , ?, ?, ?, ? )";


		try {
			
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, fvo.getTitle());
			pstmt.setString(2, fvo.getContent());
			pstmt.setString(3, fvo.getPrice());
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
		
		
		String sql = "INSERT INTO FB_ATTACHMENT (FBA_NO, FBA_REF_NO, FBA_ORIGIN_NAME, FBA_CHANGE_NAME, FBA_FILE_PATH) VALUES(SEQ_FB_ATTACHMENT_NO.NEXTVAL, SEQ_FREEBOARD_TRADE_NO.CURRVAL, ?, ?, ?)";


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
	
	/*
	 * 중고거래 게시판 총 글 수 
	 */
	public int getCount(Connection conn) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//일반게시판은 타입1 / 사진게시판은 타입2 
			String sql = "SELECT COUNT(FB_NO) AS COUNT FROM FREEBOARD_TRADE WHERE FB_STATUS='N'";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			//실행결과 -> 자바 데이터로 변환
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return count;
	}
	
	/*
	 * 중고거래 게시판 리스트 조회 (페이징 처리)
	 */
	public List<FreeBoardTradeVo> selectList(Connection conn, PageVo fbpageVo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FreeBoardTradeVo> fbvoList = new ArrayList<FreeBoardTradeVo>();
		
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.FB_NO ,B.FB_TITLE ,B.FB_CONTENT ,B.FB_PRICE, B.FB_CNT ,B.FB_ENROLL_DATE ,M.ID AS FB_WRITER FROM FREEBOARD_TRADE B JOIN MEMBER M ON B.FB_WRITER = M.NO WHERE B.FB_STATUS='N' ORDER BY B.FB_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		
		try {
			//SQL을 객체에 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			
			int start = (fbpageVo.getCurrentPage()-1)*fbpageVo.getListLimit() +1;
			int end = start + fbpageVo.getListLimit() -1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
			//SQL 실행 및 결과저장
			rs = pstmt.executeQuery();
			
			//rs->java
			while(rs.next()){
			
				//객체 만들고 값 세팅해주기
				FreeBoardTradeVo fbvo = new FreeBoardTradeVo();
				
				fbvo.setNo(rs.getString("FB_NO"));
				fbvo.setTitle(rs.getString("FB_TITLE"));
				fbvo.setContent(rs.getString("FB_CONTENT"));
				fbvo.setPrice(rs.getString("FB_PRICE"));
				fbvo.setWriter(rs.getString("FB_WRITER"));
				fbvo.setCnt(rs.getString("FB_CNT"));
				fbvo.setEnrollDate(rs.getString("FB_ENROLL_DATE"));
				
				
				//값 세팅한 vo객체를 list에 추가해주기
				fbvoList.add(fbvo);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		return fbvoList;
	}
	
	/*
	 * 중고거래 게시판 메인글 가져오기 (인기글)
	 */
	public List<FreeBoardTradeVo> selectMainList(Connection conn) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<FreeBoardTradeVo> fbMainList = new ArrayList<FreeBoardTradeVo>();
		
		//SQL 준비
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.FB_NO ,B.FB_TITLE ,B.FB_CONTENT ,B.FB_PRICE, B.FB_CNT ,B.FB_ENROLL_DATE ,M.ID AS FB_WRITER FROM FREEBOARD_TRADE B JOIN MEMBER M ON B.FB_WRITER = M.NO WHERE B.FB_STATUS='N' ORDER BY B.FB_CNT DESC ) T ) WHERE RNUM BETWEEN 1 AND 6";
		
		try {

			//SQL 객체에 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			
			//SQL 실행
			rs = pstmt.executeQuery();
			
			//결과 변환 // ResultSet -> 자바객체(NoticeVo)
			while(rs.next()) {
				
				
				FreeBoardTradeVo vo = new FreeBoardTradeVo();
				
				vo.setNo(rs.getString("FB_NO"));
				vo.setTitle(rs.getString("FB_TITLE"));
				vo.setContent(rs.getString("FB_CONTENT"));
				vo.setWriter(rs.getString("FB_WRITER"));
				vo.setPrice(rs.getString("FB_PRICE"));
				vo.setCnt(rs.getString("FB_CNT"));
				vo.setEnrollDate(rs.getString("FB_ENROLL_DATE"));
				
				//실행될 때마다 voList에 vo하나씩 담아주기
				fbMainList.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		//결과 리턴
		return fbMainList;
	}
	
	/*
	 * 조회 수 증가
	 */
	public int increaseFreeBoardTrade(Connection conn, String num) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "UPDATE FREEBOARD_TRADE SET FB_CNT = FB_CNT+1 WHERE FB_NO=? AND FB_STATUS ='N'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		
		return result;
		
	}
	/*
	 * 특정 게시글 가져오기 ( 상세보기 )
	 */
	
	public FreeBoardTradeVo selectOne(Connection conn, String num) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FreeBoardTradeVo fbvo = null;
		
		try {
			
			String sql = "SELECT B.FB_NO, B.FB_TITLE, B.FB_CONTENT, M.NAME AS FB_WRITER, B.FB_PRICE, B.FB_CNT, B.FB_ENROLL_DATE FROM FREEBOARD_TRADE B JOIN MEMBER M ON B.FB_WRITER = M.NO WHERE B.FB_NO = ? AND B.FB_STATUS ='N'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			//rs -> obj로 바꿔주는 작업 필요
			if(rs.next()) {
				
				
				
				//vo객체에 담아주기
				fbvo = new FreeBoardTradeVo();
				
				
				
				fbvo.setNo(rs.getString("FB_NO"));
				fbvo.setTitle(rs.getString("FB_TITLE"));
				fbvo.setContent(rs.getString("FB_CONTENT"));
				fbvo.setWriter(rs.getString("FB_WRITER"));
				fbvo.setPrice(rs.getString("FB_PRICE"));
				fbvo.setCnt(rs.getString("FB_CNT"));
				fbvo.setEnrollDate(rs.getString("FB_ENROLL_DATE"));
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		return fbvo;
	}
	
	
	/*
	 * 댓글 리스트 가져오기
	 */
	public List<FreeBoardTradeRepleVo> selectReple(Connection conn, String num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FreeBoardTradeRepleVo> fbrvoList = new ArrayList<FreeBoardTradeRepleVo>();
		
		try {
			
			String sql = "SELECT F.FBR_NO, F.FBR_CONTENT, M.NAME AS FBR_WRITER, F.FBR_ENROLL_DATE, F.FBR_STATUS FROM FB_REPLE F JOIN MEMBER M ON F.FBR_WRITER = M.NO WHERE F.FBR_REF_NO = ? AND F.FBR_STATUS ='N'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			//rs -> obj로 바꿔주는 작업 필요
			if(rs.next()) {
				
				FreeBoardTradeRepleVo fbrvo = new FreeBoardTradeRepleVo();
				
				//vo객체에 담아주기
				fbrvo = new FreeBoardTradeRepleVo();
				
				fbrvo.setNo(rs.getString("FR_NO"));
				fbrvo.setContent(rs.getString("FR_CONTENT"));
				fbrvo.setWriter(rs.getString("FR_WRITER"));
				fbrvo.setEnrollDate(rs.getString("FR_ENROLL_DATE"));
				
				fbrvoList.add(fbrvo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return fbrvoList;
	}

	
}
