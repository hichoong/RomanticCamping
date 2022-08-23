package com.kh.campdetail.vo;

public class CampDetailVo {
	
	
	public CampDetailVo() {}
	
	public CampDetailVo(String code, String name, String city, String district, String address, String phone,
			String intro, String rgDate, String refund, String imgPath, String themeCode, String sectionNo,
			String stayMax, String price, String zName, String zNor) {
		super();
		this.code = code;
		this.name = name;
		this.city = city;
		this.district = district;
		this.address = address;
		this.phone = phone;
		this.intro = intro;
		this.rgDate = rgDate;
		this.refund = refund;
		this.imgPath = imgPath;
		this.themeCode = themeCode;
		this.sectionNo = sectionNo;
		this.stayMax = stayMax;
		this.price = price;
		this.zName = zName;
		this.zNor = zNor;
	}
	private String code;
	private String name;
	private String city;
	private String district;
	private String address;
	private String phone;
	private String intro;
	private String rgDate;
	private String refund;
	private String imgPath;
	private String themeCode;
	private String sectionNo;
	private String stayMax;
	private String price;
	private String zName;
	private String zNor;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getIntro() {
		return intro;
	}
	public void setIntro(String intro) {
		this.intro = intro;
	}
	public String getRgDate() {
		return rgDate;
	}
	public void setRgDate(String rgDate) {
		this.rgDate = rgDate;
	}
	public String getRefund() {
		return refund;
	}
	public void setRefund(String refund) {
		this.refund = refund;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public String getThemeCode() {
		return themeCode;
	}
	public void setThemeCode(String themeCode) {
		this.themeCode = themeCode;
	}
	public String getSectionNo() {
		return sectionNo;
	}
	public void setSectionNo(String sectionNo) {
		this.sectionNo = sectionNo;
	}
	public String getStayMax() {
		return stayMax;
	}
	public void setStayMax(String stayMax) {
		this.stayMax = stayMax;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getzName() {
		return zName;
	}
	public void setzName(String zName) {
		this.zName = zName;
	}
	public String getzNor() {
		return zNor;
	}
	public void setzNor(String zNor) {
		this.zNor = zNor;
	}
	@Override
	public String toString() {
		return "CampDetailVo [code=" + code + ", name=" + name + ", city=" + city + ", district=" + district
				+ ", address=" + address + ", phone=" + phone + ", intro=" + intro + ", rgDate=" + rgDate + ", refund="
				+ refund + ", imgPath=" + imgPath + ", themeCode=" + themeCode + ", sectionNo=" + sectionNo
				+ ", stayMax=" + stayMax + ", price=" + price + ", zName=" + zName + ", zNor=" + zNor + "]";
	}
	
	
}
