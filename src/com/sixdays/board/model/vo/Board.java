package com.sixdays.board.model.vo;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Seokhun
 *
 */
public class Board implements Serializable {

	private static final long serialVersionUID = -8935709964213018076L;
	
	private int rnum;
	private int bno;						// 글번호
	private String btitle;					// 글제목
	private String bwriter;					// 작성자
	private Date bdate;						// 작성일
	private String bcontent;				// 내용
	private String boardfile;				// 파일
	private int bcount;						// 조회수
	private int bcomment;					// 댓글수
	private String status;					// 삭제여부
	private int rownum;						// 글순서

	public Board() {}
	
	

	public Board(String btitle, String bwriter, Date bdate, String bcontent, String boardfile) {
		super();
		this.btitle = btitle;
		this.bwriter = bwriter;
		this.bdate = bdate;
		this.bcontent = bcontent;
		this.boardfile = boardfile;
	}



	public Board(int bno, String btitle, String bwriter, Date bdate, String bcontent, String boardfile,
			int bcount, int bcomment, String status) {
		super();
		this.bno = bno;
		this.btitle = btitle;
		this.bwriter = bwriter;
		this.bdate = bdate;
		this.bcontent = bcontent;
		this.boardfile = boardfile;
		this.bcount = bcount;
		this.bcomment = bcomment;
		this.status = status;
	}

	public int getRnum() {
		return rnum;
	}
	
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	
	public int getBno() {
		return bno;
	}

	public void setBno(int bno) {
		this.bno = bno;
	}

	public String getBtitle() {
		return btitle;
	}

	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public Date getBdate() {
		return bdate;
	}

	public void setBdate(Date bdate) {
		this.bdate = bdate;
	}

	public String getBcontent() {
		return bcontent;
	}

	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}

	public String getBoardfile() {
		return boardfile;
	}

	public void setBoardfile(String boardfile) {
		this.boardfile = boardfile;
	}

	public int getBcount() {
		return bcount;
	}

	public void setBcount(int bcount) {
		this.bcount = bcount;
	}

	public int getBcomment() {
		return bcomment;
	}

	public void setBcomment(int bcomment) {
		this.bcomment = bcomment;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	public int getRownum() {
		return rownum;
	}



	public void setRownum(int rownum) {
		this.rownum = rownum;
	}



	@Override
	public String toString() {
		return "Board [rnum=" + rnum + ", bno=" + bno + ", btitle=" + btitle + ", bwriter=" + bwriter + ", bdate="
				+ bdate + ", bcontent=" + bcontent + ", boardfile=" + boardfile + ", bcount=" + bcount + ", bcomment="
				+ bcomment + ", status=" + status + ", rownum=" + rownum + "]";
	}

	
	
}



	
	
	
	