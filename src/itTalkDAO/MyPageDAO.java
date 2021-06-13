package itTalkDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import itTalkDAO.DBManager;
import itTalkDO.C;
import itTalkDO.Mb;


public class MyPageDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	
	// 로그인된 사용자의 댓글 출력
	public ArrayList<String> getMyComment() {
		conn= DBManager.connect();
		
		ArrayList<String> myComments=new ArrayList();
		
		String sql="select mb_no from C";
		
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				myComments.add(rs.getString("c_no"));
				myComments.add(rs.getString("b_no"));
				myComments.add(rs.getString("c_write"));
				myComments.add(rs.getString("c_date"));
				myComments.add(rs.getString("c_secret"));
				myComments.add(rs.getString("c_deleted"));
				myComments.add(rs.getString("c_report"));
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
		return myComments;
		
	}
	
	// 로그인된 사용자의 게시글 출력
	
	// 로그인된 사용자의 정보
	
	// 로그인된 사용자의 좋아요 한 게시글 출력
	
	// 사용자 비밀번호 확인 기능   
	public String getMember_pw(String id) {
		conn=DBManager.connect();
		String sql = "SELECT mb_pw FROM Mb WHERE mb_no=?";
		String member_pw = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				member_pw = rs.getString("mb_pw");
			}
		} catch (Exception e) {
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
		return member_pw;
	}
	
	// 회원 정보 변경 기능
	public void updateMember(Mb mb) {
		conn=DBManager.connect();
		String sql="update Mb set mb_id=?,mb_pw=?,mb_nick=? where mb_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb.getMb_id());
			pstmt.setString(2, mb.getMb_pw());
			pstmt.setString(3, mb.getMb_nick());
			pstmt.setInt(4, mb.getMb_no());

			pstmt.executeUpdate();
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
	}
	
	// 회원 탈퇴 기능   
	public void deleteMember(int mb_no) {
		conn=DBManager.connect();
		String sql="DELETE FROM Member WHERE mb_no = ?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mb_no);
			
			pstmt.executeUpdate();
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
	}

}
