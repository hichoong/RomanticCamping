package com.kh.campzonelist.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.camplist.campinfo.vo.CampInfoVo;
import com.kh.campzonelist.campzone.vo.CampZoneVo;
import static com.kh.common.JDBCTemplate.*;

public class CampZoneListDao {

	//구역상세 리스트 조회
	public List<CampZoneVo> selectList(Connection conn, String campCode) {
		
		String sql = "SELECT Z_NO, Z_STAYMAX, Z_PRICE, Z_NAME, Z_NOR, CAMP_CODE, Z_IMGPATH FROM CAMP_ZONE WHERE CAMP_CODE = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<CampZoneVo> list = new ArrayList<CampZoneVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, campCode);
			
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				String zoneNo = rs.getString("Z_NO");
				String zoneStayMax = rs.getString("Z_STAYMAX");
				String zonePrice = rs.getString("Z_PRICE");
				String zoneName = rs.getString("Z_NAME");
				String zoneNor = rs.getString("Z_NOR");
				String zCampCode = rs.getString("CAMP_CODE");
				String zoneImgPath = rs.getString("Z_IMGPATH");
				
				CampZoneVo vo = new CampZoneVo();
				vo.setZoneNo(zoneNo);
				vo.setZoneStayMax(zoneStayMax);
				vo.setZonePrice(zonePrice);
				vo.setZoneName(zoneName);
				vo.setZoneNor(zoneNor);
				vo.setCampCode(zCampCode);
				vo.setZoneImgPath(zoneImgPath);
				
				list.add(vo);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}

		return list;
		
	}

	public CampInfoVo campSelect(Connection conn, String campCode) {
		
		String sql = "SELECT CAMP_CODE, CAMP_NAME, CITY, DISTRICT, CAMP_ADDRESS, CAMP_INTRO, CAMP_IMGPATH FROM CAMP_INFO WHERE CAMP_CODE = ? AND CAMP_STATUS = 'Y'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CampInfoVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, campCode);

			rs = pstmt.executeQuery();

			if(rs.next()) {
				String campCodez = rs.getString("CAMP_CODE");
				String campName = rs.getString("CAMP_NAME");
				String city = rs.getString("CITY");
				String district = rs.getString("DISTRICT");
				String address = rs.getString("CAMP_ADDRESS");
				String campIntro = rs.getString("CAMP_INTRO");
				String campImgpath = rs.getString("CAMP_IMGPATH");

				vo = new CampInfoVo();
				vo.setCampCode(campCodez);
				vo.setCampName(campName);
				vo.setCity(city);
				vo.setDistrict(district);
				vo.setCampAddress(address);
				vo.setCampIntro(campIntro);
				vo.setCampImgpath(campImgpath);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return vo;
	}
	
	
	
	
	
	
	
}
