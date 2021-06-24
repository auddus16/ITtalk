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
	
	//�̸��� �ߺ�Ȯ��
	public boolean emailCheck(String mb_email) {
		conn= DBManager.connect();

		String sql="select mb_email from mb where mb_email=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, mb_email);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
					System.out.println("�ߺ� �̸���");
					return true;//�ߺ��� �̸���
			}
						
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;//�ߺ����� ���� �̸���
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println("�ߺ����� ���� �̸���");
		return false;//�ߺ����� ���� �̸���
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
		// �̸��Ϸ� ���̵� ã��
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
		// �̸��� ���̵�� ��й�ȣ ã��
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
