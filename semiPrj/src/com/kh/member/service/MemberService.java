package com.kh.member.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;

import com.kh.member.repository.MemberDao;
import com.kh.member.vo.MemberVo;

public class MemberService {

	private final MemberDao dao = new MemberDao();
	
	public MemberVo login(MemberVo memberVo) {
		
		if(memberVo.getId().length() < 1 || memberVo.getPwd().length() < 1) {
			return null;
		}
		
		Connection conn = getConnection();
		MemberVo vo = dao.login(conn, memberVo);
		
		close(conn);
		
		return vo;
	}

}
