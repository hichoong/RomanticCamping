package com.kh.campdetail.service;

import static com.kh.common.JDBCTemplate.close;
import static com.kh.common.JDBCTemplate.getConnection;

import java.sql.Connection;
import java.util.List;

import com.kh.campdetail.repository.CampDetailDao;
import com.kh.campdetail.vo.CampDetailVo;
import com.kh.campzonelist.campzone.vo.CampZoneVo;
import com.sjy.buisness.camp.vo.CampAttachmentVo;

public class CampDetailService {
	
	CampDetailDao dao = new CampDetailDao(); 
	
	//특정 캠핑장 가져오기 
	public CampDetailVo selectOne(String campCode, String zoneNo) {

		Connection conn = getConnection();
				
		CampDetailVo campVo = null;
		campVo = dao.selectCampZone(conn, campCode, zoneNo); 
		
		close(conn);		
		
		return campVo;		
		
		
	}

	/*
	 * 해시코드 리스트 가져오기
	 */
	public List<String> selectHashTag(String campCode) {

		Connection conn = getConnection();
		
		List<String> hashCode = null;
		hashCode = dao.selectHashCode(conn, campCode); 
		
		close(conn);		
		
		return hashCode;		
		
	}
	
	/*
	 * 이미지 불러오기 
	 */
	public CampAttachmentVo selectImg(String campCode) {
		Connection conn = getConnection();
		
		CampAttachmentVo campAttachVo = null;
		campAttachVo = dao.selectCampZone(conn, campCode); 
		
		close(conn);		
		
		return campAttachVo;	
	}

	/*
	 * 시설물 얻어오기
	 */
	public List<String> selectFac(String campCode) {
		
		Connection conn = getConnection();
		
		List<String> facList = null;
		facList = dao.selectfac(conn, campCode); 
		
		close(conn);		
		
		return facList;	
	}

}//class
