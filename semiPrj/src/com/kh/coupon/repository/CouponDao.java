package com.kh.coupon.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.coupon.vo.CouponVo;
import com.kh.member.vo.MemberVo;

public class CouponDao {

	//유저 쿠폰리스트 조회하기
	public List<CouponVo> selectCouponList(Connection conn, MemberVo loginMember) {
		//기본작업
		List<CouponVo> couponVo = new ArrayList<CouponVo>();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//sql 작성하기
		String sql = "SELECT C.C_NAME , C.C_DISCOUNT FROM COUPON_LIST C JOIN USER_COUPON_LIST U ON C.C_CODE = U.C_CODE "
				+ "WHERE U.U_STATUS = 'N' AND U.USER_NO = ?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, loginMember.getNo());
		
		
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JDBCTemplate.close(pstmt);
		}
		
		
		
		return couponVo;
	}
	
}
