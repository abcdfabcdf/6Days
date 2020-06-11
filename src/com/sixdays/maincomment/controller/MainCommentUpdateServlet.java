package com.sixdays.maincomment.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.maincomment.model.service.MainCommentService;
import com.sixdays.maincomment.model.vo.MainComment;

/**
 * Servlet implementation class MainCommentUpdateServlet
 */
@WebServlet("/UpdateComment.mo")
public class MainCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainCommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String mcontent = request.getParameter("ncontent");
		int pbno = Integer.parseInt(request.getParameter("pbno"));
		int mno = Integer.parseInt(request.getParameter("mno"));
		
		MainComment mc = new MainComment();
		
		mc.setPbno(pbno);
		mc.setMno(mno);
		mc.setMcontent(mcontent);
		
		System.out.println("mc : " + mc);
		
		int result = new MainCommentService().updateComment(mc);
		
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
