package com.sjy.buisness.camp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sjy.buisness.camp.service.BsCampService;

@WebServlet(urlPatterns = "/bscamp/delete")
public class BsCampDeleteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//캠핑장 정보로 번호 가져오기
		int num = 0;
		
		//int result =new BsCampService().delete(num);
	}
}
