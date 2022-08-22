package com.syl.board.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import static com.kh.common.JDBCTemplate.*;
import com.syl.board.vo.QuestionBoardVo;

public class QuestionBoardDao {

	
public ArrayList<QuestionBoardVo> selectList(Connection conn){
		
		//SQL
		String sql = "";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<QuestionBoardVo> list = new ArrayList<QuestionBoardVo>();
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				String no = rs.getString("Q_NO");
				String title = rs.getString("Q_TITLE");
//				String content = rs.getString("Q_CONTENT");
				String writer = rs.getString("Q_WRITER");
				String cnt = rs.getString("Q_CNT");
				String updateDate = rs.getString("Q_UPDATE_DATE");
				
				QuestionBoardVo vo = new QuestionBoardVo();
				vo.setqNo(no);
				vo.setqTitle(title);
				vo.setqContent(content);
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
	
	
	
	
	
	
	
	
}//class
