package com.sixdays.userMember.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.p_board.model.service.p_BoardService;
import com.sixdays.p_board.model.vo.p_Board;
import com.sixdays.userMember.model.service.userMemberService;
import com.sixdays.userMember.model.vo.userMember;

/**
 * Servlet implementation class userSearchServlet
 */
@WebServlet("/usersearch.me")
public class userSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<userMember> list = null;
	      String result = request.getParameter("result");
	      userMemberService um = new userMemberService();
	      list =um.selectList(result);
	      

	      
	      String page = "";
	      
	      if(list != null) {
	         
	         page = "/views/user/UserSearch.jsp";
	         request.setAttribute("list", list);
	      } else {
	         
	         System.out.println("마이 페이지 조회 실패!");
	         request.setAttribute("msg", "사진 게시판 목록 조회 실패!!");
	         
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
