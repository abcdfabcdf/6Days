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
 * Servlet implementation class CommentUpdateServlet
 */
@WebServlet("/UpdateComment.qo")
public class CommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ccontent = request.getParameter("ccontent");
		int qno = Integer.parseInt(request.getParameter("qno"));
		int cno = Integer.parseInt(request.getParameter("cno"));
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
		
		QnAComment qco = new QnAComment();
		
		qco.setQno(qno);
		qco.setCno(cno);
		qco.setCcontent(ccontent);
		qco.setCdate(cdate);
		
		System.out.println("qco : " + qco);
		int result = new QnACommentService().updateComment(qco);
		
		if(result > 0) {
			
			response.sendRedirect("qSelectOne.qo?qno=" + qno);
		} else {
			request.setAttribute("msg", "댓글 수정 실패!");
		
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
