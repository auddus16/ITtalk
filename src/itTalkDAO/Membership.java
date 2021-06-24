package itTalkDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import itTalkDO.Mb;

public class Membership {

	Connection conn;
	PreparedStatement pstmt;

	//아이디 중복확인
	public boolean idCheck(String mb_id) {
		conn= DBManager.connect();

		String sql="select mb_id from mb where mb_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mb_id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
					System.out.println("중복 아이디");
					return true;//중복된 아이디
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;//중복되지 않은 아이디
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;//중복되지 않은 아이디
	}
	
	//이메일 중복확인
	public boolean emailCheck(String mb_email) {
		conn= DBManager.connect();

		String sql="select mb_email from mb where mb_email=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mb_email);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
					System.out.println("중복 이메일");
					return true;//중복된 이메일
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;//중복되지 않은 이메일
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("중복되지 않은 이메일");
		return false;//중복되지 않은 이메일
	}
	
	//닉네임 중복확인
	public boolean nickCheck(String mb_nick) {
		conn= DBManager.connect();
		
		String sql="select mb_nick from mb where mb_nick=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mb_nick);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("중복 닉네임");
				return true;//중복된 닉네임
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;//중복되지 않은 닉네임
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;//중복되지 않은 닉네임
	}
	
	// 사용자 회원가입
	public boolean addMember(Mb mb) {
		conn= DBManager.connect();

		String sql="insert into mb(mb_id,mb_pw,mb_email,mb_nick,mb_job,mb_certify) values (?,?,?,?,?,?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mb.getMb_id());
			pstmt.setString(2, mb.getMb_pw());
			pstmt.setString(3, mb.getMb_email());
			pstmt.setString(4, mb.getMb_nick());
			pstmt.setBoolean(5, mb.isMb_job());
			pstmt.setBoolean(6, mb.isMb_certify());
			pstmt.executeUpdate();
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
		return true;
	}
	
	//회원가입한 사용자 닉네임
		public ArrayList<String> nickPrint() {
			conn= DBManager.connect();
			ArrayList<String> nicks = new ArrayList<>(); 
			String sql="select nick from mb";
			try {
				ResultSet rs=pstmt.executeQuery();
				while (rs.next()) {
					nicks.add(rs.getString(1));
				}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return nicks;
			} finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return nicks;
		}
		// 이메일로 아이디 찾기
		public Mb SearchId(String mb_email){
			Mb mb=new Mb();
			try {
				conn=DBManager.connect();
				String sql="select mb_id from Mb where mb_email=?";
				pstmt=conn.prepareStatement(sql);
				
				pstmt.setString(1, mb_email);
				
				ResultSet rs=pstmt.executeQuery();
				
				while(rs.next()) {
					mb.setMb_id(rs.getString("mb_id"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return null;
			}
			finally {
				try {
					pstmt.close();
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			return mb;
		}
		// 이메일 아이디로 비밀번호 찾기
				public Mb SearchPw(String mb_id,String mb_email){
					Mb mb=new Mb();
					try {
						conn=DBManager.connect();
						String sql="select mb_pw from mb where mb_id=? and mb_email=?";
						pstmt=conn.prepareStatement(sql);
						
						pstmt.setString(1, mb_id);
						pstmt.setString(2, mb_email);
						
						ResultSet rs=pstmt.executeQuery();
						
						while(rs.next()) {
							mb.setMb_id(rs.getString("mb_pw"));
						}
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						return null;
					}
					finally {
						try {
							pstmt.close();
							conn.close();
						} catch (SQLException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					return mb;
				}
		
}
