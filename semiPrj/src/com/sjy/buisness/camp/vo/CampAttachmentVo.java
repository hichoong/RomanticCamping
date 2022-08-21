package com.sjy.buisness.camp.vo;

public class CampAttachmentVo {
	
	private String zaNo;			//이미지 번호
	private String zaOrignName;		//실제 이름
	private String zaChangeName;	//변경 이름
	private String zaPath;			//파일 경로
	private String uploadDate;		//업로드 날짜
	private String imgType;			//이미지 타입(대표:M , 실내: I , 입구: E)
	private String status;			//상태 
	
	public CampAttachmentVo() {}

	public CampAttachmentVo(String zaNo, String zaOrignName, String zaChangeName, String zaPath, String uploadDate,
			String imgType, String status) {
		super();
		this.zaNo = zaNo;
		this.zaOrignName = zaOrignName;
		this.zaChangeName = zaChangeName;
		this.zaPath = zaPath;
		this.uploadDate = uploadDate;
		this.imgType = imgType;
		this.status = status;
	}

	public String getZaNo() {
		return zaNo;
	}

	public void setZaNo(String zaNo) {
		this.zaNo = zaNo;
	}

	public String getZaOrignName() {
		return zaOrignName;
	}

	public void setZaOrignName(String zaOrignName) {
		this.zaOrignName = zaOrignName;
	}

	public String getZaChangeName() {
		return zaChangeName;
	}

	public void setZaChangeName(String zaChangeName) {
		this.zaChangeName = zaChangeName;
	}

	public String getZaPath() {
		return zaPath;
	}

	public void setZaPath(String zaPath) {
		this.zaPath = zaPath;
	}

	public String getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(String uploadDate) {
		this.uploadDate = uploadDate;
	}

	public String getImgType() {
		return imgType;
	}

	public void setImgType(String imgType) {
		this.imgType = imgType;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "CampAttachmentVo [zaNo=" + zaNo + ", zaOrignName=" + zaOrignName + ", zaChangeName=" + zaChangeName
				+ ", zaPath=" + zaPath + ", uploadDate=" + uploadDate + ", imgType=" + imgType + ", status=" + status
				+ "]";
	}
	
	
	
}
