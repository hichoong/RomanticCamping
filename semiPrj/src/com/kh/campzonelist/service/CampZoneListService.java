package com.kh.campzonelist.service;

import java.sql.Connection;
import java.util.List;

import com.kh.camplist.campinfo.vo.CampInfoVo;
import com.kh.campzonelist.campzone.vo.CampZoneVo;
import com.kh.campzonelist.repository.CampZoneListDao;
import com.kh.review.repository.ReviewDao;

import static com.kh.common.JDBCTemplate.*;

public class CampZoneListService {
	
	private final CampZoneListDao dao = new CampZoneListDao();

	//구역상세 리스트 조회
	public List<CampZoneVo> selectList(String campCode) {
		Connection conn = getConnection();
		List<CampZoneVo> list = dao.selectList(conn, campCode);
		close(conn);
		return list;
	}

	public CampInfoVo selectCamp(String campCode) {
		Connection conn = getConnection();
		CampInfoVo vo = dao.campSelect(conn, campCode);
		close(conn);
		return vo;
	}

	
}
