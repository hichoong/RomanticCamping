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
		String sql = "INSERT INTO PAYMENT( PAY_CODE , RE_NO , PAY_AMOUNT , PAY_METHOD , C_CODE ) VALUES( SEQ_PAYMENT_NO.NEXTVAL , SEQ_RESERVATION_NO.CURRVAL , ? , ? , ? )";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, orderVo.getPayAmount());
			pstmt.setString(2, orderVo.getPayMethod());
			pstmt.setString(3, orderVo.getCouponCode());
			result = pstmt.executeUpdate();
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
		String sql = "INSERT INTO RESERVATION( NO , NAME , PHONE , CHECKIN , CHECKOUT , NOP , REQUEST , CAMP_CODE , Z_NO , USER_NO ) "
				+"VALUES( SEQ_RESERVATION_NO.NEXTVAL , ? , ? , ? , ? , ? , ? , ? , ?, ?  )";
		
		try {
			pstmt = conn.prepareStatement(sql);
			//예약정보에 들어갈 값 세팅
			pstmt.setString(1, reservationVo.getReservationName());
			pstmt.setString(2, reservationVo.getReservationPhone());
			pstmt.setString(3, reservationVo.getReservationCheckin());
			pstmt.setString(4, reservationVo.getReservationCheckout());
			pstmt.setString(5, reservationVo.getReservationNop());
			pstmt.setString(6, reservationVo.getRequest());
			pstmt.setString(7, reservationVo.getCampCode());
			pstmt.setString(8, reservationVo.getZoneNo());
			pstmt.setString(9, reservationVo.getUserNo());
			result = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		return result;
	}
}
