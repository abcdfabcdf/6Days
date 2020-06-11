package com.sixdays.admin.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixdays.admin.model.service.adminService;
import com.sixdays.admin.model.vo.Report;
import com.sixdays.maincomment.model.service.MainCommentService;
import com.sixdays.p_board.model.service.p_BoardService;
import com.sixdays.userMember.model.exception.MemberException;

/**
 * Servlet implementation class ReportUpdateServlet
 */
@WebServlet("/update.rp")
public class ReportUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//업데이트할 정보
		String userId = request.getParameter("userId");
		String reason = request.getParameter("reason");
		int releasDate = Integer.parseInt(request.getParameter("releasDate"));
		
		System.out.println("-- 사용자 정지 서블릿 작동. --");
		System.out.println("정지할 유저ID : "+userId);
		System.out.println("정지 사유 : "+reason);
		System.out.println("정지 일 수 :"+releasDate);
		
		int result = new adminService().userblock(userId, reason, releasDate);
		
				
		if(result > 0) {
			System.out.println("사용자 계정 정지 완료.");
	
		} else {
			request.setAttribute("msg", "사용자 계정 정지 실패!.");
			System.out.println("사용자 계정 정지 실패!.");
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
