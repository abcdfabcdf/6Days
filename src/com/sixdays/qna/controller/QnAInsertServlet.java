package com.sixdays.qna.controller;

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
import com.sixdays.qna.model.service.QnAService;
import com.sixdays.qna.model.vo.QnA;

/**
 * Servlet implementation class QnAInsertServlet
 */
@WebServlet("/qInsert.qo")
public class QnAInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public QnAInsertServlet() {
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
		
		String savePath = root + "resources/QnAUploadFiles";
		
		MultipartRequest mrequest = new MultipartRequest(
									request,
									savePath,
									maxSize,
									"UTF-8",
									new DefaultFileRenamePolicy()
		);
				
		String type = mrequest.getParameter("qtype");
		String title = mrequest.getParameter("qtitle");
		String writer = mrequest.getParameter("qwriter");
		String content = mrequest.getParameter("qcontent");
		String QnAfile = mrequest.getFilesystemName("qnafile");
		String date = mrequest.getParameter("qdate"); //  --> mrequest(x) / request(o)
		
		
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
		}
		
		QnA q = new QnA();

		q.setQtype(type);
		q.setQtitle(title);
		q.setQdate(writeDate);
		q.setQwriter(writer);
		q.setQnafile(QnAfile);
		q.setQcontent(content);
		
		QnAService bs = new QnAService();
		
		int result = bs.insertQnA(q);
	
		if(result > 0) {
			response.sendRedirect("selectList.qo");
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
