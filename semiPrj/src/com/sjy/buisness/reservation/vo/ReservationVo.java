package com.sjy.buisness.reservation.vo;

public class ReservationVo {
	private String no;					//예약번호
	private String name;				//예약자
	private String phone;				//전화번호
	private String checkin;				//체크인
	private String checkout;			//체크아웃
	private String nop;					//인원수
	private String request;				//요청사항
	private String reservationDate;		//예약일자
	private String status;				//상태
	private String campCode;			//캠핑장 코드
	private String zoneNo;				//캠핑장 구역 번호
	private String userMo;				//회원번호
	
	public ReservationVo() {}

	public ReservationVo(String no, String name, String phone, String checkin, String checkout, String nop,
			String request, String reservationDate, String status) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.checkin = checkin;
		this.checkout = checkout;
		this.nop = nop;
		this.request = request;
		this.reservationDate = reservationDate;
		this.status = status;
	}

	public ReservationVo(String no, String name, String phone, String checkin, String checkout, String nop,
			String request, String reservationDate, String status, String campCode, String zoneNo, String userMo) {
		super();
		this.no = no;
		this.name = name;
		this.phone = phone;
		this.checkin = checkin;
		this.checkout = checkout;
		this.nop = nop;
		this.request = request;
		this.reservationDate = reservationDate;
		this.status = status;
		this.campCode = campCode;
		this.zoneNo = zoneNo;
		this.userMo = userMo;
	}

	public String getNo() {
		return no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCheckin() {
		return checkin;
	}

	public void setCheckin(String checkin) {
		this.checkin = checkin;
	}

	public String getCheckout() {
		return checkout;
	}

	public void setCheckout(String checkout) {
		this.checkout = checkout;
	}

	public String getNop() {
		return nop;
	}

	public void setNop(String nop) {
		this.nop = nop;
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

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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

	public String getUserMo() {
		return userMo;
	}

	public void setUserMo(String userMo) {
		this.userMo = userMo;
	}

	@Override
	public String toString() {
		return "ReservationVo [no=" + no + ", name=" + name + ", phone=" + phone + ", checkin=" + checkin
				+ ", checkout=" + checkout + ", nop=" + nop + ", request=" + request + ", reservationDate="
				+ reservationDate + ", status=" + status + ", campCode=" + campCode + ", zoneNo=" + zoneNo + ", userMo="
				+ userMo + "]";
	}
	
	
	
}
