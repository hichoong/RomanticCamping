package com.sjy.buisness.camp.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;

import com.sjy.buisness.camp.repository.BsCampDao;
import com.sjy.buisness.camp.vo.BsCampVo;

public class BsCampService {

	/*
	 * 캠핑장 등록
	 */
	public int campInsert(BsCampVo campVo) {
		Connection conn = null;
		conn = getConnection();
		
		int result =0;
		result = new BsCampDao().campInsert(conn, campVo);
		
		
		return result;
	}

}
