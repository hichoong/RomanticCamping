package com.kh.freeboard.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.kh.common.PageVo;
import com.kh.freeboard.service.FreeBoardService;
import com.kh.freeboard.service.FreeBoardTradeService;
import com.kh.freeboard.vo.FreeBoardTradeVo;
import com.kh.freeboard.vo.FreeBoardVo;

@WebServlet(urlPatterns = "/freeboard/page")
public class FreeBoardPageController extends HttpServlet{

	/*
	 * 자유게시판 리스트 조회 후 페이지로 이동
	 */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//페이징 처리
		//------------------ 페이징 처리 -------------------
		int flistCount;		//현재 총 게시글 개수
		int fblistCount;	//현재 총 게시글 개수
		
		int fcurrentPage;	//현재 페이지(== 사용자가 요청한 페이지)
		int fbcurrentPage;	//현재 페이지(== 사용자가 요청한 페이지)
		
		int pageLimit;		//페이지 하단에 보여질 페이지 버튼의 최대 개수
		int boardLimit;		//한 페이지 내 보여질 게시글 최대 개수
		
		// 위의 4개를 이용해서 3개 값 구하기
		int fmaxPage;		//가장 마지막 페이지 ( =총 페이지 수)
		int fbmaxPage;		//가장 마지막 페이지 ( =총 페이지 수)
		
		int fstartPage;		//페이징바의 시작
		int fbstartPage;	//페이징바의 시작
		
		int fendPage;		//페이징바의 끝
		int fbendPage;		//페이징바의 끝
		
		//listCount 값 구하기
		//DB에 가서, BOARD 테이블의 총 게시글 개수
		flistCount = new FreeBoardService().getCount();
		fblistCount = new FreeBoardTradeService().getCount();
		
		//currentPage 값 구하기
		fcurrentPage = Integer.parseInt(req.getParameter("p1"));
		fbcurrentPage = Integer.parseInt(req.getParameter("p2"));
		
		//pageLimit, boardLimit - 내 마음대로 정함
		pageLimit = 5; 
		boardLimit = 5;
				
		
		fmaxPage = (int)Math.ceil(((double)flistCount/boardLimit));
		fbmaxPage = (int)Math.ceil(((double)fblistCount/boardLimit));
		
		fstartPage = (fcurrentPage-1)/pageLimit*pageLimit+1;
		fbstartPage = (fbcurrentPage-1)/pageLimit*pageLimit+1;
		
		fendPage = fstartPage + pageLimit -1;
		fbendPage = fbstartPage + pageLimit -1;
		
		//startPage가 11이면 endPage는 20 // 근데, maxPage가 13이면?
		if(fendPage>fmaxPage) {
			fendPage = fmaxPage;
		}
		
		//startPage가 11이면 endPage는 20 // 근데, maxPage가 13이면?
		if(fbendPage>fbmaxPage) {
			fbendPage = fbmaxPage;
		}
		
		
		//vo에 페이지 관련 변수 담기
		
		PageVo fpageVo = new PageVo();
		
		fpageVo.setListLimit(boardLimit);
		fpageVo.setCurrentPage(fcurrentPage);
		fpageVo.setEndPage(fendPage);
		fpageVo.setListCount(flistCount);
		fpageVo.setMaxPage(fmaxPage);
		fpageVo.setPageLimit(pageLimit);
		fpageVo.setStartPage(fstartPage);
		
		
		PageVo fbpageVo = new PageVo();
		
		fbpageVo.setListLimit(boardLimit);
		fbpageVo.setCurrentPage(fbcurrentPage);
		fbpageVo.setEndPage(fbendPage);
		fbpageVo.setListCount(fblistCount);
		fbpageVo.setMaxPage(fbmaxPage);
		fbpageVo.setPageLimit(pageLimit);
		fbpageVo.setStartPage(fbstartPage);
		
		
		
		
		//자유게시판 페이징 글 조회 백엔드작업
		List<FreeBoardVo> fvoList = new FreeBoardService().selectList(fpageVo);
		
		//중고거래게시판 페이징 글 조회 백엔드 작업
		List<FreeBoardTradeVo> fbvoList = new FreeBoardTradeService().selecList(fbpageVo);
		
		//자유게시판 인기글 조회 백엔드 작업
		List<FreeBoardVo> fMainList = new FreeBoardService().selectMainList();
		
		//중고거래게시판 인기글 조회 백엔드 작업
		List<FreeBoardTradeVo> fbMainList = new FreeBoardTradeService().selectMainList();
		
		
		//결과에 따라 다음 타자 정하기
		req.setAttribute("fpageVo", fpageVo);
		req.setAttribute("fvoList", fvoList);
		
		req.setAttribute("fbpageVo", fbpageVo);
		req.setAttribute("fbvoList", fbvoList);
		
		
		req.setAttribute("fMainList", fMainList);
		req.setAttribute("fbMainList", fbMainList);
		
		req.getRequestDispatcher("/views/freeBoard/freeBoardPageTest.jsp").forward(req, resp);
	}
	
	
	
}//class
