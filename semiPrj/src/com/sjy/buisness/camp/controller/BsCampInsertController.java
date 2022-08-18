package com.sjy.buisness.camp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.camplist.campinfo.vo.CampInfoVo;
import com.kh.camplist.hashtag.vo.HashTagVo;
import com.kh.camplist.service.CampListService;
import com.kh.camplist.theme.vo.ThemeVo;
import com.sjy.buisness.camp.service.BsCampService;
import com.sjy.buisness.camp.vo.BsCampVo;

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
		
		//테마 조회
		List<ThemeVo> themeList = new CampListService().selectTheme();
		req.setAttribute("themeList", themeList);
		
		
		//해시태그 조회
		List<HashTagVo> hashTagList = new CampListService().selectHashTag(); 

		req.setAttribute("hashTagList", hashTagList);
		
		String[] hashTag = req.getParameterValues("hashTag");

		
		//시설현황 데이터 받아오기
		
		//화면 불러오기
		req.getRequestDispatcher("/views/buisness/campInsertForm.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("insert_dopost");
		req.setCharacterEncoding("UTF-8");
		//캠핑장 등록정보 가져오기
		String campName = req.getParameter("campName");
		String city = req.getParameter("city");
		String district= req.getParameter("district");
		String campDetailAdd = req.getParameter("campDetailAdd");
		String campPhone = req.getParameter("campPhone");
		String campIntro = req.getParameter("campIntro");
		String[] f = req.getParameterValues("facility");
		String[] t = req.getParameterValues("theme");
		String[] h = req.getParameterValues("hashTag");
		
		String campRefund = req.getParameter("campRefund");
		
		
		String facility ="";
		String theme = "";
		String hashTag = "";
		facility = String.join(",", f);
		theme = String.join(",", t);
		hashTag= String.join(",", h);
		//캠핑장 대표이미지 넣기
		String campRepImg = req.getParameter("campRepImg");
		
		
		//캠핑장 구역 정보 
		String[] c = req.getParameterValues("campZoneName");
		String campZoneName = "";
		campZoneName = String.join(",", c);
		String maxGusests = req.getParameter("maxGusests");
		String campZonePrice = req.getParameter("campZonePrice");
		String zonef = req.getParameter("campRepImg ");
		
		System.out.println(campName);
		System.out.println(city);
		System.out.println(district);
		System.out.println(campDetailAdd);
		System.out.println(campPhone);
		System.out.println(campIntro);
		System.out.println(facility);
		System.out.println(theme);
		System.out.println(campRefund);
		System.out.println(campRepImg);
		System.out.println(campZoneName);
		System.out.println(maxGusests);
		System.out.println(campZonePrice);
		
		
		/*데이터 뭉치기*/
		
		//캠핑장 
		BsCampVo campVo  = new BsCampVo();
		campVo.setCampName(campName);
		campVo.setCity(city);
		campVo.setDistrict(district);
		campVo.setCampAddress(campDetailAdd);
		campVo.setCampPhone(campPhone);
		//대표이미지처리
		
		//등록일 sysdate
		campVo.setCampRefund(campRefund);
		//수정일 sysdate
		
		//캠핑장 테이블 insert
		int resultCamp = new BsCampService().campInsert(campVo);
		
		//테마
		ThemeVo tmVo = new ThemeVo();
		tmVo.setThemeName(theme);
		
		//해쉬태그 
		HashTagVo htVo = new HashTagVo();
		htVo.setHtName(hashTag);
		
		//시설
		
		//구역 데이터등록
		//구역이미지 처리
		
		
		
		
		//모든 등록이 완료되면 화면이동
		req.getRequestDispatcher("/views/buisness/campSearchForm.jsp").forward(req, resp);
	}
	
}
