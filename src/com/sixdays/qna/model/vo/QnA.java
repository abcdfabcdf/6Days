package com.sixdays.qna.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class QnA implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4926833931113015975L;
	
	private int rnum;
	private int qno;
	private String qtype;
	private String qtitle;
	private String qwriter;
	private String qcontent;
	private Date qdate;
	private int qcount;
	private int qcomment;
	private String qnafile;
	private String status;
	
	public QnA() {}
	
	

	public QnA(int qno, String qtype, String qtitle, String qwriter, String qcontent, Date qdate, String qnafile) {
		super();
		this.qno = qno;
		this.qtype = qtype;
		this.qtitle = qtitle;
		this.qwriter = qwriter;
		this.qcontent = qcontent;
		this.qdate = qdate;
		this.qnafile = qnafile;
	}



	public QnA(int qno, String qtype, String qtitle, String qwriter, String qcontent, Date qdate, int qcount, int qcomment,
			String qnafile, String status) {
		super();
		this.qno = qno;
		this.qtype = qtype;
		this.qtitle = qtitle;
		this.qwriter = qwriter;
		this.qcontent = qcontent;
		this.qdate = qdate;
		this.qcount = qcount;
		this.qcomment = qcomment;
		this.qnafile = qnafile;
		this.status = status;
	}

	
	public int getRnum() {
		return rnum;
	}



	public void setRnum(int rnum) {
		this.rnum = rnum;
	}



	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getQtype() {
		return qtype;
	}

	public void setQtype(String qtype) {
		this.qtype = qtype;
	}

	public String getQtitle() {
		return qtitle;
	}

	public void setQtitle(String qtitle) {
		this.qtitle = qtitle;
	}

	public String getQwriter() {
		return qwriter;
	}

	public void setQwriter(String qwriter) {
		this.qwriter = qwriter;
	}

	public String getQcontent() {
		return qcontent;
	}

	public void setQcontent(String qcontent) {
		this.qcontent = qcontent;
	}

	public Date getQdate() {
		return qdate;
	}

	public void setQdate(Date qdate) {
		this.qdate = qdate;
	}

	public int getQcount() {
		return qcount;
	}

	public void setQcount(int qcount) {
		this.qcount = qcount;
	}

	public int getQcomment() {
		return qcomment;
	}

	public void setQcomment(int qcomment) {
		this.qcomment = qcomment;
	}

	public String getQnafile() {
		return qnafile;
	}

	public void setQnafile(String qnafile) {
		this.qnafile = qnafile;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "QnA [qno=" + qno + ", qtype=" + qtype + ", qtitle=" + qtitle + ", qwriter=" + qwriter + ", qcontent="
				+ qcontent + ", qdate=" + qdate + ", qcount=" + qcount + ", qcomment=" + qcomment + ", qnafile="
				+ qnafile + ", status=" + status + "]";
	}
	
	
	
	
	
	
}
