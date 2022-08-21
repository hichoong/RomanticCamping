package com.kh.order.vo;

public class OrderVo {
	//결제정보 객체에 넣을 컬럼
	private String payCode; //결제번호
	private String reservationNo; //예약번호
	private String payDate; //결제일자
	private String payAmount; //총 금액
	private String payStatus; //결제상태
	private String payMethod; //결제방법
	private String couponCode; //쿠폰코드
	//기본생성자
	public OrderVo() {
	
	}
	//생성자 오버로딩
	public OrderVo(String payCode, String reservationNo, String payDate, String payAmount, String payStatus,
			String payMethod, String couponCode) {
		this.payCode = payCode;
		this.reservationNo = reservationNo;
		this.payDate = payDate;
		this.payAmount = payAmount;
		this.payStatus = payStatus;
		this.payMethod = payMethod;
		this.couponCode = couponCode;
	}
	//get, set
	public String getPayCode() {
		return payCode;
	}
	public void setPayCode(String payCode) {
		this.payCode = payCode;
	}
	public String getReservationNo() {
		return reservationNo;
	}
	public void setReservationNo(String reservationNo) {
		this.reservationNo = reservationNo;
	}
	public String getPayDate() {
		return payDate;
	}
	public void setPayDate(String payDate) {
		this.payDate = payDate;
	}
	public String getPayAmount() {
		return payAmount;
	}
	public void setPayAmount(String payAmount) {
		this.payAmount = payAmount;
	}
	public String getPayStatus() {
		return payStatus;
	}
	public void setPayStatus(String payStatus) {
		this.payStatus = payStatus;
	}
	public String getPayMethod() {
		return payMethod;
	}
	public void setPayMethod(String payMethod) {
		this.payMethod = payMethod;
	}
	public String getCouponCode() {
		return couponCode;
	}
	public void setCouponCode(String couponCode) {
		this.couponCode = couponCode;
	}
	//toString
	
	@Override
	public String toString() {
		return "OrderVo [payCode=" + payCode + ", reservationNo=" + reservationNo + ", payDate=" + payDate
				+ ", payAmount=" + payAmount + ", payStatus=" + payStatus + ", payMethod=" + payMethod + ", couponCode="
				+ couponCode + "]";
	}
	
}
