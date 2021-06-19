package itTalkDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import itTalkDAO.DBManager;
import itTalkDO.B;
import itTalkDO.Bs;
import itTalkDO.C;
import itTalkDO.Mb;


public class MyPageDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	
	// �α��ε� ������� ��� ��� 
	public ArrayList<C> getMyComment(int mb_no) {
		conn= DBManager.connect();
		ArrayList<C> myComments=new ArrayList();
		String sql="select * FROM C WHERE mb_no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mb_no);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				C c=new C();
				c.setC_no(rs.getInt("c_no"));
				c.setB_no(rs.getInt("b_no"));
				c.setMb_no(rs.getInt("mb_no"));
				c.setC_write(rs.getString("c_write"));
				c.setC_date(rs.getString("c_date"));
				c.setC_secret(rs.getBoolean("c_secret"));
				c.setC_deleted(rs.getBoolean("c_deleted"));
				c.setC_report(rs.getInt("c_report"));
			
				myComments.add(c);
				
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

		public ArrayList<B> getMyBoard(int mb_no) {
			conn= DBManager.connect();
			ArrayList<B> myBoards=new ArrayList();
			String sql="select * FROM B WHERE mb_no=? ORDER BY b_date DESC";
			try {
				pstmt=conn.prepareStatement(sql);
				pstmt.setInt(1, mb_no);
				ResultSet rs=pstmt.executeQuery();
				while(rs.next()) {
					B b=new B();
					b.setB_no(rs.getInt("b_no"));
					b.setMb_no(rs.getInt("mb_no"));
					b.setBc_no(rs.getInt("bc_no"));
					b.setB_title(rs.getString("b_title"));
					b.setB_write(rs.getString("b_write"));
					b.setB_file(rs.getString("b_file"));
					b.setB_date(rs.getString("b_date"));
					b.setB_hits(rs.getInt("b_hits"));
					b.setB_deleted(rs.getBoolean("b_deleted"));
					b.setB_report(rs.getInt("b_report"));
					b.setB_cnt(rs.getInt("b_cnt"));
					myBoards.add(b);
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
	// �α��ε� ������� �Խñ� ���>��ũ���̺�Ʈ ����

	public ArrayList<B> getMyBoard(int mb_no, int cnt) {
		conn= DBManager.connect();
		ArrayList<B> myBoards=new ArrayList();
		String sql="select * FROM B WHERE mb_no=? ORDER BY b_date DESC limit 0,?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mb_no);
			pstmt.setInt(2, cnt);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				B b=new B();
				b.setB_no(rs.getInt("b_no"));
				b.setMb_no(rs.getInt("mb_no"));
				b.setBc_no(rs.getInt("bc_no"));
				b.setB_title(rs.getString("b_title"));
				b.setB_write(rs.getString("b_write"));
				b.setB_file(rs.getString("b_file"));
				b.setB_date(rs.getString("b_date"));
				b.setB_hits(rs.getInt("b_hits"));
				b.setB_deleted(rs.getBoolean("b_deleted"));
				b.setB_report(rs.getInt("b_report"));
				b.setB_cnt(rs.getInt("b_cnt"));
				myBoards.add(b);
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
	public Mb Info(int mb_no){
		Mb mb=new Mb();
		try {
			conn=DBManager.connect();
			String sql="select * from Mb where mb_no=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, mb_no);
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				
				mb.setMb_no(rs.getInt("mb_no"));
				mb.setMb_id(rs.getString("mb_id"));
				mb.setMb_pw(rs.getString("mb_pw"));
				mb.setMb_email(rs.getString("mb_email"));
				mb.setMb_nick(rs.getString("mb_nick"));
				mb.setMb_job(rs.getBoolean("mb_job"));
				mb.setMb_certify(rs.getBoolean("mb_certify"));	
				
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
	
	
	
	
	
	// �α��ε� ������� ���ƿ� �� �Խñ� ���
	public ArrayList<Bs> getMyBoardSave(int mb_no) {
		conn= DBManager.connect();
		ArrayList<Bs> myBoardsSave=new ArrayList();
		String sql="select * FROM Bs WHERE mb_no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mb_no);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Bs bs=new Bs();
				bs.setBs_no(rs.getInt("bs_no"));
				bs.setMb_no(rs.getInt("mb_no"));
				bs.setB_no(rs.getInt("b_no"));
				bs.setBs_date(rs.getString("bs_date"));
				
				myBoardsSave.add(bs);
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
	public String getMember_pw(int mb_no) {
		conn=DBManager.connect();
		String sql = "SELECT mb_pw FROM Mb WHERE mb_no=?";
		String member_pw = null;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mb_no);
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
	
	// ȸ�� ��й�ȣ ����
	public void updateMemberPw(Mb mb) {
		conn=DBManager.connect();
		String sql="update Mb set mb_pw=? where mb_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mb.getMb_pw());
			pstmt.setInt(2, mb.getMb_no());

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
		String sql="DELETE FROM Mb WHERE mb_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, mb_no);
			
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

}
