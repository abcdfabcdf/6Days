package com.sixdays.qnacomment.model.service;

import static com.sixdays.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.sixdays.qnacomment.model.dao.QnACommentDao;
import com.sixdays.qnacomment.model.vo.QnAComment;

public class QnACommentService {
	
	private QnACommentDao qcDao = new QnACommentDao();
	
	public ArrayList<QnAComment> selectList(int qno){
		Connection con = getConnection();
		
		ArrayList<QnAComment> clist = qcDao.selectList(con, qno);
		
		close(con);
		
		return clist;
	}
	
	

	public int insertComment(QnAComment qco) {
		Connection con = getConnection();
		
		int result = qcDao.insertComment(con,qco);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		return result;
	}



	public int updateComment(QnAComment qco) {
		Connection con = getConnection();
		
		int result = qcDao.updateComment(con, qco);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}
	public int updateComment2(int qno) {
		Connection con = getConnection();
		
		int result = qcDao.updateComment2(con, qno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}



	public int deleteComment(int cno) {
		Connection con = getConnection();
		
		int result = qcDao.deleteComment(con, cno);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
		}
	}

