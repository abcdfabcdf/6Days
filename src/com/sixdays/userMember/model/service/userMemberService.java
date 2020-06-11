package com.sixdays.userMember.model.service;



import static com.sixdays.common.JDBCTemplate.close;
import static com.sixdays.common.JDBCTemplate.commit;
import static com.sixdays.common.JDBCTemplate.getConnection;
import static com.sixdays.common.JDBCTemplate.rollback;

import java.sql.Connection;
import java.util.ArrayList;

import com.sixdays.board.model.vo.Board;
import com.sixdays.userMember.model.dao.userMemberDao;
import com.sixdays.userMember.model.exception.MemberException;
import com.sixdays.userMember.model.vo.userMember;

/**
 * 작성자 : 박주완
 * 작성일 : 2020-02-06
 * 내용 : 연결 service 생성
 */
public class userMemberService {
	
	private Connection con;
	private userMemberDao mDao = new userMemberDao();
	
	public int insertMember(userMember m) {
		con = getConnection();
		int result = mDao.insertMember(con,m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
		
	}

	
	/**
	 * 작성자  : 신지영
	 * 작성일 : 2020. 2. 10.
	 * 가입정보확인(로그인)
	 * @param m
	 * @return
	 * @throws MemberException 
	 */
	public userMember selectMember(userMember m) throws MemberException {
		con = getConnection();
		
		userMember result = mDao.selectMember(con,m);
		
		close(con);
		if(result == null) {
			throw new MemberException("아이디나 비밀번호가 올바르지 않습니다.");
		}
		
		return result;
	}

	public int idDupCheck(String id) {
		
		Connection con = getConnection();
		
		int result = mDao.idDupCheck(con,id);
		
		close(con);
		
		return result;
	}
	
public int nameUpdateMember(userMember m) throws MemberException {
		
		con = getConnection();
		
		int result = mDao.nameUpdateMember(con,m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}

	public int commentUpdateMember(userMember m) throws MemberException {
		con = getConnection();
		
		int result = mDao.commentUpdateMember(con,m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}

	public int updateProImg(userMember m) throws MemberException{
		con = getConnection();
		
		int result = mDao.updateProImg(con,m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	/**
	 * 작성자 : 박주완
	 * 작성일 : 2020-02-17
	 * 내용 : 아이디 찾기 서비스
	 */
	public userMember userSearch(String phone, String email) {
		con = getConnection();
		userMemberDao dao = new userMemberDao();
		userMember m = dao.userSearch(con, phone, email);
		System.out.println("서비스  m: " + m);
		
		
		close(con);
		System.out.println("Member : "+ m);
		
		return m;
	}
	
	/**
	 * 작성자 : 박주완
	 * 작성일 : 2020-02-17
	 * 내용 : 비밀번호 찾기 서비스 
	 * @param AuthenticationKey 
	 */
	public int userPwdSearch(String id,String eamil, String AuthenticationKey) {
		con = getConnection();
		userMemberDao dao = new userMemberDao();
		int result = dao.userPwdSearch(con, id, eamil, AuthenticationKey);
		System.out.println(result);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
	
		return result;
	}


	



	
	public int updateProBack(userMember m) throws MemberException{
		con = getConnection();
		
		int result = mDao.updateProBack(con,m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}


	public int deleteProImg(userMember m) throws MemberException{
		con = getConnection();
		
		
		int result = mDao.deleteProImg(con,m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}
	
	public int deleteProBack(userMember m) throws MemberException{
		con = getConnection();
		
		int result = mDao.deleteProBack(con,m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}


	/**
	 * 작성자 : 윤석훈
	 * 작성일 : 2020-02-18
	 * 내용 : 개인정보 변경 
	 * @param changeMember 
	 */
	public int changeMember(userMember m) {
		
		con = getConnection();
		
		int result = mDao.changeMember(con,m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}

	/**
	 * 작성자 : 윤석훈
	 * 작성일 : 2020-02-18
	 * 내용 : 비밀번호 일치여부확인 
	 * @param pwdchk 
	 */

	public userMember pwdchk(userMember m) {
		con = getConnection();
		
		userMember result = mDao.pwdchk(con,m);
		
		close(con);
		
		return result;
	}


	/**
	 * 회원탈퇴
	 * 작성자:윤석훈
	 * @param m
	 * @return
	 */
	public int memberOut(userMember m) {
		
		con = getConnection();
		
		int result = mDao.memberOut(con,m);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		
	}


	/**
	 * 유저조회
	 * 작성자:윤석훈
	 * @param result
	 * @return
	 */
	public ArrayList<userMember> selectList(String result) {
		Connection con = getConnection();
		
		ArrayList<userMember> list = mDao.selectList(con, result);
		
		close(con);
		return list;
	}


	public userMember selectProfileMember(String userid) {
		con = getConnection();
		
		userMember result = mDao.selectProfileMember(con,userid);
		
		close(con);
		
		return result;
	}






}
