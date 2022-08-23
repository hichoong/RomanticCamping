package com.kh.order.service;

import java.sql.Connection;

import com.kh.common.JDBCTemplate;
import com.kh.order.repository.OrderDao;
import com.kh.order.vo.OrderVo;
import com.kh.order.vo.ReservationVo;

public class OrderService {
	
	//결제정보에 들어갈 비지니스 로직
	public int insertPayment (OrderVo orderVo) {
		//커넥션 준비
		Connection conn = null;
		conn = JDBCTemplate.getConnection();		
		int result = new OrderDao().insertPayment(conn,orderVo);
		if(result == 1) {
			JDBCTemplate.commit(conn);			
		}else {
			JDBCTemplate.rollback(conn);			
		}
		JDBCTemplate.close(conn);
		return result;			
	}
	//Reservation 테이블에 들어갈 비즈니스 로직 
	public int insertReservation(ReservationVo reservationVo) {
		Connection conn = null;
		conn = JDBCTemplate.getConnection();
		int result = new OrderDao().insertReservation(conn,reservationVo);
		if(result == 1) {
			JDBCTemplate.commit(conn);				
		}else {
			JDBCTemplate.rollback(conn);								
		}
		JDBCTemplate.close(conn);
		return result;
	}
}
