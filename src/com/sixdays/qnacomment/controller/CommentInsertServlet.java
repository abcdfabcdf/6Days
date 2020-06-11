package com.sixdays.qnacomment.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.qnacomment.model.service.QnACommentService;
import com.sixdays.qnacomment.model.vo.QnAComment;

/**
 * Servlet implementation class CommentInsertServlet
 */
@WebServlet("/InsertComment.qo")
public class CommentInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String cwriter = request.getParameter("cwriter");
		int qno = Integer.parseInt(request.getParameter("qno"));
		String ccontent = request.getParameter("ccontent");
		int refcno = Integer.parseInt(request.getParameter("refcno"));
		int clevel = Integer.parseInt(request.getParameter("clevel"));
		String date = request.getParameter("cdate");

		Date cdate = null;
		if(date != "" && date != null) {
			// 날짜가 들어왔을 때
			// 2020-01-30 --> 2020, 1, 30
			String[] dateArr = date.split("-");
			int[] intArr = new int[dateArr.length];
			
			// String -> int
			for(int i=0; i<dateArr.length; i++) {
				intArr[i] = Integer.parseInt(dateArr[i]);
			}
			cdate = new Date(new GregorianCalendar(intArr[0], intArr[1]-1, intArr[2]).getTimeInMillis());
		} else {
			// 날짜가 들어오지 않으면
			cdate = new Date(new GregorianCalendar().getTimeInMillis());
		}
				
		QnAComment qco = new QnAComment(qno, ccontent, cwriter, refcno, clevel, cdate);
		
		int result = new QnACommentService().insertComment(qco);
		if(result > 0) {
			int result2 = new QnACommentService().updateComment2(qno);
			
			if(result2 >0) {
			response.sendRedirect("qSelectOne.qo?qno=" + qno);
			
		} else {
			request.setAttribute("msg", "댓글 작성 실패");
		}}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
