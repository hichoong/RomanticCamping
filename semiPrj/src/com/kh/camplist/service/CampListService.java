package com.kh.camplist.service;

import java.sql.Connection;
import java.util.List;

import com.kh.camplist.campinfo.vo.CampInfoVo;
import com.kh.camplist.hashtag.vo.HashTagVo;
import com.kh.camplist.repository.CampListDao;
import com.kh.camplist.theme.vo.ThemeVo;
import com.kh.common.PageVo;

import static com.kh.common.JDBCTemplate.*;

public class CampListService {

	private final CampListDao dao = new CampListDao();
	
	//테마 리스트 조회
	public List<ThemeVo> selectTheme() {
		Connection conn = getConnection();
		List<ThemeVo> list = dao.selectTheme(conn);
		close(conn);
		return list;
	}
	
	//해시태그 리스트 조회
	public List<HashTagVo> selectHashTag() {
		Connection conn = getConnection();
		List<HashTagVo> list = dao.selectHashTag(conn);
		close(conn);
		return list;
	}

//	//캠핑장 정보 리스트(카드) 총 갯수
//	public int getCount() {
//		Connection conn = getConnection();
//		int result = dao.getCount(conn);
//		close(conn);
//		return result;
//	}
//
//	//현재 페이지에 보여질 캠핑장 리스트 조회
//	public List<CampInfoVo> selectList(PageVo pageVo) {
//		Connection conn = getConnection();
//		List<CampInfoVo> voList = dao.selectList(conn, pageVo);
//		close(conn);
//		return voList;
//	}
	
	
	
}
