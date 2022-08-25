package com.sjy.buisness.camp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import com.kh.camplist.hashtag.vo.HashTagVo;
import com.kh.camplist.service.CampListService;
import com.kh.camplist.theme.vo.ThemeVo;
import com.kh.member.vo.MemberVo;
import com.sjy.buisness.camp.service.BsCampService;
import com.sjy.buisness.camp.vo.BsCampFacVo;
import com.sjy.buisness.camp.vo.BsCampVo;
import com.sjy.buisness.camp.vo.BsCampZoneVo;
import com.sjy.buisness.hashmapping.vo.HashMappingVo;


@MultipartConfig(
		//fileSizeThreshold = 1024*1024, //size : byte단위
		//location = ""
		maxFileSize = 1024 * 1024 * 50 ,
		maxRequestSize = 1024 * 1024 * 50 *5
		)
@WebServlet(urlPatterns = "/bscamp/update")
public class BsCampUpdateController extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		System.out.println("update_doget");
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
		
		
		//선택된 캠핑장  해시태그 조회
		List<HashMappingVo> myHashMappingList = new BsCampService().selecOnetHashTag(campCode); 
		req.setAttribute("myHashMappingList", myHashMappingList);
		
		//캠핑장 정보 가져오기
		BsCampVo bsVo = new BsCampService().selectOneCamp(mvo.getNo(), campCode);
		req.setAttribute("bsVo", bsVo);
		req.getRequestDispatcher("/views/buisness/campUpdateIfo.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		System.out.println("update_dopost");
		
		//로그인한 회원번호 가져오기
		HttpSession ss = req.getSession();
		MemberVo mvo = (MemberVo)ss.getAttribute("loginMember");
		
		//수정 데이터 가져오기
		String campName = req.getParameter("campName");				//캠핑장이름
		String city = req.getParameter("city");						//주소 시/도
		String district= req.getParameter("district");				//주소 구/군
		String campDetailAdd = req.getParameter("campDetailAdd");	//상세주소
		String campPhone = req.getParameter("campPhone");			//연락처
		String campIntro = req.getParameter("campIntro");			//시설소개
		String[] f = req.getParameterValues("facility");			//시설현황
		String theme = req.getParameter("theme");				//테마
		String[] hash = req.getParameterValues("hashTag");			//해쉬태그
		String[] h = req.getParameterValues("hashTag");				//해쉬태그
		String campRefund = req.getParameter("campRefund");			//환불규정
		String campRepImg = req.getParameter("campRepImg");
		Part mainImg = req.getPart("campRepImg");
		
		System.out.println("f::" +f);
		System.out.println("f_lgt::" +f.length);
		

		
		// 캠핑장 정보가져온것들 insert처리하기 캠핑장 정보테이블 
		//checkbox 데이터 배열로 받은것 처리
		String facility ="";
		String hashTag = "";
		if(f != null) {
			facility = String.join(",", f);
		}
		if(h != null) {
			hashTag = String.join(",", h);
		}
		
		
		String fac = req.getParameter("facNum");
//        int facNum = (int)fac;
        System.out.println("hidden_facNum::"+fac);
		// 시설현황 테이블에 insert
//		BsCampFacVo faVo = new BsCampFacVo();
//		for (int i = 0; i < facNum; i++) {
//			if (f[i].equals("w")) {
//				faVo.setWifi(f[i]);
//			}
//			if (f[i].equals("e")) {
//				faVo.setElectro(f[i]);
//			}
//			if (f[i].equals("h")) {
//				faVo.setHotWater(f[i]);
//			}
//			if (f[i].equals("p")) {
//				faVo.setPet(f[i]);
//			}
//			if (f[i].equals("s")) {
//				faVo.setStore(f[i]);
//			}
//			if (f[i].equals("f")) {
//				faVo.setFwood(f[i]);
//			}
//			if (f[i].equals("g")) {
//				faVo.setPlayGround(f[i]);
//			}
//			if (f[i].equals("t")) {
//				faVo.setTrail(f[i]);
//			}
//			if (f[i].equals("o")) {
//				faVo.setPool(f[i]);
//			}
//			
//			System.out.println(faVo);
//		}
		
        System.out.println(campName);
        System.out.println(city);
        System.out.println(district);
        System.out.println(campDetailAdd);
        System.out.println(campPhone);
        System.out.println(campIntro);
        System.out.println(facility);
        System.out.println(theme);
        System.out.println(hashTag);
        System.out.println(hash);
        System.out.println(campRefund);
        System.out.println(campRepImg);
        
        //시설현황 변경: 캠핑장 코드들고가서 업데이트하기
        
		BsCampVo campVo = new BsCampVo(); 
        campVo.setCampName(campName);
        campVo.setCity(city);
        campVo.setDistrict(district);
        campVo.setCampAddress(campDetailAdd);
        campVo.setCampPhone(campPhone);
        campVo.setCampIntro(campIntro);
        campVo.setTheme(theme);
        //수정일 sysdate
        campVo.setCampRefund(campRefund);
        
        //캠핑장 구역개수 가져오기
        String code = req.getParameter("campCode");
        System.out.println("code::"+code);
        int zoneCount = new BsCampService().selectZoneCount(code);
        System.out.println(zoneCount);
        
        //캠핑 구역 데이터 가져오기
        String[] campZoneName = req.getParameterValues("campZoneName");
        String[] maxGusests = req.getParameterValues("maxGusests");
        String[] zoneNor = req.getParameterValues("zoneNor");
        String[] campZonePrice = req.getParameterValues("campZonePrice");
        
        Part[] updateImg = new Part[zoneCount];
        Part[] nowImg = new Part[zoneCount];
        Part[] ChangeImg = new Part[zoneCount];
        
        for (int j = 0; j < zoneCount; j++) {
        	nowImg[j] = req.getPart("nowCampZoneImg");
        	ChangeImg[j] = req.getPart("changeCampZonImg");
        	//변경하는 이미지 존재여부 판별 
        	if (ChangeImg[j] == null) {
        		updateImg[j] = nowImg[j];
        	}else {
        		updateImg[j]=ChangeImg[j];
        	}
        	System.out.println(j+"번째");
        	System.out.println(campZoneName[j]);
        	System.out.println(maxGusests[j]);
        	System.out.println(zoneNor[j]);
        	System.out.println(campZonePrice[j]);
        	System.out.println(updateImg[j]);
        	
		}
        
        
        
        
        
        
		
	}
}
