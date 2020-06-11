package com.sixdays.like.model.vo;

public class LikeUser {

	private int pbno;
	private String Like;
	private String userid;
	private int plno;
	private int pcount;
	
	public int getPcount() {
		return pcount;
	}


	public void setPcount(int pcount) {
		this.pcount = pcount;
	}


	public LikeUser() {
		super();
	}
	
	
	public LikeUser(int pbno, String userid) {
		super();
		this.pbno = pbno;
		this.userid = userid;
	}


	public LikeUser(int pcount) {
		super();
		this.pcount = pcount;
	}


	public LikeUser(int pbno, String like, String userid, int plno, int pcount) {
		super();
		this.pbno = pbno;
		Like = like;
		this.userid = userid;
		this.plno = plno;
		this.pcount = pcount;
	}


	public LikeUser(int pbno, String userid, int plno) {
		super();
		this.pbno = pbno;
		this.userid = userid;
		this.plno = plno;
	}


	public LikeUser(int pbno, String like, String userid, int plno) {
		super();
		this.pbno = pbno;
		Like = like;
		this.userid = userid;
		this.plno = plno;
	}
	public int getPbno() {
		return pbno;
	}
	public void setPbno(int pbno) {
		this.pbno = pbno;
	}
	public String getLike() {
		return Like;
	}
	public void setLike(String like) {
		Like = like;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public int getPlno() {
		return plno;
	}
	public void setPlno(int plno) {
		this.plno = plno;
	}


	@Override
	public String toString() {
		return "LikeUser [pbno=" + pbno + ", Like=" + Like + ", userid=" + userid + ", plno=" + plno + "]";
	}
	
	
}
