package com.kh.review.vo;

public class ReviewVo {
	
	public ReviewVo() {
		
	}
	
	public ReviewVo(String reviewNo, String reservationNo, String enrollDate, String reviewContent, String starScore,
			String reviewUpdated, String reviewStatus, String campCode) {
		super();
		this.reviewNo = reviewNo;
		this.reservationNo = reservationNo;
		this.enrollDate = enrollDate;
		this.reviewContent = reviewContent;
		this.starScore = starScore;
		this.reviewUpdated = reviewUpdated;
		this.reviewStatus = reviewStatus;
		this.campCode = campCode;
	}

	private String reviewNo;
	private String reservationNo;
	private String enrollDate;
	private String reviewContent;
	private String starScore;
	private String reviewUpdated;
	private String reviewStatus;
	private String campCode;
	
	public String getReviewNo() {
		return reviewNo;
	}

	public void setReviewNo(String reviewNo) {
		this.reviewNo = reviewNo;
	}

	public String getReservationNo() {
		return reservationNo;
	}

	public void setReservationNo(String reservationNo) {
		this.reservationNo = reservationNo;
	}

	public String getEnrollDate() {
		return enrollDate;
	}

	public void setEnrollDate(String enrollDate) {
		this.enrollDate = enrollDate;
	}

	public String getReviewContent() {
		return reviewContent;
	}

	public void setReviewContent(String reviewContent) {
		this.reviewContent = reviewContent;
	}

	public String getStarScore() {
		return starScore;
	}

	public void setStarScore(String starScore) {
		this.starScore = starScore;
	}

	public String getReviewUpdated() {
		return reviewUpdated;
	}

	public void setReviewUpdated(String reviewUpdated) {
		this.reviewUpdated = reviewUpdated;
	}

	public String getReviewStatus() {
		return reviewStatus;
	}

	public void setReviewStatus(String reviewStatus) {
		this.reviewStatus = reviewStatus;
	}

	public String getCampCode() {
		return campCode;
	}

	public void setCampCode(String campCode) {
		this.campCode = campCode;
	}

	@Override
	public String toString() {
		return "ReviewVo [reviewNo=" + reviewNo + ", reservationNo=" + reservationNo + ", enrollDate=" + enrollDate
				+ ", reviewContent=" + reviewContent + ", starScore=" + starScore + ", reviewUpdated=" + reviewUpdated
				+ ", reviewStatus=" + reviewStatus + ", campCode=" + campCode + "]";
	}
	
	
}
