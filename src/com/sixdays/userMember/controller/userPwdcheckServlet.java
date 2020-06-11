package com.sixdays.userMember.controller;

import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.userMember.model.service.userMemberService;
import com.sixdays.userMember.model.vo.userMember;

/**
 * Servlet implementation class userPwdcheckServlet
 */
@WebServlet("/pwdchk.me")
public class userPwdcheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userPwdcheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pwdchk = request.getParameter("pwdchk");
		String userid = request.getParameter("idok");
		
		MessageDigest md;
	        
	        // 생성된 임시 비밀번호 암호화 
			try {
				md = MessageDigest.getInstance("SHA-512");
				byte[] bytes = pwdchk.getBytes(Charset.forName("UTF-8"));
				md.update(bytes);
				pwdchk = Base64.getEncoder().encodeToString(md.digest());
			} catch (NoSuchAlgorithmException e1) {

				e1.printStackTrace();
			}
			
	        System.out.println("인증번호 값 " + pwdchk);
	        
	        userMember m = new userMember(pwdchk,userid);
	        userMemberService ms = new userMemberService();
 
	        
	       ms.pwdchk(m);
		
		
		response.getWriter().print(pwdchk);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
