package com.sixdays.qnacomment.model.vo;

import java.io.Serializable;
import java.sql.Date;

public class QnAComment implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8839682559483821271L;
	private int cno; // 댓글번호
	private int qno; // 게시글번호
	private String ccontent; // 댓글 내용
	private String cwriter;  // 작성자
//	private String cwriterId; 뭔지모름
	private Date cdate;		 // 댓글작성일
	private int refcno;		 // 댓글번호참조
	private int clevel;		 // 댓글 레벨(대댓글)
	private String cproimg; //이미지 추가
	
	
	public QnAComment() {}
	
	

	public String getCproimg() {
		return cproimg;
	}



	public void setCproimg(String cproimg) {
		this.cproimg = cproimg;
	}



	public QnAComment(int cno, int qno, String ccontent, String cwriter, Date cdate, int refcno, int clevel,
			String cproimg) {
		super();
		this.cno = cno;
		this.qno = qno;
		this.ccontent = ccontent;
		this.cwriter = cwriter;
		this.cdate = cdate;
		this.refcno = refcno;
		this.clevel = clevel;
		this.cproimg = cproimg;
	}






	public QnAComment(int qno, String ccontent, String cwriter, int refcno, int clevel, Date cdate) {
		super();
		this.qno = qno;
		this.ccontent = ccontent;
		this.cwriter = cwriter;
		this.refcno = refcno;
		this.clevel = clevel;
		this.cdate = cdate;
	}



	public QnAComment(int cno, int qno, String ccontent, String cwriter, Date cdate, int refcno, int clevel) {
		super();
		this.cno = cno;
		this.qno = qno;
		this.ccontent = ccontent;
		this.cwriter = cwriter;
		this.cdate = cdate;
		this.refcno = refcno;
		this.clevel = clevel;
	}

	public int getCno() {
		return cno;
	}

	public void setCno(int cno) {
		this.cno = cno;
	}

	public int getQno() {
		return qno;
	}

	public void setQno(int qno) {
		this.qno = qno;
	}

	public String getCcontent() {
		return ccontent;
	}

	public void setCcontent(String ccontent) {
		this.ccontent = ccontent;
	}

	public String getCwriter() {
		return cwriter;
	}

	public void setCwriter(String cwriter) {
		this.cwriter = cwriter;
	}

	public Date getCdate() {
		return cdate;
	}

	public void setCdate(Date cdate) {
		this.cdate = cdate;
	}

	public int getRefcno() {
		return refcno;
	}

	public void setRefcno(int refcno) {
		this.refcno = refcno;
	}

	public int getClevel() {
		return clevel;
	}

	public void setClevel(int clevel) {
		this.clevel = clevel;
	}

	@Override
	public String toString() {
		return "QnAComment [cno=" + cno + ", qno=" + qno + ", ccontent=" + ccontent + ", cwriter=" + cwriter
				+ ", cdate=" + cdate + ", refcno=" + refcno + ", clevel=" + clevel + "]";
	}
	
	
	
	
	
}
