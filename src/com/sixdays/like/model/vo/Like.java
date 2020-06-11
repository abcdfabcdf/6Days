package com.sixdays.like.model.vo;

public class Like {
	
	private String userId;
	private String userWriteTitle;
	private String userIP;
	
	public Like() {}

	public Like(String userId, String userWriteTitle, String userIP) {
		super();
		this.userId = userId;
		this.userWriteTitle = userWriteTitle;
		this.userIP = userIP;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserWriteTitle() {
		return userWriteTitle;
	}

	public void setUserWriteTitle(String userWriteTitle) {
		this.userWriteTitle = userWriteTitle;
	}

	public String getUserIP() {
		return userIP;
	}

	public void setUserIP(String userIP) {
		this.userIP = userIP;
	}

	@Override
	public String toString() {
		return "Like [userId=" + userId + ", userWriteTitle=" + userWriteTitle + ", userIP=" + userIP + "]";
	}
	
	   
}
