package com.kh.member.repository;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.camplist.campinfo.vo.CampInfoVo;

public class MemberFavoriteDao {
	

	public List<CampInfoVo> getFavorite(Connection conn, String no) {
		
		String sql = "SELECT C.CAMP_CODE, C.CAMP_NAME, C.CAMP_PHONE, C.CAMP_ADDRESS, C.CAMP_INTRO, C.CAMP_IMGPATH FROM CAMP_INFO C JOIN FAVORITE F ON C.CAMP_CODE = F.CAMP_CODE WHERE USER_NO = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<CampInfoVo> list = new ArrayList<CampInfoVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				CampInfoVo vo = new CampInfoVo();
				
				vo.setCampCode(rs.getString("CAMP_CODE"));
				vo.setCampName(rs.getString("CAMP_NAME"));
				vo.setCampPhone(rs.getString("CAMP_PHONE"));
				vo.setCampAddress(rs.getString("CAMP_ADDRESS"));
				vo.setCampIntro(rs.getString("CAMP_INTRO"));
				vo.setCampImgpath(rs.getString("CAMP_IMGPATH"));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}

	public int deleteFavorite(Connection conn, String campCode, String no) {

		String sql = "DELETE FAVORITE WHERE CAMP_CODE = ? AND USER_NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, campCode);
			pstmt.setString(2, no);
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int setFavorite(Connection conn, String campCode, String no) {

		String sql = "INSERT INTO FAVORITE (USER_NO, CAMP_CODE) VALUES(?, ?)";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, campCode);
			
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int checkFavorite(Connection conn, String campCode, String no) {

		String sql = "SELECT COUNT(*) CNT FROM FAVORITE WHERE USER_NO = ? AND CAMP_CODE = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int cnt = 0;
		
		try {

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, campCode);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				cnt = rs.getInt("CNT");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return cnt;
	}

}
