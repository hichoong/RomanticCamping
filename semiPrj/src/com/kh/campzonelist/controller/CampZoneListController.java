package com.kh.campzonelist.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.camplist.campinfo.vo.CampInfoVo;
import com.kh.campzonelist.campzone.vo.CampZoneVo;
import com.kh.campzonelist.service.CampZoneListService;
import com.kh.member.service.MemberFavoriteService;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/zone/list")
public class CampZoneListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String campCode = req.getParameter("campCode");
		
		CampInfoVo campInfoVo = new CampZoneListService().selectCamp(campCode);
		
		List<CampZoneVo> zoneList = new CampZoneListService().selectList(campCode);
		
		int check = -1;
		if(req.getSession().getAttribute("loginMember") != null && ((MemberVo)req.getSession().getAttribute("loginMember")).getType().equals("U")) {
			String no = ((MemberVo)req.getSession().getAttribute("loginMember")).getNo();
			check = new MemberFavoriteService().checkFavorite(campCode, no);
		}
		
		req.setAttribute("campInfoVo", campInfoVo);
		req.setAttribute("zoneList", zoneList);
		req.setAttribute("check", check);
		req.getRequestDispatcher("/views/camp/campZoneList.jsp").forward(req, resp);
	}
	
	
}
