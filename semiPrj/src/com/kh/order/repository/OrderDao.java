package com.kh.order.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.kh.common.JDBCTemplate;
import com.kh.order.vo.OrderVo;
import com.kh.order.vo.ReservationVo;

public class OrderDao {

	//결제 insert		
	public int insertPayment(Connection conn, OrderVo orderVo) {
		PreparedStatement pstmt = null;
		int result = 0; 
		String sql = "";
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}
	
	//예약 insert
	public int insertReservation(Connection conn, ReservationVo reservationVo) {
		PreparedStatement pstmt = null;
		int result = 0; 
		String sql = "";
		
		try {
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		return result;
	}

	
	
	

	
}
