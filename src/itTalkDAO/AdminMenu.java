package itTalkDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import itTalkDO.Ad;
import itTalkDO.B;
import itTalkDO.Bc;
import itTalkDO.C;
import itTalkDO.Mb;
import itTalkDO.Rb;
import itTalkDO.Rc;

public class AdminMenu {

	Connection conn;
	PreparedStatement pstmt;
	
	// 신고 받은 게시글 목록 전체 출력
	public ArrayList<Rb> getReportBoardList(){
		
		ArrayList<Rb> ReportBoardList = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select * from Rb ORDER BY rb_date DESC";
			pstmt=conn.prepareStatement(sql);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Rb rb=new Rb();
				
				rb.setRb_no(rs.getInt("rb_no"));
				rb.setB_no(rs.getInt("b_no"));
				rb.setMb_no(rs.getInt("mb_no"));
				rb.setRctg_no(rs.getInt("rctg_no"));
				rb.setRb_write(rs.getString("rb_write"));
				rb.setRb_date(rs.getString("rb_date"));

				ReportBoardList.add(rb);
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
		return ReportBoardList;
	}
	
	
	// 조회 클릭시 해당 신고 받은 게시글 출력
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
	
	// 삭제 클릭시 해당 신고받은 게시글 삭제
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
	// 삭제 클릭시 해당 신고받은 게시글 삭제
	public boolean deleteRb2(int b_no) {
		conn=DBManager.connect();
		String sql="DELETE FROM Rb WHERE b_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			
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
	
	
	
	
	// 신고 받은 댓글 목록 전체 출력
	public ArrayList<Rc> getReportCommentList(){
		
		ArrayList<Rc> ReportCommentList = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select * from Rc ORDER BY rc_date DESC";
			pstmt=conn.prepareStatement(sql);
			
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Rc rc=new Rc();
				
				rc.setRc_no(rs.getInt("rc_no"));
				rc.setC_no(rs.getInt("c_no"));
				rc.setMb_no(rs.getInt("mb_no"));
				rc.setRctg_no(rs.getInt("rctg_no"));
				rc.setRc_write(rs.getString("rc_write"));
				rc.setRc_date(rs.getString("rc_date"));

				ReportCommentList.add(rc);
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
		return ReportCommentList;
	}
	
	// 조회 클릭시 해당 신고 받은 댓글 출력
	public C getReportComment(int rc_no) {
		
		C c=new C();
		conn= DBManager.connect();
		String sql="select * FROM C where c_no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, rc_no);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				
				c.setC_write(rs.getString("c_write"));
				
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
		return c;
		
	}
	// 삭제 클릭시 해당 신고받은 댓글 삭제
	public boolean deleteRc(int rc_no) {
		conn=DBManager.connect();
		String sql="DELETE FROM Rc WHERE rc_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, rc_no);
			
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
	// 삭제 클릭시 해당 신고받은 댓글 삭제
	public boolean deleteRc2(int c_no) {
		conn=DBManager.connect();
		String sql="DELETE FROM Rc WHERE c_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			
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
	
	
	
	
	// 전체 게시글 목록 출력	
	public ArrayList<B> getBoardList(){
		
		ArrayList<B> boardList = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select * from B ORDER BY b_date DESC";
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

				boardList.add(b);
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
		return boardList;
	}
	
	// 조회 클릭시 해당 게시글 출력
	public ArrayList<B> getBoard(int b_no) {
		ArrayList<B> board=new ArrayList();
		
		conn= DBManager.connect();
		String sql="select * FROM B where b_no=?";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
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
				board.add(b);
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
		return board;
		
	}
	
	// 삭제 클릭시 해당 게시글 삭제
	public boolean deleteB(int b_no) {
		conn=DBManager.connect();
		String sql="DELETE FROM B WHERE b_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			
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
	
	// 게시판 카테고리 출력
	public ArrayList<Bc> getBoardCategory() {
		ArrayList<Bc> boardCategory=new ArrayList();
		
		conn= DBManager.connect();
		String sql="select * FROM Bc";
		try {
			pstmt=conn.prepareStatement(sql);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				Bc bc=new Bc();
				
				bc.setBc_no(rs.getInt("bc_no"));
				bc.setBc_name(rs.getString("bc_name"));

				boardCategory.add(bc);
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
		return boardCategory;
		
	}
	
	// 게시판 카테고리 추가 기능
	public boolean addMember(Bc bc) {
		conn= DBManager.connect();

		String sql="insert into bc(bc_name) values (?)";
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, bc.getBc_name());

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
	
	// 게시판 카테고리 수정 기능
	public boolean updateBc(int bc_no, String bc_name) {
		conn=DBManager.connect();
		String sql="update Bc set bc_name=? where bc_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, bc_name);
			pstmt.setInt(2, bc_no);

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
	
	// 게시판 카테고리 삭제 기능
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
	
	// 신고 받은 카테고리 이름 목록 출력
	public String getReportCategory(int rctg_no){
		
		String result=null;
		try {
			conn=DBManager.connect();
			String sql="select rctg_name from Rctg where rctg_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, rctg_no);
			ResultSet rs=pstmt.executeQuery();
			while(rs.next()) {
				
				result= rs.getString("rctg_name");

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
		return result;
	}
	
	// 로그인된 관리자의 정보 
	public Ad AdInfo(int ad_no){
		Ad ad=new Ad();
		try {
			conn=DBManager.connect();
			String sql="select * from Ad where ad_no=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setInt(1, ad_no);
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				
				
				ad.setAd_no(rs.getInt("ad_no"));
				ad.setAd_id(rs.getString("ad_id"));
				ad.setAd_pw(rs.getString("ad_pw"));
				ad.setAd_email(rs.getString("ad_email"));
				ad.setAd_nick(rs.getString("ad_nick"));
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
		return ad;
	}
	
	// 로그인할때 입력받은 ad_id로  ad_no을 받을 수 있는 메소드
	public int getAd_no(String ad_id){
		int ad_no=0;
		try {
			conn=DBManager.connect();
			String sql="select ad_no from Ad where ad_id=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, ad_id);
			
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()) {
				ad_no=rs.getInt("ad_no");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return 0;
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
		return ad_no;
	}
	
	//게시글 신고 해제 기능
	
	public boolean updateB_deleted(int b_no) {
		conn=DBManager.connect();
		String sql="update B set b_deleted=0 where b_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,b_no);

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
	
	//댓글 신고 해제 기능
	
	public boolean updateC_deleted(int c_no) {
		conn=DBManager.connect();
		String sql="update C set c_deleted=0 where c_no=?";
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,c_no);

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
