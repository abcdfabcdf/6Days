package com.sixdays.maincomment.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.maincomment.model.service.MainCommentService;
import com.sixdays.maincomment.model.vo.MainComment;

/**
 * Servlet implementation class MainCommentServlet
 */
@WebServlet("/InsertComment.mo")
public class MainCommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainCommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int pbno = Integer.parseInt(request.getParameter("pbno"));
		int mno = Integer.parseInt(request.getParameter("mno"));
		String mwriter = request.getParameter("mwriter");
		String mcontent = request.getParameter("mcontent");
		String mnickname = request.getParameter("mnickname");
		String date = request.getParameter("mdate");
		
		Date mdate = null;
		if(date != "" && date != null) {
			// 날짜가 들어왔을 때
			// 2020-01-30 --> 2020, 1, 30
			String[] dateArr = date.split("-");
			int[] intArr = new int[dateArr.length];
			
			// String -> int
			for(int i=0; i<dateArr.length; i++) {
				intArr[i] = Integer.parseInt(dateArr[i]);
			}
			mdate = new Date(new GregorianCalendar(intArr[0], intArr[1]-1, intArr[2]).getTimeInMillis());
		} else {
			// 날짜가 들어오지 않으면
			mdate = new Date(new GregorianCalendar().getTimeInMillis());
		}
		
		System.out.println(mdate);
		MainComment mc = new MainComment(pbno, mno, mwriter, mcontent, mnickname, mdate);
		
		int result = new MainCommentService().insertComment(mc);
		
		response.getWriter().print(result);
		
						
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
