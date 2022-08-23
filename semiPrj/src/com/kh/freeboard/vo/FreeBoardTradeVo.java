package com.kh.freeboard.vo;

import javax.servlet.http.Part;

public class FreeBoardTradeVo {

	
	public FreeBoardTradeVo() {}
	

	
	

	public FreeBoardTradeVo(String no, String title, String content, String price, String writer, String cnt,
			String enrollDate, String status) {
		super();
		this.no = no;
		this.title = title;
		this.content = content;
		this.price = price;
		this.writer = writer;
		this.cnt = cnt;
		this.enrollDate = enrollDate;
		this.status = status;
	}



	
	
	
	
	public FreeBoardTradeVo(String changeName, String no, String title, String content, String price, String writer,
			String cnt, String enrollDate, String status) {
		super();
		this.changeName = changeName;
		this.no = no;
		this.title = title;
		this.content = content;
		this.price = price;
		this.writer = writer;
		this.cnt = cnt;
		this.enrollDate = enrollDate;
		this.status = status;
	}

	//끝 
	
	
	
	private String no;
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
		return "FreeBoardTradeVo [no=" + no + ", title=" + title + ", content=" + content + ", price=" + price
				+ ", writer=" + writer + ", cnt=" + cnt + ", enrollDate=" + enrollDate + ", status=" + status + "]";
	}
	
	
	//메인글 사진 가져오기 위해 추가한 내용
	private String changeName;
		
		
	public String getChangeName() {
			return changeName;
		}
	
	public void setChangeName(String changeName) {
		this.changeName = changeName;
	}
	
	
	
	
}
