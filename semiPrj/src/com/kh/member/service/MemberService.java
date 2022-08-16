package com.kh.member.service;

import java.sql.Connection;

import static com.kh.common.JDBCTemplate.*;

import com.kh.member.repository.MemberDao;
import com.kh.member.vo.MemberVo;

public class MemberService {

	private final MemberDao dao = new MemberDao();
	
	public MemberVo login(MemberVo memberVo) {
		
		if(memberVo.getId().length() < 3 || memberVo.getPwd().length() < 4) {
			return null;
		}
		
		Connection conn = getConnection();
		MemberVo vo = dao.login(conn, memberVo);
		
		close(conn);
		
		return vo;
	}

	public int userJoin(MemberVo vo) {

		if(!joinCheck(vo)) return -1;
		
		Connection conn = getConnection();
		
		int dup = new MemberDao().checkDup(conn, vo);
		if(dup != 0) {
			close(conn);
			return -1;
		}
		
		int result = dao.userJoin(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int businessJoin(MemberVo vo) {
				
		if(!joinCheck(vo)) return -1;
		
		Connection conn = getConnection();
		
		int dup = new MemberDao().checkDup(conn, vo);
		if(dup != 0) {
			close(conn);
			return -1;
		}
		
		int result = dao.businessJoin(conn, vo);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	protected boolean joinCheck(MemberVo vo) {
		
		if(vo.getId().length() < 3 || vo.getPwd().length() < 4) {
			return false;
		}
		
		if(vo.getPwd().equals(vo.getPwdCheck()) == false) {
			return false;
		}
		
		if(vo.getName().length() < 1) {
			return false;
		}
		
		if(vo.getPhone().length() != 11) {
			return false;
		}
		
		return true;
	}
	
}
