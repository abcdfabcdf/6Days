package com.sixdays.maincomment.model.vo;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author tjrgn
 *
 */
public class MainComment implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8335348120932005196L;
	private int pbno;			// 게시글번호
	private int mno;			// 댓글번호
	private String mcontent;	// 댓글내용
	private String status;		// 삭제유무
	private String mwriter;
	private String cproimg;
	private String mnickname;
	private Date mdate;


	public Date getMdate() {
		return mdate;
	}

	public void setMdate(Date mdate) {
		this.mdate = mdate;
	}

	public String getMnickname() {
		return mnickname;
	}

	public void setMnickname(String mnickname) {
		this.mnickname = mnickname;
	}
	
	public MainComment() {}
	


	public String getMwriter() {
		return mwriter;
	}
	
	public void setMwriter(String mwriter) {
		this.mwriter = mwriter;
	}
	
	public String getCproimg() {
		return cproimg;
	}
	
	public void setCproimg(String cproimg) {
		this.cproimg = cproimg;
	}

	public int getPbno() {
		return pbno;
	}

	public void setPbno(int pbno) {
		this.pbno = pbno;
	}

	public int getMno() {
		return mno;
	}

	public void setMno(int mno) {
		this.mno = mno;
	}

	public String getMcontent() {
		return mcontent;
	}

	public void setMcontent(String mcontent) {
		this.mcontent = mcontent;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

	public MainComment(int pbno, int mno, String mcontent, String mwriter, String mnickname, Date mdate) {
		super();
		this.pbno = pbno;
		this.mno = mno;
		this.mcontent = mcontent;
		this.mwriter = mwriter;
		this.mnickname = mnickname;
		this.mdate = mdate;
	}

	public MainComment(int pbno, int mno, String mcontent, String status, String mwriter, String cproimg,
			String mnickname, Date mdate) {
		super();
		this.pbno = pbno;
		this.mno = mno;
		this.mcontent = mcontent;
		this.status = status;
		this.mwriter = mwriter;
		this.cproimg = cproimg;
		this.mnickname = mnickname;
		this.mdate = mdate;
	}

	@Override
	public String toString() {
		return "MainComment [pbno=" + pbno + ", mno=" + mno + ", mcontent=" + mcontent + ", status=" + status
				+ ", mwriter=" + mwriter + ", cproimg=" + cproimg + ", mnickname=" + mnickname + ", mdate=" + mdate
				+ "]";
	}

	
	
	
	
}
