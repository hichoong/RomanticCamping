package com.kh.coupon.service;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

import com.kh.common.JDBCTemplate;
import com.kh.coupon.repository.CouponDao;
import com.kh.coupon.vo.CouponVo;
import com.kh.member.vo.MemberVo;

public class CouponService {

	//유저 쿠폰 사용
	public int useCoupon(String no, String couponCode) {
		//커넥션 얻기
		Connection conn = null;
		conn = JDBCTemplate.getConnection();
		int result = new CouponDao().useCoupon(conn, no, couponCode);
		if(result == 1) {
			JDBCTemplate.commit(conn);
		}else {
			JDBCTemplate.rollback(conn);
		}
		return result;
	}

	//유저 쿠폰리스트 보여주기
	public List<CouponVo> selectCouponList(String no) {

		Connection conn = JDBCTemplate.getConnection();
		List<CouponVo> list = new CouponDao().selectCouponList(conn, no);
		
		JDBCTemplate.close(conn);
		
		return list;
	}
}
