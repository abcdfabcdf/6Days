package com.sixdays.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.qna.model.service.QnAService;
import com.sixdays.qna.model.vo.QnA;
import com.sixdays.qnacomment.model.service.QnACommentService;
import com.sixdays.qnacomment.model.vo.QnAComment;

/**
 * Servlet implementation class QnASelectOneServlet
 */
@WebServlet("/qSelectOne.qo")
public class QnASelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnASelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int qno = Integer.parseInt(request.getParameter("qno"));
		
		QnAService qs = new QnAService();
		
		QnA q = qs.selectOne(qno);
		
		ArrayList<QnAComment> clist = new QnACommentService().selectList(qno);
		String page = "";
		
		if(q != null) {
			page = "views/qna/QnADetail.jsp";
			request.setAttribute("qna", q);
			request.setAttribute("clist", clist);
		} else {
			request.setAttribute("msg", "공지사항 상세보기 실패");
		}
		request.getRequestDispatcher(page).forward(request, response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
