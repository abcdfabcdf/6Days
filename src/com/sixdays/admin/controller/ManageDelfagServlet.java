package com.sixdays.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.admin.model.service.adminService;
import com.sixdays.admin.model.vo.userManage;
import com.sixdays.board.model.service.BoardService;
import com.sixdays.board.model.vo.Board;
import com.sixdays.p_board.model.service.p_BoardService;
import com.sixdays.userMember.model.exception.MemberException;
import com.sixdays.userMember.model.service.userMemberService;
import com.sixdays.userMember.model.vo.userMember;

/**
 * Servlet implementation class ManageDelfagServlet
 */
@WebServlet("/mDelfagN.ad")
public class ManageDelfagServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageDelfagServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
		String userId = request.getParameter("userid");
	      

	      
	      int result = new adminService().delflagcheckN(userId);
	      
	    
	     
	      
			if(result > 0) {

				response.sendRedirect("/6Days/aManage.ad");
			
			} else {
				System.out.println("실패");

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
