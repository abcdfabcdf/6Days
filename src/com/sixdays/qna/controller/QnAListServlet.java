package com.sixdays.qna.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.board.model.vo.PageInfo;
import com.sixdays.qna.model.service.QnAService;
import com.sixdays.qna.model.vo.QnA;

/**
 * Servlet implementation class QnAListServlet
 */
@WebServlet("/selectList.qo")
public class QnAListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<QnA> list = null;
		QnAService qs = new QnAService();
		
		int startPage;
		
		int endPage;
		
		int maxPage;
		
		int currentPage;
		
		int limit;
		
		currentPage = 1;
		
		limit = 10;
		
		if(request.getParameter("currentPage") != null) {
			currentPage = Integer.parseInt(request.getParameter("currentPage"));
		}
		
		int listCount = qs.getListCount();
		
		System.out.println("총 페이지 갯수 : " + listCount);
		
		maxPage = (int)((double)listCount / limit + 0.9);
		
		startPage = ((int)((double)currentPage / limit + 0.9)-1) * limit + 1;
		
		endPage = startPage + limit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		list = qs.selectList(currentPage, limit); 
		
		String page = "";
		
		if(list != null) {
			page = "views/qna/QnAList.jsp";
			request.setAttribute("list", list);
			
			PageInfo pi = new PageInfo(currentPage, listCount, limit, maxPage, startPage, endPage);
			request.setAttribute("pi", pi);
		} else {
			page = "";
			request.setAttribute("msg", "QnA 목록 불러오기 에러!");
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
