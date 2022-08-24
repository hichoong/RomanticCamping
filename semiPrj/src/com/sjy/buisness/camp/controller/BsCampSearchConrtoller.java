package com.sjy.buisness.camp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.member.vo.MemberVo;
import com.sjy.buisness.camp.service.BsCampService;
import com.sjy.buisness.camp.vo.BsCampVo;

@WebServlet(urlPatterns = "/bscamp/search")
public class BsCampSearchConrtoller extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		//로그인한 회원번호 가져오기
		HttpSession ss = req.getSession();
		MemberVo mvo = (MemberVo)ss.getAttribute("loginMember");
		
		
		
		//캠핑장 정보 가져오기
		List<BsCampVo> bsVo = new BsCampService().selectAllCamp(mvo.getNo());
		
		//등록된 캠핑장 갯수 가져오기
		int CampNum = new BsCampService().MyCampNum(mvo.getNo());
		System.out.println("캠핑장개수"+CampNum);
		req.setAttribute("bsVo", bsVo);
		req.setAttribute("CampNum", CampNum);
		req.getRequestDispatcher("/views/buisness/campSearchForm.jsp").forward(req, resp);
	}
	
	
}
