package com.kh.member.repository;

import static com.kh.common.JDBCTemplate.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kh.member.vo.MemberVo;

public class MemberDao {
	
	public MemberVo login(Connection conn, MemberVo mvo) {

		String sql = "SELECT NO, TYPE, ID, NAME, PHONE, EMAIL, BIRTHDAY, GENDER, GRADE, TO_CHAR(JOIN_DATE, 'YY/MM/DD') AS JOIN_DATE FROM MEMBER WHERE ID=? AND PWD = ?";
		
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
				vo.setType(rs.getString("TYPE"));
				vo.setId(rs.getString("ID"));
				vo.setName(rs.getString("NAME"));
				vo.setPhone(rs.getString("PHONE"));
				vo.setEmail(rs.getString("EMAIL"));
				vo.setPhone(rs.getString("BIRTHDAY"));
				vo.setPhone(rs.getString("GENDER"));
				vo.setPhone(rs.getString("GRADE"));
				vo.setJoinDate(rs.getString("JOIN_DATE"));
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return vo;
	}

	public int userJoin(Connection conn, MemberVo vo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "INSERT INTO MEMBER(NO, TYPE, ID, PWD, NAME, PHONE, EMAIL, BIRTHDAY, GENDER) VALUES (SEQ_MEMBER_NO.NEXTVAL, 'U', ?, ?, ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getEmail());
			pstmt.setString(6, vo.getBirthday());
			pstmt.setString(7, vo.getGender());
			
			result = pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int businessJoin(Connection conn, MemberVo vo) {
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			String sql = "INSERT INTO MEMBER(NO, TYPE, ID, PWD, NAME, PHONE, EMAIL) VALUES (SEQ_MEMBER_NO.NEXTVAL, 'B', ?, ?, ?, ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			pstmt.setString(2, vo.getPwd());
			pstmt.setString(3, vo.getName());
			pstmt.setString(4, vo.getPhone());
			pstmt.setString(5, vo.getEmail());
			
			result = pstmt.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}

	public int checkDup(Connection conn, MemberVo vo) {
		String sql = "SELECT COUNT(ID) DUP FROM MEMBER WHERE ID=?";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		int n = -1;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getId());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				n = rs.getInt("DUP");
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
			close(rs);
		}
		
		return n;
	}

}
