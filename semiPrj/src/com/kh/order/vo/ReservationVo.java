package com.kh.order.vo;

public class ReservationVo {
	private String reservationNo;
	private String reservationPhone;
	private String reservationCheckin;
	private String reservationCheckout;
	private String reservationNop;
	private String request;
	private String reservationDate;
	private String reservationStatus;
	private String campZone;
	private String zNo;
	private String userNo;

	//생성자
	
	public ReservationVo() {

	}

	public ReservationVo(String reservationNo, String reservationPhone, String reservationCheckin,
			String reservationCheckout, String reservationNop, String request, String reservationDate,
			String reservationStatus, String campZone, String zNo, String userNo) {
		this.reservationNo = reservationNo;
		this.reservationPhone = reservationPhone;
		this.reservationCheckin = reservationCheckin;
		this.reservationCheckout = reservationCheckout;
		this.reservationNop = reservationNop;
		this.request = request;
		this.reservationDate = reservationDate;
		this.reservationStatus = reservationStatus;
		this.campZone = campZone;
		this.zNo = zNo;
		this.userNo = userNo;
	}

	//get, set
	
	public String getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(String reservationNo) {
		this.reservationNo = reservationNo;
	}

	public String getReservationPhone() {
		return reservationPhone;
	}

	public void setReservationPhone(String reservationPhone) {
		this.reservationPhone = reservationPhone;
	}

	public String getReservationCheckin() {
		return reservationCheckin;
	}

	public void setReservationCheckin(String reservationCheckin) {
		this.reservationCheckin = reservationCheckin;
	}

	public String getReservationCheckout() {
		return reservationCheckout;
	}

	public void setReservationCheckout(String reservationCheckout) {
		this.reservationCheckout = reservationCheckout;
	}

	public String getReservationNop() {
		return reservationNop;
	}

	public void setReservationNop(String reservationNop) {
		this.reservationNop = reservationNop;
	}

	public String getRequest() {
		return request;
	}

	public void setRequest(String request) {
		this.request = request;
	}

	public String getReservationDate() {
		return reservationDate;
	}

	public void setReservationDate(String reservationDate) {
		this.reservationDate = reservationDate;
	}

	public String getReservationStatus() {
		return reservationStatus;
	}

	public void setReservationStatus(String reservationStatus) {
		this.reservationStatus = reservationStatus;
	}

	public String getCampZone() {
		return campZone;
	}

	public void setCampZone(String campZone) {
		this.campZone = campZone;
	}

	public String getzNo() {
		return zNo;
	}

	public void setzNo(String zNo) {
		this.zNo = zNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}

	//toString
	@Override
	public String toString() {
		return "ReservationVo [reservationNo=" + reservationNo + ", reservationPhone=" + reservationPhone
				+ ", reservationCheckin=" + reservationCheckin + ", reservationCheckout=" + reservationCheckout
				+ ", reservationNop=" + reservationNop + ", request=" + request + ", reservationDate=" + reservationDate
				+ ", reservationStatus=" + reservationStatus + ", campZone=" + campZone + ", zNo=" + zNo + ", userNo="
				+ userNo + "]";
	}
	
	
	

}
