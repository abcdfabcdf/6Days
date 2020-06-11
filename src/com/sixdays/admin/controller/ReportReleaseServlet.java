package com.sixdays.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.admin.model.service.adminService;

/**
 * Servlet implementation class ReportReleaseServlet
 */
@WebServlet("/release.rp")
public class ReportReleaseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportReleaseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			//업데이트할 정보
			String userId = request.getParameter("userId");
			
			System.out.println("-- 사용자 활성화 서블릿 작동. --");
			System.out.println("활성화 할 유저ID : "+userId);
			
			int result = new adminService().userRelease(userId);
			
					
			if(result > 0) {
				System.out.println("사용자 계정 활성화 완료.");

			} else {
				request.setAttribute("msg", "사용자 계정 활성화 실패!.");
				System.out.println("사용자 계정 활성화 실패!.");
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
