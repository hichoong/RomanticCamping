package com.syl.board.vo;

public class QuestionBoardVo {
	
	public QuestionBoardVo() {}

	private String qNo;
	private String qTitle;
	private String qContent;
	private String qWriter;
	private String qCnt;
	private String qUpdateDate;
	
	
	public QuestionBoardVo(String qNo, String qTitle, String qContent, String qWriter, String qCnt,
			String qUpdateDate) {
		super();
		this.qNo = qNo;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qWriter = qWriter;
		this.qCnt = qCnt;
		this.qUpdateDate = qUpdateDate;
	}


	public String getqNo() {
		return qNo;
	}


	public void setqNo(String qNo) {
		this.qNo = qNo;
	}


	public String getqTitle() {
		return qTitle;
	}


	public void setqTitle(String qTitle) {
		this.qTitle = qTitle;
	}


	public String getqContent() {
		return qContent;
	}


	public void setqContent(String qContent) {
		this.qContent = qContent;
	}


	public String getqWriter() {
		return qWriter;
	}


	public void setqWriter(String qWriter) {
		this.qWriter = qWriter;
	}


	public String getqCnt() {
		return qCnt;
	}


	public void setqCnt(String qCnt) {
		this.qCnt = qCnt;
	}


	public String getqUpdateDate() {
		return qUpdateDate;
	}


	public void setqUpdateDate(String qUpdateDate) {
		this.qUpdateDate = qUpdateDate;
	}


	@Override
	public String toString() {
		return "QuestionBoardVo [qNo=" + qNo + ", qTitle=" + qTitle + ", qContent=" + qContent + ", qWriter=" + qWriter
				+ ", qCnt=" + qCnt + ", qUpdateDate=" + qUpdateDate + "]";
	}
	
	
	
} //class
