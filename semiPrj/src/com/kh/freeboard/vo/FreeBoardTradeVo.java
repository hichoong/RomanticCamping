package com.kh.freeboard.vo;

import javax.servlet.http.Part;

public class FreeBoardTradeVo {

	
	public FreeBoardTradeVo() {}
	
	
	public FreeBoardTradeVo(String no, String type, String title, String content, String price, String writer, String cnt,
			String enrollDate, String status) {
		super();
		this.no = no;
		this.type = type;
		this.title = title;
		this.content = content;
		this.price = price;
		this.writer = writer;
		this.cnt = cnt;
		this.enrollDate = enrollDate;
		this.status = status;
	}



	private String no;
	private String type; //작성기능 : 게시판번호 | 조회기능 : 게시판이름
	private String title;
	private String content;
	private String price;
	private String writer; //작성기능 : 회원번호 | 조회기능 : 회원이름
	private String cnt;
	private String enrollDate;
	private String status;
	
	
	
	public String getNo() {
		return no;
	}
	public void setNo(String no) {
		this.no = no;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getCnt() {
		return cnt;
	}
	public void setCnt(String cnt) {
		this.cnt = cnt;
	}
	public String getEnrollDate() {
		return enrollDate;
	}
	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	@Override
	public String toString() {
		return "FreeBoardVo [no=" + no + ", type=" + type + ", title=" + title + ", content=" + content + ", price="
				+ price + ", writer=" + writer + ", cnt=" + cnt + ", enrollDate=" + enrollDate + ", status=" + status
				+ "]";
	}
	
	
	
}
