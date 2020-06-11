package com.sixdays.admin.model.vo;

import java.sql.Date;

public class userManage {
	
	private String userId;		// id
	private String userName;	// 닉네임(게시글 작성자)
	private int pCount;			// 게시글 수
	private Date enrolldate;	// 가입일
	private String delflag;		// 삭제여부
	private String proimg;      // 프로필 이미지
	private String email;		// 이메일
	private String mycomment;  	// 코멘트
	private Date pdate;			// 작성일
	private String pcontent;	// 게시글 내용
	private int rownum;			// 글순서
	
	public userManage() {
		super();
	}

	public userManage(String userId) {
		super();
		this.userId = userId;
	}

	public userManage(String userId, String userName, int pCount, Date enrolldate, String delflag) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.pCount = pCount;
		this.enrolldate = enrolldate;
		this.delflag = delflag;
	}

	public userManage(String userId, String userName, String email, String mycomment) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.email = email;
		this.mycomment = mycomment;
	}
	

	public userManage(Date pdate, String pcontent) {
		super();
		this.pdate = pdate;
		this.pcontent = pcontent;
	}

	public userManage(String userId, String userName, int pCount, Date enrolldate, String delflag, String proimg,
			String email, String mycomment, Date pdate, String pcontent) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.pCount = pCount;
		this.enrolldate = enrolldate;
		this.delflag = delflag;
		this.proimg = proimg;
		this.email = email;
		this.mycomment = mycomment;
		this.pdate = pdate;
		this.pcontent = pcontent;
	}

	public String getUserId() {
		return userId;
	} 

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getpCount() {
		return pCount;
	}

	public void setpCount(int pCount) {
		this.pCount = pCount;
	}

	public Date getEnrolldate() {
		return enrolldate;
	}

	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}

	public String getDelflag() {
		return delflag;
	}

	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMycomment() {
		return mycomment;
	}

	public void setMycomment(String mycomment) {
		this.mycomment = mycomment;
	}

	public Date getPdate() {
		return pdate;
	}

	public void setPdate(Date pdate) {
		this.pdate = pdate;
	}
 
	public String getPcontent() {
		return pcontent;
	}

	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}
	
	

	public String getProimg() {
		return proimg;
	}

	public void setProimg(String proimg) {
		this.proimg = proimg;
	}

	
	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
	}

	@Override
	public String toString() {
		return "userManage [userId=" + userId + ", userName=" + userName + ", pCount=" + pCount + ", enrolldate="
				+ enrolldate + ", delflag=" + delflag + ", proimg=" + proimg + ", email=" + email + ", mycomment="
				+ mycomment + ", pdate=" + pdate + ", pcontent=" + pcontent + ", rownum=" + rownum + "]";
	}

	

	
	
}
	