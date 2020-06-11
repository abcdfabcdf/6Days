package com.sixdays.like.model.service;

import static com.sixdays.common.JDBCTemplate.*;

import java.sql.Connection;

import com.sixdays.like.model.dao.LikeDao;
import com.sixdays.like.model.vo.LikeUser;
import com.sixdays.userMember.model.exception.MemberException;
import com.sixdays.userMember.model.vo.userMember;

public class LikeService {
	private LikeDao lDao = new LikeDao();

	public int insertLike(LikeUser lu) {
		Connection con = getConnection();
		
		int result = lDao.insertComment(con, lu);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public int UpdateLike(LikeUser lu) {
		Connection con = getConnection();
		
		int result = lDao.UpdateLike(con, lu);
		
		if(result > 0) commit(con);
		else rollback(con);
		
		close(con);
		
		return result;
	}

	public LikeUser selectLike(int pbno) {
		Connection con = getConnection();
		
		LikeUser result = lDao.selectLike(con,pbno);
		
		close(con);
		

		return result;
	}
	
	

}
