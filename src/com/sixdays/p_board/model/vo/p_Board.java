package com.sixdays.p_board.model.vo;

import java.sql.Date;

public class p_Board {
	
	private int pbno;			//게시판번호
	private String pbwriter;	//사진게시판 작성자
	private Date pbdate;		//사진게시판 작성일
	private String photo1;		//사진
	private String photo2;
	private String photo3;
	private String photo4;
	private String photo5;
	private String photo6;
	private String pcontent;	//사진게시판 내용
	private String hashtag;		//해시태그
	private int like_count;		//좋아요수
	private int pbcomment;		//댓글 수 
	private String status;		//삭제여부
	private String blockflag;	//정지유무
	private String report_yn;	//신고유무
	private String pnickname;   //닉네임
	private String pproimg; //이미지
	
	
	private String mycomment;	//남에코멘트
	private String proback;		//남의배경이미지
	private String userName;	//딴놈닉네임
	
	
	public String getPnickname() {
		return pnickname;
	}


	public void setPnickname(String pnickname) {
		this.pnickname = pnickname;
	}


	public String getPproimg() {
		return pproimg;
	}


	public void setPproimg(String pproimg) {
		this.pproimg = pproimg;
	}


	public p_Board() {
		
	}


	public p_Board(String pbwriter, String photo1, String photo2, String photo3, String photo4, String photo5,
			String photo6, String pcontent, String hashtag) {
		super();
		this.pbwriter = pbwriter;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
		this.photo4 = photo4;
		this.photo5 = photo5;
		this.photo6 = photo6;
		this.pcontent = pcontent;
		this.hashtag = hashtag;
	}


	public p_Board(int pbno, String pbwriter, Date pbdate, String photo1, String photo2, String photo3, String photo4,
			String photo5, String photo6, String pcontent, String hashtag, int like_count, int pbcomment, String status,
			String blockflag, String report_yn, String pnickname, String pproimg) {
		super();
		this.pbno = pbno;
		this.pbwriter = pbwriter;
		this.pbdate = pbdate;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
		this.photo4 = photo4;
		this.photo5 = photo5;
		this.photo6 = photo6;
		this.pcontent = pcontent;
		this.hashtag = hashtag;
		this.like_count = like_count;
		this.pbcomment = pbcomment;
		this.status = status;
		this.blockflag = blockflag;
		this.report_yn = report_yn;
		this.pnickname = pnickname;
		this.pproimg = pproimg;
	}


	public p_Board(int pbno, String pbwriter, Date pbdate, String photo1, String photo2, String photo3, String photo4,
			String photo5, String photo6, String pcontent, String hashtag, int like_count, int pbcomment, String status,
			String blockflag, String report_yn) {
		super();
		this.pbno = pbno;
		this.pbwriter = pbwriter;
		this.pbdate = pbdate;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
		this.photo4 = photo4;
		this.photo5 = photo5;
		this.photo6 = photo6;
		this.pcontent = pcontent;
		this.hashtag = hashtag;
		this.like_count = like_count;
		this.pbcomment = pbcomment;
		this.status = status;
		this.blockflag = blockflag;
		this.report_yn = report_yn;
	}
	
	


	public p_Board(int pbno, String pbwriter, Date pbdate, String photo1, String photo2, String photo3, String photo4,
			String photo5, String photo6, String pcontent, String hashtag, int like_count, int pbcomment, String status,
			String blockflag, String report_yn, String pnickname, String pproimg, String mycomment, String proback,
			String userName) {
		super();
		this.pbno = pbno;
		this.pbwriter = pbwriter;
		this.pbdate = pbdate;
		this.photo1 = photo1;
		this.photo2 = photo2;
		this.photo3 = photo3;
		this.photo4 = photo4;
		this.photo5 = photo5;
		this.photo6 = photo6;
		this.pcontent = pcontent;
		this.hashtag = hashtag;
		this.like_count = like_count;
		this.pbcomment = pbcomment;
		this.status = status;
		this.blockflag = blockflag;
		this.report_yn = report_yn;
		this.pnickname = pnickname;
		this.pproimg = pproimg;
		this.mycomment = mycomment;
		this.proback = proback;
		this.userName = userName;
	}


	public int getPbno() {
		return pbno;
	}


	public void setPbno(int pbno) {
		this.pbno = pbno;
	}


	public String getPbwriter() {
		return pbwriter;
	}


	public void setPbwriter(String pbwriter) {
		this.pbwriter = pbwriter;
	}
	


	public String getMycomment() {
		return mycomment;
	}


	public void setMycomment(String mycomment) {
		this.mycomment = mycomment;
	}


	public String getProback() {
		return proback;
	}


	public void setProback(String proback) {
		this.proback = proback;
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public Date getPbdate() {
		return pbdate;
	}


	public void setPbdate(Date pbdate) {
		this.pbdate = pbdate;
	}


	public String getPhoto1() {
		return photo1;
	}


	public void setPhoto1(String photo1) {
		this.photo1 = photo1;
	}


	public String getPhoto2() {
		return photo2;
	}


	public void setPhoto2(String photo2) {
		this.photo2 = photo2;
	}


	public String getPhoto3() {
		return photo3;
	}


	public void setPhoto3(String photo3) {
		this.photo3 = photo3;
	}


	public String getPhoto4() {
		return photo4;
	}


	public void setPhoto4(String photo4) {
		this.photo4 = photo4;
	}


	public String getPhoto5() {
		return photo5;
	}


	public void setPhoto5(String photo5) {
		this.photo5 = photo5;
	}


	public String getPhoto6() {
		return photo6;
	}


	public void setPhoto6(String photo6) {
		this.photo6 = photo6;
	}


	public String getPcontent() {
		return pcontent;
	}


	public void setPcontent(String pcontent) {
		this.pcontent = pcontent;
	}


	public String getHashtag() {
		return hashtag;
	}


	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}


	public int getLike_count() {
		return like_count;
	}


	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}


	public int getPbcomment() {
		return pbcomment;
	}


	public void setPbcomment(int pbcomment) {
		this.pbcomment = pbcomment;
	}


	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getBlockflag() {
		return blockflag;
	}


	public void setBlockflag(String blockflag) {
		this.blockflag = blockflag;
	}


	public String getReport_yn() {
		return report_yn;
	}


	public void setReport_yn(String report_yn) {
		this.report_yn = report_yn;
	}


	@Override
	public String toString() {
		return "p_Board [pbno=" + pbno + ", pbwriter=" + pbwriter + ", pbdate=" + pbdate + ", photo1=" + photo1
				+ ", photo2=" + photo2 + ", photo3=" + photo3 + ", photo4=" + photo4 + ", photo5=" + photo5
				+ ", photo6=" + photo6 + ", pcontent=" + pcontent + ", hashtag=" + hashtag + ", like_count="
				+ like_count + ", pbcomment=" + pbcomment + ", status=" + status + ", blockflag=" + blockflag
				+ ", report_yn=" + report_yn + ",test=" + userName + "]";
	}
	
	
		
}
