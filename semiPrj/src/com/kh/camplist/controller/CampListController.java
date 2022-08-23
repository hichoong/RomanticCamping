package com.kh.camplist.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.kh.camplist.campinfo.vo.CampInfoVo;
import com.kh.camplist.hashtag.vo.HashTagVo;
import com.kh.camplist.service.CampListService;
import com.kh.camplist.theme.vo.ThemeVo;
import com.kh.common.PageVo;

@WebServlet(urlPatterns = "/camp/campList")
public class CampListController extends HttpServlet {
	
	//캠핑장 목록 화면 보여주기
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//페이징 처리
		int listCount;			//현재 총 게시글 갯수 
		int currentPage;		//현재 페이지(==사용자가 요청한 페이지) 
		int pageLimit;			//페이지 하단에 보여질 페이지 버튼의 최대 갯수 
		int listLimit;			//한 페이지 내 보여질 게시글 최대 갯수
		// 위의 4개를 이용해서 아래 3개 값 구하기
		int maxPage;			//가장 마지막 페이지(==총 페이지 수)
		int startPage;			//페이징바의 시작
		int endPage;			//페이징바의 끝
		
		
		listCount = new CampListService().getCount();
		currentPage = Integer.parseInt(req.getParameter("p"));
		pageLimit = 3;
		listLimit = 7;
		maxPage = (int)Math.ceil(((double)listCount/listLimit));
		startPage = (currentPage-1) / pageLimit * pageLimit + 1;
		endPage = startPage + pageLimit -1;
		
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		PageVo pageVo = new PageVo();
		pageVo.setListLimit(listLimit);
		pageVo.setCurrentPage(currentPage);
		pageVo.setEndPage(endPage);
		pageVo.setListCount(listCount);
		pageVo.setMaxPage(maxPage);
		pageVo.setPageLimit(pageLimit);
		pageVo.setStartPage(startPage);
		
		//테마 리스트 조회
		List<ThemeVo> themeList = new CampListService().selectTheme();
		
		//해시태그 리스트 조회
		List<HashTagVo> hashTagList = new CampListService().selectHashTag(); 
		
		//검색
		String keyword = (req.getParameter("keyword") == null) ? "" : req.getParameter("keyword");
		String sido1 = req.getParameter("sido1");
		String gugun1 = req.getParameter("gugun1");
		String theme = (req.getParameter("theme") == null) ? "" : req.getParameter("theme");
		String[] hashTag = req.getParameterValues("hashTag"); //입력값 없을 시 null 이었던것 같아

		if(sido1 == null || sido1.equals("시/도 선택")) {
			sido1 = "";
		}
		if(gugun1 == null || gugun1.equals("구/군 선택")) {
			gugun1 = "";
		}
		//해시태그 검색값
		List<String> checkedHashCodes = null;
		if(hashTag != null) {
			checkedHashCodes = Arrays.asList(hashTag);
//			for(String pk : checkedHashCodes) {
//				System.out.println("입력값 => " + pk);
//			}
		} else {
			checkedHashCodes = new ArrayList<String>();
		}
		
		List<CampInfoVo> searchList = new CampListService().searchList(pageVo, keyword, sido1, gugun1, theme, checkedHashCodes);
		
		Gson g = new Gson();
		String checkedTags = g.toJson(checkedHashCodes);
		req.setAttribute("checkedTags", checkedTags);
		
		
		//String 으로 해쓰인까 인풋에 집어넣을때 
		
		req.setAttribute("pv", pageVo);
		req.setAttribute("themeList", themeList);
		req.setAttribute("hashTagList", hashTagList);
		
		req.setAttribute("keyword", keyword);
		req.setAttribute("sido1", sido1);
		req.setAttribute("gugun1", gugun1);
		req.setAttribute("theme", theme);
		req.setAttribute("checkedHashCodes", checkedHashCodes);
		
		req.setAttribute("searchList", searchList);
		req.getRequestDispatcher("/views/camp/campList.jsp").forward(req, resp);
		
		
	}
	
	
	
	

}
