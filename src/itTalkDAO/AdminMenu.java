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
	
	// �Ű� ���� �Խñ� ��� ��ü ���
	
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
	
	// ��ȸ Ŭ���� �ش� �Ű� ���� �Խñ� ���
	
	// ���� Ŭ���� �ش� �Ű���� �Խñ� ����
	
	// ��ü �Խñ� ��� ���	
	
	
	// ��ȸ Ŭ���� �ش� �Խñ� ���
	
	// ���� Ŭ���� �ش� ���ñ� ����
	
	// �Խ��� ī�װ� ���� ���
	
	// �Խ��� ī�װ� ���� ���
	

	
}
