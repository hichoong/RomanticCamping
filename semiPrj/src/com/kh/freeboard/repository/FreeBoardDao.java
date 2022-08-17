package com.kh.freeboard.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;

import com.kh.common.PageVo;
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
	
	
	/*
	 * 자유게시판 글 조회
	 */
	public List<FreeBoardVo> selectList(Connection conn, PageVo fpageVo) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FreeBoardVo> fvoList = new ArrayList<FreeBoardVo>();
		
		//SQL 준비
		String sql = "SELECT * FROM ( SELECT ROWNUM RUNM, T.* FROM ( SELECT B.NO ,B.TITLE ,B.CONTENT ,B.CNT ,B.ENROLL_DATE ,M.ID AS WRITER ,C.CATEGORY_NAME AS CATEGORY_NAME FROM BOARD B JOIN MEMBER M ON B.WRITER = M.NO JOIN CATEGORY C USING(CATEGORY_NO) WHERE B.TYPE=1 AND B.STATUS='N' ORDER BY B.NO DESC ) T ) WHERE RUNM BETWEEN ? AND ?";
		
		try {

			//SQL 객체에 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			
			int start = (fpageVo.getCurrentPage()-1)*fpageVo.getListLimit() +1;
			int end = start + fpageVo.getListLimit() -1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			
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
				
				FreeBoardVo vo = new FreeBoardVo();
				
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setCnt(cnt);
				vo.setEnrollDate(enrollDate);
				vo.setStatus(status);
				
				//실행될 때마다 voList에 vo하나씩 담아주기
				fvoList.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		//결과 리턴
		return fvoList;
	}

	/*
	 * 자유게시판 총 글 수
	 */
	public int getCount(Connection conn) {

		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			//일반게시판은 타입1 / 사진게시판은 타입2 
			String sql = "SELECT COUNT(NO) AS COUNT FROM BOARD WHERE STATUS='N' AND TYPE=1";
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
	 * 자유게시판 메인 인기글
	 */
	public List<FreeBoardVo> selectMainList(Connection conn) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FreeBoardVo> fMainList = new ArrayList<FreeBoardVo>();
		
		//SQL 준비
		String sql = "SELECT N.NO, N.TITLE, N.CONTENT, N.CNT, TO_CHAR(N.ENROLL_DATE, 'YY/MM/DD HH:MI') AS ENROLL_DATE, N.STATUS, M.NAME AS WRITER FROM NOTICE N JOIN MEMBER M ON N.WRITER = M.NO WHERE N.STATUS = 'N' ORDER BY CNT DESC 4개만";
		
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
				
				FreeBoardVo vo = new FreeBoardVo();
				
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setCnt(cnt);
				vo.setEnrollDate(enrollDate);
				vo.setStatus(status);
				
				//실행될 때마다 voList에 vo하나씩 담아주기
				fMainList.add(vo);
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		
		//결과 리턴
		return fMainList;
	}

	
	/*
	 * 조회 수 증가
	 */
	public int increaseFreeBoard(Connection conn, String num) {
		
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			
			String sql = "UPDATE FREEBOARD SET CNT = CNT+1 WHERE NO=? AND STATUS ='N'";
			
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
	 * 상세페이지 보여줄 특정 게시글 조회
	 */
	public FreeBoardVo F_selectOne(Connection conn, String num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FreeBoardVo fvo = null;
		
		try {
			
			String sql = "SELECT N.NO, N.TITLE, N.CONTENT, M.NAME AS WRITER, N.CNT, N.ENROLL_DATE, N.STATUS FROM NOTICE N JOIN MEMBER M ON N.WRITER = M.NO WHERE N.NO = ? AND N.STATUS ='N'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			//rs -> obj로 바꿔주는 작업 필요
			if(rs.next()) {
				
				//vo객체에 담아주기
				fvo = new FreeBoardVo();
				
				fvo.setNo(rs.getString("NO"));
				fvo.setTitle(rs.getString("TITLE"));
				fvo.setContent(rs.getString("CONTENT"));
				fvo.setWriter(rs.getString("WRITER"));
				fvo.setCnt(rs.getString("CNT"));
				fvo.setEnrollDate(rs.getString("ENROLL_DATE"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return fvo;
	}

}
