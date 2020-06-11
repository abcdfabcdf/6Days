package com.sixdays.board.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BoardFileDownloadServlet
 */
@WebServlet("/bfdown.bo")
public class BoardFileDownloadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardFileDownloadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String fileName = request.getParameter("path");
		
		String folder = request.getServletContext().getRealPath("/resources/boardUploadFiles");
		
		ServletOutputStream downStream = response.getOutputStream();
		
		response.addHeader("Content-Disposition", "attachment; filename=\"" 
		+ new String(fileName.getBytes("UTF-8"),"ISO-8859-1") + "\"");
		
		File downFile = new File(folder + "/" + fileName);
		
		response.setContentLength((int)downFile.length());
		
		BufferedInputStream bin = new BufferedInputStream(new FileInputStream(downFile));
		
		int readData = 0;
		
		while((readData = bin.read()) != -1) {
			downStream.write(readData);
		}
		downStream.close();
		bin.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
