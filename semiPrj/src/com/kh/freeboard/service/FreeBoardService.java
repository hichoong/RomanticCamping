package com.kh.freeboard.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.common.PageVo;
import com.kh.freeboard.repository.FreeBoardDao;
import com.kh.freeboard.vo.FreeBoardRepleVo;
import com.kh.freeboard.vo.FreeBoardTradeRepleVo;
import com.kh.freeboard.vo.FreeBoardVo;

public class FreeBoardService {

	FreeBoardDao dao = new FreeBoardDao();
	
	
	/*
	 * 자유게시판 게시글 작성 
	 */
	public int insertBoard(FreeBoardVo vo) {
		
		//선언먼저~
		Connection conn = getConnection();
		
		int result  = dao.insertBoard(conn, vo);
		
		if(result ==1 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
			
		close(conn);
		
		//결과 리턴 
		return result;
		
	}

	/*
	 * 자유게시판 리스트 조회 (페이징처리)
	 */
	public List<FreeBoardVo> selectList(PageVo fpageVo) {
		
		Connection conn = getConnection();
		
		List<FreeBoardVo> fvoList = null;
				
		fvoList = dao.selectList(conn, fpageVo);
			
		close(conn);
		
		//실행 결과 리턴
		return fvoList;
		
	}
	
	/*
	 * 자유게시판 총 글 수
	 */
	public int getCount() {
		
		int result = 0;
		Connection conn = getConnection();
		
		try {
			
			//select 쿼리이지만 count작업으로 int리턴됨.(셀렉트 이므로 커밋롤백필요없다.)
			result = dao.getCount(conn);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(conn);
		}
		
		return result;
	}

	/*
	 * 자유게시판 메인 인기글 가져오기
	 */
	public List<FreeBoardVo> selectMainList() {
		Connection conn = getConnection();
		
		List<FreeBoardVo> fMainList = dao.selectMainList(conn);
		
		close(conn);
		
		return fMainList;
	}
	
	/*
	 * 특정 게시글 조회 수 증가
	 */
	public int increaseNotice(String num) {
		
		Connection conn = getConnection();
		
		int result = dao.increaseFreeBoard(conn, num);

		if(result==1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
	}
	
	/*
	 * 상세페이지 보여줄 특정 게시글 조회
	 */
	public FreeBoardVo selectOne(String num) {

		Connection conn = getConnection();
		
		FreeBoardVo fvo = null;
		fvo = dao.selectFreeBoard(conn, num); 
		
		close(conn);		
		
		return fvo;		
				
	}
	/*
	 * 댓글 리스트 가져오기
	 */
	public List selectReple(String num) {
	
		Connection conn = getConnection();
		
		List<FreeBoardRepleVo> frvoList = null;
				
		frvoList = dao.selectReple(conn, num);
			
		close(conn);
		
		//실행 결과 리턴
		return frvoList;
	}

	/*
	 * 댓글테이블에 입력해주기
	 */
	public int insertRepleBoard(FreeBoardRepleVo vo) {

		//선언먼저~
		Connection conn = getConnection();
		
		int result  = dao.insertRepleBoard(conn, vo);
		
		if(result ==1 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
			
		close(conn);
		
		//결과 리턴 
		return result;
	}
	
	/*
	 *  게시글 수정하기 작업 ( update ) 
	 */
	public int editFreeBoard(FreeBoardVo fvo) {
		
		//데이터 검사
		if(fvo.getTitle().length() < 1) {
			return -1;
		}
		
		if(fvo.getContent().length() < 1) {
			return -2;
		}
		
		
		Connection conn = getConnection();
		
		int result = dao.editFreeBoard(conn, fvo);
		
		if(result == 1 ) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		
		return result;
	
	}
	/*
	 * 게시판 글 삭제
	 */
	public int deleteBoard(String num) {

		Connection conn = getConnection();
		
		int result = dao.deleteBoard(conn, num);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	/*
	 * 댓글 삭제
	 */
	public int deleteRepleBoard(String num) {

		Connection conn = getConnection();
		
		int result = dao.deleteRepleBoard(conn, num);
		
		if(result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
		
		
	
	}
	
	

	
	
}//class
