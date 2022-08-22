package com.kh.coupon.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.coupon.repository.CouponDao;
import com.kh.coupon.vo.CouponVo;
import com.kh.member.vo.MemberVo;

public class CouponService {

	//유저 쿠폰리스트 보여주기
	public List<CouponVo> selectCouponList (MemberVo loginMember) {
		
		//커넥션 얻기
		Connection conn = null;
		
		conn = JDBCTemplate.getConnection();
		//유저 쿠폰리스트 조회하기
		List<CouponVo> couponVo = new ArrayList<CouponVo>();
		couponVo = new CouponDao().selectCouponList(conn, loginMember);
	
	
		return couponVo;
	}
	
		
	
	
	
}
