package itTalkDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

	Connection conn;
	PreparedStatement pstmt;
	
	// 회원 로그인
		public boolean login(String mb_id,String mb_pw) {
			conn= DBManager.connect();

			String sql="select mb_pw from mb where mb_id=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, mb_id);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString("mb_pw").equals(mb_pw)) {
						return true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return false;
		}
		// 관리자 로그인
		public boolean adminLogin(String ad_id,String ad_pw) {
			conn= DBManager.connect();
			
			String sql="select ad_pw from ad where ad_id=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, ad_id);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString("ad_pw").equals(ad_pw)) {
						return true;
					}
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return false;
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return false;
		}
		
		//아이디 찾기
		public String idSearch(String mb_email) {
			String id = null;
			conn= DBManager.connect();
			
			String sql="select mb_id from mb where mb_email=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, mb_email);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					id = rs.getString("mb_id");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("관련된 아이디가 없습니다");
				e.printStackTrace();
				return null;
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("아이디 찾기 성공");
			return id;
		}
		
		//비밀번호 찾기
		public String pwSearch(String mb_id) {
			String pw = null;
			conn= DBManager.connect();
			
			String sql="select mb_pw from mb where mb_id=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, mb_id);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					pw = rs.getString("mb_pw");
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("관련된 비밀번호가 없습니다");
				e.printStackTrace();
				return null;
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			System.out.println("비밀번호 찾기 성공");
			return pw;
		}
		
	
}
