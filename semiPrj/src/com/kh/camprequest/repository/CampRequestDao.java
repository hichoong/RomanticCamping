package com.kh.camprequest.repository;

import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.sjy.buisness.camp.vo.BsCampVo;
import com.syl.board.vo.QuestionBoardVo;

public class CampRequestDao {

	//캠핑장 등록 요청 목록
	public ArrayList<BsCampVo> selectList(Connection conn){
		
		String sql = "SELECT * FROM  CAMP_INFO WHERE CAMP_STATUS = 'W'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<BsCampVo> list = new ArrayList<BsCampVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String campCode = rs.getString("CAMP_CODE");
				String campName = rs.getString("CAMP_NAME");
				String campAddress = rs.getString("CAMP_ADDRESS");
				String campPhone = rs.getString("CAMP_PHONE");
				String campIntro = rs.getString("CAMP_INTRO");
				String campImgpath = rs.getString("CAMP_IMGPATH");
				
				BsCampVo vo = new BsCampVo();
				vo.setCampCode(campCode);
				vo.setCampName(campName);
				vo.setCampAddress(campAddress);
				vo.setCampPhone(campPhone);
				vo.setCampIntro(campIntro);
				vo.setCampImgPath(campImgpath);
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
			close(pstmt);
			close(rs);
		}	
		return list;
	}
	
	// 캠핑장 등록 요청 상세조회
	public BsCampVo selectOne(Connection conn, String num) {
		
		PreparedStatement pstmt =  null;
		ResultSet rs = null;
		BsCampVo vo = null;
		
		String sql = "SELECT * FROM CAMP_INFO  WHERE CAMP_STATUS = 'W' AND CAMP_CODE = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				String campCode = rs.getString("CAMP_CODE");
				String campName = rs.getString("CAMP_NAME");
				String city = rs.getString("CITY");
				String district = rs.getString("DISTRICT");
				String campAddress = rs.getString("CAMP_ADDRESS");
				String campPhone = rs.getString("CAMP_PHONE");
				String campIntro = rs.getString("CAMP_INTRO");
				String rgDate = rs.getString("RG_DATE");
				String campRefund = rs.getString("CAMP_REFUND");
//				String campImgpath = rs.getString("CAMP_IMGPATH");
				String themeCode = rs.getString("THEME_CODE");
//				String campUpdated = rs.getString("CAMP_UPDATED");
				
				vo = new BsCampVo();
				vo.setCampCode(campCode);
				vo.setCampName(campName);
				vo.setCity(city);
				vo.setDistrict(district);
				vo.setCampAddress(campAddress);
				vo.setCampPhone(campPhone);
				vo.setCampIntro(campIntro);
				vo.setRgDate(rgDate);
				vo.setCampRefund(campRefund);
//				vo.setCampImgPath(campImgpath);
				vo.setTheme(themeCode);
//				vo.setCampUpdated(campUpdated);
				
			}

		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(rs);
			close(pstmt);
		}
		
		return vo;
	}
	
	// 캠핑장 등록 요청 _ 승낙
	public int consent (Connection conn, String num) {
	
		String sql = "UPDATE CAMP_INFO SET CAMP_STATUS = 'Y' WHERE CAMP_CODE = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, num);
			
			result = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
	
	return result;
	}
	
	// 캠핑장 등록 요청 _ 거절
	public int reject (Connection conn, String num) {
		
		String sql = "UPDATE CAMP_INFO SET CAMP_STATUS = 'N' WHERE CAMP_CODE = ?";
			
		PreparedStatement pstmt = null;
		int result = 0;
			
		try {
			pstmt = conn.prepareStatement(sql);
				
			pstmt.setString(1, num);
				
			result = pstmt.executeUpdate();
				
		} catch (SQLException e) {
				e.printStackTrace();
		}finally {
				close(pstmt);
		}
			
		return result;
	}
	
	
}//class
