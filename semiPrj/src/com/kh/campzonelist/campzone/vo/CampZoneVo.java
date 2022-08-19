package com.kh.campzonelist.campzone.vo;

public class CampZoneVo {
	
	public CampZoneVo() {
		
	}
	
	public CampZoneVo(String zoneNo, String zoneStayMax, String zonePrice, String zoneName, String zoneNor,
			String campCode) {
		super();
		this.zoneNo = zoneNo;
		this.zoneStayMax = zoneStayMax;
		this.zonePrice = zonePrice;
		this.zoneName = zoneName;
		this.zoneNor = zoneNor;
		this.campCode = campCode;
	}
	
	private String zoneNo; 
	private String zoneStayMax;
	private String zonePrice;
	private String zoneName;
	private String zoneNor;
	private String campCode;
	
	public String getZoneNo() {
		return zoneNo;
	}

	public void setZoneNo(String zoneNo) {
		this.zoneNo = zoneNo;
	}

	public String getZoneStayMax() {
		return zoneStayMax;
	}

	public void setZoneStayMax(String zoneStayMax) {
		this.zoneStayMax = zoneStayMax;
	}

	public String getZonePrice() {
		return zonePrice;
	}

	public void setZonePrice(String zonePrice) {
		this.zonePrice = zonePrice;
	}

	public String getZoneName() {
		return zoneName;
	}

	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}

	public String getZoneNor() {
		return zoneNor;
	}

	public void setZoneNor(String zoneNor) {
		this.zoneNor = zoneNor;
	}

	public String getCampCode() {
		return campCode;
	}

	public void setCampCode(String campCode) {
		this.campCode = campCode;
	}

	@Override
	public String toString() {
		return "CampZoneVo [zoneNo=" + zoneNo + ", zoneStayMax=" + zoneStayMax + ", zonePrice=" + zonePrice
				+ ", zoneName=" + zoneName + ", zoneNor=" + zoneNor + ", campCode=" + campCode + "]";
	}
	
	
}
