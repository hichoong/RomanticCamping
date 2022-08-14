package com.kh.camplist.hashtag.vo;

public class HashTagVo {
	
	public HashTagVo() {
		
	}
	
	public HashTagVo(String htCode, String htName) {
		super();
		this.htCode = htCode;
		this.htName = htName;
	}

	private String htCode;
	private String htName;
	public String getHtCode() {
		return htCode;
	}

	public void setHtCode(String htCode) {
		this.htCode = htCode;
	}

	public String getHtName() {
		return htName;
	}

	public void setHtName(String htName) {
		this.htName = htName;
	}

	@Override
	public String toString() {
		return "HashTagVo [htCode=" + htCode + ", htName=" + htName + "]";
	}
	
}
