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
import com.sixdays.board.model.vo.PageInfo;

/**
 * Servlet implementation class ReportServlet
 */
@WebServlet("/report.ad")
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Report> list = null;
		
		adminService as = new adminService();
		
		/*int startPage;
		
		int endPage;  
		
		int maxPage;
		
		int currentPage;
		
		int limit;
		
		currentPage = 1;
		
		limit = 10;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}*/
		
		/*int rlistCount = as.getrListCount();
		
		System.out.println("신고사항 게시판 총 페이지 갯수 : " + rlistCount);
		
		maxPage = (int)((double)rlistCount / limit + 0.9);
		
		startPage = ((int)((double)currentPage / limit + 0.9)-1) * limit + 1;
		
		endPage = startPage + limit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		*/
		
//		list = as.rselectList(currentPage, limit);
		list = as.rselectList();
		
		String page = "";
		
		if(list != null) {
			page = "/views/admin/report.jsp";
			request.setAttribute("list", list);
			
			//PageInfo pi = new PageInfo(currentPage, rlistCount, limit, maxPage, startPage, endPage);
			
//			request.setAttribute("pi", pi);
		} else {
			page = "";
			request.setAttribute("msg", "신고사항관리 목록 불러오기 에러!");
			
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
