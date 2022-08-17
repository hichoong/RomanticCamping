package com.kh.freeboard.service;

import java.sql.Connection;
import java.util.List;
import java.util.UUID;

import static com.kh.common.JDBCTemplate.*;

import com.kh.common.PageVo;
import com.kh.freeboard.attachment.vo.FreeBoardAttachmentVo;
import com.kh.freeboard.repository.FreeBoardTradeDao;
import com.kh.freeboard.vo.FreeBoardTradeVo;
import com.kh.freeboard.vo.FreeBoardVo;

public class FreeBoardTradeService {

	FreeBoardTradeDao dao = new FreeBoardTradeDao();
	
	/*
	 * 원본 파일명을 중복되지 않는 의미있는 이름으로 바꿔주기
	 */
	public String createChangeName(String originName) {

		int dot = originName.lastIndexOf(".");
		String ext = originName.substring(dot);
		
		//현재시간이 밀리세컨드 단위까지 나온다.
		long now = System.currentTimeMillis();
		//랜덤숫자 
		String random = UUID.randomUUID().toString();
		random = random.substring(0,8);
		
		String changeName = "FreeB_" + now + "_" + random + ext;
		
		
		return changeName;
	}

	/*
	 * 게시글 작성 - 일단은 중고거래게시판에
	 */
	public int insertBoard(FreeBoardTradeVo fvo, FreeBoardAttachmentVo fbavo) {

		int result = 0;
		Connection conn = getConnection();
		
		//데이터 검사
		if(fvo.getTitle().length() < 1) {
			// 실패처리. 다음단계 진행 X
			return -1;
		}
		
		if(fvo.getContent().length() <1 ) {
			// 실패처리. 다음단계 진행 X
			return -2;
		}
		
		//DAO 호출
		int result1 = dao.insertBoard(conn, fvo);
		
		//파일첨부가 안되어서 인서트 작업 안되더라도 보더에는 인서트된걸로 처리되어야하므로 기본값 1로!
		int result2 = 1;
		if(fbavo != null) {
			result2 = dao.insertAttachment(conn, fbavo);
		}
		
		
		//트랜잭션 처리
		if(result1 * result2 == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		
		close(conn);
		
		return result * result2;
		
	}
	
	
	/*
	 * 중고거래 게시판 총 글 수
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
	 * 중고거래 게시판 리시트 조회 (페이징처리)
	 */
	public List<FreeBoardTradeVo> selecList(PageVo fbpageVo) {

		Connection conn = getConnection();
		
		List<FreeBoardTradeVo> fbvoList = null;
		
		//dao 호출
		fbvoList = dao.selectList(conn, fbpageVo);
		
		close(conn);
		

		
		return fbvoList;
	
	}
	
	/*
	 * 중고거래 게시판 인기글 가져오기
	 */
	public List<FreeBoardTradeVo> selectMainList() {

		Connection conn = getConnection();
		
		List<FreeBoardTradeVo> fbMainList = null;
		
		fbMainList = dao.selectMainList(conn);
		
		close(conn);
		
		return fbMainList;
	}

	
	
	
	
	
	
}//class
