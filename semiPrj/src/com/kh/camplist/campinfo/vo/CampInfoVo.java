package com.kh.camplist.campinfo.vo;

public class CampInfoVo {

	public CampInfoVo() {
		
	}
	
	public CampInfoVo(String campCode, String campName, String city, String district, String campAddress,
			String campPhone, String campIntro, String rgDate, String campRefund, String campImgpath, String themeCode,
			String campUpdated, String campStatus) {
		super();
		this.campCode = campCode;
		this.campName = campName;
		this.city = city;
		this.district = district;
		this.campAddress = campAddress;
		this.campPhone = campPhone;
		this.campIntro = campIntro;
		this.rgDate = rgDate;
		this.campRefund = campRefund;
		this.campImgpath = campImgpath;
		this.themeCode = themeCode;
		this.campUpdated = campUpdated;
		this.campStatus = campStatus;
	}

	private String campCode;
	private String campName;
	private String city;
	private String district;
	private String campAddress;
	private String campPhone;
	private String campIntro;
	private String rgDate;
	private String campRefund;
	private String campImgpath;
	private String themeCode;
	private String campUpdated;
	private String campStatus;
	
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

	public String getCampImgpath() {
		return campImgpath;
	}

	public void setCampImgpath(String campImgpath) {
		this.campImgpath = campImgpath;
	}

	public String getThemeCode() {
		return themeCode;
	}

	public void setThemeCode(String themeCode) {
		this.themeCode = themeCode;
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
		return "CampInfoVo [campCode=" + campCode + ", campName=" + campName + ", city=" + city + ", district="
				+ district + ", campAddress=" + campAddress + ", campPhone=" + campPhone + ", campIntro=" + campIntro
				+ ", rgDate=" + rgDate + ", campRefund=" + campRefund + ", campImgpath=" + campImgpath + ", themeCode="
				+ themeCode + ", campUpdated=" + campUpdated + ", campStatus=" + campStatus + "]";
	}
	
}
