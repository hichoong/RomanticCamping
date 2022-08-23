package com.sjy.buisness.camp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.kh.camplist.hashtag.vo.HashTagVo;
import com.kh.camplist.service.CampListService;
import com.kh.camplist.theme.vo.ThemeVo;
import com.kh.member.vo.MemberVo;
import com.sjy.buisness.camp.service.BsCampService;
import com.sjy.buisness.camp.vo.BsCampFacVo;
import com.sjy.buisness.camp.vo.BsCampVo;
import com.sjy.buisness.camp.vo.BsCampZoneVo;
import com.sjy.buisness.hashmapping.vo.HashMappingVo;

@WebServlet(urlPatterns = "/bscamp/detail")
public class BsCampDetailController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//로그인한 회원번호 가져오기
		HttpSession ss = req.getSession();
		MemberVo mvo = (MemberVo)ss.getAttribute("loginMember");
		
		//선택된 캠핑장 코드 가져오기
		String campCode = req.getParameter("campCode");
		System.out.println(campCode);
		
		//선택된 캠핑장 테마 조회
		List<ThemeVo> themeList = new CampListService().selectTheme();
		req.setAttribute("themeList", themeList);
		
		//선택된 캠핑장 시설현황 조회
		BsCampFacVo facVo = new BsCampService().selectOneFac(campCode);
		req.setAttribute("facVo", facVo);
		
		//선택된 캠핑장  해시태그 조회
		List<HashTagVo> hashTagList = new BsCampService().selectHashTag(); 
		req.setAttribute("hashTagList", hashTagList);
		
		//선택된 캠핑장 테마 조회
		BsCampVo myTheme = new BsCampService().selectOneTheme(campCode);
		req.setAttribute("myTheme", myTheme);
		
		//선택된 캠핑장의 모든구역정보 가져오기
		List<BsCampZoneVo> zoneList =  new BsCampService().selectZoneAll(campCode);
		System.out.println("con zli"+zoneList);
		req.setAttribute("zoneList", zoneList);
		
		//구역 이미지 
		
		
		//선택된 캠핑장  해시태그 조회
		List<HashMappingVo> myHashMappingList = new BsCampService().selecOnetHashTag(campCode); 
		req.setAttribute("myHashMappingList", myHashMappingList);
		
		//캠핑장 정보 가져오기
		BsCampVo bsVo = new BsCampService().selectOneCamp(mvo.getNo(), campCode);
				
		req.setAttribute("bsVo", bsVo);
		req.getRequestDispatcher("/views/buisness/campDetaileInfo.jsp").forward(req, resp);
	}
}
