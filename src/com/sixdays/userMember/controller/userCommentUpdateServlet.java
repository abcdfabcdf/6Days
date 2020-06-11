package com.sixdays.userMember.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sixdays.userMember.model.exception.MemberException;
import com.sixdays.userMember.model.service.userMemberService;
import com.sixdays.userMember.model.vo.userMember;

/**
 * Servlet implementation class userCommentUpdateServlet
 */
@WebServlet("/coUpdate.me")
public class userCommentUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userCommentUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원 정보
		String mycomment = request.getParameter("mycomment");
		String userid = request.getParameter("userid0");
		
		HttpSession session = request.getSession(false);
		
	
		userMember m = (userMember)session.getAttribute("member");
		
		m.setMycomment(mycomment);
		
		System.out.println("변경한 회원 정보 확인 :" + m);
		
		userMemberService ms = new userMemberService();
		
		try {
			ms.commentUpdateMember(m);
			System.out.println("회원 정보 수정 완료!");
			

			response.sendRedirect("/6Days/pbSelect.bo?userId="+ userid);
			
		} catch (MemberException e) {
			e.printStackTrace();
			request.setAttribute("msg", "회원정보 수정 중 에러 발생!");
			request.setAttribute("exception", e);
			
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		
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
