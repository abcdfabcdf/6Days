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
import com.sixdays.userMember.model.service.userMemberService;
import com.sixdays.userMember.model.vo.userMember;

/**
 * Servlet implementation class pBoardSelectListServlet
 */
@WebServlet("/pbSelect.bo")
public class pBoardSelectListServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pBoardSelectListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      ArrayList<p_Board> list = null;
      String userid = request.getParameter("userId");
      
      userMember m = new userMember(userid);
      
      userMemberService ms = new userMemberService();
      
      
      
      p_BoardService pb = new p_BoardService();
      
      
      list =pb.selectList(userid);
      

      
      String page = "";
      
      if(list != null) {
    	  m = ms.selectProfileMember(userid);
         page = "/views/user/Profile.jsp";
         request.setAttribute("list", list);
         request.setAttribute("user", m);
    	  
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