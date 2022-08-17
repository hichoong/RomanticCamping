package com.kh.freeboard.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;

import com.kh.common.PageVo;
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
	
	/*
	 * 중고거래 게시판 총 글 수 
	 */
	public int getCount(Connection conn) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//일반게시판은 타입1 / 사진게시판은 타입2 
			String sql = "SELECT COUNT(NO) AS COUNT FROM BOARD WHERE STATUS='N' AND TYPE=20";
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
		
		
		String sql = "SELECT * FROM ( SELECT ROWNUM RUNM, T.* FROM ( SELECT B.NO ,B.TITLE ,B.CONTENT ,B.CNT ,B.ENROLL_DATE ,M.ID AS WRITER ,C.CATEGORY_NAME AS CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON B.WRITER = M.NO JOIN CATEGORY C USING(CATEGORY_NO) WHERE B.TYPE=1 AND B.STATUS='N' ORDER BY B.NO DESC ) T ) WHERE RUNM BETWEEN ? AND ?";
		
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
				
				fbvo.setNo(rs.getString("NO"));
				fbvo.setTitle(rs.getString("TITLE"));
				fbvo.setContent(rs.getString("CONTENT"));
				fbvo.setWriter(rs.getString("WRITER"));
				fbvo.setCnt(rs.getString("CNT"));
				fbvo.setEnrollDate(rs.getString("ENROLL_DATE"));
				fbvo.setStatus(rs.getString("STATUS"));
				
				
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
		String sql = "SELECT N.NO, N.TITLE, N.CONTENT, N.CNT, TO_CHAR(N.ENROLL_DATE, 'YY/MM/DD HH:MI') AS ENROLL_DATE, N.STATUS, M.NAME AS WRITER FROM NOTICE N JOIN MEMBER M ON N.WRITER = M.NO WHERE N.STATUS = 'N' ORDER BY CNT DESC 6개가져오기";
		
		try {

			//SQL 객체에 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			
			//SQL 실행
			rs = pstmt.executeQuery();
			
			//결과 변환 // ResultSet -> 자바객체(NoticeVo)
			while(rs.next()) {
				String no = rs.getString("NO");
				String title = rs.getString("TITLE");
				String content = rs.getString("CONTENT");
				String writer = rs.getString("WRITER");
				String cnt = rs.getString("CNT");
				String enrollDate = rs.getString("ENROLL_DATE");
				String status = rs.getString("STATUS");
				
				FreeBoardTradeVo vo = new FreeBoardTradeVo();
				
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setCnt(cnt);
				vo.setEnrollDate(enrollDate);
				vo.setStatus(status);
				
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

	
}
