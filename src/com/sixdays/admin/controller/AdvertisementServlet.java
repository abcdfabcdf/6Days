package com.sixdays.admin.controller;

import java.io.IOException;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sixdays.admin.model.service.adminService;
import com.sixdays.admin.model.vo.Advertisement;
import com.sixdays.admin.model.vo.userManage;
import com.sixdays.board.model.service.BoardService;
import com.sixdays.board.model.vo.Board;
import com.sixdays.board.model.vo.PageInfo;
import com.sixdays.userMember.model.exception.MemberException;
import com.sixdays.userMember.model.service.userMemberService;
import com.sixdays.userMember.model.vo.userMember;

/**
 * Servlet implementation class AdvertisementServlet
 */
@WebServlet("/aminsert.ad")
public class AdvertisementServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdvertisementServlet() {
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

		String savePath = root + "resources/AdvertisementFiles";
	
		
		MultipartRequest mrequest = new MultipartRequest(
										request, 
										savePath, 
										maxSize,	
										"UTF-8",	
										new DefaultFileRenamePolicy()			
				);
		
		String adimg = mrequest.getFilesystemName("adimg");
		
		
		Advertisement a = new Advertisement();
		
		
		
		System.out.println(a);
		
		adminService as = new adminService();
		
		
		int result=as.amUpdate(a);
		
	
		if(result > 0) {
			response.sendRedirect("/6Days/views/admin/advertisement.jsp");
		} else {
			request.setAttribute("msg", "공지사항 등록 실패!");
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
