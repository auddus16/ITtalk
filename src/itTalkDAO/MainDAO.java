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
	
	// �ǽð� �α� �Խñ� 10��(��ȸ��+��ۼ�:1�ð����� ����(�̿����� ���)) view���� �ڹٽ�ũ��Ʈ �̿�
	public ArrayList<B> getHits() {
		conn= DBManager.connect();
		ArrayList<B> Hits=new ArrayList<>();
		String sql="SELECT b_no,mb_no,bc_no,b_title,b_write,b_file,b_date,b_hits,b_deleted,b_report,b_cnt,b_hits+b_cnt as b_total from b Order by b_total desc limit 10";
		try {
			pstmt=conn.prepareStatement(sql);
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
				
				Hits.add(b);
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
	
	
	// ����&���� �˻� ��� -> �˻��� �Խù� ��� ��ü ��� // getKeyword = ����ڰ� �˻� â�� �Է��� ��
	
	public ArrayList<B> find(String getKeyword){
		
		ArrayList<B> findB = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select b_title,b_write from B where b_title like '%?%' and b_write like '%?%'";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, getKeyword);
			pstmt.setString(2, getKeyword);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				B b=new B();
				
				b.setB_title(rs.getString("b_title")); // �ȵ� �� 1
				b.setB_write(rs.getString("b_write")); // �ȵ� �� 2
				findB.add(b);
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
		return findB;
	}
}
