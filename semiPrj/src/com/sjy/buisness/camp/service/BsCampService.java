package com.sjy.buisness.camp.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import static com.kh.common.JDBCTemplate.*;

import com.kh.camplist.hashtag.vo.HashTagVo;
import com.kh.camplist.theme.vo.ThemeVo;
import com.sjy.buisness.camp.repository.BsCampDao;
import com.sjy.buisness.camp.vo.BsCampFacVo;
import com.sjy.buisness.camp.vo.BsCampVo;
import com.sjy.buisness.camp.vo.BsCampZoneVo;
import com.sjy.buisness.camp.vo.CampAttachmentVo;
import com.sjy.buisness.hashmapping.vo.HashMappingVo;

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
	 * 선택한 캠핑장 정보 가져오기
	 */
	public BsCampVo selectOneCamp(String no, String campCode) {
		Connection conn = null;
		conn = getConnection();
		
		BsCampVo bsVo = dao.selectOneCamp(conn, no, campCode); 
		return bsVo;
	}
	
	/*
	 * 캠핑장/ 구역 등록 여부 확인
	 */
	public int camp( BsCampVo campVo, CampAttachmentVo ahVo,  int hashNum, String hashTag, String mbNo,BsCampZoneVo[] zoneVo, CampAttachmentVo[] ahVo2, int zonNum , BsCampFacVo faVo) {
		Connection conn = null;
		
		conn = getConnection();
		int resultCamp =0;
		int resultZone = 0;
		
		resultCamp = campInsert(conn, campVo, ahVo, hashNum, hashTag, mbNo , zoneVo , ahVo2, zonNum,faVo);
		
		
        
		//캠핑장구역
		
		//캠핑장구역이미지
		if (resultCamp ==1 && resultZone ==1) {
			commit(conn);
		}else {
			rollback(conn);
		}
        
        
		return resultCamp;		
	}

	
	/*
	 * 캠핑장 구역 등록
	 */
//	public int campZoneInsert(BsCampZoneVo[] zoneVo, int i, CampAttachmentVo ahVo2) {
//		Connection conn =null;
//		conn = getConnection();
//		
//		int result1 = 0;
//		int result2 = 0;
//		result1 = new BsCampDao().campZoneInsert(conn, zoneVo, i);
//		result2 = new BsCampDao().ZoneImgInsert(conn, ahVo2,i);
//		//결과에따른 커밋 롤백
//		if (result1*result2==1) {
//			commit(conn);
//		}else {rollback(conn);}
//		
//		
//		return result1*result2;
//	}
	
//	public int campZoneInsert(BsCampZoneVo zoneVo, int i, CampAttachmentVo ahVo2) {
//		// TODO Auto-generated method stub
//		return 0;
//	}
	public int campZoneInsert(Connection conn, BsCampZoneVo zoneVo, int i, CampAttachmentVo ahVo2, int zonNum) {
		int result1 = 0;
		int result2 = 0;
		System.out.println("campZoneInsert_sv:: "+zoneVo);
		for (int j = 0; j <= zonNum; j++) {
			result1 = new BsCampDao().campZoneInsert(conn, zoneVo, i, ahVo2);
			result2 = new BsCampDao().ZoneImgInsert(conn, ahVo2,i);
		}
		//결과에따른 커밋 롤백
		if (result1 == 1 && result2 == 1) {
			commit(conn);
		}else {rollback(conn);}
		
		
		return result1*result2;
	}
	
	/*
	 * 캠핑장 등록
	 */
	public int campInsert(Connection conn, BsCampVo campVo, CampAttachmentVo ahVo,  int hashNum, String hashTag, String mbNo,BsCampZoneVo[] zoneVo,  CampAttachmentVo[] ahVo2, int zonNum, BsCampFacVo faVo) {
		//캠핑장 테이블
		int result1 =0;
		int result2 =0;
		int result3 =0;
		int result4 =0;
		int resultZone =0;
		int resultZoneImg =0;
		
		System.out.println("campvo"+campVo);
		System.out.println("ahvo"+ahVo);
		System.out.println("mbNo"+mbNo);
		result1 = new BsCampDao().campInsert(conn, campVo, ahVo, mbNo);
		if (result1 != 1) {
			System.out.println("캠핑장 등록오류");
		}
		
		//캠핑장 메인 이미지 저장
		result2 = new BsCampDao().insertMainAh(conn, ahVo);
		if (result2 != 1) {
			System.out.println("캠핑장 메인 이미지 등록 오류");
		}
		
		//시설현황 등록
		result3 = dao.insertFac(conn, faVo);
		if (result3 != 1) {
			System.out.println("시설현황 등록 오류");
		}
		
		//해쉬태그맵핑테이블
		HashTagVo hashVo = new HashTagVo();
		String[] hashs = new String[hashNum];
        for (int i1 = 0; i1 < hashNum; i1++) {
        	hashs = hashTag.split(",");
        	System.out.println(i1+":"+hashs[i1]);
        	hashVo.setHtCode(hashs[i1]);
        	result4 = new BsCampService().insertHash(conn, hashVo);
        	
        	if (result4 != 1) {
        		//등록 실패(해쉬태그 등록 오류)
        		System.out.println("해쉬태그 등록오류");
        	}
        }
        
        //캠핑장 구역 insert
        for (int i = 0; i < zonNum; i++) {
        	//System.out.println(i+"| sv_zN::"+zonNum);
        	//System.out.println("campZoneInsert_sv:: "+zoneVo);
        	resultZone = new BsCampDao().campZoneInsert(conn, zoneVo[i], i, ahVo2[i]);
        	resultZoneImg = new BsCampDao().ZoneImgInsert(conn, ahVo2[i],i);
        	//System.out.println("resultZone::"+resultZone);
        	//System.out.println("resultZoneImg::" + resultZoneImg);
        	if (resultZone!=1) {
				System.out.println("캠핑장 구역 등록 오류");
			}else if(resultZoneImg!=1) {System.out.println("캠핑장 이미지 등록 오류");}
		}
        
		//결과에따른 커밋 롤백
		if (result1==1 && result2==1 && result3==1 && resultZone ==1 && resultZoneImg==1) {
			commit(conn);
		}else {rollback(conn);}
		
		return result1*result2*result3*resultZone*resultZoneImg;
 
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
	
	public String createChangeZoneName(String originName) {
		//확장자 가져오기
		int dotIdx = originName.lastIndexOf("."); //
		String ext = originName.substring(dotIdx);
		long now = System.currentTimeMillis();
		String random = UUID.randomUUID().toString().substring(0,4);
		
		String changeName = "KH_Zone" + now + "_" + random + ext;
		
		return changeName;
	}
	/*
	 * 맵핑테이블에 데이터 insert
	 */
	public int insertHash(Connection conn, HashTagVo hashVo) {
		
		int result = dao.insertHash(conn, hashVo); 
		if (result == 1) {
			commit(conn);
		}else {
			rollback(conn);
		}
		return result;
	}
	
	/*선택한 캠핑장에서 테마, 해쉬태그 , 시설현황 가져오기*/
	public BsCampVo selectOneTheme(String campCode) {
		Connection conn = getConnection();
		BsCampVo vo = dao.selectOneTheme(conn,campCode);
		close(conn);
		return vo;
	}
	public List<HashMappingVo> selecOnetHashTag(String campCode) {
		Connection conn = getConnection();
		List<HashMappingVo> list = dao.selectOneHashTag(conn,campCode);
		close(conn);
		return list;
	}
	
//	public List<HashTagVo> selecOnetF(String campCode) {
//		Connection conn = getConnection();
//		List<HashTagVo> list = dao.selectOneHashTag(conn,campCode);
//		close(conn);
//		return list;
//	}
	//시설현황
	public BsCampFacVo selectOneFac(String campCode) {
		Connection conn = getConnection();
		BsCampFacVo facVo = dao.selectOneFac(conn,campCode);
		close(conn);
		return facVo;
	}


	public List<BsCampZoneVo> selectZoneAll(String campCode) {
		Connection conn = null;
		conn = getConnection();
		List<BsCampZoneVo> list = dao.selectZoneAll(conn, campCode);
		System.out.println("sev zli"+list);
		return list;
	}
	
	/*
	 * 캠프 상태값 N으로 변경
	 */
	public int delteCamp(String campCode) {
		Connection conn = null;
		conn = getConnection();
		
		int result = dao.delteCamp(conn, campCode);
		if (result == 1) {
			commit(conn);
		}else {rollback(conn);}
		
		return result;
	}
	
	//캠핑장에 구역개수 가져오기
	public int selectZoneCount(String code) {
		Connection conn = null;
		conn =  getConnection();
		
		int result =  dao.selectZoneCount(conn, code);
		return 0;
	}






}
