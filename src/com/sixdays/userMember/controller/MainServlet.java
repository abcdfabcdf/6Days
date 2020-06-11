package com.sixdays.userMember.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.maincomment.model.service.MainCommentService;
import com.sixdays.maincomment.model.vo.MainComment;
import com.sixdays.p_board.model.service.p_BoardService;
import com.sixdays.p_board.model.vo.p_Board;

/**
 * Servlet implementation class MainServlet
 */
@WebServlet("/main.me")
public class MainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  ArrayList<p_Board> list = null;
		  p_BoardService pb = new p_BoardService();
		  list = pb.allList();
		  
		  ArrayList<MainComment> mlist = null;
		  
		  
		  MainCommentService mcs = new MainCommentService();
		  mlist = mcs.selectList();
		  
		  System.out.println("ddddddddddddddddddddd : " +  mlist);
		  
		  
		  
		  String page = "";
		  
		  if(list != null) {
		         
		         page = "/main.jsp";
		         request.setAttribute("list", list);
		         request.setAttribute("mlist", mlist);
		      } else {
		         
		         System.out.println("메인 페이지 조회 실패!");
		         request.setAttribute("msg", "메인페이지 조회 실패!!");
		         
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
