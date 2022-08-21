package com.kh.coupon.vo;

public class UserCouponVo {

	private String userNo;  	// 유저번호          
	private String  couponCode;      //쿠폰번호   
	private String  userStatus;     //유저사용여부

	
	//기본생성자
	public UserCouponVo() {
	
	}


	public UserCouponVo(String userNo, String couponCode, String userStatus) {
		this.userNo = userNo;
		this.couponCode = couponCode;
		this.userStatus = userStatus;
	}


	//get, set
	
	public String getUserNo() {
		return userNo;
	}


	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}


	public String getCouponCode() {
		return couponCode;
	}


	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}


	public String getUserStatus() {
		return userStatus;
	}


	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}


	@Override
	public String toString() {
		return "UserCouponVo [userNo=" + userNo + ", couponCode=" + couponCode + ", userStatus=" + userStatus + "]";
	}
	
	
	
	
	
	
}