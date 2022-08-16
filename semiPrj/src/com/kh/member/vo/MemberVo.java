package com.kh.member.vo;

public class MemberVo {

	private String no;
	private String type;
	private String id;
	private String pwd;
	private String pwdCheck;
	private String name;
	private String phone;
	private String email;
	private String birthday;
	private String gender;
	private String grade;
	private String joinDate;
	private String status;
	
	public MemberVo() {
		
	}
	
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
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id.replaceAll(" ", "");
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd.replaceAll(" ", "");
	}
	public String getPwdCheck() {
		return pwdCheck;
	}
	public void setPwdCheck(String pwdCheck) {
		this.pwdCheck = pwdCheck.replaceAll(" ", "");
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name.trim();
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone.replaceAll(" ", "");
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email.replaceAll(" ", "");
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday.replaceAll("-", "");
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public String getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	@Override
	public String toString() {
		return "MemberVo [no=" + no + ", type=" + type + ", id=" + id + ", pwd=" + pwd + ", pwdCheck=" + pwdCheck
				+ ", name=" + name + ", phone=" + phone + ", email=" + email + ", birthday=" + birthday + ", gender="
				+ gender + ", grade=" + grade + ", joinDate=" + joinDate + ", status=" + status + "]";
	}
	
}
