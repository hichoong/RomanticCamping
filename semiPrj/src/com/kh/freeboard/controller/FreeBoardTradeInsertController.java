package com.kh.freeboard.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.kh.freeboard.attachment.vo.FreeBoardAttachmentVo;
import com.kh.freeboard.service.FreeBoardTradeService;
import com.kh.freeboard.vo.FreeBoardTradeVo;
import com.kh.member.vo.MemberVo;

@MultipartConfig(
		maxFileSize = 1024 * 1024 * 50,
		maxRequestSize = 1024 * 1024 * 50*5
	)

@WebServlet(urlPatterns = "/freeboard/trade/insert")
public class FreeBoardTradeInsertController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
	
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String price = req.getParameter("price");
		
		Part f = req.getPart("f");
		
		//데이터 뭉치기 
		FreeBoardTradeVo fvo = new FreeBoardTradeVo();
		fvo.setType("10");//10은 중고 20은 자유게시판
		fvo.setTitle(title);
		fvo.setContent(content);
		fvo.setPrice(price);
		
		MemberVo m = (MemberVo)req.getSession().getAttribute("loginMember");
		fvo.setWriter(m.getNo());
		
		//0. 제출된 파일이 있는 경우에만 파일업로드 작업시작되도록 if 문!
		FreeBoardAttachmentVo fbavo = null;
		String savePath = "";
		
		if(f.getSubmittedFileName().length()>0) {
			//파일 업로드
			
			//1. 사용자가 입력한 파일의 이름
			String originName = f.getSubmittedFileName();
			//2. 중복되지 않는 의미있는 파일명으로 변경
			String changeName = new FreeBoardTradeService().createChangeName(originName);
			
			//3. 인풋 스트림 준비
			InputStream is = f.getInputStream(); 
			BufferedInputStream bis = new BufferedInputStream(is);
			
			//4. 아웃풋 스트림 준비(서버에 저장하기 위한)
			//4-1. 읽은 파일 저장할 경로를 얻어올 때 다른 사람 컴퓨터에서도 사용할 수 있으므로 - 경로얻어오기 체크
			String realPath = req.getServletContext().getRealPath("/resources/upload");
			
			//4-2. 실제 저장될 파일경로를 써주어야한다. - realPath + 파일구분자 + 파일명
			savePath = realPath + File.separator + changeName;
			FileOutputStream os =  new FileOutputStream(savePath);
			BufferedOutputStream bos = new BufferedOutputStream(os);
			
			//5. 1byte 1개씩 말고 1024개 한 번에 읽고싶다. 담아줄 byte 배열 필요 - buffer 라는 의미로 buf
			byte[] buf = new byte[1024];
			
			//5-1 buf에 얼만큼 들어갔는지 체크하는 변수
			int size = 0;
			
			//6. 한 글자씩이 아닌 buf를읽어주고 - 써주기 
			while((size = bis.read(buf)) != -1) {
				bos.write(buf, 0, size);
			
			}
		
			//7. 반납
			bos.flush();
			bis.close();
			bos.close();
			
////////////////Attachment 테이블 관련 데이터는 위에 준비 되어있는 상태 (원본파일명, 변경파일명, 경로)
			
			//준비된 데이터를 사용하여, 객체로 뭉치기
			fbavo = new FreeBoardAttachmentVo();
			
			fbavo.setOriginName(originName);
			fbavo.setChangeName(changeName);
			fbavo.setFilePath(realPath);
			
		}//if
		
		//Board 테이블 채우기 ( 보더테이블 먼저 insert )
		int result = new FreeBoardTradeService().insertBoard(fvo, fbavo);
		
		
		//결과에 따라 다음타자 선택 작업
		if(result == 1) {
			//성공 -> 일반게시판 목록 1페이지 + 알람띄우기 
			
		}else {
			//실패 -> 에러페이지 + 알람띄우기
			//실패한게 db인서트 실패한것이다. 
			//파일업로드는 이미 이루어졌음 -> 파일 삭제해주어야 한다.
			
			
			if(fbavo != null) { //첨부파일이 있음 : 업로드 이미 되어있을 수 있음
				new File(savePath).delete();
			}
		}
		
		
	}//method
	
}//class
