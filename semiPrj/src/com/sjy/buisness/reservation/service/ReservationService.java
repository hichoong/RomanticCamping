package com.sjy.buisness.reservation.service;

import com.sjy.buisness.reservation.repository.BsReservationDao;
import com.sjy.buisness.reservation.vo.ReservationVo;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;

public class ReservationService extends ReservationVo {
	BsReservationDao dao =  new BsReservationDao();
	
	
	public ReservationVo selectAllRsv(String bsNo) {
		Connection conn = null;
		conn = getConnection();
		
		ReservationVo rsvVo = dao. selectAllRsv(conn, bsNo);
		
		return rsvVo;
	}

}
