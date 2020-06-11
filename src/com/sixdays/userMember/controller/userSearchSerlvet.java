package com.sixdays.userMember.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.userMember.model.dao.userMemberDao;
import com.sixdays.userMember.model.service.userMemberService;
import com.sixdays.userMember.model.vo.userMember;

//<!-- 작성자 : 박주완
//* 작성일 : 2020.01.14
//* 내용 : 아이디 찾기 결과
//* 수정일 : 
//-->
@WebServlet("/search.me")
public class userSearchSerlvet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userSearchSerlvet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. 인코딩
		response.setContentType("text/html; charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		//2. 변수저장
		String phone = request.getParameter("inputPh");
		String email = request.getParameter("inputEmail");
		
		System.out.println("phone : "+ phone);
		System.out.println("email : "+ email);
		
		//3. 비즈니스로직
		userMemberService serivce = new userMemberService();
		userMember member = serivce.userSearch(phone,email);
		
		System.out.println("member : " + member);
		//4. 뷰처리
		
		if(member != null) {
			request.setAttribute("member", member);
			RequestDispatcher rd = request.getRequestDispatcher("/views/member/IdSearchOK.jsp");
			rd.forward(request, response);
			System.out.println("if member : " + member);
			
		}else {
			request.setAttribute("msg","정확한 정보를 입력해 주세요.");
			System.out.println("else member : " + member);
			
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			PrintWriter out = response.getWriter();

			out.println("<script>alert('없는 사용자정보 입니다.'); location.href='/6Days/views/member/IdSearch.jsp';</script>"); 
			out.close();


			
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
