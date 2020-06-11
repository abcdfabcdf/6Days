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
 * Servlet implementation class QnASearchServlet
 */
@WebServlet("/qSearch.qo")
public class QnASearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnASearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String category = request.getParameter("category");
		String keyword = request.getParameter("keyword");
		
		System.out.println("category : " + category);
		System.out.println("keyword : " + keyword);
		
		ArrayList<QnA> list = new ArrayList<>();
		
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
		
		int listCount = qs.getListSubCount(category, keyword);
		
		
		System.out.println("listcount :" + listCount);
		
		maxPage = (int)((double)listCount / limit + 0.9);
		
		
		startPage = ((int)((double)currentPage / limit + 0.9)-1) * limit + 1;
		
		endPage = startPage + limit - 1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		list = qs.searchQnA(category, keyword, currentPage, limit);
		
		String page = "";
		
		if(list != null) {
			page = "views/qna/QnAList.jsp";
			request.setAttribute("list", list);
			
			PageInfo pi = new PageInfo(currentPage,listCount,limit,maxPage,startPage,endPage);
			request.setAttribute("pi", pi);
			
			request.setAttribute("category", category);
			request.setAttribute("keyword", keyword);
		} else {
			page = "";
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
