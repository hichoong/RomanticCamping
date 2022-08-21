package com.kh.member.service;

import java.sql.Connection;
import java.util.List;

import static com.kh.common.JDBCTemplate.*;

import com.kh.camplist.campinfo.vo.CampInfoVo;
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
	
	protected boolean idCheck(Connection conn, String id) {
			
		if(id.length() < 3) {
			return false;
		}
		
		int dup = new MemberDao().checkDup(conn, id);
		if(dup != 0) {
			close(conn);
			return false;
		}
		
		return true;
	}
	
	protected boolean pwdCheck(String pwd, String pwdCheck) {
		
		if(pwd.length() < 4) {
			return false;
		}
		
		if(pwd.equals(pwdCheck) == false) {
			return false;
		}
		
		return true;
	}
	
	public int userJoin(MemberVo vo) {

		if(!pwdCheck(vo.getPwd(), vo.getPwdCheck())) return -1;
		if(!etcCheck(vo)) return -1;
		
		Connection conn = getConnection();
		
		if(!idCheck(conn, vo.getId())) {
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
				
		if(!pwdCheck(vo.getPwd(), vo.getPwdCheck())) return -1;
		if(!etcCheck(vo)) return -1;
		
		Connection conn = getConnection();
		
		if(!idCheck(conn, vo.getId())) {
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

	public int changePwd(String originPwd, String newPwd, String newPwdCheck, String id) {

		if(originPwd.length() < 4) return -1;
		if(!pwdCheck(newPwd, newPwdCheck)) return -1;
		
		Connection conn = getConnection();
		int result = dao.changePwd(conn, originPwd, newPwd, id);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public int quit(String no) {
		
		Connection conn = getConnection();
		int result = dao.quit(conn, no);
		
		if(result == 1) {
			commit(conn);
		} else {
			rollback(conn);
		}
		
		close(conn);
		
		return result;
	}

	public String findId(String name, String phone) {

		Connection conn = getConnection();
		String id = dao.findId(conn, name, phone);
		
		close(conn);
		
		return id;
	}

	public String findPwd(String id, String name, String phone) {
		
		Connection conn = getConnection();
		String pwd = dao.findPwd(conn, id, name, phone);
		
		close(conn);
		
		return pwd;
	}

	public List<CampInfoVo> getFavorite(String no) {
		
		Connection conn = getConnection();
		List<CampInfoVo> list = dao.getFavorite(conn, no);
		
		close(conn);
		
		return list;
	}
	
}
