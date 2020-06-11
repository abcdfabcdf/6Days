package com.sixdays.board.model.dao;

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

import com.sixdays.board.model.vo.Board;

public class BoardDao {
	private Properties prop;
	
	public BoardDao() {
		
		prop = new Properties();
		
		String filePath = Board.class.getResource("/config/board-query.properties").getPath();
		
		try {
			prop.load(new FileReader(filePath));
		} catch(IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Board> selectList(Connection con, int currentPage, int limit) {
		ArrayList<Board> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectList");
		
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
				Board b = new Board();
				
				b.setRnum(rset.getInt("rnum"));
				b.setBno(rset.getInt("bno"));
				b.setBtitle(rset.getString("btitle"));
				b.setBwriter(rset.getString("bwriter"));
				b.setBdate(rset.getDate("bdate"));
				b.setBcount(rset.getInt("bcount"));
				
				list.add(b);
			
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
	
	

	/**
	 * 공지사항 추가
	 * @param con
	 * @param b
	 * @return
	 */
	public int insertBoard(Connection con, Board b) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("insertBoard");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, b.getBtitle());
			pstmt.setString(2, b.getBcontent());
			pstmt.setString(3, b.getBwriter());
			pstmt.setString(4, b.getBoardfile());
			pstmt.setDate(5, b.getBdate());

			result = pstmt.executeUpdate();
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/** 
	 * 공지사항 세부내용
	 * @param con
	 * @param bno
	 * @return
	 */
	public Board selectOne(Connection con, int bno) {
		Board b = null;
		
		PreparedStatement pstmt = null;
		
		ResultSet rset = null;
		
		String sql = prop.getProperty("selectOne");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			rset = pstmt.executeQuery();
			
			if(rset.next()) {
				b = new Board();
				
				b.setBno(bno);
				b.setBtitle(rset.getString("btitle"));
				b.setBdate(rset.getDate("bdate"));
				b.setBwriter(rset.getString("bwriter"));
				b.setBoardfile(rset.getString("boardfile"));
				b.setBcontent(rset.getString("bcontent"));
				}
			
			System.out.println("board 확인 : " + b);
			} catch(SQLException e) {
				e.printStackTrace();
			} finally {
				close(rset);
				close(pstmt);
			}
			return b;
		}

	/**
	 * 공지사항 조회수
	 * @param con
	 * @param bno
	 * @return
	 */
	public int updateReadCount(Connection con, int bno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateReadCount");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/** 공지사항 수정
	 * @param con
	 * @param b
	 * @return
	 */
	public int updateBoard(Connection con, Board b) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("updateBoard");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, b.getBtitle());
			pstmt.setString(2, b.getBcontent());
			pstmt.setString(3, b.getBoardfile());
			pstmt.setInt(4, b.getBno());
			
			result = pstmt.executeUpdate();
	
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 공지수항 삭제
	 * @param con
	 * @param bno
	 * @return
	 */
	public int deleteBoard(Connection con, int bno) {
		int result = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = prop.getProperty("deleteBoard");
		
		try {
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bno);
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(pstmt);
		}
		return result;
	}

	/**
	 * 공지사항 카운트
	 * @param con
	 * @return
	 */
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
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(stmt);
		}
		return listCount;
	}




	/**
	 * 공지사항 검색
	 * @param con
	 * @param category
	 * @param keyword
	 * @return
	 */
	public ArrayList<Board> searchBoard(Connection con, String category, String keyword, int currentPage, int limit) {
		ArrayList<Board> list = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;
		
		String sql = null;
		
		switch(category) {
		case "title" :
			sql = prop.getProperty("searchTitleBoard");
			break;
		case "writer" :
			sql = prop.getProperty("searchWriterBoard");
			break;
		}
		
		try {
			pstmt = con.prepareStatement(sql);
			
			int startRow = (currentPage-1) * limit + 1;
			int endRow = startRow + limit - 1;
			
			pstmt.setString(1, keyword);
			pstmt.setInt(2, endRow);
			pstmt.setInt(3, startRow);
			
			rset = pstmt.executeQuery();
			
			list = new ArrayList<Board>();
			
			while(rset.next()) {
				Board b = new Board();
				
				b.setRnum(rset.getInt("rnum"));
				b.setBno(rset.getInt("bno"));
				b.setBtitle(rset.getString("btitle"));
				b.setBcontent(rset.getString("bcontent"));
				b.setBwriter(rset.getString("bwriter"));
				b.setBcount(rset.getInt("bcount"));
				b.setBdate(rset.getDate("bdate"));
				System.out.println(b);
				list.add(b);
			}
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			close(rset);
			close(pstmt);
		}
		return list;
	}

	public int getListSubCount(Connection con, String category, String keyword) {
	      int listCount = 0;
	      
	      PreparedStatement pstmt = null;
	      ResultSet rset = null;
	     
	      String sql = null;
	      
	      switch(category) {
	      case "title" :
				sql = prop.getProperty("listTitleCount");
				break;
		  case "writer" :
				sql = prop.getProperty("listWriterCount");
				break;
	      }
	      
	      try {
	         pstmt = con.prepareStatement(sql);
	         
	         pstmt.setString(1, keyword);
	         
	         rset = pstmt.executeQuery();
	         
	         if(rset.next()) {
	            listCount = rset.getInt(1);
	         }
	      }catch(SQLException e) {
	         e.printStackTrace();
	      }finally {
	         close(rset);
	         close(pstmt);
	      }
	      return listCount;
	}

	
	
}
