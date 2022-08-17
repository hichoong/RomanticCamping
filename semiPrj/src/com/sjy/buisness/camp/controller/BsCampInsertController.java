package com.sjy.buisness.camp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

@MultipartConfig(
		//fileSizeThreshold = 1024*1024, //size : byte단위
		//location = ""
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 50 *5
		)
@WebServlet(urlPatterns = ("/bscamp/insert"))
public class BsCampInsertController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("insert_doget");
		req.getRequestDispatcher("/views/buisness/campInsertForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//캠핑장 등록정보 가져오기
		String x = req.getParameter("campName");
		String city = req.getParameter("city");
		String district= req.getParameter("district");
		String campDetailAdd = req.getParameter("campDetailAdd");
		String campPhone = req.getParameter("campPhone");
		String campIntro = req.getParameter("campIntro");
		String facility = req.getParameter("facility");
		String theme = req.getParameter("theme");
		String campRefund = req.getParameter("campRefund");
		
		//캠핑장 대표이미지 넣기
		Part campRepImg = req.getPart("campRepImg");
		
		
		//캠핑장 구역 정보 
//		String xㅇ = req.getParameter("");
//		String xㅇ = req.getParameter("");
//		String xㅇ = req.getParameter("");
//		String xㅇ = req.getParameter("");
//		String xㅇ = req.getParameter("");
//				
	}
	
}
