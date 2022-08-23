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
		String sql = "SELECT * FROM (   SELECT ROWNUM RNUM, T.*, FA.FBA_CHANGE_NAME FROM ( SELECT B.FB_NO ,B.FB_TITLE ,B.FB_CONTENT ,B.FB_PRICE, B.FB_CNT ,B.FB_ENROLL_DATE ,M.ID AS FB_WRITER FROM FREEBOARD_TRADE B JOIN MEMBER M ON B.FB_WRITER = M.NO WHERE B.FB_STATUS='N' ORDER BY B.FB_CNT DESC ) T JOIN FB_ATTACHMENT FA ON T.FB_NO = FA.FBA_REF_NO ) WHERE RNUM BETWEEN 1 AND 6";
		
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
				vo.setChangeName(rs.getString("FBA_CHANGE_NAME"));
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
			
			String sql = "SELECT FBR_NO, FBR_REF_NO, FBR_WRITER, FBR_CONTENT, FBR_ENROLL_DATE FROM FB_REPLE WHERE ? = FBR_REF_NO AND FBR_STATUS='N' ORDER BY FBR_NO";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			//rs -> obj로 바꿔주는 작업 필요
			while(rs.next()) {
				
				FreeBoardTradeRepleVo fbrvo = new FreeBoardTradeRepleVo();
				
				//vo객체에 담아주기
				fbrvo.setNo(rs.getString("FBR_NO"));
				fbrvo.setWriter(rs.getString("FBR_WRITER"));
				fbrvo.setContent(rs.getString("FBR_CONTENT"));
				fbrvo.setEnrollDate(rs.getString("FBR_ENROLL_DATE"));
				
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
	
	/*
	 * 댓글 입력 작업
	 */
	public int insertRepleTradeBoard(Connection conn, FreeBoardTradeRepleVo vo) {

		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			String sql = "INSERT INTO FB_REPLE ( FBR_NO, FBR_REF_NO, FBR_WRITER, FBR_CONTENT ) VALUES ( SEQ_FB_REPLE_NO.NEXTVAL, ?, ?, ? )";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getNo());
			pstmt.setString(2, vo.getWriter());
			pstmt.setString(3, vo.getContent());
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	
	
	}
	/*
	 * 게시글 수정하기 작업
	 */
	public int editFreeBoardTrade(Connection conn, FreeBoardTradeVo fbvo) {

		int result = 0;
		PreparedStatement pstmt = null;
		
		//SQL 준비
		String sql = "UPDATE FREEBOARD_TRADE SET FB_TITLE=?, FB_CONTENT=? WHERE FB_NO = ?";
		
		try {
			
			//SQL 객체에 담기 && SQL 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, fbvo.getTitle());
			pstmt.setString(2, fbvo.getContent());
			pstmt.setString(3, fbvo.getNo());
			
			//SQL실행 및 결과 저장
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		//실행결과 리턴
		return result;
	}
	
	/*
	 * 중고거래 게시글 삭제하기
	 */
	public int deleteBoardTrade(Connection conn, String num) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "UPDATE FREEBOARD_TRADE SET FB_STATUS = 'Y' WHERE FB_NO = ? ";
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
	/*
	 * 댓글삭제
	 */
	public int deleteRepleBoardTrade(Connection conn, String num) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "UPDATE FB_REPLE SET FBR_STATUS='Y' WHERE FBR_NO=?";
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
	
	/*
	 * 파일 조회
	 */
	public List<FreeBoardAttachmentVo> selectFile(Connection conn, String num) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FreeBoardAttachmentVo> fbavoList = new ArrayList<FreeBoardAttachmentVo>();
		
		try {
			
			String sql = "SELECT FBA_NO ,FBA_REF_NO ,FBA_ORIGIN_NAME ,FBA_CHANGE_NAME ,FBA_FILE_PATH FROM FB_ATTACHMENT WHERE FBA_REF_NO = ? AND FBA_STATUS ='N' ORDER BY FBA_NO";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			//rs -> obj로 바꿔주는 작업 필요
			if(rs.next()) {
				
				
				
				//vo객체에 담아주기
				FreeBoardAttachmentVo fbavo = new FreeBoardAttachmentVo();
				
				
				fbavo.setNo(rs.getString("FBA_NO"));
				fbavo.setRefBno(rs.getString("FBA_REF_NO"));
				fbavo.setOriginName(rs.getString("FBA_ORIGIN_NAME"));
				fbavo.setChangeName(rs.getString("FBA_CHANGE_NAME"));
				fbavo.setFilePath(rs.getString("FBA_FILE_PATH"));
				
				fbavoList.add(fbavo);
				
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		return fbavoList;
		
	}
	/*
	 * 메인파일 조회
	 */
	public FreeBoardAttachmentVo selectMainFile(Connection conn, String no) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FreeBoardAttachmentVo fbavo = null;
		
		try {
			
			String sql = "SELECT FBA_NO ,FBA_REF_NO ,FBA_ORIGIN_NAME ,FBA_CHANGE_NAME ,FBA_FILE_PATH FROM FB_ATTACHMENT WHERE FBA_REF_NO = ? AND FBA_STATUS ='N' ORDER BY FBA_NO";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			//rs -> obj로 바꿔주는 작업 필요
			if(rs.next()) {
				
				
				
				//vo객체에 담아주기
				fbavo = new FreeBoardAttachmentVo();
				
				
				fbavo.setNo(rs.getString("FBA_NO"));
				fbavo.setRefBno(rs.getString("FBA_REF_NO"));
				fbavo.setOriginName(rs.getString("FBA_ORIGIN_NAME"));
				fbavo.setChangeName(rs.getString("FBA_CHANGE_NAME"));
				fbavo.setFilePath(rs.getString("FBA_FILE_PATH"));
				
				
				}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		
		return fbavo;
	
	}

	
}//class
