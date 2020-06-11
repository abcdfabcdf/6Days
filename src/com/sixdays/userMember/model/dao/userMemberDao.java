package com.sixdays.userMember.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import static com.sixdays.common.JDBCTemplate.*;

import com.sixdays.board.model.vo.Board;
import com.sixdays.userMember.model.exception.MemberException;
import com.sixdays.userMember.model.vo.userMember;

/**
 * 작성자 : 박주완
 * 작성일 : 2020-02-06
 * 내용 : 사용자 DAO --> CRUD
 */
public class userMemberDao {
	private Properties prop;
	
	/**
	 * 작성자  : 박주완
	 * 작성일 : 2020. 2. 6.
	 * 내용 : 쿼리문을 독립적으로 관리하는 메소드 생성
	 */
	public userMemberDao() {
		prop = new Properties();
		
		String filePath = userMemberDao.class.getResource("/config/member-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	/**
	 * 작성자  : 박주완
	 * 작성일 : 2020. 2. 6.
	 * 내용 : 사용자 추가를 위한 메소드
	 */
	public int insertMember(Connection con, userMember m) {
		// 결과 확인을 위한 변수 result 생성
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("insertMember");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserpwd());
			pstmt.setString(3, m.getUserName());
			pstmt.setString(4, m.getEmail());
			pstmt.setString(5, m.getPhone());
			pstmt.setString(6, m.getGender());
			pstmt.setString(7, m.getMycomment());

			
			result = pstmt.executeUpdate();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		return result;
	}


	/**
	 * 작성자  : 신지영
	 * 작성일 : 2020. 2. 10.
	 * 가입정보확인(로그인)
	 * @param con
	 * @param m
	 * @return
	 * @throws MemberException 
	 */
	public userMember selectMember(Connection con, userMember m) throws MemberException {
		userMember result = null; // 결과를 담을 객체
		
		PreparedStatement pstmt = null;
		ResultSet rset = null; // Select의 결과를 담을 객체
		
		try {
			String sql = prop.getProperty("selectMember");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserpwd());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = new userMember();
				
				result.setUserId(rset.getString("USERID"));
				result.setUserpwd(rset.getString("USERPWD"));
				result.setUserName(rset.getString("USERNAME"));
				result.setEmail(rset.getString("EMAIL"));
				result.setPhone(rset.getString("PHONE"));
				result.setGender(rset.getString("GENDER"));
				result.setMycomment(rset.getString("MYCOMMENT"));
				result.setProimg(rset.getString("PROIMG"));
				result.setProback(rset.getString("PROBACK"));

				System.out.println(result);
			}	
		}catch(Exception e) {
			//e.printStackTrace();
			
			throw new MemberException(e.getMessage());
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	/**
	 * 작성자  : 윤석훈
	 * 작성일 : 2020. 2. 13.
	 * 중복확인
	 * @param con
	 * @param id
	 * @return
	 */
	public int idDupCheck(Connection con, String id) {
		int result = -1;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("idDupCheck");
		
		
		try {
			pstmt = con.prepareStatement(sql);			
			pstmt.setString(1, id);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				//-1:에러!
				// 0: id 중복사용자 없음
				// 1: id를 누군가 사용중
				result = rset.getInt(1);
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
			
		}finally {
			close(rset);
			close(pstmt);
		}
	return result;
	}
	
	/**
	 * 작성자  : 신지영
	 * 작성일 : 2020. 2. 12.
	 * 닉네임 변경
	 * @param con
	 * @param m
	 * @return
	 * @throws MemberException
	 */
	public int nameUpdateMember(Connection con, userMember m) throws MemberException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("nameupMember");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getUserName());
			pstmt.setString(2, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			throw new MemberException(e.getMessage());
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 작성자  : 신지영
	 * 작성일 : 2020. 2. 12.
	 * 코멘트 변경
	 * @param con
	 * @param m
	 * @return
	 * @throws MemberException 
	 */
	public int commentUpdateMember(Connection con, userMember m) throws MemberException {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("commentupMember");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getMycomment());
			pstmt.setString(2, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			throw new MemberException(e.getMessage());
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 작성자  : 신지영
	 * 작성일 : 2020. 2. 16.
	 * 프로필 사진 변경
	 * @param con
	 * @param m
	 * @return
	 */
	public int updateProImg(Connection con, userMember m) throws MemberException{
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("updateProImg");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getProimg());
			pstmt.setString(2, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	
	}
	
	
	/**
	 * 작성자  : 박주완
	 * 작성일 : 2020. 2. 17.
	 * 내용 : 아이디 찾기
	 */
	public userMember userSearch(Connection con,String phone,String email) {
		PreparedStatement pstmt= null;
		ResultSet rset = null;
		userMember m = null;
		
		try {
			String sql = prop.getProperty("searchId");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phone);
			pstmt.setString(2, email);
			rset = pstmt.executeQuery();
			while(rset.next()) {
					m = new userMember();
					m.setUserId(rset.getString("userId"));
					m.setEnrolldate(rset.getDate("enrolldate"));
					System.out.println("userId : "+ m);
			}
			
			
		} catch (Exception e) {
			
		} finally {
			close(pstmt);
			close(rset);
		}
		
		return m;
	}
	
	/**
	 * 작성자  : 박주완
	 * 작성일 : 2020. 2. 17.
	 * 내용 : 비밀번호찾기 임시비밀번호 발급 후 DB업데이트
	 * @param authenticationKey 
	 */
	public int userPwdSearch(Connection con,String id, String email, String authenticationKey) {
		PreparedStatement pstmt= null;
		userMember m = null;
		int result = 0;
		try {
			String sql = prop.getProperty("searchPwd");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, authenticationKey);
			pstmt.setString(2, email);
			pstmt.setString(3, id);
			System.out.println("------------DAO------------");
			System.out.println("입력받은 아이디 : "+ id);
			System.out.println("입력받은 이메일 : "+ email);
			System.out.println("변경할 임시 비밀번호 : "+ authenticationKey);
			System.out.println("------------DAO END------------");
			
			result = pstmt.executeUpdate();
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		
		return result;
	}
	
	
	/**
	 * 작성자  : 신지영
	 * 작성일 : 2020. 2. 16.
	  * 프로필 배경 사진 변경
	 * @param con
	 * @param m
	 * @return
	 * @throws MemberException
	 */
	public int updateProBack(Connection con, userMember m) throws MemberException{
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("updateProBack");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, m.getProback());
			pstmt.setString(2, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	/**
	 * 작성자  : 신지영
	 * 작성일 : 2020. 2. 17.
	  * 프로필 사진 삭제 변경
	 * @param con
	 * @param m
	 * @return
	 */
	public int deleteProImg(Connection con, userMember m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("deleteProImg");
			
			pstmt = con.prepareStatement(sql);
			
			//pstmt.setString(1, m.getProback());
			pstmt.setString(1, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	/**
	 * 작성자  : 신지영
	 * 작성일 : 2020. 2. 17.
	  * 프로필 배경 사진 삭제 변경
	 * @param con
	 * @param m
	 * @return
	 */
	public int deleteProBack(Connection con, userMember m) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("deleteProBack");
			
			pstmt = con.prepareStatement(sql);
			
			//pstmt.setString(1, m.getProback());
			pstmt.setString(1, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	/**
	 * 작성자  : 윤석훈
	 * 작성일 : 2020. 2. 18.
	 * 개인정보 변경 
	 * @param con
	 * @param m
	 * @return
	 */
	public int changeMember(Connection con, userMember m) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("chahgeMember");
			
			pstmt = con.prepareStatement(sql);
			
			//pstmt.setString(1, m.getProback());
			pstmt.setString(1, m.getUserpwd());
			pstmt.setString(2, m.getEmail());
			pstmt.setString(3, m.getPhone());
			pstmt.setString(4, m.getUserId());
			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	/**
	 * 작성자  : 윤석훈
	 * 작성일 : 2020. 2. 18.
	 * 비밀번호 확인
	 * @param con
	 * @param m
	 * @return
	 */
	public userMember pwdchk(Connection con, userMember m) {
		userMember result = null; // 결과를 담을 객체
		PreparedStatement pstmt = null;
		ResultSet rset = null; // Select의 결과를 담을 객체
		
		try {
			String sql = prop.getProperty("pwdchk");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, m.getUserId());
			pstmt.setString(2, m.getUserpwd());
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = new userMember();
				
				result.setUserId(rset.getString("USERID"));
				result.setUserpwd(rset.getString("USERPWD"));
				result.setUserName(rset.getString("USERNAME"));
				result.setEmail(rset.getString("EMAIL"));
				result.setPhone(rset.getString("PHONE"));
				result.setGender(rset.getString("GENDER"));
				result.setMycomment(rset.getString("MYCOMMENT"));
				result.setProimg(rset.getString("PROIMG"));
				result.setProback(rset.getString("PROBACK"));
			}	
		}catch(Exception e) {
			e.printStackTrace();

		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}

	/**
	 * 작성자  : 윤석훈
	 * 작성일 : 2020. 2. 18.
	 * 회원탈퇴
	 * @param con
	 * @param m
	 * @return
	 */
	public int memberOut(Connection con, userMember m) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("memberOut");
			
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, m.getUserId());

			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public ArrayList<userMember> selectList(Connection con, String result) {
		ArrayList<userMember> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectSearch");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, result);

			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				userMember result1 = new userMember();
				
				result1.setUserId(rset.getString("USERID"));
				result1.setUserpwd(rset.getString("USERPWD"));
				result1.setUserName(rset.getString("USERNAME"));
				result1.setEmail(rset.getString("EMAIL"));
				result1.setPhone(rset.getString("PHONE"));
				result1.setGender(rset.getString("GENDER"));
				result1.setMycomment(rset.getString("MYCOMMENT"));
				result1.setProimg(rset.getString("PROIMG"));
				result1.setProback(rset.getString("PROBACK"));
				
				list.add(result1);
			
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		

		return list;
	}

	public userMember selectProfileMember(Connection con, String userid) {
		userMember result = null; // 결과를 담을 객체
		PreparedStatement pstmt = null;
		ResultSet rset = null; // Select의 결과를 담을 객체
		
		try {
			String sql = prop.getProperty("selectProfileMember");
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userid);
		
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				result = new userMember();
				
				result.setUserId(rset.getString("USERID"));
				result.setUserpwd(rset.getString("USERPWD"));
				result.setUserName(rset.getString("USERNAME"));
				result.setEmail(rset.getString("EMAIL"));
				result.setPhone(rset.getString("PHONE"));
				result.setGender(rset.getString("GENDER"));
				result.setMycomment(rset.getString("MYCOMMENT"));
				result.setProimg(rset.getString("PROIMG"));
				result.setProback(rset.getString("PROBACK"));
			}	
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return result;
	}





}
