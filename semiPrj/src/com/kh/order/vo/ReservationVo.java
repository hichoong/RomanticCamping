package com.kh.order.vo;

public class ReservationVo {
	private String reservationNo;
	private String reservationPhone;	//예약한 사람의 전화번호
	private String reservationCheckin;
	private String reservationCheckout;
	private String reservationNop;
	private String request;
	private String reservationDate;		//예약을 한 일자
	private String reservationStatus;	//처리상태
	private String campCode;	//캠핑장코드
	private String zoneNo;			//구역번호
	private String userNo;		//유저번호
	
	private String campName;
	private String campPhone;
	private String campAddr;
	private String zoneName;
	
	//생성자
	public ReservationVo() {

	}

	public ReservationVo(String reservationNo, String reservationPhone, String reservationCheckin,
			String reservationCheckout, String reservationNop, String request, String reservationDate,
			String reservationStatus, String campCode, String zoneNo, String userNo) {
		this.reservationNo = reservationNo;
		this.reservationPhone = reservationPhone;
		this.reservationCheckin = reservationCheckin;
		this.reservationCheckout = reservationCheckout;
		this.reservationNop = reservationNop;
		this.request = request;
		this.reservationDate = reservationDate;
		this.reservationStatus = reservationStatus;
		this.campCode = campCode;
		this.zoneNo = zoneNo;
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

	public String getCampCode() {
		return campCode;
	}

	public void setCampCode(String campCode) {
		this.campCode = campCode;
	}

	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getUserNo() {
		return userNo;
	}

	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	
	public String getCampName() {
		return campName;
	}

	public void setCampName(String campName) {
		this.campName = campName;
	}

	public String getCampPhone() {
		return campPhone;
	}

	public void setCampPhone(String campPhone) {
		this.campPhone = campPhone;
	}

	public String getCampAddr() {
		return campAddr;
	}

	public void setCampAddr(String campAddr) {
		this.campAddr = campAddr;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	@Override
	public String toString() {
		return "ReservationVo [reservationNo=" + reservationNo + ", reservationPhone=" + reservationPhone
				+ ", reservationCheckin=" + reservationCheckin + ", reservationCheckout=" + reservationCheckout
				+ ", reservationNop=" + reservationNop + ", request=" + request + ", reservationDate=" + reservationDate
				+ ", reservationStatus=" + reservationStatus + ", campCode=" + campCode + ", zoneNo=" + zoneNo
				+ ", userNo=" + userNo + ", campName=" + campName + ", campPhone=" + campPhone + ", campAddr="
				+ campAddr + ", zoneName=" + zoneName + "]";
	}

}
