package com.kh.member.service;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

import com.kh.camplist.campinfo.vo.CampInfoVo;
import com.kh.member.repository.MemberFavoriteDao;

public class MemberFavoriteService {

	MemberFavoriteDao dao = new MemberFavoriteDao();
	
	public List<CampInfoVo> getFavorite(String no) {
		
		Connection conn = getConnection();
		List<CampInfoVo> list = dao.getFavorite(conn, no);
		
		close(conn);
		
		return list;
	}

	public int deleteFavorite(String campCode, String no) {

		Connection conn = getConnection();
		int result = dao.deleteFavorite(conn, campCode, no);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int setFavorite(String campCode, String no) {
		
		Connection conn = getConnection();
		int result = dao.setFavorite(conn, campCode, no);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}
	
	public int checkFavorite(String campCode, String no) {
		
		Connection conn = getConnection();
		int result = dao.checkFavorite(conn, campCode, no);
		
		close(conn);
		
		return result;
	}
	
}
