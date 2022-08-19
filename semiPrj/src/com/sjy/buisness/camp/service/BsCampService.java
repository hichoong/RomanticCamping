package com.sjy.buisness.camp.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;

import com.sjy.buisness.camp.repository.BsCampDao;
import com.sjy.buisness.camp.vo.BsCampVo;
import com.sjy.buisness.camp.vo.BsCampZoneVo;

public class BsCampService {

	/*
	 * 캠핑장 등록
	 */
	public int campInsert(BsCampVo campVo) {
		Connection conn = null;
		conn = getConnection();
		
		int result =0;
		result = new BsCampDao().campInsert(conn, campVo);
		//결과에따른 커밋 롤백
		if (result==1) {
			commit(conn);
		}else {rollback(conn);}
		
		return result;
	}

	
	/*
	 * 캠핑장 구역 등록
	 */
	public int campZoneInsert(BsCampZoneVo zoneVo) {
		Connection conn =null;
		conn = getConnection();
		
		int result = 0;
		result = new BsCampDao().campZoneInsert(conn, zoneVo);
		//결과에따른 커밋 롤백
		if (result==1) {
			commit(conn);
		}else {rollback(conn);}
		
		
		return result;
	}

}
