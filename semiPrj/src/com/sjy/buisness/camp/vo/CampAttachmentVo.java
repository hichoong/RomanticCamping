package com.sjy.buisness.camp.vo;

public class CampAttachmentVo {
	
	private String atchNo;			//이미지 번호
	private String campNo;			//이미지 번호
	private String campOrignName;		//실제 이름
	private String campChangeName;	//변경 이름
	private String campPath;			//파일 경로
	private String uploadDate;		//업로드 날짜
	private String imgType;			//이미지 타입(대표:M , 실내: I , 입구: E)
	private String status;			//상태 
	
	public CampAttachmentVo() {}

	public CampAttachmentVo(String atchNo, String campNo, String campOrignName, String campChangeName, String campPath,
			String uploadDate, String imgType, String status) {
		super();
		this.atchNo = atchNo;
		this.campNo = campNo;
		this.campOrignName = campOrignName;
		this.campChangeName = campChangeName;
		this.campPath = campPath;
		this.uploadDate = uploadDate;
		this.imgType = imgType;
		this.status = status;
	}

	public String getAtchNo() {
		return atchNo;
	}

	public void setAtchNo(String atchNo) {
		this.atchNo = atchNo;
	}

	public String getCampNo() {
		return campNo;
	}

	public void setCampNo(String campNo) {
		this.campNo = campNo;
	}

	public String getCampOrignName() {
		return campOrignName;
	}

	public void setCampOrignName(String campOrignName) {
		this.campOrignName = campOrignName;
	}

	public String getCampChangeName() {
		return campChangeName;
	}

	public void setCampChangeName(String campChangeName) {
		this.campChangeName = campChangeName;
	}

	public String getCampPath() {
		return campPath;
	}

	public void setCampPath(String campPath) {
		this.campPath = campPath;
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
		return "CampAttachmentVo [atchNo=" + atchNo + ", campNo=" + campNo + ", campOrignName=" + campOrignName
				+ ", campChangeName=" + campChangeName + ", campPath=" + campPath + ", uploadDate=" + uploadDate
				+ ", imgType=" + imgType + ", status=" + status + "]";
	}

	
	
	
	
}
