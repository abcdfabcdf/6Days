package com.sixdays.qna.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.qna.model.service.QnAService;
import com.sixdays.qna.model.vo.QnA;

/**
 * Servlet implementation class QnAUpdateServlet
 */
@WebServlet("/qUpdate.qo")
public class QnAUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String qtype = request.getParameter("qtype");
		String qtitle = request.getParameter("qtitle");
		String qcontent = request.getParameter("qcontent");
		int qno = Integer.parseInt(request.getParameter("qno"));
		String qnafile = request.getParameter("qnafile");
		
		QnA q = new QnA();
		
		q.setQno(qno);
		q.setQtype(qtype);
		q.setQtitle(qtitle);
		q.setQnafile(qnafile);
		q.setQcontent(qcontent);
		
		int result = new QnAService().updateQnA(q);
		
		if(result > 0) {
			response.sendRedirect("qSelectOne.qo?qno=" + qno);
		} else {
			request.setAttribute("msg", "QnA 수정 실패");
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
