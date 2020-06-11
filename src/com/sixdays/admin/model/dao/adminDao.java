package com.sixdays.admin.model.dao;

import static com.sixdays.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

import javax.sql.StatementEvent;

import org.omg.PortableInterceptor.TRANSPORT_RETRY;

import com.sixdays.admin.model.vo.Advertisement;
import com.sixdays.admin.model.vo.Report;
import com.sixdays.admin.model.vo.userManage;
import com.sixdays.board.model.vo.Board;
import com.sixdays.p_board.model.vo.p_Board;
import com.sixdays.userMember.model.exception.MemberException;

public class adminDao {
	private Properties prop; 
	
	public adminDao() {
		
		prop = new Properties();
	
		String filePath = userManage.class.getResource("/config/admin-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<userManage> selectList(Connection con, int currentPage, int limit) {
		ArrayList<userManage> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectaManage");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			int startRow = (currentPage-1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			
			
			System.out.println("strat : "+startRow);
			System.out.println("strat : "+endRow);
			
			pstmt.setInt(1, endRow);
			pstmt.setInt(2, startRow);
			rset = pstmt.executeQuery();
			
			list = new ArrayList<>();
			
			while(rset.next()) {
				userManage u = new userManage();
				
				u.setRownum(rset.getInt(1));
				u.setUserId(rset.getString(2));
				u.setUserName(rset.getString(3));
				u.setpCount(rset.getInt(4));
				u.setEnrolldate(rset.getDate(5));
				u.setDelflag(rset.getString(6));
				
				
				list.add(u);
			
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		
		System.out.println("list : "+list);
		return list;
	}

	
	
	
	
	
	
	public int getListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("listCount");
		
		try {
			stmt = con.createStatement();
			
			rset = stmt.executeQuery(sql);
			
			if(rset.next()) {
				listCount = rset.getInt(1);
			}
			System.out.println(listCount);
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}

	/**
	 * 관리자(사용자 관리) 세부내용
	 * @param con
	 * @param userId
	 * @return
	 */
	public userManage selectOne(Connection con, String userId) {
		userManage u = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			 
			if(rset.next()) {
				u = new userManage();
				
				u.setUserId(userId);
				u.setProimg(rset.getString("PROIMG"));
				u.setUserName(rset.getString("USERNAME"));
				u.setEmail(rset.getString("EMAIL"));
				u.setMycomment(rset.getString("MYCOMMENT"));
				u.setEnrolldate(rset.getDate("ENROLLDATE"));
			
				}
			
			System.out.println("userManage 확인 : " + u);
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return u;
	}

	public ArrayList<userManage> selectUserList(Connection con, String userId) {

		
		PreparedStatement pstmt = null;
		
		ArrayList<userManage> list = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectUserList");
		
		try {
		
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<userManage>();
			
			while(rset.next()) {
				
				userManage u = new userManage();
				
				u.setPdate(rset.getDate("PBDATE"));
				u.setPcontent(rset.getString("PCONTENT"));
				
				list.add(u);	
				
			}
			
		} catch (SQLException e) {
			e.printStackTrace();	
		}finally {
			close(rset);
			close(pstmt);
			
		}
	
		return list;
	}

	public int updateDelfag(Connection con, userManage u) throws MemberException {
		int result = 0;
		PreparedStatement pstmt = null;
		System.out.println("dsdass");
		
		try {	
			String sql = prop.getProperty("updateDelfag");

			pstmt = con.prepareStatement(sql);	
			
			pstmt.setString(1, u.getUserId());		
			
			result = pstmt.executeUpdate();
		
			
		}catch(SQLException e) {
			throw new MemberException(e.getMessage());
		}finally {
			close(pstmt);
		}
		
		return result;
		
		
	}
	
//	--------------------------------------------------
//	신고사항 관리 


	public ArrayList<Report> rselectList(Connection con) {
	
		ArrayList<Report> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		
		String sql = prop.getProperty("selectReport");
	
	try {
		pstmt = con.prepareStatement(sql);
		  
		/*int startRow = (currentPage-1) * limit + 1;
		int endRow = startRow + limit - 1;*/
		
/*
		System.out.println("start : "+startRow);
		System.out.println("end : "+endRow);*/
		
		/*pstmt.setInt(1, endRow);
		pstmt.setInt(2, startRow);*/
		rset = pstmt.executeQuery();
		
		list = new ArrayList<>();
		
		while(rset.next()) {
		
		Report r = new Report();
	
		r.setRownum(rset.getInt("PBNO"));
		r.setUserId(rset.getString("PBWRITER"));
		r.setUserName(rset.getString("USERNAME"));
		r.setStatus(rset.getString("DELFLAG"));
		r.setBlockflag(rset.getString("BLOCKFLAG"));
		r.setReport_yn(rset.getString("REPORT_YN"));
		
				
	
		list.add(r);
	
	}
	
	} catch(SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(pstmt);
	}
	

		return list;
	}
	
	public int getrListCount(Connection con) {
		int listCount = 0;
		Statement stmt = null;
		ResultSet rset = null;
	
		String sql = prop.getProperty("listCount");
	
	try {
		stmt = con.createStatement();
	
		rset = stmt.executeQuery(sql);
	
	if(rset.next()) {
		listCount = rset.getInt(1);
	}
		System.out.println("신고사항 DAO 리스트 카운트 : "+listCount);
	} catch(SQLException e) {
		e.printStackTrace();
	} finally {
		close(rset);
		close(stmt);
	}
		return listCount;
	}

	public int delflagcheckN(Connection con, String userid) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("delflagcheckN");
			
			pstmt = con.prepareStatement(sql);
			

			pstmt.setString(1, userid);

			
			result = pstmt.executeUpdate();

			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
	
	public int delflagcheckY(Connection con, String userid) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("delflagcheckY");
			
			pstmt = con.prepareStatement(sql);
			
			
			pstmt.setString(1, userid);
			
			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}

	public Report reportselectOne(Connection con, String userId) {
		Report rep = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectReportOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, userId);
			
			rset = pstmt.executeQuery();
			 
			if(rset.next()) {
				rep = new Report();

				rep.setUserId(userId);
				rep.setUserName(rset.getString("USERNAME"));
				rep.setProimg(rset.getString("PROIMG"));
				rep.setEmail(rset.getString("EMAIL"));
				rep.setMycomment(rset.getString("MYCOMMENT"));
				rep.setBlockflag(rset.getString("BLOCKFLAG"));
				
				
				
				}
			
			System.out.println("Report 확인 : " + rep);
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return rep;
	}
	
	
	/*신고관리 디테일에서 사용할 DOA */
	
public ArrayList<Report> reportList(Connection con, String userId) {
		
		ArrayList<Report> rlist = null;
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	      
	      String sql = prop.getProperty("selectReportList");
	      
	      try {
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setString(1, userId);
	         rset = pstmt.executeQuery();
	         
	         rlist = new ArrayList<>();
	         System.out.println("신고사항 리스트 DAO 작동");
	         while(rset.next()) {
	        	 Report rp= new Report();
	            
	        	rp.setUserId(userId);
				rp.setUserName(rset.getString("USERNAME"));
				rp.setProimg(rset.getString("PROIMG"));
				rp.setPbDate(rset.getString("PBDATE"));
				rp.setpContent(rset.getString("PCONTENT"));
				rp.setEmail(rset.getString("EMAIL"));
				rp.setMycomment(rset.getString("MYCOMMENT"));
				rp.setStatus(rset.getString("BLOCKFLAG"));
				rp.setRpno(rset.getInt("RPNO"));
				rp.setReason(rset.getString("REASON"));
				rp.setReportdate(rset.getString("RPDATE"));
				rp.setReleasedate(rset.getString("RELEASEDATE"));
				rp.setReporter(rset.getString("REPORTER"));
				rp.setRpcount(rset.getInt("RPCOUNT"));
	            rp.setHashtag(rset.getString("HASHTAG"));
	            
	            rlist.add(rp);
	         System.out.println("rlist : "+ rlist);
	         }
	         
	      } catch(SQLException e) {
	         e.printStackTrace();
	      } finally {
	         close(rset);
	         close(pstmt);
	      }
	   
	      return rlist;
	
	}

	public int userBlockDao(Connection con, String userId, String reason, int releasDate) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("userBlock");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, reason);
			pstmt.setInt(2, releasDate);
			pstmt.setString(3, userId);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int userReleaseDao(Connection con, String userId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("userRelease");
		
		try {
			pstmt = con.prepareStatement(sql);
	
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}
	
	public int userLoginUpdateDao(Connection con, String userId) {
		int result2 = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("userLoginBlock");
		
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			
			result2 = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result2;
	}
	
	public int userLoginReleaseDao(Connection con, String userId) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("userLoginRelease");
		
		try {
			pstmt = con.prepareStatement(sql);
	
			pstmt.setString(1, userId);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int amUpdate(Connection con, Advertisement a) {
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			String sql = prop.getProperty("amupdate");
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, a.getAdimg());
			
			result = pstmt.executeUpdate();
			
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
		
		return result;
	}
}
