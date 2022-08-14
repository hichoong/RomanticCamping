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

import com.kh.camplist.hashtag.vo.HashTagVo;

@WebServlet(urlPatterns = "/camp/campList")
public class CampListController extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//해시태그 로직
		
//		List<HashTagVo> hashTagList = new CampListService().selectHashTag(); 
		List<HashTagVo> hashTagList  = new ArrayList();
		
		//임시 더미데이터
		hashTagList.add(new HashTagVo("1","#반려견동반"));
		hashTagList.add(new HashTagVo("2","#둘레길"));
		hashTagList.add(new HashTagVo("3","#여유있는"));
		hashTagList.add(new HashTagVo("4","#봄"));
		hashTagList.add(new HashTagVo("5","#겨울"));
		hashTagList.add(new HashTagVo("6","#여름"));
		hashTagList.add(new HashTagVo("7","#가을"));
		hashTagList.add(new HashTagVo("8","#가족"));
		hashTagList.add(new HashTagVo("9","#익스트림"));
		hashTagList.add(new HashTagVo("10","#연인"));
		hashTagList.add(new HashTagVo("11","#힐링"));
		hashTagList.add(new HashTagVo("12","#편한 주차"));
		hashTagList.add(new HashTagVo("13","#별 보기 좋은"));
		hashTagList.add(new HashTagVo("14","#물 맑은"));
		hashTagList.add(new HashTagVo("15","#문화"));
		hashTagList.add(new HashTagVo("16","#캠핑카"));
		req.setAttribute("hashTagList", hashTagList);
		
		String[] hashTag = req.getParameterValues("hashTag");
		List<String> checkedHashCodes = null;
		if(hashTag != null) {
			checkedHashCodes = Arrays.asList(hashTag);
			for(String pk : checkedHashCodes) {
				System.out.println("입력값 => " + pk);
			}
		} else {
			checkedHashCodes = new ArrayList<String>();
		}
		
		req.setAttribute("hashTagCodeList", checkedHashCodes);
		req.getRequestDispatcher("/views/camp/campList.jsp").forward(req, resp);
	}
	

}
