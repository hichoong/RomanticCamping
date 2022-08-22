package com.kh.review.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;

import com.kh.camplist.campinfo.vo.CampInfoVo;
import com.kh.review.repository.ReviewDao;
import com.kh.review.vo.ReviewVo;

public class ReviewService {
	
	private final ReviewDao dao = new ReviewDao();
	
	//리뷰 조회
	public ReviewVo selectOne(String num) {
		Connection conn = getConnection();
		ReviewVo vo = new ReviewDao().selectOne(conn, num);
		close(conn);
		return vo;
	}

	//리뷰 작성
	public int reviewInsert(ReviewVo vo) {
		
		if(vo.getStarScore().equals("") || vo.getStarScore() == null) {
			return-1;
		}
		
		if(vo.getReviewContent().length() < 1) {
			return-2;
		}
		
		Connection conn = getConnection();
		int result = dao.reviewInsert(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}
	
	//리뷰 수정
	public int edit(ReviewVo vo) {
		
		if(vo.getReviewContent().length() < 1) {
			return-2;
		}
		
		Connection conn = getConnection();
		int result = dao.edit(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

	//리뷰 삭제
	public int delete(String num) {
		
		Connection conn = getConnection();
		int result = dao.delete(conn,num);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		close(conn);
		
		return result;
	}

//	public CampInfoVo campSelect(String reservationNo) {
//		Connection conn = getConnection();
//		CampInfoVo vo = new ReviewDao().campSelect(conn, reservationNo);
//		close(conn);
//		return vo;
//	}

	//캠핑장 정보 조회

	
	
	

}
