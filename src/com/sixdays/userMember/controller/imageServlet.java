package com.sixdays.userMember.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.p_board.model.service.p_BoardService;
import com.sixdays.p_board.model.vo.p_Board;

/**
 * Servlet implementation class imageServlet
 */
@WebServlet("/imageServlet.me")
public class imageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public imageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("application/json; charset=UTF-8");
	      String pno = request.getParameter("pbno");
	      String pw = request.getParameter("pbWriter");
	      
	      
	       p_BoardService pb = new p_BoardService();
	      
	       p_Board pb2 = pb.selectOne(pno);
	       /*/views/user/Profile.jsp*/
	      String page = "";
	      
	      if(pb2 != null) {
	            page = "/views/user/imgdetail.jsp";
	         request.setAttribute("pb3", pb2);
	         System.out.println("셀릭트 원 서블릿 성공");
	      } else {
	         request.setAttribute("msg", "공지사항 상세보기 실패!");
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
