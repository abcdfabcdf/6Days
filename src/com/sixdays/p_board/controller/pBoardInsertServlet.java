package com.sixdays.p_board.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.Enumeration;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sixdays.p_board.model.service.p_BoardService;
import com.sixdays.p_board.model.vo.p_Board;

/**
 * Servlet implementation class pBoardInsertServlet
 */
@WebServlet("/pbInsert.bo")
public class pBoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pBoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int maxSize = 1024*1024*10;	//10MB
		
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "multipart를 통한 전송이 아닙니다.");
		}
		
		String root = request.getServletContext().getRealPath("/resources");
		System.out.println("root : " + root);
		
		String savePath = root + "/pboardUploadFiles";
		
		MultipartRequest mrequest = new MultipartRequest(
									request,
									savePath,
									maxSize,
									"UTF-8",
									new DefaultFileRenamePolicy()
		);
				
		
		// -- 파일 업로드 로직 실시 --//
		//기본 전송값 처리
		String pbwriter=mrequest.getParameter("userId");
		String photo1 = mrequest.getFilesystemName("thumbnailImg1");
		String photo2 = mrequest.getFilesystemName("thumbnailImg2");
		String photo3 = mrequest.getFilesystemName("thumbnailImg3");
		String photo4 = mrequest.getFilesystemName("thumbnailImg4");
		String photo5 = mrequest.getFilesystemName("thumbnailImg5");
		String photo6 = mrequest.getFilesystemName("thumbnailImg6");
		String pcontent = mrequest.getParameter("Infcomment");
		String hashtag = mrequest.getParameter("Infhashtag");
		
		System.out.println("인서트의 id : " + pbwriter);
		
		//전송된 파일 VO에 담아서 서비스로 보내기
		p_Board pb = new p_Board();		
		pb.setPbwriter(pbwriter);
		pb.setPhoto1(photo1);
		pb.setPhoto2(photo2);
		pb.setPhoto3(photo3);
		pb.setPhoto4(photo4);
		pb.setPhoto5(photo5);
		pb.setPhoto6(photo6);
		pb.setPcontent(pcontent);
		pb.setHashtag(hashtag);
		
		
		//서비스 결과 처리
		int result = new p_BoardService().insertBoard(pb);
		
		
		if(result>0) {
			System.out.println("사진 업로드 완료");
			response.sendRedirect("/6Days/main.me");
			
		}else {
			request.setAttribute("msg", "사진 게시판 작성 실패!");
			
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
