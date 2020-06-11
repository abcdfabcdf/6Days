package com.sixdays.userMember.model.vo;

import java.io.Serializable;
import java.sql.Date;
/*
 * 작성자 : 박주완
 * 작성일 : 2020-02-06
 * 내용 : 사용자 정보 기본 vo
 */
public class userMember implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 5279850312044346879L;
	
	private String userId;
	private String userpwd;
	private String userName;
	private String email;
	private String phone;
	private String gender;
	private String mycomment;
	private String proimg;
	private String proback;
	private Date enrolldate;
	private String otype;
	private String admin;
	private String blockflag;
	private String report;
	private String delflag;
	

	
	public userMember() {
		
	}

	

	public userMember(String userId) {
		super();
		this.userId = userId;
	}

	// 로그인용 생성자(userId, userPwd)
	public userMember(String userId, String userPwd) {
		super();
		this.userId = userId;
		this.userpwd = userPwd;
	}
	
	public userMember(String userId, String userpwd, String email, String phone) {
		super();
		this.userId = userId;
		this.userpwd = userpwd;
		this.email = email;
		this.phone = phone;
	}



	public userMember(String userId, String userpwd, String userName, String email, String phone, String gender,
			String mycomment) {
		super();
		this.userId = userId;
		this.userpwd = userpwd;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.mycomment = mycomment;
	}


	public userMember(String userId, String userpwd, String userName, String email, String phone, String gender,
			String mycomment, String proimg, String proback, Date enrolldate, String otype, String admin,
			String blockflag, String report, String delflag) {
		super();
		this.userId = userId;
		this.userpwd = userpwd;
		this.userName = userName;
		this.email = email;
		this.phone = phone;
		this.gender = gender;
		this.mycomment = mycomment;
		this.proimg = proimg;
		this.proback = proback;
		this.enrolldate = enrolldate;
		this.otype = otype;
		this.admin = admin;
		this.blockflag = blockflag;
		this.report = report;
		this.delflag = delflag;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public String getUserpwd() {
		return userpwd;
	}


	public void setUserpwd(String userpwd) {
		this.userpwd = userpwd;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPhone() {
		return phone;
	}


	public void setPhone(String phone) {
		this.phone = phone;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getMycomment() {
		return mycomment;
	}


	public void setMycomment(String mycomment) {
		this.mycomment = mycomment;
	}


	public String getProimg() {
		return proimg;
	}


	public void setProimg(String proimg) {
		this.proimg = proimg;
	}


	public String getProback() {
		return proback;
	}


	public void setProback(String proback) {
		this.proback = proback;
	}


	public Date getEnrolldate() {
		return enrolldate;
	}


	public void setEnrolldate(Date enrolldate) {
		this.enrolldate = enrolldate;
	}


	public String getOtype() {
		return otype;
	}


	public void setOtype(String otype) {
		this.otype = otype;
	}


	public String getAdmin() {
		return admin;
	}


	public void setAdmin(String admin) {
		this.admin = admin;
	}


	public String getBlockflag() {
		return blockflag;
	}


	public void setBlockflag(String blockflag) {
		this.blockflag = blockflag;
	}


	public String getReport() {
		return report;
	}


	public void setReport(String report) {
		this.report = report;
	}


	public String getDelflag() {
		return delflag;
	}


	public void setDelflag(String delflag) {
		this.delflag = delflag;
	}


	@Override
	public String toString() {
		return "userMember [userId=" + userId + ", userpwd=" + userpwd + ", userName=" + userName + ", email=" + email
				+ ", phone=" + phone + ", gender=" + gender + ", mycomment=" + mycomment + ", proimg=" + proimg
				+ ", proback=" + proback + ", enrolldate=" + enrolldate + ", otype=" + otype + ", admin=" + admin
				+ ", blockflag=" + blockflag + ", report=" + report + ", delflag=" + delflag + "]";
	}


}
