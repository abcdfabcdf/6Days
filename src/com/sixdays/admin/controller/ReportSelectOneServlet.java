package com.sixdays.admin.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.admin.model.service.adminService;
import com.sixdays.admin.model.vo.Report;
import com.sixdays.admin.model.vo.userManage;

/**
 * Servlet implementation class ReportSelectOneServlet
 */
@WebServlet("/sone.rp")
public class ReportSelectOneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportSelectOneServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		System.out.println("신고사항 상세보기 서블릿 작동.");
		System.out.println("선택한 게시물 작성자 : "+userId);
		
		adminService as = new adminService();
		
		Report rep = as.reportselectOne(userId);
		ArrayList<Report> rlist = as.reportList(userId);
		
		
		String page = "";
		 
		if(rep != null) {
			page = "views/admin/reportdetail.jsp";
			request.setAttribute("rlist", rlist);
			request.setAttribute("report", rep);
			System.out.println("신고사항  상세보기 서블릿 성공.");
			
		} else {
			request.setAttribute("msg", "신고사항 상세보기 실패!");
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
