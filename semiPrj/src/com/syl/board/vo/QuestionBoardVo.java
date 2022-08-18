package com.syl.board.vo;

public class QuestionBoardVo {

	private String qestionNo;
	private String qestionTitle;
	private String qestionContent;
	private String qestionWriter;
	private String qestionEnrollDate;
	private String qestionCnt;
	
	
	public QuestionBoardVo(String qestionNo, String qestionTitle, String qestionContent, String qestionWriter,
			String qestionEnrollDate, String qestionCnt) {
		super();
		this.qestionNo = qestionNo;
		this.qestionTitle = qestionTitle;
		this.qestionContent = qestionContent;
		this.qestionWriter = qestionWriter;
		this.qestionEnrollDate = qestionEnrollDate;
		this.qestionCnt = qestionCnt;
	}


	public String getQestionNo() {
		return qestionNo;
	}


	public void setQestionNo(String qestionNo) {
		this.qestionNo = qestionNo;
	}


	public String getQestionTitle() {
		return qestionTitle;
	}


	public void setQestionTitle(String qestionTitle) {
		this.qestionTitle = qestionTitle;
	}


	public String getQestionContent() {
		return qestionContent;
	}


	public void setQestionContent(String qestionContent) {
		this.qestionContent = qestionContent;
	}


	public String getQestionWriter() {
		return qestionWriter;
	}


	public void setQestionWriter(String qestionWriter) {
		this.qestionWriter = qestionWriter;
	}


	public String getQestionEnrollDate() {
		return qestionEnrollDate;
	}


	public void setQestionEnrollDate(String qestionEnrollDate) {
		this.qestionEnrollDate = qestionEnrollDate;
	}


	public String getQestionCnt() {
		return qestionCnt;
	}


	public void setQestionCnt(String qestionCnt) {
		this.qestionCnt = qestionCnt;
	}


	@Override
	public String toString() {
		return "QestionBoardVo [qestionNo=" + qestionNo + ", qestionTitle=" + qestionTitle + ", qestionContent="
				+ qestionContent + ", qestionWriter=" + qestionWriter + ", qestionEnrollDate=" + qestionEnrollDate
				+ ", qestionCnt=" + qestionCnt + "]";
	}
	

	
} //class
