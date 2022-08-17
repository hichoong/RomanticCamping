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

	protected boolean etcCheck(MemberVo vo) {
		
		if(vo.getName().length() < 1) {
			return false;
		}
		
		if(vo.getPhone().length() != 11) {
			return false;
		}
		
		return true;
	}
	
	protected boolean idCheck(Connection conn, MemberVo vo) {
			
		if(vo.getId().length() < 3) {
			return false;
		}
		
		int dup = new MemberDao().checkDup(conn, vo);
		if(dup != 0) {
			close(conn);
			return false;
		}
		
		return true;
	}
	
	protected boolean pwdCheck(MemberVo vo) {
		
		if(vo.getPwd().length() < 4) {
			return false;
		}
		
		if(vo.getPwd().equals(vo.getPwdCheck()) == false) {
			return false;
		}
		
		return true;
	}
	
	public int userJoin(MemberVo vo) {

		if(!pwdCheck(vo)) return -1;
		if(!etcCheck(vo)) return -1;
		
		Connection conn = getConnection();
		
		if(!idCheck(conn, vo)) {
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
				
		if(!pwdCheck(vo)) return -1;
		if(!etcCheck(vo)) return -1;
		
		Connection conn = getConnection();
		
		if(!idCheck(conn, vo)) {
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

	public MemberVo edit(MemberVo vo) {
		
		if(!etcCheck(vo)) return null;
		
		Connection conn = getConnection();
		int result = new MemberDao().edit(conn, vo);
		MemberVo updateVo = null;
		
		if(result == 1) {
			commit(conn);
			updateVo = selectOneByNo(vo.getNo());
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return updateVo;
	}
	
	public MemberVo selectOneByNo(String no) {
		
		Connection conn = getConnection();
		MemberVo vo = new MemberDao().selectOneByNo(conn, no);
		close(conn);
		
		return vo;
	}
	
	
	
}
