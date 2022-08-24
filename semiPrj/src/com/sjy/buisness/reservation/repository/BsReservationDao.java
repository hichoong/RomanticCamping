package com.sjy.buisness.reservation.repository;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.sjy.buisness.reservation.vo.ReservationVo;

public class BsReservationDao {

	public ReservationVo selectAllRsv(Connection conn, String bsNo) {
		
 		//SQL 준비
		String sql = "";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReservationVo vo = null;
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
	}

}
