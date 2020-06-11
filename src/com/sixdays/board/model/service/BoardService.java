package com.sixdays.board.model.service;

import static com.sixdays.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.sixdays.board.model.dao.BoardDao;
import com.sixdays.board.model.vo.Board;
import com.sixdays.board.model.vo.PageInfo;

public class BoardService {
	
	private BoardDao bDao = new BoardDao();
	

	/**
	 * 공지사항 목록 불러오기
	 * @return
	 */
	public ArrayList<Board> selectList(int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<Board> list = bDao.selectList(con, currentPage, limit);
		
		close(con);
		return list;
	}

	/**
	 * 공지사항 추가
	 * @param b
	 * @return
	 */
	public int insertBoard(Board b) {
		Connection con = getConnection();
		int result = bDao.insertBoard(con,b);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}


	/** 공지사항 세부내용
	 * @param bno
	 * @return
	 */
	public Board selectOne(int bno) {
		Connection con = getConnection();
		
		Board b = bDao.selectOne(con, bno);
		
		if(b != null) {
			int result = bDao.updateReadCount(con, bno);
			
			if(result > 0) commit(con);
			else rollback(con);
		}
		
		close(con);
		return b;
	}


	/**
	 * 공지사항 수정 창
	 * @param bno
	 * @return
	 */
	public Board updateView(int bno) {
		Connection con = getConnection();
		
		Board b = bDao.selectOne(con, bno);
		
		close(con);
		
		return b;
	}


	/**
	 * 공지사항 내용 수정
	 * @param b
	 * @return
	 */
	public int updateBoard(Board b) {
		Connection con = getConnection();
		
		int result = bDao.updateBoard(con,b);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}


	/**
	 * 공지사항 삭제
	 * @param bno
	 * @return
	 */
	public int deleteBoard(int bno) {
		Connection con = getConnection();
		
		int result = bDao.deleteBoard(con, bno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}


	/**
	 * 공지사항 카운트
	 * @return
	 */
	public int getListCount() {
		Connection con = getConnection();
		int listCount = bDao.getListCount(con);
		
		close(con);
		
		return listCount;
	}




	/**
	 * 공지사항 검색
	 * @param category
	 * @param keyword
	 * @return
	 */
	public ArrayList<Board> searchBoard(String category, String keyword, int currentPage, int limit) {
		Connection con = getConnection();
		
		ArrayList<Board> list = null;
		
		if(category.length() > 0) {
			list = bDao.searchBoard(con, category, keyword, currentPage, limit);
		} 
		close(con);
		return list;
	}

	public int getListSubCount(String category, String keyword) {
		Connection con = getConnection();
		
		int listCount = bDao.getListSubCount(con, category, keyword);
		
		close(con);
		
		return listCount;
	}
}

