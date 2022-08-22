package com.sjy.buisness.camp.repository;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.camplist.hashtag.vo.HashTagVo;
import com.sjy.buisness.camp.vo.BsCampVo;
import com.sjy.buisness.camp.vo.BsCampZoneVo;
import com.sjy.buisness.camp.vo.CampAttachmentVo;

public class BsCampDao {
/*
 		//SQL 준비
		String sql = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			//SQL 객체 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			
			
			//SQL 실행 및 결과 저장
			rs =  pstmt.executeQuery();
			
			while(rs.next()) {
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		//결과리턴
		return vo;
 */
	/*
	 * 캠핑장 갯수 가져오기
	 */
	public int selectMyCampNum(Connection conn, String no) {
		// 
 		//SQL 준비
		String sql = "SELECT COUNT(*)AS COUNT FROM CAMP_INFO WHERE NO = ? AND CAMP_STATUS ='Y'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int result =0;
		try {
			//SQL 객체 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			//SQL 실행 및 결과 저장
			rs =  pstmt.executeQuery();
			
			if(rs.next()) {
				result  =rs.getInt("COUNT");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		//결과리턴
		return result;
	}
	
	/*
	 * 캠핑장 모든정보 가져오기(로그인 사업자)
	 */
	public List<BsCampVo> selectAllCamp(Connection conn, String no) {
		
		//SQL 준비
		String sql = "SELECT * FROM CAMP_INFO WHERE NO = ? AND CAMP_STATUS ='Y'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BsCampVo> list  = new ArrayList<BsCampVo>();
		
		try {
			//SQL 객체 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			rs =  pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new BsCampVo(
						rs.getString("CAMP_CODE")
						,rs.getString("CAMP_NAME")
						,rs.getString("CITY")
						,rs.getString("DISTRICT")
						,rs.getString("CAMP_ADDRESS")
						,rs.getString("CAMP_PHONE")
						,rs.getString("CAMP_INTRO")
						,rs.getString("RG_DATE")
						,rs.getString("CAMP_REFUND")
						,rs.getString("CAMP_IMGPATH")
						,rs.getString("THEME_CODE")
						,rs.getString("THEME_CODE")
						,rs.getString("CAMP_UPDATED")
						,rs.getString("CAMP_STATUS")
						
						));
	
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		//결과리턴
		return list;
	}
	
	
	
	/*
	 * insert 준비사항
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
	 */
	
	/*
	 * 캠핑장 정보 저장
	 */
	public int campInsert(Connection conn, BsCampVo campVo, CampAttachmentVo ahVo) {
		
		//SQL 준비
		String sql = "INSERT INTO CAMP_INFO (CAMP_CODE, CAMP_NAME, CITY, DISTRICT, CAMP_ADDRESS, CAMP_PHONE, CAMP_INTRO, CAMP_REFUND, CAMP_IMGPATH, THEME_CODE) VALUES (SEQ_CAMP_INFO_CODE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
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
			pstmt.setString(8, ahVo.getZaPath());//이미지는 업로드된파일에서 
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
	public int campZoneInsert(Connection conn, BsCampZoneVo[] zoneVo, int i) {
		
		//SQL 준비
		String sql = "INSERT INTO CAMP_ZONE (Z_NO, Z_STAYMAX, Z_PRICE, Z_NAME, Z_NOR, CAMP_CODE) VALUES(SEQ_CAMP_ZONE_NO.NEXTVAL, ?, ?, ?, ?, SEQ_CAMP_INFO_CODE.CURRVAL)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//SQL 객체 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, zoneVo[i].getZoneStayMax());
			pstmt.setString(2, zoneVo[i].getZonePrice());
			pstmt.setString(3, zoneVo[i].getZoneName());
			pstmt.setString(4, zoneVo[i].getZoneNor());
			
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

	public List<HashTagVo> selectHashTag(Connection conn) {
		String sql = "SELECT HT_CODE, HT_NAME FROM HASHTAG ORDER BY HT_CODE";
		
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

	/*
	 * 해쉬태그 맵핑테이블에 insert
	 */
	public int insertHash(Connection conn, HashTagVo hashVo) {
		//SQL 준비
		String sql = "INSERT INTO HASHTAG_MAPPING (CAMP_CODE, HT_CODE) VALUES (SEQ_CAMP_INFO_CODE.CURRVAL, ?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//SQL 객체 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, hashVo.getHtCode());

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
