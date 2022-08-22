package com.sjy.buisness.hashmapping.vo;

public class HashMappingVo {
	private String campCode;
	private String htCode;
	
	public HashMappingVo() {}

	public HashMappingVo(String campCode, String htCode) {
		super();
		this.campCode = campCode;
		this.htCode = htCode;
	}

	public String getCampCode() {
		return campCode;
	}

	public void setCampCode(String campCode) {
		this.campCode = campCode;
	}

	public String getHtCode() {
		return htCode;
	}

	public void setHtCode(String htCode) {
		this.htCode = htCode;
	}

	@Override
	public String toString() {
		return "HashMappingVo [campCode=" + campCode + ", htCode=" + htCode + "]";
	}
	
	
	
}
