package com.kh.reservation.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;
import com.kh.order.vo.ReservationVo;

public class ReservationDao {

	public List<ReservationVo> reservationCheck(Connection conn, String no, String type) {

		String sql = "SELECT R.NO, R.NAME, R.PHONE, TO_CHAR(R.CHECKIN, 'YYYY-MM-DD') CHECKIN, TO_CHAR(R.CHECKOUT, 'YYYY-MM-DD') CHECKOUT, R.NOP, R.REQUEST, R.RESERVATION_DATE, R.STATUS, R.CAMP_CODE, R.Z_NO, R.USER_NO, C.CAMP_NAME, C.CAMP_PHONE, C.CAMP_ADDRESS, Z.Z_NAME FROM RESERVATION R JOIN CAMP_INFO C ON R.CAMP_CODE = C.CAMP_CODE JOIN CAMP_ZONE Z ON R.Z_NO = Z.Z_NO WHERE R.USER_NO = ? AND R.STATUS = ?  ORDER BY RESERVATION_DATE DESC";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReservationVo> list = new ArrayList<ReservationVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			pstmt.setString(2, type);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				ReservationVo vo = new ReservationVo();
				
				vo.setReservationNo(rs.getString("NO"));
				vo.setReservationName(rs.getString("NAME"));
				vo.setReservationPhone(rs.getString("PHONE"));
				vo.setReservationCheckin(rs.getString("CHECKIN"));
				vo.setReservationCheckout(rs.getString("CHECKOUT"));
				vo.setReservationNop(rs.getString("NOP"));
				vo.setRequest(rs.getString("REQUEST"));
				vo.setReservationDate(rs.getString("RESERVATION_DATE"));
				vo.setReservationStatus(rs.getString("STATUS"));
				vo.setCampCode(rs.getString("CAMP_CODE"));
				vo.setZoneNo(rs.getString("Z_NO"));
				vo.setUserNo(rs.getString("USER_NO"));
				vo.setCampName(rs.getString("CAMP_NAME"));
				vo.setCampPhone(rs.getString("CAMP_PHONE"));
				vo.setCampAddr(rs.getString("CAMP_ADDRESS"));
				vo.setZoneName(rs.getString("Z_NAME"));
				
				list.add(vo);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return list;
	}

	public int cancleReservation(Connection conn, String no) {

		String sql = "UPDATE RESERVATION SET STATUS = 'N' WHERE NO = ?";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, no);
			
			result = pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

}
