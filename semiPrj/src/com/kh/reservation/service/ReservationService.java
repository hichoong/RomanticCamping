package com.kh.reservation.service;

import java.sql.Connection;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;
import com.kh.order.vo.ReservationVo;
import com.kh.reservation.repository.ReservationDao;

public class ReservationService {

	ReservationDao dao = new ReservationDao();
	
	public List<ReservationVo> reservationCheck(String no, String type) {

		Connection conn = getConnection();
		List<ReservationVo> list = dao.reservationCheck(conn, no, type);
		
		close(conn);
		
		return list;
	}

	public int cancleReservation(String no) {

		Connection conn = getConnection();
		int result = dao.cancleReservation(conn, no);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public String enrollCheck(String reservationNo) {
		
		Connection conn = getConnection();
		String result = dao.enrollCheck(conn, reservationNo);
		
		close(conn);
		
		return result;
	}

}
