package itTalkDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import itTalkDO.Rb;

public class AdminMenu {

	Connection conn;
	PreparedStatement pstmt;
	
	// 신고 받은 게시글 목록 전체 출력
	
	public ArrayList<Rb> getReportBoard() {
		ArrayList<Rb> reportBoards=new ArrayList();
		
		conn= DBManager.connect();
		String sql="select * FROM Rb";
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				
				Rb rb = new Rb();
				rb.setRb_no(rs.getInt("rb_no"));
				rb.setB_no(rs.getInt("b_no"));
				rb.setMb_no(rs.getInt("mb_no"));
				rb.setRctg_no(rs.getInt("rctg_no"));
				rb.setRb_write(rs.getString("rb_write"));
				rb.setRb_date(rs.getString("rb_date"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return reportBoards;
		
	}
	
	// 조회 클릭시 해당 신고 받은 게시글 출력
	
	// 삭제 클릭시 해당 신고받은 게시글 삭제
	
	// 전체 게시글 목록 출력	
	
	
	// 조회 클릭시 해당 게시글 출력
	
	// 삭제 클릭시 해당 개시글 삭제
	
	// 게시판 카테고리 수정 기능
	
	// 게시판 카테고리 삭제 기능
	

	
}
