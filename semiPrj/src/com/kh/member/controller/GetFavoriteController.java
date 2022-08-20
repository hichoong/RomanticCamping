package com.kh.member.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.camplist.campinfo.vo.CampInfoVo;
import com.kh.member.service.MemberService;
import com.kh.member.vo.MemberVo;

@WebServlet(urlPatterns = "/member/favorite")
public class GetFavoriteController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String no = ((MemberVo)req.getSession().getAttribute("loginMember")).getNo();
		
		List<CampInfoVo> list = new MemberService().getFavorite(no);
		
		req.setAttribute("favoriteList", list);
		req.getRequestDispatcher("/views/member/myFavoritePage.jsp").forward(req, resp);
	
	}

}
