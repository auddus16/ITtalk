package itTalkDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login {

	Connection conn;
	PreparedStatement pstmt;
	
	// 로그인
		public boolean login(String mb_id,String mb_pw) {
			conn= DBManager.connect();

			String sql="select mb_pw from mb where mb_id=?";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1, mb_id);
				ResultSet rs=pstmt.executeQuery();
				if(rs.next()) {
					if(rs.getString("mb_pw").equals(mb_pw)) {
						System.out.println("로그인성공");
						return true;
					}
					else {
						System.out.println("로그인실패-비밀번호불일치");
					}
				}
				else {
					System.out.println("해당아이디없음");
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
	
}
