package com.sjy.buisness.camp.repository;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sjy.buisness.camp.vo.BsCampVo;
import com.sjy.buisness.camp.vo.BsCampZoneVo;

public class BsCampDao {

	/*
	 * 캠핑장 정보 저장
	 */
	public int campInsert(Connection conn, BsCampVo campVo) {
		
		//SQL 준비
		String sql = "INSERT INTO CAMP_INFO (CAMP_CODE, CAMP_NAME, CITY, DISTRICT, CAMP_ADDRESS, CAMP_PHONE, CAMP_INTRO, CAMP_REFUND, CAMP_IMGPATH, THEME_CODE) VALUES (SEQ_CAMP_INFO_CODE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//SQL 객체 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, campVo.getCampName());
			pstmt.setString(2, campVo.getCity());
			pstmt.setString(3, campVo.getDistrict());
			pstmt.setString(4, campVo.getCampAddress());
			pstmt.setString(5, campVo.getCampPhone());
			pstmt.setString(6, campVo.getCampIntro());
			pstmt.setString(7, campVo.getCampRefund());
			pstmt.setString(8, campVo.getCampImgPath());//이미지는 업로드된파일에서 
			pstmt.setString(9, campVo.getTheme());
			
			//SQL 실행 및 결과 저장
			result =  pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		//결과리턴
		return result;
	}

	/*
	 * 캠핑장구역정보 저장
	 */
	public int campZoneInsert(Connection conn, BsCampZoneVo zoneVo) {
		
		//SQL 준비
		String sql = "";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//SQL 객체 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			
			
			//SQL 실행 및 결과 저장
			result =  pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		//결과리턴
		return result;
	}

}
