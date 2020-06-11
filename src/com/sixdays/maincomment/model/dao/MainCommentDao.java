package com.sixdays.maincomment.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.sixdays.maincomment.model.vo.MainComment;
import com.sixdays.qnacomment.model.dao.QnACommentDao;

import static com.sixdays.common.JDBCTemplate.*;


public class MainCommentDao {
	
	private Properties prop;
	
	public MainCommentDao() {
		prop = new Properties();
		
		String filePath = QnACommentDao.class.getResource("/config/maincomment-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch(IOException e) {
			e.printStackTrace();
		}	
	}

	public ArrayList<MainComment> selectList(Connection con) {
		ArrayList<MainComment> mlist = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectComment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			
			rset = pstmt.executeQuery();
			
			mlist = new ArrayList<MainComment>();
			
			while(rset.next()) {
				MainComment mc = new MainComment();
				mc.setPbno(rset.getInt("PBNO"));
				mc.setMno(rset.getInt("MNO"));
				mc.setMcontent(rset.getString("MCONTENT"));
				mc.setMwriter(rset.getString("USERNAME"));
				mc.setCproimg(rset.getString("PROIMG"));
				mc.setMnickname(rset.getString("MNICKNAME"));
				mc.setMdate(rset.getDate("MDATE"));
				
				mlist.add(mc);
				
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$ mlist : " + mlist);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return mlist;
	}

	public int insertComment(Connection con, MainComment mc) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertComment");
		
		try {
			
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, mc.getPbno());
			pstmt.setString(2, mc.getMcontent());
			pstmt.setString(3, mc.getMwriter());
			pstmt.setString(4, mc.getMnickname());
			
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateComment(Connection con, MainComment mc) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateComment");
		
		try {
			pstmt = con.prepareStatement(sql);
		
			pstmt.setString(1, mc.getMcontent());
			pstmt.setInt(2, mc.getMno());
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	}

	
	
	public int deleteComment(Connection con, int mno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteComment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, mno);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public ArrayList<MainComment> selectOneList(Connection con, String pno) {
		ArrayList<MainComment> mlist = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOneComment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1,pno);
			
			rset = pstmt.executeQuery();
			
			mlist = new ArrayList<MainComment>();
			
			while(rset.next()) {
				MainComment mc = new MainComment();
				mc.setPbno(rset.getInt("PBNO"));
				mc.setMno(rset.getInt("MNO"));
				mc.setMcontent(rset.getString("MCONTENT"));
				mc.setMwriter(rset.getString("USERNAME"));
				mc.setCproimg(rset.getString("PROIMG"));
				mc.setMnickname(rset.getString("MNICKNAME"));
				mc.setMdate(rset.getDate("MDATE"));
				
				mlist.add(mc);
				
				System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$ mlist : " + mlist);
			}
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return mlist;
	}
}


