package com.sixdays.board.controller;

import java.io.IOException;
import java.sql.Date;
import java.util.GregorianCalendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import com.sixdays.board.model.service.BoardService;
import com.sixdays.board.model.vo.Board;

/**
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/bInsert.bo")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
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
		}
		String root = request.getServletContext().getRealPath("/");
		System.out.println("root : " + root);
		
		String savePath = root + "resources/boardUploadFiles";
		
		MultipartRequest mrequest = new MultipartRequest(
									request,
									savePath,
									maxSize,
									"UTF-8",
									new DefaultFileRenamePolicy()
		);
				
		
		String title = mrequest.getParameter("title");
		String writer = mrequest.getParameter("writer");
		String content = mrequest.getParameter("content");
		String boardfile = mrequest.getFilesystemName("boardfile");
		String date = mrequest.getParameter("date"); //  --> mrequest(x) / request(o)
		
		
		Date writeDate = null;
		System.out.println(date.isEmpty());
//		if(date != "" && date != null) {
		if(!date.isEmpty()) {
			// 날짜가 들어왔을 때
			System.out.println("날짜 : " + date);
			// 2020-01-30 --> 2020, 1, 30
			String[] dateArr = date.split("-");
			int[] intArr = new int[dateArr.length];
			
			// String -> int
			for(int i=0; i<dateArr.length; i++) {
				intArr[i] = Integer.parseInt(dateArr[i]);
			}
			writeDate = new Date(new GregorianCalendar(intArr[0], intArr[1]-1, intArr[2]).getTimeInMillis());
			System.out.println("writeDate :" + writeDate);
		} else {
			// 날짜가 들어오지 않으면
			writeDate = new Date(new GregorianCalendar().getTimeInMillis());
			System.out.println("dsdsadas");
		}
		
		Board b = new Board();

		b.setBtitle(title);
		b.setBdate(writeDate);
		b.setBwriter(writer);
		b.setBoardfile(boardfile);
		b.setBcontent(content);
		
		BoardService bs = new BoardService();
		
		int result = bs.insertBoard(b);
	
		if(result > 0) {
			response.sendRedirect("selectList.bo");
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
