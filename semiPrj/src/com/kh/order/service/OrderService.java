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
		//Dao 호출하기
		
		int result = new OrderDao().insertPayment(conn,orderVo);
		
		//잘 됐을 시 커밋 
		JDBCTemplate.commit(conn);
		//오류 시 롤백
		JDBCTemplate.rollback(conn);
		return result;
		
		
	}

	
	//Reservation 테이블에 들어갈 비즈니스 로직 
	public int insertReservation(ReservationVo reservationVo) {

		//커넥션 준비
				Connection conn = null;
				conn = JDBCTemplate.getConnection();
				//Dao 호출하기
				
				int result = new OrderDao().insertReservation(conn,reservationVo);
				
				//잘 됐을 시 커밋 
				JDBCTemplate.commit(conn);
				//오류 시 롤백
				JDBCTemplate.rollback(conn);
				
				return result;
		
				
	}
	
}
