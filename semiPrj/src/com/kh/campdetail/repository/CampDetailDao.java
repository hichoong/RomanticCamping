package com.kh.campdetail.repository;

import static com.kh.common.JDBCTemplate.close;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.kh.campdetail.vo.CampDetailVo;
import com.sjy.buisness.camp.vo.CampAttachmentVo;

public class CampDetailDao {

	/*
	 * 캠핑장 번호와 구역번호로 화면 구성에 필요한 정보(객체로) 얻어오기 
	 */
	public CampDetailVo selectCampZone(Connection conn, String campCode, String zoneNo) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CampDetailVo campVo = null;
		
		String sql = "SELECT CI.CAMP_CODE CODE ,CI.CAMP_NAME NAME ,CI.CITY CITY ,CI.DISTRICT DISTRICT ,CI.CAMP_ADDRESS ADDRESS ,CI.CAMP_PHONE PHONE ,CI.CAMP_INTRO INTRO ,CI.RG_DATE RG_DATE ,CI.CAMP_REFUND REFUND ,CI.CAMP_IMGPATH IMGPATH ,T.THEME_NAME THEME_CODE ,CJ.Z_NO SECTION_NO ,CJ.Z_STAYMAX STAYMAX ,CJ.Z_PRICE PRICE ,CJ.Z_NAME Z_NAME ,CJ.Z_NOR Z_NOR FROM CAMP_INFO CI JOIN CAMP_ZONE CJ ON CI.CAMP_CODE=? AND CJ.Z_NO=? JOIN THEME T ON CI.THEME_CODE=T.THEME_CODE";
		
		
		try{
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, campCode);
		pstmt.setString(2, zoneNo);
		
		rs = pstmt.executeQuery();
		
		//rs -> obj로 바꿔주는 작업 필요
		if(rs.next()) {
			
			//vo객체에 담아주기
			campVo = new CampDetailVo();
			
			campVo.setCode(rs.getString("CODE"));
			campVo.setName(rs.getString("NAME"));
			campVo.setCity(rs.getString("CITY"));
			campVo.setDistrict(rs.getString("DISTRICT"));
			campVo.setAddress(rs.getString("ADDRESS"));
			campVo.setPhone(rs.getString("PHONE"));
			campVo.setIntro(rs.getString("INTRO"));
			campVo.setRgDate(rs.getString("RG_DATE"));
			campVo.setRefund(rs.getString("REFUND"));
			campVo.setImgPath(rs.getString("IMGPATH"));
			campVo.setThemeCode(rs.getString("THEME_CODE"));
			campVo.setSectionNo(rs.getString("SECTION_NO"));;
			campVo.setStayMax(rs.getString("STAYMAX"));
			campVo.setPrice(rs.getString("PRICE"));
			campVo.setzName(rs.getString("Z_NAME"));
			campVo.setzNor(rs.getString("Z_NOR"));
			
			}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return campVo;
		
	}
	
	/*
	 * 해시코드 리스트 가져오기
	 */
	public List<String> selectHashCode(Connection conn, String campCode) {

		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<String> hashCode = new ArrayList<String>();
		String sql = "SELECT HM.*, H.HT_NAME FROM( SELECT CAMP_CODE, HT_CODE FROM HASHTAG_MAPPING WHERE CAMP_CODE = ? )HM JOIN HASHTAG H ON HM.HT_CODE = H.HT_CODE";
		
		
		try{
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, campCode);
		
		rs = pstmt.executeQuery();
		
		//rs -> obj로 바꿔주는 작업 필요
		while(rs.next()) {
			
			hashCode.add(rs.getString("HT_NAME"));
			
			
			}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return hashCode;
	
	
	}
	/*
	 * 이미지 불러오기
	 */
	public CampAttachmentVo selectCampZone(Connection conn, String campCode) {

		
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CampAttachmentVo campAttachVo = null;
		
		String sql = "select * from camp_attachment where camp_no=? and img_type='Z'";
		
		
		try{
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, campCode);
		
		rs = pstmt.executeQuery();
		
		//rs -> obj로 바꿔주는 작업 필요
		if(rs.next()) {
			
			//vo객체에 담아주기
			campAttachVo = new CampAttachmentVo();
			
			campAttachVo.setCampPath(rs.getString("F_PATH"));
			campAttachVo.setCampChangeName(rs.getString("CHANGENAME"));
			
			}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return campAttachVo;
		
	}
	/*
	 * 시설 리스트 얻어오기
	 */
	public List<String> selectfac(Connection conn, String campCode) {
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		List<String> facList = new ArrayList<String>();
		String sql = "SELECT WIFI, ELECTRO, HOTWATER, PET, STORE, FWOOD, PLAYGROUND, TRAIL, POOL FROM CAMP_FAC WHERE CAMP_CODE=?";
		
		
		try{
		
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, campCode);
		
		rs = pstmt.executeQuery();
		
		//rs -> obj로 바꿔주는 작업 필요
		if(rs.next()) {
			if(rs.getString("WIFI")!= null) {
				facList.add("와이파이");
			}
			
			if(rs.getString("ELECTRO")!= null) {
				facList.add("전기");
			}
			
			if(rs.getString("HOTWATER")!= null) {
				facList.add("온수");
			}
			
			if(rs.getString("PET")!= null) {
				facList.add("반려견동반");
			}
			
			if(rs.getString("STORE")!= null) {
				facList.add("매점");
			}
			
			if(rs.getString("FWOOD")!= null) {
				facList.add("장작판매");
			}
			
			if(rs.getString("PLAYGROUND")!= null) {
				facList.add("운동장");
			}
			
			if(rs.getString("TRAIL")!= null) {
				facList.add("산책로");
			}
			
			if(rs.getString("POOL")!= null) {
				facList.add("물놀이장");
			}
		}
		
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return facList;
	}

}//class
