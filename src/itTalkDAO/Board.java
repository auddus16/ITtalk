package itTalkDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.cj.protocol.Message;

import itTalkDO.B;
import itTalkDO.BoardSet;
import itTalkDO.C;

public class Board {

	Connection conn;
	PreparedStatement pstmt;
	
	// 게시글 등록

	// 게시글 수정
	
	// 게시글 출력
	public ArrayList<BoardSet> BoardPrint(int b_no){//게시글 번호

		ArrayList<BoardSet> datas=new ArrayList<>();
		BoardSet bs = new BoardSet();
		try {
			conn=DBManager.connect();
			String sql="select * from b where b_no=?";
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
				
				ArrayList<C> cs=new ArrayList<>();

				String sql2="select * from c where b_no=?";
				pstmt=conn.prepareStatement(sql2);
				pstmt.setInt(1, b_no);
				ResultSet rs2=pstmt.executeQuery();
				while(rs2.next()) {
					C c=new C();
					c.setC_no(rs2.getInt("c_no"));
					c.setB_no(rs2.getInt("b_no"));
					c.setMb_no(rs2.getInt("mb_no"));
				    c.setC_write(rs2.getString("c_weite"));
					c.setC_date(rs2.getString("c_date"));
					c.setC_secret(rs2.getBoolean("c_secret"));
					c.setC_deleted(rs2.getBoolean("c_deleted"));
					c.setC_report(rs2.getInt("c_report"));
					cs.add(c);
				}
				rs2.close();
				

				bs.setBoard(b);;
				bs.setRlist(cs);

				datas.add(bs);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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
		return datas;
	}
	
	
	// 댓글 등록
	public boolean newReply(C c){
		try {
			conn=DBManager.connect();
			String sql="insert into reply (b_no,mb_no,c_write) values(?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, c.getB_no());
			pstmt.setInt(2, c.getMb_no());
			pstmt.setString(3, c.getC_write());
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
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
		return true;
	}
	
	// 게시글 삭제
	public boolean delB(int b_id){//게시글 번호
		try {
			conn=DBManager.connect();
			String sql="delete from b where b_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, b_id);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
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
		return true;
	}
	
	// 댓글 삭제
	public boolean delC(int c_id){//댓글번호
		try {
			conn=DBManager.connect();
			String sql="delete from c where c_id=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, c_id);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
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
		return true;
	}
	// 게시글 좋아요
	public boolean like(int mb_no , int b_no) {//회원번호,게시글번호
		try {
			conn=DBManager.connect();
			String sql="insert into bs(mb_no , b_no) values (?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, mb_no);
			pstmt.setInt(2, b_no);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
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
		return true;
	}
	
	// 게시글 조회수
	public void hits(int b_no) {//게시글 번호
		try {
			conn=DBManager.connect();
			String sql="update b set b_hits=b_hits+1 where b_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
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
	}
	
	// 게시글 신고
	public boolean ReportB(int b_no , int mb_no , int rctg_no , String rc_write) {//게시글번호,회원번호,신고카테고리번호,신고내용
		try {
			conn=DBManager.connect();
			String sql="insert into rc(b_no , mb_no , rctg_no , rc_write) values (?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			pstmt.setInt(2, mb_no);
			pstmt.setInt(3, rctg_no);
			pstmt.setString(4, rc_write);
			pstmt.executeUpdate();
			
			sql="update b set b_report=b_report+1 where b_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, b_no);
			pstmt.executeUpdate();
			
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
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
		return true;
	}

	// 댓글 신고
	public boolean ReportC(int c_no , int mb_no , int rctg_no , String rc_write) {//신고댓글,알림이 갈 회원,신고카테고리번호,신고내용
		try {
			conn=DBManager.connect();
			String sql="insert into rc(c_no , mb_no , rctg_no , rc_write) values (?,?,?,?)";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			pstmt.setInt(2, mb_no);
			pstmt.setInt(3, rctg_no);
			pstmt.setString(4, rc_write);
			pstmt.executeUpdate();
			
			sql="update c set c_report=c_report+1 where c_no=?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, c_no);
			pstmt.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
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
		return true;
	}
	
	// 검색 게시글 목록 출력(제목+내용)
	public ArrayList<B> titleSearch(String search){

		ArrayList<B> datas = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select * from b where b_title=? or b_write=? ";
			pstmt=conn.prepareStatement(sql);

			pstmt.setString(1, search);
			pstmt.setString(2, search);


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
				datas.add(b);
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
		return datas;
	}
	
	// 검색 게시글 목록 출력(작성자)
	public ArrayList<B> nickSearch(String nick){
		
		ArrayList<B> datas = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select * from b where b_nick=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, nick);
			
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
				datas.add(b);
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
		return datas;
	}
	
	// 게시글 목록 출력
	public ArrayList<B> search(){
		
		ArrayList<B> datas = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select * from b";
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
				datas.add(b);
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
		return datas;
	}
	
	// 카테고리 게시글 목록 출력
	
	public ArrayList<B> bcSearch(String nick){
		
		ArrayList<B> datas = new ArrayList<>();
		try {
			conn=DBManager.connect();
			String sql="select * from b where b_nick=?";
			pstmt=conn.prepareStatement(sql);
			
			pstmt.setString(1, nick);
			
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
				datas.add(b);
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
		return datas;
	}
	
}
