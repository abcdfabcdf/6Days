package com.sixdays.qnacomment.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.qnacomment.model.service.QnACommentService;
import com.sixdays.qnacomment.model.vo.QnAComment;

/**
 * Servlet implementation class CommentDeleteServlet
 */
@WebServlet("/DeleteComment.qo")
public class CommentDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CommentDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int cno = Integer.parseInt(request.getParameter("cno"));
		int qno = Integer.parseInt(request.getParameter("qno"));
		
		int result = new QnACommentService().deleteComment(cno);
		
		if(result > 0) {
			int result2 = new QnACommentService().updateComment2(qno);
			if(result2 > 0) {
				response.sendRedirect("qSelectOne.qo?qno=" + qno);
			}
		} else {
			request.setAttribute("msg", "QnA 삭제 실패");
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
