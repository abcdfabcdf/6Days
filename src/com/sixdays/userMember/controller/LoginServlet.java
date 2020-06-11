package com.sixdays.userMember.controller;

import java.io.IOException;
import java.io.PrintWriter;

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
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login.me")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 인코딩
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");

				String userId = request.getParameter("userId");
				String userPwd = request.getParameter("password");
				
				
				userMember m = new userMember(userId,userPwd);
				
				userMemberService  ms = new userMemberService();
				
				try { // 로그인 성공
					m = ms.selectMember(m);
					
					System.out.println("로그인 성공");
					
					HttpSession session = request.getSession();
					
					session.setAttribute("member", m);
					
					
					response.sendRedirect("main.me");
					
					
					
				
				}catch(MemberException e) { // 로그인 실패
	
					PrintWriter out = response.getWriter();
					
					out.println("<script language='javascript'>");
					out.println("alert('아이디 / 비밀번호를 다시 확인해주세요.')");
					out.println("location.href='login.jsp'");
					out.println("</script>");
					out.flush();
					out.close();
					request.setAttribute("msg", "회원 로그인 실패!");
					request.setAttribute("exception", e);
					request.getRequestDispatcher("login.jsp");

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
