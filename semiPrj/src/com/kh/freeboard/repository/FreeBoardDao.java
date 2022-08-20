package com.kh.freeboard.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;

import com.kh.common.PageVo;
import com.kh.freeboard.vo.FreeBoardRepleVo;
import com.kh.freeboard.vo.FreeBoardVo;

public class FreeBoardDao {

	/*
	 * 자유게시판 글 작성
	 */
	public int insertBoard(Connection conn, FreeBoardVo vo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			String sql = "INSERT INTO FREEBOARD ( F_NO, F_TITLE, F_CONTENT, F_WRITER ) VALUES ( SEQ_FREEBOARD_NO.NEXTVAL, ?, ?, ? )";
			
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
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.F_NO ,B.F_TITLE ,B.F_CONTENT ,B.F_CNT ,B.F_ENROLL_DATE ,M.ID AS F_WRITER FROM FREEBOARD B JOIN MEMBER M ON B.F_WRITER = M.NO WHERE B.F_STATUS='N' ORDER BY B.F_NO DESC ) T ) WHERE RNUM BETWEEN ? AND ?";
		
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
				String no = rs.getString("F_NO");
				String title = rs.getString("F_TITLE");
				String content = rs.getString("F_CONTENT");
				String writer = rs.getString("F_WRITER");
				String cnt = rs.getString("F_CNT");
				String enrollDate = rs.getString("F_ENROLL_DATE");
				
				FreeBoardVo vo = new FreeBoardVo();
				
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setCnt(cnt);
				vo.setEnrollDate(enrollDate);
				
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
			String sql = "SELECT COUNT(F_NO) AS COUNT FROM FREEBOARD WHERE F_STATUS='N'";
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
		String sql = "SELECT * FROM ( SELECT ROWNUM RNUM, T.* FROM ( SELECT B.F_NO ,B.F_TITLE ,B.F_CONTENT ,B.F_CNT ,B.F_ENROLL_DATE ,M.ID AS F_WRITER FROM FREEBOARD B JOIN MEMBER M ON B.F_WRITER = M.NO WHERE B.F_STATUS='N' ORDER BY B.F_CNT DESC ) T ) WHERE RNUM BETWEEN 1 AND 4";
		
		try {

			//SQL 객체에 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			
			//SQL 실행
			rs = pstmt.executeQuery();
			
			//결과 변환 // ResultSet -> 자바객체(NoticeVo)
			while(rs.next()) {
				String no = rs.getString("F_NO");
				String title = rs.getString("F_TITLE");
				String content = rs.getString("F_CONTENT");
				String writer = rs.getString("F_WRITER");
				String cnt = rs.getString("F_CNT");
				String enrollDate = rs.getString("F_ENROLL_DATE");
				
				FreeBoardVo vo = new FreeBoardVo();
				
				vo.setNo(no);
				vo.setTitle(title);
				vo.setContent(content);
				vo.setWriter(writer);
				vo.setCnt(cnt);
				vo.setEnrollDate(enrollDate);
				
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
			
			String sql = "UPDATE FREEBOARD SET F_CNT = F_CNT+1 WHERE F_NO=? AND F_STATUS ='N'";
			
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
	public FreeBoardVo selectFreeBoard(Connection conn, String num) {
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		FreeBoardVo fvo = null;
		
		try {
			
			String sql = "SELECT B.F_NO, B.F_TITLE, B.F_CONTENT, M.NAME AS F_WRITER, B.F_CNT, B.F_ENROLL_DATE, B.F_STATUS FROM FREEBOARD B JOIN MEMBER M ON B.F_WRITER = M.NO WHERE B.F_NO = ? AND B.F_STATUS ='N'";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			//rs -> obj로 바꿔주는 작업 필요
			if(rs.next()) {
				
				//vo객체에 담아주기
				fvo = new FreeBoardVo();
				
				fvo.setNo(rs.getString("F_NO"));
				fvo.setTitle(rs.getString("F_TITLE"));
				fvo.setContent(rs.getString("F_CONTENT"));
				fvo.setWriter(rs.getString("F_WRITER"));
				fvo.setCnt(rs.getString("F_CNT"));
				fvo.setEnrollDate(rs.getString("F_ENROLL_DATE"));
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return fvo;
	}

	/*
	 * 댓글 리스트 가져오기
	 */
	public List selectReple(Connection conn, String num) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<FreeBoardRepleVo> frvoList = new ArrayList<FreeBoardRepleVo>();
		
		try {
			
			String sql = "SELECT FR_NO, FR_REF_NO, FR_WRITER, FR_CONTENT, FR_ENROLL_DATE FROM F_REPLE, FREEBOARD WHERE ? = FREEBOARD.F_NO";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			
			//rs -> obj로 바꿔주는 작업 필요
			if(rs.next()) {
				
				FreeBoardRepleVo frvo = new FreeBoardRepleVo();
				
				//vo객체에 담아주기
				frvo.setNo(rs.getString("FR_NO"));
				frvo.setWriter(rs.getString("FR_WRITER"));
				frvo.setContent(rs.getString("FR_CONTENT"));
				frvo.setEnrollDate(rs.getString("FR_ENROLL_DATE"));
				
				frvoList.add(frvo);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		
		return frvoList;
	
	}

	/*
	 * 댓글 insert 작업 
	 */
	public int insertRepleBoard(Connection conn, FreeBoardRepleVo vo) {
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			String sql = "INSERT INTO F_REPLE ( FR_NO, FR_REF_NO, FR_WRITER, FR_CONTENT ) VALUES ( SEQ_F_REPLE_NO.NEXTVAL, ?, ?, ? )";
			
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

}
