package com.sixdays.p_board.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.board.model.service.BoardService;
import com.sixdays.p_board.model.service.p_BoardService;

/**
 * Servlet implementation class pBoardDeletePostServlet
 */
@WebServlet("/pdelete.bo")
public class pBoardDeletePostServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pBoardDeletePostServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  //1. 인코딩
	      request.setCharacterEncoding("UTF-8");
	      response.setContentType("application/json; charset=UTF-8");
	      
	      System.out.println("p보드 게시물 삭제 서블릿 동작.");
/*	     
	      int cno = Integer.parseInt(request.getParameter("cno"));
	      String pbnostr = request.getParameter("pbno");
	      
	      */
	      
	      int pbno = Integer.parseInt(request.getParameter("pbno"));
	      

	      System.out.println("불러온 pbno값 : " + pbno);
	      
	      int result = new p_BoardService().deletepBoard(pbno);
	      
	     
	      
			if(result > 0) {
				System.out.println("p보드 게시물 삭제 완료.");
		
				
				
			} else {
				request.setAttribute("msg", "게시물 삭제 실패!");
				System.out.println("p보드 게시물 삭제 실패.");
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
