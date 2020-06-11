package com.sixdays.p_board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.p_board.model.service.p_BoardService;
import com.sixdays.p_board.model.vo.p_Board;

/**
 * Servlet implementation class pBoardSelectUserProfileServlet
 */
@WebServlet("/userprofile.bo")
public class pBoardSelectUserProfileServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pBoardSelectUserProfileServlet() {
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
	      
	      String pno = request.getParameter("pbno");
	      String userid = request.getParameter("userid");
	      
	      System.out.println("유저프로필 서블릿 테스트 PNO 는 "+ pno+ "userId는 " + userid);
	      
	       p_BoardService pb = new p_BoardService();     
	       p_Board pb2 = pb.selectOne(pno);
	       

	       

	       /*/views/user/Profile.jsp*/
	      String page = "";
	      
	      if(pb2 != null) {
	    	  ArrayList<p_Board> list = pb.selectList(userid);
	    	  if(list != null) {
	         page = "/views/user/ProfilePeople.jsp";
	         request.setAttribute("pb2", pb2);
	         request.setAttribute("list", list);
	         System.out.println("유저프로필 서블릿 성공");
	    	  }
	      } else {
	         request.setAttribute("msg", "유저프로필 상세보기 실패!");
	         System.out.println("유저프로필 서블릿 에러");
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
