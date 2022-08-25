package com.sjy.buisness.reservation.controller;

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
import com.sjy.buisness.reservation.service.ReservationService;
import com.sjy.buisness.reservation.vo.ReservationVo;

@WebServlet(urlPatterns = "/bscamp/reservation")
public class ReservationController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인한 회원번호 가져오기
		HttpSession ss = req.getSession();
		MemberVo mvo = (MemberVo)ss.getAttribute("loginMember");
		
		//등록된 캠핑장 갯수 가져오기
		int CampNum = new BsCampService().MyCampNum(mvo.getNo());
		
		//캠핑장 정보 가져오기
		List<BsCampVo> bsVo = new BsCampService().selectAllCamp(mvo.getNo());
		
		List<ReservationVo> rvList = null;
		
			//모든 예약 정보 가져오기
			
			
			for (int i = 1; i <=CampNum ; i++) {
				System.out.println("i::" +i);
				rvList= new ReservationService().selectAllRsv(i);
				
			}
			//예약정보 개수가져오기
			
		
		System.out.println(rvList);
		
		req.setAttribute("rvList", rvList);
		req.getRequestDispatcher("/views/buisness/campRsvForm.jsp").forward(req, resp);
	}
}
