package com.sjy.buisness.camp.repository;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.sjy.buisness.camp.vo.BsCampVo;

public class BsCampDao {

	public int campInsert(Connection conn, BsCampVo campVo) {
		
		PreparedStatement pstmt =null;
		int result = 0;

		return 0;
	}

}
