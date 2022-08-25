package com.sjy.buisness.reservation.repository;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.sjy.buisness.reservation.vo.ReservationVo;

public class BsReservationDao {

	public List<ReservationVo> selectAllRsv(Connection conn, int i) {
		
 		//SQL 준비
		String sql = "SELECT * FROM RESERVATION WHERE CAMP_CODE=? ";
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReservationVo vo = null;
		List<ReservationVo> list = new ArrayList<ReservationVo>();
		try {
			//SQL 객체 담기 및 완성
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, i);
			
			//SQL 실행 및 결과 저장
			rs =  pstmt.executeQuery();
			
			while(rs.next()) {
				list.add(new ReservationVo(
							rs.getString("NO"),
							rs.getString("NAME"),
							rs.getString("PHONE"),
							rs.getString("CHECKIN"),
							rs.getString("CHECKOUT"),
							rs.getString("NOP"),
							rs.getString("REQUEST"),
							rs.getString("RESERVATION_DATE"),
							rs.getString("STATUS")
						));
			}
			System.out.println(i+"::rvList_dao::" +list);
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		//결과리턴
		return list;
	}

}
