package itTalkDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import itTalkDO.Bc;
import itTalkDO.Mb;
import itTalkDO.Rb;

public class AdminMenu {

	Connection conn;
	PreparedStatement pstmt;
	
	// �Ű� ���� �Խñ� ��� ��ü ���
	
	
	
	// ��ȸ Ŭ���� �ش� �Ű� ���� �Խñ� ���
	public ArrayList<Rb> getReportBoard(int rb_no) {
		ArrayList<Rb> reportBoards=new ArrayList();
		
		conn= DBManager.connect();
		String sql="select * FROM Rb where rb_no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, rb_no);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Rb rb = new Rb();
				
				rb.setRb_no(rs.getInt("rb_no"));
				rb.setB_no(rs.getInt("b_no"));
				rb.setMb_no(rs.getInt("mb_no"));
				rb.setRctg_no(rs.getInt("rctg_no"));
				rb.setRb_write(rs.getString("rb_write"));
				rb.setRb_date(rs.getString("rb_date"));
				reportBoards.add(rb);
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
	
	// ���� Ŭ���� �ش� �Ű���� �Խñ� ����
	public boolean deleteRb(int rb_no) {
		conn=DBManager.connect();
		String sql="DELETE FROM Rb WHERE rb_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rb_no);
			
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
	
	
	// ��ü �Խñ� ��� ���	
	
	// ��ȸ Ŭ���� �ش� �Խñ� ���
	
	// ���� Ŭ���� �ش� �Խñ� ����
	
	
	
	
	// �Խ��� ī�װ� ���� ���
	public void updateBc(int bc_no) {
		conn=DBManager.connect();
		String sql="update Bc set bc_no=?,bc_name=? where bc_no=?";
		try {
			Bc bc = new Bc();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bc.getBc_no());
			pstmt.setString(2, bc.getBc_name());
			pstmt.setInt(3, bc_no);

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
	
	// �Խ��� ī�װ� ���� ���
	public boolean deleteBc(int bc_no) {
		conn=DBManager.connect();
		String sql="DELETE FROM Bc WHERE bc_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, bc_no);
			
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
