package com.sixdays.maincomment.model.service;

import static com.sixdays.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.sixdays.maincomment.model.dao.MainCommentDao;
import com.sixdays.maincomment.model.vo.MainComment;

public class MainCommentService {
	
	private MainCommentDao mco = new MainCommentDao();

	public ArrayList<MainComment> selectList() {
		Connection con = getConnection();
		
		ArrayList<MainComment> mlist = mco.selectList(con);
		
		close(con);
		
		return mlist;
	}
	

	public int insertComment(MainComment mc) {
		Connection con = getConnection();
		
		int result = mco.insertComment(con, mc);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}


	public int updateComment(MainComment mc) {
		Connection con = getConnection();
		
		int result = mco.updateComment(con, mc);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}


	public int deleteComment(int mno) {
		Connection con = getConnection();
		
		int result = mco.deleteComment(con, mno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}


	public ArrayList<MainComment> selectOneList(String pno) {
		Connection con = getConnection();
		
		ArrayList<MainComment> mlist = mco.selectOneList(con,pno);
		
		close(con);
		
		return mlist;
	}
}
