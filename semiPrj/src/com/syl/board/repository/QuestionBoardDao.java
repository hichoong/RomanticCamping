package com.syl.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.syl.board.vo.QuestionBoardVo;

import static com.kh.common.JDBCTemplate.*;
import com.kh.common.PageVo;

public class QuestionBoardDao {

		/////////////////////문의게시판 글 목록//////////////////////
	public ArrayList<QuestionBoardVo> selectList(Connection conn){
		
		//SQL
		String sql = "SELECT Q_NO ,Q_TITLE , M.NAME AS Q_WRITER , Q_CNT , Q_UPDATE_DATE FROM QUESTIONBOARD Q JOIN MEMBER M ON Q_WRITER = M.NO WHERE Q_FREQ = 'N'";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<QuestionBoardVo> list = new ArrayList<QuestionBoardVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("Q_NO");
				String title = rs.getString("Q_TITLE");
				String writer = rs.getString("Q_WRITER");
				String cnt = rs.getString("Q_CNT");
				String updateDate = rs.getString("Q_UPDATE_DATE");
				
				QuestionBoardVo vo = new QuestionBoardVo();
				vo.setqNo(no);
				vo.setqTitle(title);
				vo.setqWriter(writer);
				vo.setqCnt(cnt);
				vo.setqUpdateDate(updateDate);
				
				list.add(vo);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			close(conn);
			close(pstmt);
			close(rs);
		}	
		return list;
	}
	
		/////////////////////문의글 작성//////////////////////
	public int insertBoard(QuestionBoardVo vo, Connection conn) {
		
		String sql = "INSERT INTO QUESTIONBOARD ( Q_NO , Q_TITLE , Q_CONTENT , Q_WRITER ) VALUES ( SEQ_QUESTIONBOARD_NO.NEXTVAL , ? , ? , ? )";
		
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, vo.getqTitle());
			pstmt.setString(2, vo.getqContent());
			pstmt.setString(3, vo.getqWriter());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			close(pstmt);
		}
			
		//결과 리턴
		return result;
	}
		
		////////////////////문의글 조회수 증가//////////////////////
		public int increaseBoard(Connection conn, String num) {
			
			//SQL 
			String sql = "UPDATE QUESTIONBOARD SET Q_CNT = Q_CNT+1 WHERE Q_NO = ? AND Q_FREQ  = 'N'";
			PreparedStatement pstmt =  null;
			int result = 0;
			
			try {
				
				//SQL 을 객체에 담기 및 물음표 채우기
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, num);
				
				//SQL 실행 및 결과 저장
				result = pstmt.executeUpdate();
				
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			//결과 반환
			return result;
		}
	
		////////////////////문의글 상세 조회////////////////////
		public QuestionBoardVo selectOne(Connection conn, String num) {
			
			PreparedStatement pstmt =  null;
			ResultSet rs = null;
			QuestionBoardVo vo = null;
			
			String sql = "SELECT Q_NO ,Q_TITLE , Q_CONTENT , M.NAME AS Q_WRITER , Q_CNT , Q_UPDATE_DATE , Q_FREQ FROM QUESTIONBOARD Q JOIN MEMBER M ON Q_WRITER = M.NO WHERE Q_FREQ = 'N' AND Q_NO = ?";
			
			try {
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, num);
				
				rs = pstmt.executeQuery();
				if(rs.next()) {
					String no = rs.getString("Q_NO");
					String title = rs.getString("Q_TITLE");
					String writer = rs.getString("Q_WRITER");
					String content = rs.getString("Q_CONTENT");
					String cnt = rs.getString("Q_CNT");
					String updateDate = rs.getString("Q_UPDATE_DATE");
				
					vo = new QuestionBoardVo();
					vo.setqNo(no);
					vo.setqTitle(title);
					vo.setqWriter(writer);
					vo.setqContent(content);
					vo.setqCnt(cnt);
					vo.setqUpdateDate(updateDate);
				}

			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(rs);
				close(pstmt);
			}
			
			return vo;
		}
	
		
		/////////////////문의글 삭제///////////////////
		public int delete(Connection conn, String num) {
			
			String sql = "UPDATE QUESTIONBOARD SET Q_FREQ = 'Y' WHERE Q_NO = ?";
			
			PreparedStatement pstmt = null;
			int result = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, num);
				
				result = pstmt.executeUpdate();
				
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			
			return result;
		}
	
		/////////////////문의글 수정///////////////////
		public int edit(Connection conn, QuestionBoardVo vo) {
			
			PreparedStatement pstmt = null;
			int result = 0;
			
			try {
				String sql = "UPDATE QUESTIONBOARD SET Q_TITLE = ? , Q_CONTENT = ? WHERE Q_NO = ?";
				
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, vo.getqTitle());
				pstmt.setString(2, vo.getqContent());
				pstmt.setString(3, vo.getqNo());
				
				result = pstmt.executeUpdate();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
			}
			return result;
		}
		
		
		
		/*
		 * 게시글 총 갯수 조회
		 */
		public int getCount(Connection conn) {
			
			//SQL
			String sql = "SELECT COUNT(Q_NO) AS COUNT FROM QUESTIONBOARD WHERE Q_FREQ = 'N'";
			
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int count = 0;
			
			try {
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					count = rs.getInt("COUNT");
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				close(pstmt);
				close(rs);
			}
			
			return count;
			
		}
		
	
}//class
