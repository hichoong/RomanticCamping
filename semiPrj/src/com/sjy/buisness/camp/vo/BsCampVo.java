package com.sjy.buisness.camp.vo;

public class BsCampVo {
	
	private String campCode; 		//캠핑장 코드/번호
	private String campName;		//캠핑장 이름
	private String city;			//시/도
	private String district;		//구/군
	private String campAddress;		//상세주소
	private String campPhone;		//전화번호
	private String campIntro;		//시설소개
	private String campFacility; 	//시설현황
	private String rgDate;			//등록일
	private String campRefund;		//환불규정
	private String campImgPath;		//대표이미지
	private String theme;			//테마
	private String campUpdated;		//최근수정일
	private String campStatus;		//상태
	
	public BsCampVo() {}

	public BsCampVo(String campCode, String campName, String city, String district, String campAddress,
			String campPhone, String campIntro, String campFacility, String rgDate, String campRefund,
			String campImgPath,String theme, String campUpdated, String campStatus) {
		super();
		this.campCode = campCode;
		this.campName = campName;
		this.city = city;
		this.district = district;
		this.campAddress = campAddress;
		this.campPhone = campPhone;
		this.campIntro = campIntro;
		this.campFacility = campFacility;
		this.rgDate = rgDate;
		this.campRefund = campRefund;
		this.campImgPath = campImgPath;
		this.theme = theme;
		this.campUpdated = campUpdated;
		this.campStatus = campStatus;
	}

	public String getCampCode() {
		return campCode;
	}

	public void setCampCode(String campCode) {
		this.campCode = campCode;
	}

	public String getCampName() {
		return campName;
	}

	public void setCampName(String campName) {
		this.campName = campName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getCampAddress() {
		return campAddress;
	}

	public void setCampAddress(String campAddress) {
		this.campAddress = campAddress;
	}

	public String getCampPhone() {
		return campPhone;
	}

	public void setCampPhone(String campPhone) {
		this.campPhone = campPhone;
	}

	public String getCampIntro() {
		return campIntro;
	}

	public void setCampIntro(String campIntro) {
		this.campIntro = campIntro;
	}

	public String getCampFacility() {
		return campFacility;
	}

	public void setCampFacility(String campFacility) {
		this.campFacility = campFacility;
	}

	public String getRgDate() {
		return rgDate;
	}

	public void setRgDate(String rgDate) {
		this.rgDate = rgDate;
	}

	public String getCampRefund() {
		return campRefund;
	}

	public void setCampRefund(String campRefund) {
		this.campRefund = campRefund;
	}

	public String getCampImgPath() {
		return campImgPath;
	}

	public void setCampImgPath(String campImgPath) {
		this.campImgPath = campImgPath;
	}

	
	public String getTheme() {
		return theme;
	}

	public void setTheme(String theme) {
		this.theme = theme;
	}

	public String getCampUpdated() {
		return campUpdated;
	}

	public void setCampUpdated(String campUpdated) {
		this.campUpdated = campUpdated;
	}

	
	public String getCampStatus() {
		return campStatus;
	}

	public void setCampStatus(String campStatus) {
		this.campStatus = campStatus;
	}

	@Override
	public String toString() {
		return "BsCampVo [campCode=" + campCode + ", campName=" + campName + ", city=" + city + ", district=" + district
				+ ", campAddress=" + campAddress + ", campPhone=" + campPhone + ", campIntro=" + campIntro
				+ ", campFacility=" + campFacility + ", rgDate=" + rgDate + ", campRefund=" + campRefund
				+ ", campImgPath=" + campImgPath + ", theme=" + theme + ", campUpdated=" + campUpdated + ", campStatus="
				+ campStatus + "]";
	}
	
	
	
}