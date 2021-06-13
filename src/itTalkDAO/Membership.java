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

	//���̵� �ߺ�Ȯ��
	public boolean idCheck(String mb_id) {
		conn= DBManager.connect();

		String sql="select mb_id from mb where mb_id=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mb_id);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
					System.out.println("�ߺ� ���̵�");
					return true;//�ߺ��� ���̵�
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;//�ߺ����� ���� ���̵�
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;//�ߺ����� ���� ���̵�
	}
	
	//�г��� �ߺ�Ȯ��
	public boolean nickCheck(String mb_nick) {
		conn= DBManager.connect();
		
		String sql="select mb_nick from mb where mb_nick=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mb_nick);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				System.out.println("�ߺ� �г���");
				return true;//�ߺ��� �г���
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;//�ߺ����� ���� �г���
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;//�ߺ����� ���� �г���
	}
	
	// ����� ȸ������
	public boolean addMember(Mb mb) {
		conn= DBManager.connect();

		String sql="insert into member(mb_id,mb_pw,mb_email,mb_nick,mb_job,mb_certify) values (?,?,?,?,?,?)";
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
	
	//ȸ�������� ����� �г���
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
		
}
