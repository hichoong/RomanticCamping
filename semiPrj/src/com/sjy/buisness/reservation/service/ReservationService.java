package com.sjy.buisness.reservation.service;

import com.sjy.buisness.reservation.repository.BsReservationDao;
import com.sjy.buisness.reservation.vo.ReservationVo;
import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.List;

public class ReservationService extends ReservationVo {
	BsReservationDao dao =  new BsReservationDao();
	
	
	public List<ReservationVo> selectAllRsv(int i) {
		Connection conn = null;
		conn = getConnection();
		List<ReservationVo> rvList = null;
		rvList = dao. selectAllRsv(conn, i);
		System.out.println(i+"::rvList_sv::" +rvList);
		return rvList;
	}

}
