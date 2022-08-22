package com.sjy.buisness.camp.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static com.kh.common.JDBCTemplate.*;

import com.kh.camplist.hashtag.vo.HashTagVo;
import com.sjy.buisness.camp.repository.BsCampDao;
import com.sjy.buisness.camp.vo.BsCampVo;
import com.sjy.buisness.camp.vo.BsCampZoneVo;
import com.sjy.buisness.camp.vo.CampAttachmentVo;

public class BsCampService {
	BsCampDao dao = new BsCampDao();

	/*
	 * 현재 캠핑장 등록 개수 가져오기
	 */
	public int  MyCampNum(String no) {
		
		Connection conn = null;
		conn = getConnection();
		
		int num =0;
		num =  dao.selectMyCampNum(conn,no);
		return num; 
	}
	/*
	 * 모든 캠핑장 정보 가져오기
	 */
	public List<BsCampVo> selectAllCamp(String no) {
		
		Connection conn = null;
		conn = getConnection();
		
		List<BsCampVo> bsVo = dao.selectAllCamp(conn, no); 
		return bsVo;
	}
	
	/*
	 * 캠핑장 등록
	 */
	public int campInsert(BsCampVo campVo, CampAttachmentVo ahVo) {
		Connection conn = null;
		conn = getConnection();
		
		//해쉬태그맵핑테이블
				
		//캠핑장구역
		
		//캠핑장구역이미지
		
		//캠핑장 메인 이미지
		
		//캠핑장 테이블
		int result =0;
		result = new BsCampDao().campInsert(conn, campVo, ahVo);
		//결과에따른 커밋 롤백
		if (result==1) {
			commit(conn);
		}else {rollback(conn);}
		
		return result;
	}

	
	/*
	 * 캠핑장 구역 등록
	 */
	public int campZoneInsert(BsCampZoneVo[] zoneVo, int i) {
		Connection conn =null;
		conn = getConnection();
		
		int result = 0;
		result = new BsCampDao().campZoneInsert(conn, zoneVo, i);
		//결과에따른 커밋 롤백
		if (result==1) {
			commit(conn);
		}else {rollback(conn);}
		
		
		return result;
	}

	/*
	 * 해쉬태그가져오기 code순서대로
	 */
	public List<HashTagVo> selectHashTag() {
		Connection conn = getConnection();
		List<HashTagVo> list = dao.selectHashTag(conn);
		close(conn);
		return list;
	}

	/*
	 * 원본 파일명을 중복되지 않을 이름으로 변경 
	 */
	public String createChangeName(String originName) {
		//확장자 가져오기
		int dotIdx = originName.lastIndexOf("."); //
		String ext = originName.substring(dotIdx);
		long now = System.currentTimeMillis();
		String random = UUID.randomUUID().toString().substring(0,4);
		
		String changeName = "KH_CampMain" + now + "_" + random + ext;
		
		return changeName;
	}

	/*
	 * 맵핑테이블에 데이터 insert
	 */
	public int insertHash(HashTagVo hashVo) {
		Connection conn = null;
		conn =  getConnection();
		
		int result = dao.insertHash(conn, hashVo); 
		
		return result;
	}




}
