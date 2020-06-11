package com.sixdays.userMember.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sixdays.userMember.model.exception.MemberException;
import com.sixdays.userMember.model.service.userMemberService;
import com.sixdays.userMember.model.vo.userMember;

/**
 * Servlet implementation class userProfileImageDeleteServlet
 */
@WebServlet("/pimgDelete.me")
public class userProfileImageDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userProfileImageDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maxSize = 1024*1024*10;
		

		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "multipart를 통한 전송이 아닙니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		String root = request.getServletContext().getRealPath("/");
		System.out.println("root : " + root);

		String savePath = root + "resources/proimgUploadFiles";
		
		MultipartRequest mrequest = new MultipartRequest(
										request, 
										savePath, 
										maxSize,	
										"UTF-8",	
										new DefaultFileRenamePolicy()			
				);
		
		String proimg = mrequest.getFilesystemName("proimg");
		String userid = mrequest.getParameter("userid4");
		
		HttpSession session = request.getSession(false);
		
		
		userMember m = (userMember)session.getAttribute("member");
		
		m.setProimg(proimg);
		
		System.out.println("변경한 회원 정보 확인 :" + m);
		
		userMemberService ms = new userMemberService();
		try {
			ms.deleteProImg(m);
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
