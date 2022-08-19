package com.kh.camplist.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.kh.camplist.campinfo.vo.CampInfoVo;
import com.kh.camplist.hashtag.vo.HashTagVo;
import com.kh.camplist.repository.CampListDao;
import com.kh.camplist.theme.vo.ThemeVo;
import com.kh.common.PageVo;

import static com.kh.common.JDBCTemplate.*;

public class CampListService {

	private final CampListDao dao = new CampListDao();
	
	//캠핑장 정보 리스트(카드) 총 갯수
	public int getCount() {
		Connection conn = getConnection();
		int result = dao.getCount(conn);
		close(conn);
		return result;
	}

	//현재 페이지에 보여질 캠핑장 리스트 조회
	public List<CampInfoVo> selectList(PageVo pageVo) {
		Connection conn = getConnection();
		List<CampInfoVo> voList = dao.selectList(conn, pageVo);
		close(conn);
		return voList;
	}
	
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

	//검색 결과 리스트 조회
	public List<CampInfoVo> searchList(String keyword, String sido1, String gugun1, String theme,
			List<String> checkedHashCodes) {

		
		List<String> keywordList = null;
		if(!keyword.equals("") && keyword.contains(" ")) {
			String[] keywords = keyword.split(" ");
			keywordList = Arrays.asList(keywords);
		} else if(!keyword.equals("")) {
			keywordList = new ArrayList<String>();
			keywordList.add(keyword);
		} else {
			keywordList = new ArrayList<String>();
		}
		
		Connection conn = getConnection();
		List<CampInfoVo> list = dao.searchList(conn, keywordList, sido1, gugun1, theme, checkedHashCodes);
		close(conn);
		System.out.println("서비스 잘 됨");
		return list;
	}

	
	
	
	
}
