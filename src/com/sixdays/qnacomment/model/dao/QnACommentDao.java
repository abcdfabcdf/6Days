package com.sixdays.qnacomment.model.dao;

import static com.sixdays.common.JDBCTemplate.close;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Properties;

import com.sixdays.qnacomment.model.vo.QnAComment;

public class QnACommentDao {

	private Properties prop;
	
	public QnACommentDao() {
		prop = new Properties();
		
		String filePath = QnACommentDao.class.getResource("/config/comment-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	/**
	 * QnA 댓글 조회
	 * @param con
	 * @param qno
	 * @return
	 */
	public ArrayList<QnAComment> selectList(Connection con, int qno) {
		ArrayList<QnAComment> clist = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, qno);
			
			rset = pstmt.executeQuery();
			
			clist = new ArrayList<QnAComment>();
			
			while(rset.next()) {
				QnAComment qco = new QnAComment();
				
				qco.setCno(rset.getInt("CNO"));
				qco.setQno(qno);
				qco.setCcontent(rset.getString("CCONTENT"));
				qco.setCwriter(rset.getString("CWRITER"));
				qco.setRefcno(rset.getInt("REF_CNO"));
				qco.setClevel(rset.getInt("CLEVEL"));
				qco.setCproimg(rset.getString("PROIMG"));
				qco.setCdate(rset.getDate("CDATE"));
				
				clist.add(qco);
				
				System.out.println(clist);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return clist;
	}
	
	public int insertComment(Connection con, QnAComment qco) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertComment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, qco.getQno());
			pstmt.setString(2, qco.getCcontent());
			pstmt.setString(3, qco.getCwriter());
			
			if(qco.getRefcno() > 0) {
				pstmt.setInt(4, qco.getRefcno());
			} else {
				pstmt.setNull(4, java.sql.Types.NULL);
			}
			pstmt.setInt(5, qco.getClevel());
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int updateComment(Connection con, QnAComment qco) {

		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateComment");
		
		try {
			pstmt = con.prepareStatement(sql);
		
			pstmt.setString(1, qco.getCcontent());
			pstmt.setDate(2, qco.getCdate());
			pstmt.setInt(3, qco.getCno());
			
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;

	
	}
	
	public int updateComment2(Connection con, int qno) {
		
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateComment2");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, qno);
			pstmt.setInt(2, qno);
				
			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	public int deleteComment(Connection con, int cno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteComment");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, cno);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}	
	
	
}
