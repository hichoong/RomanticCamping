package com.kh.review.vo;

public class ReviewVo {
	
	public ReviewVo() {
		
	}
	
	public ReviewVo(String rNo, String reNo, String rDate, String rContent, String rNum, String rUpdated,
			String rStatus) {
		super();
		this.rNo = rNo;
		this.reNo = reNo;
		this.rDate = rDate;
		this.rContent = rContent;
		this.rNum = rNum;
		this.rUpdated = rUpdated;
		this.rStatus = rStatus;
	}

	private String rNo;
	private String reNo;
	private String rDate;
	private String rContent;
	private String rNum;
	private String rUpdated;
	private String rStatus;
	
	public String getrNo() {
		return rNo;
	}

	public void setrNo(String rNo) {
		this.rNo = rNo;
	}

	public String getReNo() {
		return reNo;
	}

	public void setReNo(String reNo) {
		this.reNo = reNo;
	}

	public String getrDate() {
		return rDate;
	}

	public void setrDate(String rDate) {
		this.rDate = rDate;
	}

	public String getrContent() {
		return rContent;
	}

	public void setrContent(String rContent) {
		this.rContent = rContent;
	}

	public String getrNum() {
		return rNum;
	}

	public void setrNum(String rNum) {
		this.rNum = rNum;
	}

	public String getrUpdated() {
		return rUpdated;
	}

	public void setrUpdated(String rUpdated) {
		this.rUpdated = rUpdated;
	}

	public String getrStatus() {
		return rStatus;
	}

	public void setrStatus(String rStatus) {
		this.rStatus = rStatus;
	}

	@Override
	public String toString() {
		return "ReviewVo [rNo=" + rNo + ", reNo=" + reNo + ", rDate=" + rDate + ", rContent=" + rContent + ", rNum="
				+ rNum + ", rUpdated=" + rUpdated + ", rStatus=" + rStatus + "]";
	}
	
	
	
}
