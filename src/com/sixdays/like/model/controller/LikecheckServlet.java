package com.sixdays.like.model.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.like.model.service.LikeService;
import com.sixdays.like.model.vo.LikeUser;

/**
 * Servlet implementation class LikecheckServlet
 */
@WebServlet("/likecheck.me")
public class LikecheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LikecheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pbno = Integer.parseInt(request.getParameter("pbno"));
		String userid = request.getParameter("userid");
		int lno = Integer.parseInt(request.getParameter("lno"));
		
		LikeUser lu = new LikeUser(pbno,userid,lno);
	
		int result = new LikeService().insertLike(lu);



			lu = new LikeService().selectLike(pbno);
			response.getWriter().print(lu.getPcount());
		
	}
	
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
