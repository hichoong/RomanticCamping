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

}
