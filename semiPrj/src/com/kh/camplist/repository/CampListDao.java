package com.kh.camplist.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.camplist.hashtag.vo.HashTagVo;
import com.kh.camplist.campinfo.vo.CampInfoVo;
import com.kh.camplist.theme.vo.ThemeVo;
import com.kh.common.PageVo;

import static com.kh.common.JDBCTemplate.*;

public class CampListDao {
	
	//캠핑장 정보 리스트(카드) 총 갯수
	public int getCount(Connection conn) {

		String sql = "SELECT COUNT(CAMP_CODE) AS COUNT FROM CAMP_INFO WHERE CAMP_STATUS = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int count = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				count = rs.getInt("COUNT");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return count;
	}

	//테마 리스트 조회
	public List<ThemeVo> selectTheme(Connection conn) {
		
		String sql = "SELECT THEME_CODE, THEME_NAME FROM THEME";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ThemeVo> list = new ArrayList<ThemeVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new ThemeVo(
							rs.getString("THEME_CODE"),
							rs.getString("THEME_NAME")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}
	
	//해시태그 리스트 조회
	public List<HashTagVo> selectHashTag(Connection conn) {
		
		String sql = "SELECT HT_CODE, HT_NAME FROM HASHTAG";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HashTagVo> list = new ArrayList<HashTagVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new HashTagVo(
							rs.getString("HT_CODE"),
							rs.getString("HT_NAME")
						));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
	}

	//검색 결과 리스트 조회
	public List<CampInfoVo> searchList(PageVo pageVo, Connection conn, List<String> keywordList, String sido1, String gugun1, String theme,
			List<String> checkedHashCodes) {

		//검색 쿼리
		String sql = "SELECT * FROM ( SELECT ROWNUM AS RNUM, CI.* FROM ((SELECT * FROM CAMP_INFO WHERE CAMP_STATUS = 'Y'";
		
		if(keywordList != null) {
			for(int i=0; i<keywordList.size(); i++) {
					sql += " AND CAMP_NAME LIKE '%" + keywordList.get(i) + "%'";
				}
		}
		if(!sido1.equals("")) {
				sql += " AND CITY = " + "'" + sido1  + "'";
		}
		if(!gugun1.equals("")) {
				sql += " AND DISTRICT = " + "'" +gugun1+ "'";
		}
		if(!theme.equals("")) {
				sql += " AND THEME_CODE = " + theme;
		}
		if(checkedHashCodes != null) {
			for(int i=0; i<checkedHashCodes.size(); i++) {
				sql += " AND CAMP_CODE IN ( SELECT C.CAMP_CODE FROM CAMP_INFO C INNER JOIN HASHTAG_MAPPING HTM ON C.CAMP_CODE = HTM.CAMP_CODE WHERE HTM.HT_CODE = " + checkedHashCodes.get(i) + ")";
			}
		}
		
		sql += ")) CI ) WHERE RNUM BETWEEN ? AND ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CampInfoVo> list = new ArrayList<CampInfoVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			int start = (pageVo.getCurrentPage()-1) * pageVo.getListLimit() + 1;
			int end = start + pageVo.getListLimit() - 1;
			
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				
				String campCode = rs.getString("CAMP_CODE");
				String campName = rs.getString("CAMP_NAME");
				String campIntro = rs.getString("CAMP_INTRO");
				String campImgpath = rs.getString("CAMP_IMGPATH");
				
				CampInfoVo vo = new CampInfoVo();
				vo.setCampCode(campCode);
				vo.setCampName(campName);
				vo.setCampIntro(campIntro);
				vo.setCampImgpath(campImgpath);
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return list;
		
	}
	
	


	

	
	
	
	
	
}
