package com.kh.campzonelist.service;

import java.sql.Connection;
import java.util.List;

import com.kh.campzonelist.campzone.vo.CampZoneVo;
import com.kh.campzonelist.repository.CampZoneListDao;

import static com.kh.common.JDBCTemplate.*;

public class CampZoneListService {
	
	private final CampZoneListDao dao = new CampZoneListDao();

	//구역상세 리스트 조회
	public List<CampZoneVo> selectList(String num) {

		Connection conn = getConnection();
		List<CampZoneVo> list = dao.selectList(conn, num);
		close(conn);
		return list;
	}

}
