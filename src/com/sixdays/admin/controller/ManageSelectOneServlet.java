package com.sixdays.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.admin.model.service.adminService;
import com.sixdays.admin.model.vo.userManage;
import com.sixdays.board.model.service.BoardService;
import com.sixdays.board.model.vo.Board;

/**
 * Servlet implementation class ManageSelectOneServlet
 */
@WebServlet("/mSelectOne.ad")
public class ManageSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		
		System.out.println(userId);
		
		adminService as = new adminService();
		
		userManage u = as.selectOne(userId);
		ArrayList<userManage> list = as.selectUserList(userId);
		
		
		String page = "";
		 
		if(u != null) {
			page = "views/admin/user_managedetail.jsp";
			request.setAttribute("list", list);
			request.setAttribute("userManage", u);
			
		} else {
			request.setAttribute("msg", "사용자 관리자 상세보기 실패!");
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
