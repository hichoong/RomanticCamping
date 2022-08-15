package com.kh.member.repository;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.member.vo.MemberVo;

public class MemberDao {
	
	public MemberVo login(Connection conn, MemberVo mvo) {

		String sql = "SELECT NO, ID, NAME, TO_CHAR(ENROLL_DATE, 'YY/MM/DD') AS ENROLL_DATE FROM E_MEMBER WHERE ID=? AND PWD = ?";
		
		MemberVo vo = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mvo.getId());
			pstmt.setString(2, mvo.getPwd());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MemberVo();
				vo.setNo(rs.getString("NO"));
				vo.setId(rs.getString("ID"));
				vo.setName(rs.getString("NAME"));
				vo.setJoinDate(rs.getString("ENROLL_DATE"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return vo;
	}

}
