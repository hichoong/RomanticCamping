package com.syl.board.vo;

public class QuestionBoardVo {

	public QuestionBoardVo() {}
	
	private String qNo;
	private String qTitle;
	private String qContent;
	private String qUpdateDate;
	private String qTag;
	private String qAnswerYN;
	private String qAnswer;
	private String freq;
	private String qWriter;
	private String aWriter;
	private String qCnt;
		
	public QuestionBoardVo(String qNo, String qTitle, String qContent, String qUpdateDate, String qTag,
			String qAnswerYN, String qAnswer, String freq, String qWriter, String aWriter, String qCnt) {
		super();
		this.qNo = qNo;
		this.qTitle = qTitle;
		this.qContent = qContent;
		this.qUpdateDate = qUpdateDate;
		this.qTag = qTag;
		this.qAnswerYN = qAnswerYN;
		this.qAnswer = qAnswer;
		this.freq = freq;
		this.qWriter = qWriter;
		this.aWriter = aWriter;
		this.qCnt = qCnt;
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

	public String getqUpdateDate() {
		return qUpdateDate;
	}


	public void setqUpdateDate(String qUpdateDate) {
		this.qUpdateDate = qUpdateDate;
	}


	public String getqTag() {
		return qTag;
	}


	public void setqTag(String qTag) {
		this.qTag = qTag;
	}


	public String getqAnswerYN() {
		return qAnswerYN;
	}


	public void setqAnswerYN(String qAnswerYN) {
		this.qAnswerYN = qAnswerYN;
	}


	public String getqAnswer() {
		return qAnswer;
	}


	public void setqAnswer(String qAnswer) {
		this.qAnswer = qAnswer;
	}


	public String getFreq() {
		return freq;
	}


	public void setFreq(String freq) {
		this.freq = freq;
	}


	public String getqWriter() {
		return qWriter;
	}


	public void setqWriter(String qWriter) {
		this.qWriter = qWriter;
	}


	public String getaWriter() {
		return aWriter;
	}


	public void setaWriter(String aWriter) {
		this.aWriter = aWriter;
	}


	public String getqCnt() {
		return qCnt;
	}


	public void setqCnt(String qCnt) {
		this.qCnt = qCnt;
	}


	@Override
	public String toString() {
		return "QuestionBoardVo [qNo=" + qNo + ", qTitle=" + qTitle + ", qContent=" + qContent + ", qUpdateDate="
				+ qUpdateDate + ", qTag=" + qTag + ", qAnswerYN=" + qAnswerYN + ", qAnswer=" + qAnswer + ", freq="
				+ freq + ", qWriter=" + qWriter + ", aWriter=" + aWriter + ", qCnt=" + qCnt + "]";
	}
	
	
	
} //class
