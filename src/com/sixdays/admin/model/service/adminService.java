package com.sixdays.admin.model.service;

import static com.sixdays.common.JDBCTemplate.close;
import static com.sixdays.common.JDBCTemplate.commit;
import static com.sixdays.common.JDBCTemplate.getConnection;
import static com.sixdays.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.sixdays.admin.model.dao.adminDao;
import com.sixdays.admin.model.vo.Advertisement;
import com.sixdays.admin.model.vo.Report;
import com.sixdays.admin.model.vo.userManage;
import com.sixdays.board.model.vo.Board;
import com.sixdays.userMember.model.exception.MemberException;
import com.sixdays.userMember.model.vo.userMember;


public class adminService {
	

	private adminDao aDao = new adminDao();
	
	public ArrayList<userManage> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<userManage> list = aDao.selectList(con, currentPage, limit);

		close(con);
		return list;
	}
 
	public int getListCount() {
		Connection con = getConnection();
		int listCount = aDao.getListCount(con);
		
		close(con);
		
		return listCount;
	}

	public userManage selectOne(String userId) {
		Connection con = getConnection();
				
		userManage u= aDao.selectOne(con, userId);	
		
		close(con);
		return u;
	}

	public ArrayList<userManage> selectUserList(String userId) {

		Connection con = getConnection();
		
		ArrayList<userManage> list = aDao.selectUserList(con,userId);
		
		close(con);
		
		
		return list;
	}

	public int updateDelfag(userManage u) throws MemberException {
		Connection con = getConnection();
		System.out.println("서비스로 넘어왔닝");
		int result = aDao.updateDelfag(con,u);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}
	
	//	--------------------------------------------------
	//	신고사항 관리 
	  
	
	/**
	* 신고사항 전체 조회
	* @return
	*/
	public ArrayList<Report> rselectList() {
	Connection con = getConnection();
	
	ArrayList<Report> list = aDao.rselectList(con);
	
	close(con);
	return list; 
	}
	
	
	
	
	public int getrListCount() {
	Connection con = getConnection();
	int listCount = aDao.getrListCount(con);
	
	close(con);
	
	return listCount;
	}
	
	
	

	public int delflagcheckN(String userid) {
		Connection con = getConnection();
		
		int result = aDao.delflagcheckN(con,userid);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}
	public int delflagcheckY(String userid) {
		Connection con = getConnection();
		
		int result = aDao.delflagcheckY(con,userid);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}
	
	/* 작성자 : 박주완
	 * 내용 : 신고사항 리스트 에서 사용자 ID 클릭시 디테일창으로 넘어감 ㅇㅇ
	 * 작성일 : 2020-02-22
	 */
	public Report reportselectOne(String userId) {
		Connection con = getConnection();
		
		Report rep= aDao.reportselectOne(con, userId);	
		
		close(con);
		
		return rep;
	}
	
	

	public ArrayList<Report> reportList(String userId) {
		Connection con = getConnection();
		
		ArrayList<Report> rlist = aDao.reportList(con, userId);
		
		close(con);
		
		return rlist;
	}
	
	public int userblock(String userId, String reason, int releasDate) {
		Connection con = getConnection();
		
		int result = aDao.userBlockDao(con,userId,reason,releasDate);
/*		int result2 = aDao.userLoginUpdateDao(con,userId);*/
		
		if(result > 0 /*&& result2 > 0*/) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
		
	}

	public int userRelease(String userId) {
		Connection con = getConnection();
		
		int result = aDao.userReleaseDao(con,userId);
/*		int result2 = aDao.userLoginReleaseDao(con,userId);*/
		
		if(result > 0 /*&& result2 > 0*/) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int amUpdate(Advertisement a) {
		Connection con = getConnection();;
		
		int result = aDao.amUpdate(con,a);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}





	
	

}
