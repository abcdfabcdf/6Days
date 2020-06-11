package com.sixdays.admin.model.vo;

public class Report {
	
	
	private int rownum;			// 글순서
/*	위쪽부분에 출력될 사용자 정보	*/
	private String userId;		// 아이디(작성자)
	private String userName;	// 닉네임(작성자)
	private String proimg;      // 프로필 이미지
	private String email;		// 이메일
	private String mycomment;  	// 코멘트
	private String Blockflag;	//현재정지유무
	private String pbDate;		//작성일
	private String pContent;	//게시글 내용
	private String hashtag;		//해쉬태그내용
	private String report_yn;
	private String Status;
/*	밑부분에 뿌려줄 정보	*/
	private int rpno;			//신고된게시글번호
	private String reason;		//정지사유
	private String reportdate;	//신고일
	private String releasedate; //정지해제일
	private String reporter;	//신고자
	private int rpcount;		//누적 정지 횟수
	
	
	public Report() {
		super();
	}


	public Report(int rownum, String userId, String userName, String proimg, String email, String mycomment,
			String blockflag, String pbDate, String pContent, String hashtag, String report_yn, String status, int rpno,
			String reason, String reportdate, String releasedate, String reporter, int rpcount) {
		super();
		this.rownum = rownum;
		this.userId = userId;
		this.userName = userName;
		this.proimg = proimg;
		this.email = email;
		this.mycomment = mycomment;
		Blockflag = blockflag;
		this.pbDate = pbDate;
		this.pContent = pContent;
		this.hashtag = hashtag;
		this.report_yn = report_yn;
		Status = status;
		this.rpno = rpno;
		this.reason = reason;
		this.reportdate = reportdate;
		this.releasedate = releasedate;
		this.reporter = reporter;
		this.rpcount = rpcount;
	}


	public int getRownum() {
		return rownum;
	}


	public void setRownum(int rownum) {
		this.rownum = rownum;
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


	public String getProimg() {
		return proimg;
	}


	public void setProimg(String proimg) {
		this.proimg = proimg;
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


	public String getBlockflag() {
		return Blockflag;
	}


	public void setBlockflag(String blockflag) {
		Blockflag = blockflag;
	}


	public String getPbDate() {
		return pbDate;
	}


	public void setPbDate(String pbDate) {
		this.pbDate = pbDate;
	}


	public String getpContent() {
		return pContent;
	}


	public void setpContent(String pContent) {
		this.pContent = pContent;
	}


	public String getHashtag() {
		return hashtag;
	}


	public void setHashtag(String hashtag) {
		this.hashtag = hashtag;
	}


	public String getReport_yn() {
		return report_yn;
	}


	public void setReport_yn(String report_yn) {
		this.report_yn = report_yn;
	}


	public String getStatus() {
		return Status;
	}


	public void setStatus(String status) {
		Status = status;
	}


	public int getRpno() {
		return rpno;
	}


	public void setRpno(int rpno) {
		this.rpno = rpno;
	}


	public String getReason() {
		return reason;
	}


	public void setReason(String reason) {
		this.reason = reason;
	}


	public String getReportdate() {
		return reportdate;
	}


	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}


	public String getReleasedate() {
		return releasedate;
	}


	public void setReleasedate(String releasedate) {
		this.releasedate = releasedate;
	}


	public String getReporter() {
		return reporter;
	}


	public void setReporter(String reporter) {
		this.reporter = reporter;
	}


	public int getRpcount() {
		return rpcount;
	}


	public void setRpcount(int rpcount) {
		this.rpcount = rpcount;
	}


	@Override
	public String toString() {
		return "Report [rownum=" + rownum + ", userId=" + userId + ", userName=" + userName + ", proimg=" + proimg
				+ ", email=" + email + ", mycomment=" + mycomment + ", Blockflag=" + Blockflag + ", pbDate=" + pbDate
				+ ", pContent=" + pContent + ", hashtag=" + hashtag + ", report_yn=" + report_yn + ", Status=" + Status
				+ ", rpno=" + rpno + ", reason=" + reason + ", reportdate=" + reportdate + ", releasedate="
				+ releasedate + ", reporter=" + reporter + ", rpcount=" + rpcount + "]";
	}

	
	
}