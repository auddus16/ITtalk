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
	
	// �α��ε� ������� ��� ��� 
	public ArrayList<String> getMyComment(String mb_no) {
		conn= DBManager.connect();
		ArrayList<String> myComments=new ArrayList();
		String sql="select * FROM C WHERE mb_no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mb_no);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				myComments.add(rs.getString("c_no"));
				myComments.add(rs.getString("b_no"));
				myComments.add(rs.getString("mb_no"));
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
	
	// �α��ε� ������� �Խñ� ���
	public ArrayList<String> getMyBoard(String mb_no) {
		conn= DBManager.connect();
		ArrayList<String> myBoards=new ArrayList();
		String sql="select * FROM B WHERE mb_no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mb_no);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				myBoards.add(rs.getString("b_no"));
				myBoards.add(rs.getString("mb_no"));
				myBoards.add(rs.getString("bc_no"));
				myBoards.add(rs.getString("b_title"));
				myBoards.add(rs.getString("b_write"));
				myBoards.add(rs.getString("b_file"));
				myBoards.add(rs.getString("b_date"));
				myBoards.add(rs.getString("b_hits"));
				myBoards.add(rs.getString("b_deleted"));
				myBoards.add(rs.getString("b_report"));
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
		return myBoards;
		
	}
	
	// �α��ε� ������� ���� 
	public ArrayList<String> getMyInfo(Mb member) {
		conn= DBManager.connect();
		ArrayList<String> myInfo=new ArrayList();
		String sql="select mb_id, mb_pw, mb_email, mb_nick, mb_job FROM Mb WHERE mb_no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				myInfo.add(rs.getString("mb_id"));
				myInfo.add(rs.getString("mb_pw"));
				myInfo.add(rs.getString("mb_email"));
				myInfo.add(rs.getString("mb_nick"));
				myInfo.add(rs.getString("mb_job"));
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
		return myInfo;
		
	}
	
	
	
	
	
	// �α��ε� ������� ���ƿ� �� �Խñ� ���
	public ArrayList<String> getMyBoardSave(String mb_no) {
		conn= DBManager.connect();
		ArrayList<String> myBoardsSave=new ArrayList();
		String sql="select * FROM Bs WHERE mb_no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mb_no);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				myBoardsSave.add(rs.getString("bs_no"));
				myBoardsSave.add(rs.getString("mb_no"));
				myBoardsSave.add(rs.getString("b_no"));
				myBoardsSave.add(rs.getString("bs_date"));
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
		return myBoardsSave;
		
	}
	
	// ����� ��й�ȣ Ȯ�� ��� 
	public String getMember_pw(String mb_no) {
		conn=DBManager.connect();
		String sql = "SELECT mb_pw FROM Mb WHERE mb_no=?";
		String member_pw = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb_no);
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
	
	// ȸ�� ���� ���� ���
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
	
	// ȸ�� Ż�� ���   
	public boolean deleteMember(int mb_no) {
		conn=DBManager.connect();
		String sql="DELETE FROM Member WHERE mb_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mb_no);
			
			pstmt.executeUpdate();
			return true;
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
		
	}

}
