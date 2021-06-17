package itTalkDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import itTalkDO.B;
import itTalkDO.Ts;


public class MainDAO {
	
	Connection conn;
	PreparedStatement pstmt;
	
	// �ǽð� �α� �Խñ� 10��(��ȸ��+��ۼ�:1�ð����� ����)
	public ArrayList<String> getHits() {
		conn= DBManager.connect();
		ArrayList<String> Hits=new ArrayList();
		String sql="SELECT b_no,mb_no,bc_no,b_title,b_write,b_file,b_date,b_hits,b_deleted,b_report,b_cnt,b_hits+b_cnt as b_total from B limit 0,10 Order by desc";
		
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Hits.add(rs.getString("b_no"));
				Hits.add(rs.getString("mb_no"));
				Hits.add(rs.getString("bc_no"));
				Hits.add(rs.getString("b_title"));
				Hits.add(rs.getString("b_write"));
				Hits.add(rs.getString("b_file"));
				Hits.add(rs.getString("b_date"));
				Hits.add(rs.getString("b_hits"));		
				Hits.add(rs.getString("b_deleted"));
				Hits.add(rs.getString("b_report"));
				Hits.add(rs.getString("b_cnt"));
				Hits.add(rs.getString("b_total"));
			}
			
		}catch (SQLException e) {
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
		
		return Hits;
	}
	
	
	// ���ο� ��� �޼ҵ�
	public ArrayList<Ts> top(){
		
		ArrayList<Ts> topMain = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select * from Ts";
			pstmt=conn.prepareStatement(sql);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Ts ts=new Ts();
				
				ts.setTs_no(rs.getInt("ts_no"));
				ts.setB_no(rs.getInt("b_no"));
				ts.setB_title(rs.getString("b_title"));
				topMain.add(ts);
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
		return topMain;
	}
	
	
	// ����&���� �˻� ��� -> �˻��� �Խù� ��� ��ü ���
	
	//select employee_id, first_name
	//from EMPLOYEES
	//where first_name like '%e%';
	
}
