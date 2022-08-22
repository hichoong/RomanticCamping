package com.kh.freeboard.vo;

public class FreeBoardRepleVo {

	
	
	public FreeBoardRepleVo() {}
	
	
	public FreeBoardRepleVo(String no, String content, String writer, String enrollDate) {
		super();
		this.no = no;
		this.content = content;
		this.writer = writer;
		this.enrollDate = enrollDate;
	}


	private String no;
	private String content;
	private String writer; //작성기능 : 회원번호 | 조회기능 : 회원이름
	private String enrollDate;
	
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	
	
	@Override
	public String toString() {
		return "FreeBoardRepleVo [no=" + no + ", content=" + content + ", writer=" + writer + ", enrollDate="
				+ enrollDate + "]";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
