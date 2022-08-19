package com.kh.campzonelist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.campzonelist.campzone.vo.CampZoneVo;
import com.kh.campzonelist.service.CampZoneListService;

@WebServlet(urlPatterns = "/zone/list")
public class CampZoneListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num = req.getParameter("num");
		
		List<CampZoneVo> zoneList = new CampZoneListService().selectList(num);
		
		req.setAttribute("zoneList", zoneList);
		req.getRequestDispatcher("/views/camp/campZoneList.jsp").forward(req, resp);
	}
	
	
	
	
	
	
	
	
}
