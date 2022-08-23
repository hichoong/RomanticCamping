package com.kh.campdetail.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.campdetail.service.CampDetailService;
import com.kh.campdetail.vo.CampDetailVo;
import com.sjy.buisness.camp.vo.CampAttachmentVo;

@WebServlet(urlPatterns = "/camp/detail")
public class CampDetailController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//구역상세리스트로 부터 넘겨 받는 정보는 - 캠핑장 넘버와 / 구역 넘버
		
		String campCode = req.getParameter("campCode");
		String zoneNo = req.getParameter("zoneNo");
		
		//받아오면 삭제할 부분
		campCode = "1";
		zoneNo = "2";
		
		//캠핑장 화면 표현 필요한 정보 얻어오기 
		CampDetailVo campVo = new CampDetailService().selectOne(campCode,zoneNo);
		
		//테마 보여주기 위해 가져오기
		List<String> hashTag = new CampDetailService().selectHashTag(campCode);
		
		//구역 상세 이미지 경로와 이름 얻어오기
		CampAttachmentVo campAttachVo = new CampDetailService().selectImg(campCode);
		
		
		req.setAttribute("campVo", campVo);
		req.setAttribute("hashTag", hashTag);
		req.setAttribute("campAttachVo", campAttachVo);
		
		req.getRequestDispatcher("/views/campDetailPage/campDetailPage.jsp").forward(req, resp);
				
	}
	
	
	
}//class
