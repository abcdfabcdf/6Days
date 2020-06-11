package com.sixdays.userMember.controller;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.userMember.model.exception.MemberException;
import com.sixdays.userMember.model.service.userMemberService;
import com.sixdays.userMember.model.vo.userMember;

/**
 * Servlet implementation class userMemberInsertServlet
 * 작성자 : 박주완
 * 작성일 : 2020-02-06
 */
@WebServlet("/mInsert.me")
public class userMemberInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userMemberInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩 레츠기릿 

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");  
		String userName = request.getParameter("userName");
		String email = request.getParameter("email1");
		String phone = request.getParameter("phone");
		String gender = request.getParameter("gender");
		String comment = request.getParameter("comment");

		
		// 회원 가입하믄 전달할 vo 생성
		userMember m = new userMember(userId,password,userName,email,phone,gender,comment);
		System.out.println("회원가입정보체크 : "+ m);
		
		// 회원가입 서비스 레츠기릿 
		userMemberService ms = new userMemberService();
		
		try {
			ms.insertMember(m);
			System.out.println("회원가입성공");
			
			response.sendRedirect("login.jsp");
			
		}catch (Exception e) {
			e.printStackTrace();
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
