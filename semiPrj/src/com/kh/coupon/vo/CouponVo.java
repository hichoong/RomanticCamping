package com.kh.coupon.vo;

public class CouponVo {

	 
	private String couponCode;  //쿠폰번호            
	private String couponName;         //쿠폰이름
	private String couponDiscount;     //할인금액
	private String couponStartDay;     //시작날
	private String couponEndDay;       //만료일
	private String couponStatus;  		//사용가능여부
	
	private String couponDDay;	//만료일-시작일
	
	//생성자
	public CouponVo() {
	
	}

	public CouponVo(String couponCode, String couponName, String couponDiscount, String couponStartDay,
			String couponEndDay, String couponStatus) {
		this.couponCode = couponCode;
		this.couponName = couponName;
		this.couponDiscount = couponDiscount;
		this.couponStartDay = couponStartDay;
		this.couponEndDay = couponEndDay;
		this.couponStatus = couponStatus;
	}
	
	//get, set
	public String getCouponCode() {
		return couponCode;
	}

	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}

	public String getCouponName() {
		return couponName;
	}

	public void setCouponName(String couponName) {
		this.couponName = couponName;
	}

	public String getCouponDiscount() {
		return couponDiscount;
	}

	public void setCouponDiscount(String couponDiscount) {
		this.couponDiscount = couponDiscount;
	}

	public String getCouponStartDay() {
		return couponStartDay;
	}

	public void setCouponStartDay(String couponStartDay) {
		this.couponStartDay = couponStartDay;
	}

	public String getCouponEndDay() {
		return couponEndDay;
	}

	public void setCouponEndDay(String couponEndDay) {
		this.couponEndDay = couponEndDay;
	}

	public String getCouponStatus() {
		return couponStatus;
	}

	public void setCouponStatus(String couponStatus) {
		this.couponStatus = couponStatus;
	}

	public String getCouponDDay() {
		return couponDDay;
	}

	public void setCouponDDay(String couponDDay) {
		this.couponDDay = couponDDay;
	}

	@Override
	public String toString() {
		return "CouponVo [couponCode=" + couponCode + ", couponName=" + couponName + ", couponDiscount="
				+ couponDiscount + ", couponStartDay=" + couponStartDay + ", couponEndDay=" + couponEndDay
				+ ", couponStatus=" + couponStatus + ", couponDDay=" + couponDDay + "]";
	}
	
}
