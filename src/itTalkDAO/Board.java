package itTalkDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import itTalkDO.*;

public class Board {

	Connection conn;
	PreparedStatement pstmt;
	
	// 게시글 등록

	// 게시글 수정
	
	// 댓글 등록
	public boolean newReply(C c){
		try {
			conn=DBManager.connect();
			String sql="insert into reply (b_no,mb_no,c_write) values(?,?,?,now())";
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
	public boolean delB(int b_id){
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
	public boolean delC(int c_id){
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
	public boolean like(int mb_no , int b_no) {
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
	public void hits(int b_no) {
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
	public boolean ReportB(int b_no , int mb_no , int rctg_no , String rc_write) {
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
	public boolean ReportC(int c_no , int mb_no , int rctg_no , String rc_write) {
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
	
	// 검색 게시글 출력
		
	// 게시글 목록 출력
	
	// 카테고리 게시글 출력
	
	
	
}
