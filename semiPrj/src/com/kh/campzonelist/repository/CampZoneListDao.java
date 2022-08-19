package com.kh.campzonelist.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.campzonelist.campzone.vo.CampZoneVo;
import static com.kh.common.JDBCTemplate.*;

public class CampZoneListDao {

	//구역상세 리스트 조회
	public List<CampZoneVo> selectList(Connection conn, String num) {
		
		String sql = "SELECT Z_NO, Z_STAYMAX, Z_PRICE, Z_NAME, Z_NOR, CAMP_CODE FROM CAMP_ZONE WHERER CAMP_CODE = ?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<CampZoneVo> list = new ArrayList<CampZoneVo>();
		
		try {
			//SQL 객체에 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, num);
			
			//SQL 실행
			rs = pstmt.executeQuery();
			
			//결과 변환 //ResultSet -> 자바객체(NoticeVo)
			while (rs.next()) {
				String zoneNo = rs.getString("Z_NO");
				String zoneStayMax = rs.getString("Z_STAYMAX");
				String zonePrice = rs.getString("Z_PRICE");
				String zoneName = rs.getString("Z_NAME");
				String zoneNor = rs.getString("Z_NOR");
				String campCode = rs.getString("CAMP_CODE");
				
				CampZoneVo vo = new CampZoneVo();
				vo.setZoneNo(zoneNo);
				vo.setZoneStayMax(zoneStayMax);
				vo.setZonePrice(zonePrice);
				vo.setZoneName(zoneName);
				vo.setZoneNor(zoneNor);
				vo.setCampCode(campCode);
				
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
	
	
	
	
	
	
	
}
