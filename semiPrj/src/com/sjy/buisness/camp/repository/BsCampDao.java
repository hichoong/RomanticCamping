package com.sjy.buisness.camp.repository;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.camplist.hashtag.vo.HashTagVo;
import com.kh.camplist.theme.vo.ThemeVo;
import com.sjy.buisness.camp.vo.BsCampFacVo;
import com.sjy.buisness.camp.vo.BsCampVo;
import com.sjy.buisness.camp.vo.BsCampZoneVo;
import com.sjy.buisness.camp.vo.CampAttachmentVo;
import com.sjy.buisness.hashmapping.vo.HashMappingVo;

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
		String sql = "SELECT * FROM CAMP_INFO WHERE NO = ? AND CAMP_STATUS ='Y' ORDER BY CAMP_CODE DESC";
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
	 * 선택한 캠핑장 세부정보 가져오기
	 */

	public BsCampVo selectOneCamp(Connection conn, String no, String campCode) {
		//SQL 준비
		String sql = "SELECT * FROM CAMP_INFO WHERE NO = ? AND CAMP_CODE=? AND CAMP_STATUS ='Y'";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BsCampVo vo  = new BsCampVo();
		
		try {
			//SQL 객체 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, campCode);
			rs =  pstmt.executeQuery();
			
			if(rs.next()) {
				vo.setCampCode(rs.getString("CAMP_CODE"));
				vo.setCampName(rs.getString("CAMP_NAME"));
				vo.setCity(rs.getString("CITY"));
				vo.setDistrict(rs.getString("DISTRICT"));
				vo.setCampAddress(rs.getString("CAMP_ADDRESS"));
				vo.setCampPhone(rs.getString("CAMP_PHONE"));
				vo.setCampIntro(rs.getString("CAMP_INTRO"));
				vo.setRgDate(rs.getString("RG_DATE"));
				vo.setCampRefund(rs.getString("CAMP_REFUND"));
				vo.setCampImgPath(rs.getString("CAMP_IMGPATH"));
				vo.setTheme(rs.getString("THEME_CODE"));
				vo.setCampUpdated(rs.getString("CAMP_UPDATED"));
				vo.setCampStatus(rs.getString("CAMP_STATUS"));
				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		//결과리턴
		return vo;
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
	public int campInsert(Connection conn, BsCampVo campVo, CampAttachmentVo ahVo, String mbNo) {
		
		//SQL 준비
		String sql = "INSERT INTO CAMP_INFO (CAMP_CODE, NO, CAMP_NAME, CITY, DISTRICT, CAMP_ADDRESS, CAMP_PHONE, CAMP_INTRO, CAMP_REFUND, CAMP_IMGPATH, THEME_CODE) VALUES (SEQ_CAMP_INFO_CODE.NEXTVAL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	 	            //INSERT INTO CAMP_INFO (CAMP_CODE, NO, CAMP_NAME, CITY, DISTRICT, CAMP_ADDRESS, CAMP_PHONE, CAMP_INTRO, CAMP_REFUND, CAMP_IMGPATH, THEME_CODE, CAMP_STATUS)VALUES (SEQ_CAMP_INFO_CODE.NEXTVAL, 3,'캠핑장1', '서울시', '강남구', '역삼동 역삼빌딩', '01012341234', '여기는 캠핑장 1 입니다', '환불 안됨', '/semiPrj/resource/img/test.jpg', 1 ,'Y');
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//SQL 객체 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			System.out.println(mbNo);
			System.out.println(campVo.getCampName());
			System.out.println(campVo.getCity());
			System.out.println(campVo.getDistrict());
			System.out.println(campVo.getCampAddress());
			System.out.println(campVo.getCampPhone());
			System.out.println(campVo.getCampIntro());
			System.out.println(campVo.getCampRefund());
			System.out.println(ahVo.getCampPath());
			System.out.println(campVo.getTheme());
			
			pstmt.setInt(1, Integer.parseInt(mbNo));
			pstmt.setString(2, campVo.getCampName());
			pstmt.setString(3, campVo.getCity());
			pstmt.setString(4, campVo.getDistrict());
			pstmt.setString(5, campVo.getCampAddress());
			pstmt.setString(6, campVo.getCampPhone());
			pstmt.setString(7, campVo.getCampIntro());
			pstmt.setString(8, campVo.getCampRefund());
			pstmt.setString(9, ahVo.getCampPath() + "\\" + ahVo.getCampChangeName());//이미지는 업로드된파일에서 
			pstmt.setString(10, campVo.getTheme());
			
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
	public int campZoneInsert(Connection conn, BsCampZoneVo zoneVo, int i, CampAttachmentVo ahVo2) {
		
		//SQL 준비
		String sql = "INSERT INTO CAMP_ZONE (Z_NO, Z_STAYMAX, Z_PRICE, Z_NAME, Z_NOR, Z_IMGPATH, CAMP_CODE) VALUES(SEQ_CAMP_ZONE_NO.NEXTVAL, ?, ?, ?, ?, ?, SEQ_CAMP_INFO_CODE.CURRVAL)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//SQL 객체 담기 및 완성
			System.out.println("campZoneInsert: "+zoneVo);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, zoneVo.getZoneStayMax());
			pstmt.setString(2, zoneVo.getZonePrice());
			pstmt.setString(3, zoneVo.getZoneName());
			pstmt.setString(4, zoneVo.getZoneNor());
			pstmt.setString(5, ahVo2.getCampPath()+ "\\" + ahVo2.getCampChangeName());
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
			System.out.println(hashVo.getHtCode());
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
	
	public int insertFac(Connection conn, BsCampFacVo faVo) {
		//SQL 준비
		String sql = "INSERT INTO CAMP_FAC(CAMP_CODE,WIFI,ELECTRO,HOTWATER,PET,STORE,FWOOD,PLAYGROUND,TRAIL,POOL) VALUES(SEQ_CAMP_INFO_CODE.CURRVAL, ?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//SQL 객체 담기 및 완성
			System.out.println(faVo);
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, faVo.getWifi());
			pstmt.setString(2, faVo.getElectro());
			pstmt.setString(3, faVo.getHotWater());
			pstmt.setString(4, faVo.getPet());
			pstmt.setString(5, faVo.getStore());
			pstmt.setString(6, faVo.getFwood());
			pstmt.setString(7, faVo.getPlayGround());
			pstmt.setString(8, faVo.getTrail());
			pstmt.setString(9, faVo.getPool());
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
	 * 메인 이미지 첨푸파일 테이블에 저장
	 */
	public int insertMainAh(Connection conn, CampAttachmentVo ahVo) {
		//SQL 준비
		//String sql = "INSERT INTO CAMP_ATTACHMENT (ZA_NO ,Z_NO ,ZA_ORIGNNAME ,ZA_CHANGENAME ,ZA_PATH, IMGTYPE ) VALUES( SEQ_CAMP_ATTACHMENT_NO.NEXTVAL , SEQ_CAMP_INFO_CODE.CURRVAL , ? , ? , ? ,'M')";
		String sql = "INSERT INTO CAMP_ATTACHMENT (F_NO ,CAMP_NO, Z_NO ,ORIGNNAME ,CHANGENAME ,F_PATH, IMG_TYPE ) VALUES( SEQ_CAMP_ATTACHMENT_NO.NEXTVAL , SEQ_CAMP_INFO_CODE.CURRVAL ,0, ? , ? , ? ,'M')";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//SQL 객체 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, ahVo.getCampOrignName());
			pstmt.setString(2, ahVo.getCampChangeName());
			pstmt.setString(3, ahVo.getCampPath());
			
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
	 * 구역 이미지 넣기 
	 */
	public int ZoneImgInsert(Connection conn, CampAttachmentVo ahVo2, int i) {
		//String sql = "INSERT INTO CAMP_ATTACHMENT ( ATCH_NO ,CAMP_NO ,CAMP_ORIGNNAME ,CAMP_CHANGENAME ,CAMP_PATH, IMGTYPE ) VALUES( SEQ_CAMP_ATTACHMENT_NO.NEXTVAL , SEQ_BOARD_NO.CURRVAL , ? , ? , ? , Z)";
		String sql = "INSERT INTO CAMP_ATTACHMENT (F_NO ,CAMP_NO, Z_NO ,ORIGNNAME ,CHANGENAME ,F_PATH, IMG_TYPE ) VALUES( SEQ_CAMP_ATTACHMENT_NO.NEXTVAL , SEQ_CAMP_INFO_CODE.CURRVAL ,SEQ_CAMP_ZONE_NO.CURRVAL, ? , ? , ? ,'Z')";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//SQL 객체 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			//pstmt.setString(1, "구역번호");
			pstmt.setString(1, ahVo2.getCampOrignName());
			pstmt.setString(2, ahVo2.getCampChangeName());
			pstmt.setString(3, ahVo2.getCampPath());
			
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
	 * 선택한 캠핑장에서 테마, 해쉬태그 , 시설현황 가져오기
	 */
	public BsCampVo selectOneTheme(Connection conn, String campCode) {
		String sql = "SELECT CAMP_CODE, THEME_CODE FROM CAMP_INFO WHERE CAMP_CODE =?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BsCampVo vo = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, campCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				
				vo = new BsCampVo();
				vo.setTheme(rs.getString("THEME_CODE"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		
		return vo;
	}

	public List<HashMappingVo> selectOneHashTag(Connection conn, String campCode) {
		String sql = "SELECT CAMP_CODE, HT_CODE FROM HASHTAG_MAPPING WHERE CAMP_CODE =?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<HashMappingVo> list = new ArrayList<HashMappingVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, campCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new HashMappingVo(
							rs.getString("CAMP_CODE"),
							rs.getString("HT_CODE")
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
	
	//시설현황
	public BsCampFacVo selectOneFac(Connection conn, String campCode) {
		String sql = "SELECT CAMP_CODE ,WIFI ,ELECTRO ,HOTWATER ,PET ,STORE ,FWOOD ,PLAYGROUND ,TRAIL ,POOL FROM CAMP_FAC WHERE CAMP_CODE =?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		BsCampFacVo facVo = new BsCampFacVo();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, campCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				facVo=	new BsCampFacVo(
							rs.getString("WIFI"),
							rs.getString("ELECTRO"),
							rs.getString("HOTWATER"),
							rs.getString("PET"),
							rs.getString("STORE"),
							rs.getString("FWOOD"),
							rs.getString("PLAYGROUND"),
							rs.getString("TRAIL"),
							rs.getString("POOL")
						);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(rs);
			close(pstmt);
		}
		System.out.println("fac_list"+ facVo);
		return facVo;
	}

	public List<BsCampZoneVo> selectZoneAll(Connection conn, String campCode) {
		String sql = "SELECT Z_NO, Z_STAYMAX, Z_PRICE, Z_NAME ,Z_NOR,Z_IMGPATH FROM CAMP_ZONE WHERE CAMP_CODE =?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<BsCampZoneVo> list = new ArrayList<BsCampZoneVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, campCode);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				list.add(new BsCampZoneVo(
							rs.getString("Z_NO")
							,rs.getString("Z_STAYMAX")
							,rs.getString("Z_PRICE")
							,rs.getString("Z_NAME")
							,rs.getString("Z_NOR")
							,rs.getString("Z_IMGPATH")
							
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
	 * 캠핑장 상태값 N으로 변경 : 삭제하기
	 */
	public int delteCamp(Connection conn, String campCode) {
		String sql = "UPDATE CAMP_INFO SET CAMP_STATUS='N' WHERE CAMP_CODE=?";
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//SQL 객체 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, campCode);
			
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
